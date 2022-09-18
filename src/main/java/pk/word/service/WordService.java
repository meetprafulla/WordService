package pk.word.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pk.word.api.request.WordRequest;
import pk.word.api.response.WordLight;
import pk.word.entity.Word;
import pk.word.entity.WordSentences;
import pk.word.entity.WordType;
import pk.word.exception.WordNotFoundException;
import pk.word.exception.WordTitleIsEmptyException;
import pk.word.repository.WordRepository;
import pk.word.repository.WordSentencesRepository;
import pk.word.repository.WordTypeRepository;

@Service
public class WordService {

	@Autowired
	private WordRepository wordRepository;

	@Autowired
	private WordTypeRepository wordTypeRepository;

	@Autowired
	private WordSentencesRepository wordSentencesRepository;

	public Optional<Word> findWordById(int id) {
		return wordRepository.findById(id);
	}

	public Word findWordByText(String wordText) {
		return wordRepository.findByWordText(wordText);
	}

	public Word fetchWordById(int id) {
		return findWordById(id).orElseThrow(WordNotFoundException::new);
	}

	public WordLight fetchWordByText(String wordText) {
		Word word = wordRepository.findByWordText(wordText);
		return convertWordToWordLight(word);
	}

	public List<Word> fetchAllSynonymsForWordById(int wordId) {
		Word word = fetchWordById(wordId);
		return word.getWordSynonyms().stream().collect(Collectors.toList());
	}

	public List<WordLight> fetchAllSynonymsForWord(String wordText) {
		Word word = findWordByText(wordText);
		List<Word> wordList = word.getWordSynonyms().stream().collect(Collectors.toList());
		List<WordLight> wordLiteList = new ArrayList<WordLight>(wordList.size());
		wordList.forEach(eachWord -> {
			wordLiteList.add(convertWordToWordLight(eachWord));
		});
		return wordLiteList;
	}

	public List<Word> fetchAllAntonymsForWordById(int wordId) {
		Word word = fetchWordById(wordId);
		return word.getWordAntonyms().stream().collect(Collectors.toList());
	}

	public List<Word> fetchAllAntonymsForWord(String wordText) {
		Word word = findWordByText(wordText);
		return word.getWordAntonyms().stream().collect(Collectors.toList());
	}

	public List<WordLight> fetchWordHavingText(String searchTerm) {
		List<Word> wordList = wordRepository.findWordWithSearchText(searchTerm);
		return convertWordToWordLight(wordList);
	}

	public WordLight saveWord(WordRequest wordRequest) {
		validateWord(wordRequest);

		Word existingWord = wordRepository.findByWordText(wordRequest.getText());
		Word word = convertWordLightToWord(existingWord, wordRequest);

		WordType wordType = wordTypeRepository.findById(wordRequest.getWordType()).get();
		word.setWordtype(wordType);

		if (wordRequest.getSynonymIds() != null) {
			List<Word> synonyms = wordRepository
					.findByWordIdIn(IntStream.of(wordRequest.getSynonymIds()).boxed().collect(Collectors.toList()));
			word.setWordSynonyms(synonyms.stream().collect(Collectors.toSet()));
		}
		if (wordRequest.getAntonymIds() != null) {
			List<Word> antonyms = wordRepository
					.findByWordIdIn(IntStream.of(wordRequest.getAntonymIds()).boxed().collect(Collectors.toList()));
			word.setWordAntonyms(antonyms.stream().collect(Collectors.toSet()));
		}
		if (wordRequest.getSentences() != null) {
			word.setWordSentences(Arrays.stream(wordRequest.getSentences())
					.map(eachSen -> createWordSentences(word, eachSen)).collect(Collectors.toSet()));
		}

		wordRepository.save(word);

		return wordRequest;
	}

	private WordSentences createWordSentences(Word word, String sentence) {
		WordSentences wordSentence = new WordSentences();
		wordSentence.setSentence(sentence);
		wordSentence.setWord(word);
		return wordSentence;
	}

	private void validateWord(WordLight wordLite) {
		if (StringUtils.isEmpty(wordLite.getText()))
			throw new WordTitleIsEmptyException("Word Text Should Not Be Empty");
	}

	private boolean getWordIfPresent(WordRequest wordRequest) {
		Word word = wordRepository.findByWordText(wordRequest.getText());
		return word != null && word.getWordId() > 0;
	}

	private Word convertWordLightToWord(Word word, WordLight wordLite) {
		if (word == null) {
			word = new Word();
		}
		word.setWordText(returnNewValueIfNotEmptyOtherwiseExistingVal(word.getWordText(), wordLite.getText()));
		word.setAdjective(returnNewValueIfNotEmptyOtherwiseExistingVal(word.getAdjective(), wordLite.getAdjective()));
		word.setAdverb(returnNewValueIfNotEmptyOtherwiseExistingVal(word.getAdverb(), wordLite.getAdverb()));
		word.setConjunction(
				returnNewValueIfNotEmptyOtherwiseExistingVal(word.getConjunction(), wordLite.getConjunction()));
		word.setDeterminer(
				returnNewValueIfNotEmptyOtherwiseExistingVal(word.getDeterminer(), wordLite.getDeterminer()));
		word.setInterjection(
				returnNewValueIfNotEmptyOtherwiseExistingVal(word.getInterjection(), wordLite.getInterjection()));
		word.setNoun(returnNewValueIfNotEmptyOtherwiseExistingVal(word.getNoun(), wordLite.getNoun()));
		word.setPreposition(
				returnNewValueIfNotEmptyOtherwiseExistingVal(word.getPreposition(), wordLite.getPreposition()));
		word.setPronoun(returnNewValueIfNotEmptyOtherwiseExistingVal(word.getPronoun(), wordLite.getPronoun()));
		word.setVerb(returnNewValueIfNotEmptyOtherwiseExistingVal(word.getVerb(), wordLite.getVerb()));
		return word;
	}

	private String returnNewValueIfNotEmptyOtherwiseExistingVal(String existIngVal, String newVal) {
		return StringUtils.isNotEmpty(newVal) ? newVal : existIngVal;
	}

	private List<WordLight> convertWordToWordLight(List<Word> wordList) {
		return wordList == null ? null
				: wordList.stream().map(WordService::convertWordToWordLight).collect(Collectors.toList());
	}

	private static WordLight convertWordToWordLight(Word word) {
		WordLight wl = new WordLight();
		wl.setText(word.getWordText());
		wl.setWordId(word.getWordId());
		wl.setAdjective(word.getAdjective());
		wl.setAdverb(word.getAdverb());
		wl.setConjunction(word.getConjunction());
		wl.setDeterminer(word.getDeterminer());
		wl.setInterjection(word.getInterjection());
		wl.setNoun(word.getNoun());
		wl.setPronoun(word.getPronoun());
		wl.setPreposition(word.getPreposition());
		return wl;
	}
}

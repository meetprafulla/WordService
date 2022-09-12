package pk.word.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pk.word.api.response.WordLight;
import pk.word.entity.Word;
import pk.word.exception.WordNotFoundException;
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

	public List<Word> fetchAllSynonymsForWord(String wordText) {
		Word word = findWordByText(wordText);
		return word.getWordSynonyms().stream().collect(Collectors.toList());
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

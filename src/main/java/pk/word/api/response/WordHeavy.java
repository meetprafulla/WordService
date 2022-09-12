package pk.word.api.response;

import java.util.List;

public class WordHeavy extends WordLight {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3206525427024439275L;
	private int wordType;
	private List<WordLight> synonyms;
	private List<WordLight> antonyms;
	private List<String> sentences;
	

	public List<WordLight> getSynonyms() {
		return synonyms;
	}

	public List<WordLight> getAntonyms() {
		return antonyms;
	}

	public List<String> getSentences() {
		return sentences;
	}

	public int getWordType() {
		return wordType;
	}

	public void setWordType(int wordType) {
		this.wordType = wordType;
	}

	public void setSynonyms(List<WordLight> synonyms) {
		this.synonyms = synonyms;
	}

	public void setAntonyms(List<WordLight> antonyms) {
		this.antonyms = antonyms;
	}

	public void setSentences(List<String> sentences) {
		this.sentences = sentences;
	}

}

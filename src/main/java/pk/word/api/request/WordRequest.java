package pk.word.api.request;

import pk.word.api.response.WordLight;

public class WordRequest extends WordLight {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5915066749967572525L;

	private int wordType;
	private int[] sentenceIds;
	private String[] sentences;
	private int[] synonymIds;
	private int[] antonymIds;

	public int getWordType() {
		return wordType;
	}

	public int[] getSentenceIds() {
		return sentenceIds;
	}

	public String[] getSentences() {
		return sentences;
	}

	public void setSentences(String[] sentences) {
		this.sentences = sentences;
	}

	public int[] getSynonymIds() {
		return synonymIds;
	}

	public int[] getAntonymIds() {
		return antonymIds;
	}

	public void setWordType(int wordType) {
		this.wordType = wordType;
	}

	public void setSentenceIds(int[] sentenceIds) {
		this.sentenceIds = sentenceIds;
	}

	public void setSynonymIds(int[] synonymIds) {
		this.synonymIds = synonymIds;
	}

	public void setAntonymIds(int[] antonymIds) {
		this.antonymIds = antonymIds;
	}

}

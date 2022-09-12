package pk.word.api.response;

import java.io.Serializable;

public class WordLight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1399892840211275656L;

	protected int wordId;
	protected String text;
	protected String noun;
	protected String verb;
	protected String adjective;
	protected String adverb;
	protected String pronoun;
	protected String determiner;
	protected String preposition;
	protected String conjunction;
	protected String interjection;

	public int getWordId() {
		return wordId;
	}

	public String getText() {
		return text;
	}

	public void setWordId(int wordId) {
		this.wordId = wordId;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getNoun() {
		return noun;
	}

	public String getVerb() {
		return verb;
	}

	public String getAdjective() {
		return adjective;
	}

	public String getAdverb() {
		return adverb;
	}

	public String getPronoun() {
		return pronoun;
	}

	public String getDeterminer() {
		return determiner;
	}

	public String getPreposition() {
		return preposition;
	}

	public String getConjunction() {
		return conjunction;
	}

	public String getInterjection() {
		return interjection;
	}

	public void setNoun(String noun) {
		this.noun = noun;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public void setAdjective(String adjective) {
		this.adjective = adjective;
	}

	public void setAdverb(String adverb) {
		this.adverb = adverb;
	}

	public void setPronoun(String pronoun) {
		this.pronoun = pronoun;
	}

	public void setDeterminer(String determiner) {
		this.determiner = determiner;
	}

	public void setPreposition(String preposition) {
		this.preposition = preposition;
	}

	public void setConjunction(String conjunction) {
		this.conjunction = conjunction;
	}

	public void setInterjection(String interjection) {
		this.interjection = interjection;
	}
}

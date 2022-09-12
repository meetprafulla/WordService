package pk.word.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "WORD")
public class Word {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WORD_ID")
	private int wordId;

	@Column(name = "WORD_TEXT")
	private String wordText;

	@Column(name = "NOUN")
	private String noun;

	@Column(name = "VERB")
	private String verb;

	@Column(name = "ADJECTIVE")
	private String adjective;

	@Column(name = "ADVERB")
	private String adverb;

	@Column(name = "PRONOUN")
	private String pronoun;

	@Column(name = "DETERMINER")
	private String determiner;

	@Column(name = "PREPOSITION")
	private String preposition;

	@Column(name = "CONJUNCTION")
	private String conjunction;

	@Column(name = "INTERJECTION")
	private String interjection;

	@ManyToOne
	@JoinColumn(name = "WORDTYPE_ID")
	private WordType wordtype;

	@ManyToMany
	@JoinTable(name = "WORD_SYNONYMS", joinColumns = { @JoinColumn(name = "WORD_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "SYNONYM_ID") })
	private Set<Word> wordSynonyms;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "WORD_ID")
	private Set<WordSentences> wordSentences;

	@ManyToMany
	@JoinTable(name = "WORD_ANTONYMS", joinColumns = { @JoinColumn(name = "WORD_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ANTONYM_ID") })
	private Set<Word> wordAntonyms;

	public int getWordId() {
		return wordId;

	}

	public String getWordText() {
		return wordText;
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

	public void setWordText(String wordText) {
		this.wordText = wordText;
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

	public WordType getWordtype() {
		return wordtype;
	}

	public Set<Word> getWordSynonyms() {
		return wordSynonyms;
	}

	public void setWordtype(WordType wordtype) {
		this.wordtype = wordtype;
	}

	public void setWordSynonyms(Set<Word> wordSynonyms) {
		this.wordSynonyms = wordSynonyms;
	}

	public Set<WordSentences> getWordSentences() {
		return wordSentences;
	}

	public Set<Word> getWordAntonyms() {
		return wordAntonyms;
	}

	public void setWordSentences(Set<WordSentences> wordSentences) {
		this.wordSentences = wordSentences;
	}

	public void setWordAntonyms(Set<Word> wordAntonyms) {
		this.wordAntonyms = wordAntonyms;
	}
}

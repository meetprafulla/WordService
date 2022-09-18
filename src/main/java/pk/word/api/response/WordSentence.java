package pk.word.api.response;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pk.word.entity.Word;

@Entity
@Table(name = "WORD_SENTENCES")
public class WordSentence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3420451824066483121L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WORD_SENTENCE_ID")
	private int wordSentenceId;

	@Column(name = "SENTENCE")
	private String sentence;

	@ManyToOne
	@JoinColumn(name = "WORD_ID")
	private Word word;

	public int getWordSentenceId() {
		return wordSentenceId;
	}

	public String getSentence() {
		return sentence;
	}

	public Word getWord() {
		return word;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public void setWord(Word word) {
		this.word = word;
	}

}

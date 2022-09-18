package pk.word.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WORD_SENTENCES")
public class WordSentences {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

package pk.word.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "WORDTYPE")
public class WordType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WORDTYPE_ID")
	private int wordtypeId;
	@Column(name = "WORDTYPE_TEXT")
	private String wordtypeText;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "WORDTYPE_ID")
	private Set<Word> words;
	
	public int getWordtypeId() {
		return wordtypeId;
	}

	public String getWordtypeText() {
		return wordtypeText;
	}

	public void setWordtypeText(String wordtypeText) {
		this.wordtypeText = wordtypeText;
	}

	public Set<Word> getWords() {
		return words;
	}

	public void setWords(Set<Word> words) {
		this.words = words;
	}
}

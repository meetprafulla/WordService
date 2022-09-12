package pk.word.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pk.word.entity.WordSentences;

@Repository
public interface WordSentencesRepository extends JpaRepository<WordSentences, Integer> {

}

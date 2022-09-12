package pk.word.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pk.word.entity.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer> {
	Word findByWordText(String wordText);
	
	@Query(value = "SELECT w FROM Word w  WHERE w.wordText LIKE %:searchTerm% ORDER BY wordText")
	List<Word> findWordWithSearchText(@Param("searchTerm") String searchTerm);
	
}

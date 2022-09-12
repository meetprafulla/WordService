package pk.word.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pk.word.api.response.WordLight;
import pk.word.service.WordService;

@RestController
@RequestMapping("/api/word")
public class WordAPI {

	@Autowired
	private WordService wordService;

	@GetMapping("/{wordText}")
	public ResponseEntity<WordLight> findWordByText(@PathVariable String wordText) {
		WordLight wordLight = wordService.fetchWordByText(wordText);
		return ResponseEntity.status(HttpStatus.OK).body(wordLight);
	}

	@GetMapping("/synonyms/{wordText}")
	public ResponseEntity<List<WordLight>> findSynonymsForWord(@PathVariable String wordText) {
		List<WordLight> wordLight = wordService.fetchAllSynonymsForWord(wordText);
		return ResponseEntity.status(HttpStatus.OK).body(wordLight);
	}

	@GetMapping("/antonyms/{wordText}")
	public ResponseEntity<WordLight> findAntonymsForWord(@PathVariable String wordText) {
		WordLight wordLight = wordService.fetchWordByText(wordText);
		return ResponseEntity.status(HttpStatus.OK).body(wordLight);
	}

	@GetMapping("/sentences/{wordText}")
	public ResponseEntity<WordLight> findSentencesForWord(@PathVariable String wordText) {
		WordLight wordLight = wordService.fetchWordByText(wordText);
		return ResponseEntity.status(HttpStatus.OK).body(wordLight);
	}

	@GetMapping("/type/{wordText}")
	public ResponseEntity<WordLight> findWordTypeForWord(@PathVariable String wordText) {
		WordLight wordLight = wordService.fetchWordByText(wordText);
		return ResponseEntity.status(HttpStatus.OK).body(wordLight);
	}

	@GetMapping("/topwords/{searchTerm}")
	public ResponseEntity<List<WordLight>> fetchTopWords(@PathVariable String searchTerm) {
		List<WordLight> wordLightList = wordService.fetchWordHavingText(searchTerm);
		return ResponseEntity.status(HttpStatus.OK).body(wordLightList);
	}

}

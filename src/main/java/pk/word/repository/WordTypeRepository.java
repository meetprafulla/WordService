package pk.word.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pk.word.entity.WordType;

@Repository
public interface WordTypeRepository extends JpaRepository<WordType, Integer> {

}

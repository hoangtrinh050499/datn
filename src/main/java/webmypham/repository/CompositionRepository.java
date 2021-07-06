package webmypham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webmypham.model.Composition;

public interface CompositionRepository extends JpaRepository<Composition, Integer> {


}

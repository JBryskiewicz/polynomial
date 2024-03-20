package pl.demo.polynomial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.demo.polynomial.domain.Variable;

@Repository
public interface VariableRepository extends JpaRepository<Variable, Long> { }

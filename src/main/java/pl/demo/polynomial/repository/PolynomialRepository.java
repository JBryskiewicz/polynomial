package pl.demo.polynomial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.demo.polynomial.domain.Polynomial;

@Repository
public interface PolynomialRepository extends JpaRepository<Polynomial, Long> { }

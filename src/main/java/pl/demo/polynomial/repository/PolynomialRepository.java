package pl.demo.polynomial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.demo.polynomial.domain.Polynomial;

import java.util.List;

@Repository
public interface PolynomialRepository extends JpaRepository<Polynomial, Long> {

    @Query(value = "SELECT * FROM polynomials ORDER BY id DESC LIMIT 10", nativeQuery = true)
    List<Polynomial> findLastTenPolynomials();
}

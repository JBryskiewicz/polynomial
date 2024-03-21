package pl.demo.polynomial.service;

import pl.demo.polynomial.domain.Polynomial;

import java.util.List;

public interface PolynomialService {
    List<Polynomial> findAll();
    List<Polynomial> findLastTenPolynomials();
    Polynomial findById(Long id);
    Polynomial createPolynomial(Polynomial polynomial);
    Polynomial updatePolynomial(Long id, Polynomial polynomial);
    Boolean deletePolynomial(Long id);
}

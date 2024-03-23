package pl.demo.polynomial.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.demo.polynomial.domain.Polynomial;
import pl.demo.polynomial.domain.Variable;
import pl.demo.polynomial.repository.PolynomialRepository;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PolynomialServiceImpl implements PolynomialService {

    private final PolynomialRepository polyRepository;

    @Override
    public List<Polynomial> findAll() {
        return polyRepository.findAll();
    }

    @Override
    public List<Polynomial> findLastTenPolynomials() {
        List<Polynomial> polyList = polyRepository.findLastTenPolynomials();
        polyList.forEach(polynomial -> {
            polynomial.getVariables().sort(Comparator.comparingInt(Variable::getPosition));
        });
        return polyList;
    }

    @Override
    public Polynomial findById(Long id) {
        Polynomial polynomial = polyRepository.findById(id).orElse(null);
        if (polynomial != null) {
            polynomial.getVariables().sort(Comparator.comparingInt(Variable::getPosition));
        }
        return polynomial;
    }

    @Override
    public Polynomial createPolynomial(Polynomial polynomial) {
        return polyRepository.save(polynomial);
    }

    @Override
    public Polynomial updatePolynomial(Long id, Polynomial polynomial) {
        Polynomial existingPoly = polyRepository.findById(id).orElse(null);
        if (existingPoly != null) {
            existingPoly.setVariables(polynomial.getVariables());
            existingPoly.setRangeStart(polynomial.getRangeStart());
            existingPoly.setRangeEnd(polynomial.getRangeEnd());
            return polyRepository.save(existingPoly);
        }
        return null;
    }

    @Override
    public Boolean deletePolynomial(Long id) {
        if (polyRepository.existsById(id)) {
            polyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

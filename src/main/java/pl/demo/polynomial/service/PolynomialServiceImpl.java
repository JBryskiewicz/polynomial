package pl.demo.polynomial.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.demo.polynomial.domain.Polynomial;
import pl.demo.polynomial.repository.PolynomialRepository;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PolynomialServiceImpl implements PolynomialService{

    private final PolynomialRepository polyRepository;

    @Override
    public List<Polynomial> findAll() {
        return polyRepository.findAll();
    }

    @Override
    public List<Polynomial> findLastTenPolynomials() {
        return polyRepository.findLastTenPolynomials();
    }

    @Override
    public Polynomial findById(Long id) {
        return polyRepository.findById(id).orElse(null);
    }

    @Override
    public Polynomial createPolynomial(Polynomial polynomial) {
        return polyRepository.save(polynomial);
    }

    @Override
    public Polynomial updatePolynomial(Long id, Polynomial polynomial) {
        Polynomial existingPoly = polyRepository.findById(id).orElse(null);
        if(existingPoly != null){
            existingPoly.setVariables(polynomial.getVariables());
            return polyRepository.save(existingPoly);
        }
        return null;
    }

    @Override
    public Boolean deletePolynomial(Long id) {
        if(polyRepository.existsById(id)){
            polyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

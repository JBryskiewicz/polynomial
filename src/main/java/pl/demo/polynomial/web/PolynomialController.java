package pl.demo.polynomial.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.demo.polynomial.domain.Polynomial;
import pl.demo.polynomial.service.PolynomialService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/polynomials")
public class PolynomialController {
    private final PolynomialService polyService;

    @GetMapping
    public ResponseEntity<List<Polynomial>> getPolynomialsList() {
        List<Polynomial> polynomials = polyService.findLastTenPolynomials();
        return new ResponseEntity<>(polynomials, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Polynomial> getPolynomial(@PathVariable Long id) {
        Polynomial polynomial = polyService.findById(id);
        if(polynomial == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(polynomial, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Polynomial> createPolynomial(@RequestBody Polynomial polynomial) {
        Polynomial newPoly = polyService.createPolynomial(polynomial);
        return new ResponseEntity<>(newPoly, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolynomial(@PathVariable Long id) {
        boolean deleted = polyService.deletePolynomial(id);
        if(!deleted){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

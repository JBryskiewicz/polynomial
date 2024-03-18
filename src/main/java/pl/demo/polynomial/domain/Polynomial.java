package pl.demo.polynomial.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Polynomial {

    @Id
    private Long id;
    private Float functionValue;
    private Float constant;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Variable> variables;

}

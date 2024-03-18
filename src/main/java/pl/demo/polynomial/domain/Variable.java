package pl.demo.polynomial.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Variable {

    @Id
    private Long id;
    private int position;
    private int value;

}

package pl.demo.polynomial.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "polynomials")
public class Polynomial {

    @Id
    private Long id;

    private Float functionValue;

    private Float constant;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Variable> variables;

}

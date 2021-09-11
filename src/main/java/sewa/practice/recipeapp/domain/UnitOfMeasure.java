package sewa.practice.recipeapp.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.parser.Part;

import javax.persistence.*;

@Data
@Entity
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String uom;

    private String description;
}

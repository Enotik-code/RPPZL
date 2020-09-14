package by.defolt.entity.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Builder
@Table(name = "disability")
@AllArgsConstructor
@NoArgsConstructor
public class Disability implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disability")
    private Long idDisability;
    private String nameDisability;
}

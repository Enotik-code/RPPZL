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
@Table(name = "citizenship")
@AllArgsConstructor
@NoArgsConstructor
public class Citizenship implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_citizenship")
    private Long idCitizenship;
    private String nameCitizenship;
}

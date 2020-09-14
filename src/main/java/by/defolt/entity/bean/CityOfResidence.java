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
@Table(name = "city_of_residence")
@AllArgsConstructor
@NoArgsConstructor
public class CityOfResidence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_city_residence")
    private Long idCityResidence;
    private String nameCityResidence;
}

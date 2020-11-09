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
@Table(name = "city_of_registration")
@AllArgsConstructor
@NoArgsConstructor
public class CityOfRegistration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_city_of_registration")
    private Long idCityRegistration;
    private String nameCityRegistration;
}

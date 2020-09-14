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
@Table(name = "marital_staus")
@AllArgsConstructor
@NoArgsConstructor
public class MaritalStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marital_status")
    private Long idMaritalStatus;
    private String nameMaritalStatus;

}

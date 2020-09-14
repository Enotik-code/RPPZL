package by.defolt.authentication.bean;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Builder
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_client")
    private Long id;
    private String userName;
    private String password;
    private Boolean active;
    private String activationCode;
    private String email;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Date dateOfBirthday;
    private String sex;
    private String passportSeries;
    private String passportNumber;
    private String issuedBy;
    private Date dateOfIssued;
    private String identificationNumber;
    private String placeOfBirthday;
    private Long IdCityOfRegistration;
    private String address;
    private String homePhone;
    private String mobilePhone;
    private String placeOfWork;
    private String position;
    private Long IdCityOfResidence;
    private String placeOfResidence;
    private Long idMaritalStatus;
    private Long idCitizenship;
    private Long idDisability;
    private Boolean retiree;
    private Boolean liableForMilitaryService;
    private Double monthlyIncome;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id_client"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}


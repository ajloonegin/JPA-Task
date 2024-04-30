package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "PERSONNELTABLE")
public class Personnel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nationalCode;
    private String firstName;
    private String lastName;
    private String cityName;

    @OneToMany(mappedBy = "personnel")
    private Set<Vacation> vacations;

    public Personnel() {
    }

    public Personnel(String nationalCode, String firstName, String lastName, String cityName) {
        setNationalCode(nationalCode);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cityName = cityName;
    }

    @Column(name = "NATIONALCODE")
    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        if (nationalCode.length() <= 10) {
            this.nationalCode = nationalCode;
        } else {
            System.out.println("invalid national code");

        }
    }

    @Column(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "CITYNAME")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "nationalCode='" + nationalCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personnel personnel = (Personnel) o;
        return Objects.equals(id, personnel.id);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, nationalCode, firstName, lastName, cityName);
    }
}

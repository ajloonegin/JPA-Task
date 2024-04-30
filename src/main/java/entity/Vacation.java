package entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(
                name = "findVacationsByPersonnel",
                query = "SELECT vacation FROM Vacation vacation " +
                        "INNER JOIN vacation.personnel personnel " +
                        "WHERE personnel.nationalCode = :nationalCode"
        )

})
@Entity
@Table(name = "VACATIONTABLE")
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "PERSONNEL_ID")
    private Personnel personnel;

    public Vacation() {
    }

    public Vacation(Personnel personnel, Date date) {
        this.personnel = personnel;
        this.date = date;
    }

    @Column(name = "DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "id=" + id +
                ", date=" + date +
                ", personnel=" + personnel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacation vacation = (Vacation) o;
        return Objects.equals(id, vacation.id) && Objects.equals(date, vacation.date) && Objects.equals(personnel, vacation.personnel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, personnel);
    }
}

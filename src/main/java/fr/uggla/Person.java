package fr.uggla;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
public class Person extends PanacheEntity {
    @NotBlank
    public String name;
    public Date birth;
    public Status status;

}
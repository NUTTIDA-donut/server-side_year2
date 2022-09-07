package sit.int204.classicmodelsservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "productlines")
@Getter
@Setter
public class Productline {
    @Id
    @Column(name = "productLine", nullable = false, length = 50)
    private String id;
    @Column(name = "textDescription", length = 4000)
    private String textDescription;
    @Lob
    @Column(name = "htmlDescription")
    private String htmlDescription;
}
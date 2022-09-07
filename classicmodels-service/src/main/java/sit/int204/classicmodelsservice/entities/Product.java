package sit.int204.classicmodelsservice.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
@Getter
@Setter
@Entity
@Table(name = "products", indexes = {
        @Index(name = "productLine", columnList = "productLine")
})
public class Product {
    @Id
    @Column(name = "productCode", nullable = false, length = 15)
    private String id;
    @Column(name = "productName", nullable = false, length = 70)
    private String productName;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "productLine", nullable = false)
    private Productline productline;
    @Column(name = "productScale", nullable = false, length = 10)
    private String productScale;
    @Column(name = "productVendor", nullable = false, length = 50)
    private String productVendor;
    @Lob
    @Column(name = "productDescription", nullable = false)
    private String productDescription;
    @Column(name = "quantityInStock", nullable = false)
    private Integer quantityInStock;
    @Column(name = "buyPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal buyPrice;
    @Column(name = "MSRP", nullable = false, precision = 10, scale = 2)
    private BigDecimal msrp;
}
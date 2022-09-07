package sit.int204.classicmodelsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.entities.Product;

public interface ProductRepository extends JpaRepository<Product,String > {
}

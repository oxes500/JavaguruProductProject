package lv.javaguru.finalwork.database;

import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface JPAProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findByName(String name);

    List<Product> findByCategory(Category category);

}
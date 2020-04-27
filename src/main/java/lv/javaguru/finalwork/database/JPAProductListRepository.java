package lv.javaguru.finalwork.database;

import lv.javaguru.finalwork.domain.ProductList;
import org.springframework.data.repository.CrudRepository;

public interface JPAProductListRepository extends CrudRepository<ProductList, Long> {



}

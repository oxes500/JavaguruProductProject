package lv.javaguru.finalwork.database;

import lv.javaguru.finalwork.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface JPAUserRepository extends CrudRepository <User, Long> {

    boolean existsByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

}
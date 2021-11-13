package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import java.util.List;


public interface UserDao {

    List<User> index();


    User getUserByName(String name);

    User show(Long id);

    void save(User user);

    void update( User updatedUser, Long id);


    void delete(Long id);
}

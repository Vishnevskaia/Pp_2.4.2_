package web.dao;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    // private final Map<String, User> userMap = Collections.singletonMap("test",
    //        new User(1L, "test", "test", Collections.singleton(new Role(1L, "ROLE_USER")))); // name - уникальное значение, выступает в качестве ключа Map

    @Override
    public List<User> index() {  //addAllUsers

        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User getUserByName(String name) {
        //String query = "FROM users WHERE name=:name";
        try {
            return (User) entityManager
                    .createQuery("from User u inner JOIN FETCH u.roles as roles WHERE u.name = :name", User.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Пользователь не найден в базе");
            return null;
        }


    }

    @Override
    public User show(Long id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User updatedUser, Long id) {
        entityManager.merge(updatedUser);
    }



    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}


package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;


import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao;

    public UserServiceImpl(UserDaoImpl userDao) {

        this.userDao = userDao;
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Override
    public User show(Long id) {
        return userDao.show(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User updatedUser, Long id) {
        userDao.update(updatedUser, id);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }


}

package pl.demo.polynomial.service;

import pl.demo.polynomial.domain.User;

public interface UserService {
    User save(User user);
    User findById(long id);
    User findByUsername(String username);
}

package com.digi.service;

import com.digi.dto.requestdto.UserDTO;
import com.digi.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    List<User> getAll(String name);
    User getById(int id);
    List<User> getBySurname(String surname);

    List<User> getByYear(Integer year);

    User getByEmail(String email);

    User updateUser(int id, UserDTO userDTO);
    User changeFullName(int id, String name, String surname);
    User changeEmail(int id, String email);
    User changePassword(int id, String password);

    void deleteUser(int id);



}

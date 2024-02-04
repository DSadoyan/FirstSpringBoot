package com.digi.service.impl;

import com.digi.dto.requestdto.UserDTO;
import com.digi.model.Address;
import com.digi.model.User;
import com.digi.repository.AddressRepository;
import com.digi.repository.UserRepository;
import com.digi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void saveUser(UserDTO userDTO) {
        User user = new User();
        user.setId(0);
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setYear(userDTO.getYear());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        userRepository.save(user);
    }

    @Override
    public User getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getBySurname(String surname) {
        return userRepository.getBySurname(surname);
    }

    @Override
    public List<User> getByYear(Integer year) {
        return userRepository.getByYear(year);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public List<User> getAll(String name) {
        if (name != null) {
            return userRepository.getByName(name);
        }
        return userRepository.findAll();
    }

    @Override
    public User updateUser(int id, UserDTO userDTO) {
        Optional<User> result = userRepository.findById(id);
        if (result.isEmpty()) {
            throw new RuntimeException("User not found with given id");
        }
        User user = result.get();


        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setYear(userDTO.getYear());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return userRepository.save(user);

    }

    @Override
    public User changeFullName(int id, String name, String surname) {
        Optional<User> result = userRepository.findById(id);
        if (result.isEmpty()) {
            throw new RuntimeException("User not found with given id");
        }
        User user = result.get();
        user.setName(name);
        user.setSurname(surname);
        return userRepository.save(user);
    }

    @Override
    public User changeEmail(int id, String email) {
        Optional<User> result = userRepository.findById(id);
        if (result.isEmpty()) {
            throw new RuntimeException("User not found with given id");
        }
        User user = result.get();
        user.setEmail(email);
        return userRepository.save(user);
    }

    @Override
    public User changePassword(int id, String password) {
        Optional<User> result = userRepository.findById(id);
        if (result.isEmpty()) {
            throw new RuntimeException("User not found with given id");
        }
        User user = result.get();
        user.setPassword(password);
        return userRepository.save(user);
    }

        @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
//    @Override
//    public void deleteUser(int id) {
//        Optional<User> result = userRepository.findById(id);
//        if (result.isEmpty()) {
//            throw new RuntimeException("User not found with given id");
//        }
//        User user = result.get();
//        Address address = addressRepository.getByUser(user);
//        if (address != null) {
//            addressRepository.delete(address);
//        }
//        userRepository.deleteById(id);
//    }


}

package com.digi.repository;

import com.digi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    @Query(nativeQuery = true,value = "select * from users where email = ?")
    User getByEmail(String email);

    @Query(nativeQuery = true,value = "select * from users where id = ?")
    User getById(int id);
    //    @Query(nativeQuery = true,value = "select * from users where first_name = ?")
    List<User> getByName(String name);
//    @Query(nativeQuery = true,value = "select * from users where last_name = ?")
    List<User> getBySurname(String surname);

    List<User> getByYear(Integer year);
}

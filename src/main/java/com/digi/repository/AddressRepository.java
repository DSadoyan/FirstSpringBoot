package com.digi.repository;

import com.digi.model.Address;
import com.digi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
//    @Query(nativeQuery = true,value = "select * from address where address_id = ?")
    Address getAddressByAddressId(int id);
    List<Address> getAddressByCountry(String country);

    List<Address> getAddressByCity(String city);

    List<Address> getAddressByStreet(String street);

    List<Address> getAddressByHome(String home);

    Address getByUser(User user);
}

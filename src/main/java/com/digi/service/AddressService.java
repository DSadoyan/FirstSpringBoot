package com.digi.service;

import com.digi.dto.requestdto.AddressDTO;
import com.digi.model.Address;

import java.util.List;

public interface AddressService {
    Address addAddress(AddressDTO addressDTO, String email);

    List<Address> getAll();

    Address getById(int id);
    List<Address> getByCountry(String country);
    List<Address> getByCity(String city);
    List<Address> getByStreet(String street);
    List<Address> getByHome(String home);
    Address updateAddress(int id, AddressDTO addressDTO);
    Address changeCountry(int id, String country);
    Address changeCity(int id, String city);
    Address changeStreet(int id, String street);
    Address changeHome(int id, String home);

    void deleteAddress(int id);



}

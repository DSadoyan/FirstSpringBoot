package com.digi.service.impl;

import com.digi.dto.requestdto.AddressDTO;
import com.digi.model.Address;
import com.digi.model.User;
import com.digi.repository.AddressRepository;
import com.digi.repository.UserRepository;
import com.digi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Address addAddress(AddressDTO addressDTO, String email) {
        Address address = new Address();

        address.setAddressId(0);
        address.setCountry(addressDTO.getCountry());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setHome(addressDTO.getHome());
        User user = userRepository.getByEmail(email);
        address.setUser(user);
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(int id) {
        return addressRepository.getAddressByAddressId(id);
    }

    @Override
    public List<Address> getByCountry(String country) {
        return addressRepository.getAddressByCountry(country);
    }

    @Override
    public List<Address> getByCity(String city) {
        return addressRepository.getAddressByCity(city);
    }

    @Override
    public List<Address> getByStreet(String street) {
        return addressRepository.getAddressByStreet(street);
    }

    @Override
    public List<Address> getByHome(String home) {
        return addressRepository.getAddressByHome(home);
    }

    public Address updateAddress(int id, AddressDTO addressDTO) {
        Optional<Address> result = addressRepository.findById(id);
        if (result.isEmpty()){
            throw new RuntimeException("Address not found with given id");
        }
        Address address = result.get();

        address.setCountry(addressDTO.getCountry());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setHome(addressDTO.getHome());

        return addressRepository.save(address);
    }

    @Override
    public Address changeCountry(int id, String country) {
        Optional<Address> result = addressRepository.findById(id);
        if (result.isEmpty()){
            throw new RuntimeException("Address not found with given id");
        }
        Address address = result.get();
        address.setCountry(country);
        return addressRepository.save(address);
    }

    @Override
    public Address changeCity(int id, String city) {
        Optional<Address> result = addressRepository.findById(id);
        if (result.isEmpty()){
            throw new RuntimeException("Address not found with given id");
        }
        Address address = result.get();
        address.setCity(city);
        return addressRepository.save(address);
    }

    @Override
    public Address changeStreet(int id, String street) {
        Optional<Address> result = addressRepository.findById(id);
        if (result.isEmpty()){
            throw new RuntimeException("Address not found with given id");
        }
        Address address = result.get();
        address.setStreet(street);
        return addressRepository.save(address);
    }

    @Override
    public Address changeHome(int id, String home) {
        Optional<Address> result = addressRepository.findById(id);
        if (result.isEmpty()){
            throw new RuntimeException("Address not found with given id");
        }
        Address address = result.get();
        address.setHome(home);

        return addressRepository.save(address);
    }


    @Override
    public void deleteAddress(int id) {
        Optional<Address> result = addressRepository.findById(id);
        if (result.isEmpty()){
            throw new RuntimeException("Address not found with given id");
        }
        addressRepository.deleteById(id);

    }

}

package com.digi.controller;

import com.digi.dto.requestdto.AddressDTO;
import com.digi.model.Address;
import com.digi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address addAddress(@RequestBody AddressDTO addressDTO, Principal principal){
        String email = principal.getName();
        return addressService.addAddress(addressDTO,email);
    }
    @GetMapping
    public List<Address>getAll(){
       return addressService.getAll();
    }
    @GetMapping("/get-by-id")
    public Address getById(int id){
        return addressService.getById(id);
    }
    @GetMapping("/get-by-country")
    public List<Address> getByCountry(@RequestParam(required = false) String country){
        return addressService.getByCountry(country);
    }
    @GetMapping("/get-by-city")
    public List<Address> getByCity(@RequestParam(required = false)String city){
        return addressService.getByCity(city);
    }
    @GetMapping("/get-by-street")
    public List<Address> getByStreet(@RequestParam(required = false)String street){
        return addressService.getByStreet(street);
    }
    @GetMapping("/get-by-home")
    public List<Address> getByHome(@RequestParam (required = false)String home){
        return addressService.getByHome(home);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable int id,@RequestBody AddressDTO addressDTO){
        return addressService.updateAddress(id,addressDTO);
    }
    @PatchMapping("/change-country")
    public Address changeCountry(@RequestParam int id,@RequestParam String country){
        return addressService.changeCountry(id, country);
    }
    @PatchMapping("/change-city")
    public Address changeCity(@RequestParam int id,@RequestParam String city){
        return addressService.changeCity(id, city);
    }
    @PatchMapping("/change-street")
    public Address changeStreet(@RequestParam int id,@RequestParam String street){
        return addressService.changeStreet(id, street);
    }
    @PatchMapping("/change-home")
    public Address changeHome(@RequestParam int id,@RequestParam String home){
        return addressService.changeHome(id, home);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@RequestParam int id){
        addressService.deleteAddress(id);
    }
}

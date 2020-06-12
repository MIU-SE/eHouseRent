package miu.edu.cs425.SEProject.eHouseRentAPI.service.impl;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.Address;
import miu.edu.cs425.SEProject.eHouseRentAPI.repository.AddressRepository;
import miu.edu.cs425.SEProject.eHouseRentAPI.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl  implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public  AddressServiceImpl( AddressRepository addressRepository ){
        this.addressRepository=addressRepository;
    }
    @Override
    public List<Address> findAllByStateAndCity(String state, String city) {
        return addressRepository.findAllByStateAndCity(state,city);
    }
}



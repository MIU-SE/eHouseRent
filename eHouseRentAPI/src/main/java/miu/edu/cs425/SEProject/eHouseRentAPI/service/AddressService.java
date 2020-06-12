package miu.edu.cs425.SEProject.eHouseRentAPI.service;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAllByStateAndCity(String state, String city);

}


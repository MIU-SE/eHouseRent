package miu.edu.cs425.SEProject.eHouseRentAPI.service.impl;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.Address;
import miu.edu.cs425.SEProject.eHouseRentAPI.model.House;
import miu.edu.cs425.SEProject.eHouseRentAPI.repository.HouseRepository;
import miu.edu.cs425.SEProject.eHouseRentAPI.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

   public  HouseServiceImpl(HouseRepository houseRepository){
       this.houseRepository= houseRepository;
   }

    @Override
    public House findByAddress(Address address) {
        return houseRepository.findByAddress(address);
    }
//
//    @Override
//    public List<House> findAll() {
//        return null;
//    }

    @Override
    public House getHouseById(long houseId) {
        return houseRepository.findById(houseId).orElse(null);
    }

    @Override
    public House saveHouse(House house) {
        return houseRepository.save(house);
    }

    @Override
    public List<House> getListOfHouses() {
        return houseRepository.findAll();
    }

    @Override
    public void deleteHouse(Long houseId) {
        houseRepository.deleteById(houseId);
    }

    @Override
    public House updateHouse(House editedHouse, Long houseId) {
        return houseRepository.findById(houseId)
         .map(house->{
          house.setPrice(editedHouse.getPrice());
          house.setHouseType(editedHouse.getHouseType());
          house.setNumberOfRooms(editedHouse.getNumberOfRooms());
          house.setDescription(editedHouse.getDescription());
         // house.setAddress(editedHouse.getAddress());
          return houseRepository.save(house);
         }).orElseGet(()->{
             return houseRepository.save(editedHouse);
                });
    }


}

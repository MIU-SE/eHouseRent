package miu.edu.cs425.SEProject.eHouseRentAPI.service;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.Address;
import miu.edu.cs425.SEProject.eHouseRentAPI.model.House;

import java.util.List;
import java.util.Optional;

public interface HouseService {


        House findByAddress(Address address);
        //List<House> findAll();

        public House getHouseById(long houseId) ;
    public House saveHouse(House house);
   public House[] getListOfHouses();
   public House updateHouse(House editedHouse, Long houseId);
   public void deleteHouse(Long houseId);
}

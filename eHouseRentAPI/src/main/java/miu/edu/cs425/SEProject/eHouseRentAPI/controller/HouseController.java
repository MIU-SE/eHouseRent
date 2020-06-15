
package miu.edu.cs425.SEProject.eHouseRentAPI.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import miu.edu.cs425.SEProject.eHouseRentAPI.model.Address;
import miu.edu.cs425.SEProject.eHouseRentAPI.model.House;
import miu.edu.cs425.SEProject.eHouseRentAPI.repository.HouseRepository;
import miu.edu.cs425.SEProject.eHouseRentAPI.service.AddressService;
import miu.edu.cs425.SEProject.eHouseRentAPI.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value="/ehouserent/house")
public class HouseController {
    @Autowired
    HouseService houseService;
  @Autowired
  AddressService addressService;

    @Autowired
    HouseRepository houseRep;

    @GetMapping(value = "/search/{state}/{city}")
    public House[] getHouseByStateAndCity(@PathVariable String state, @PathVariable String city) {

        List<Address> address = addressService.findAllByStateAndCity(state, city);
        List<House> houses = new ArrayList<>();

        for (Address a : address) {
            System.out.println("getting houses");
            House h = houseService.findByAddress(a);
            if(h!=null)
                houses.add(h);
        }
//        for (House hx:houses){
//            System.out.println(hx.getHouseType());
//        }

        House [] filteredHouses= new House[houses.size()];
         houses.toArray(filteredHouses);

        return  filteredHouses;
    }

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping(value = {"/get/{houseId}"})
    public House getHouse(@PathVariable long houseId) {
        return houseService.getHouseById(houseId);
    }

    @PostMapping(value = "/add")
    public House addHouse(@Valid @RequestBody House house) {
        return houseService.saveHouse(house);
    }

    @GetMapping(value="/list")
    public House[] getHouse() {
        return houseService.getListOfHouses();

    }
    //    @PutMapping(value = "/edit/{houseId}")
//    public House editHouse(@Valid @RequestBody House editedHouse, @PathVariable Long houseId) {
//        return houseService.updateHouse(editedHouse, houseId);
//
//    }
    @DeleteMapping(value ="/delete/{houseId}" )
    public void deleteHouse(@PathVariable Long houseId){
        houseService.deleteHouse(houseId);
    }

}



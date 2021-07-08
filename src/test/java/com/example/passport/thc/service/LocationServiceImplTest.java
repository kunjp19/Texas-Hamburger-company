package com.example.passport.thc.service;

import com.example.passport.thc.model.Locations;
import com.example.passport.thc.repository.LocationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LocationServiceImplTest{

    @Bean
    public LocationService getService(){return new LocationServiceImpl();}

    @Autowired
    LocationService locationService;

    @MockBean
    private LocationRepository locationRepository;
    private Locations locations;
    private Locations locationsUpdate;
    List<Locations> locObj = new ArrayList<>();

    @Before
    public void setup(){
        //set locations property
        System.out.println("Start testing Location Service");

        locations = new Locations();
            locations.setLocationId(8L);
            locations.setName("Thc6");
            locations.setAddress_line1("25200 carlos Bee");
            locations.setAddress_line2("b123");
            locations.setCity("Hayward");
            locations.setZipCode(94542);
            locations.setLocationStatus("OPEN");
        locObj.add(locations);

        locationsUpdate = new Locations();
        locationsUpdate.setLocationId(8L);
        locationsUpdate.setName("Thc6");
        locationsUpdate.setAddress_line1("25200 carlos Bee");
        locationsUpdate.setAddress_line2("b123");
        locationsUpdate.setCity("Hayward");
        locationsUpdate.setZipCode(94542);
        locationsUpdate.setLocationStatus("CLOSED");

        Mockito.when(locationRepository.findAll()).thenReturn(Collections.singletonList(locations));
        Mockito.when(locationRepository.findById(locations.getLocationId())).thenReturn(Optional.of(locations));
        Mockito.when(locationRepository.save(locations)).thenReturn(locations);
        Mockito.when(locationRepository.save(locationsUpdate)).thenReturn(locationsUpdate);
//        Mockito.when(locationRepository.deleteById(locations.getLocationId())).thenReturn(locations);
    }

    @After
    public void cleanUp(){System.out.println("Done testing Location Service");}



    @Test
    public void findAll() throws Exception {
        List<Locations> isExisting = locationService.findAll();
        Assert.assertEquals("Location doesn't exist",locObj,isExisting);
    }

    @Test
    public void findOne() {
        Locations isExisting = locationService.findOne(locations.getLocationId());
        Assert.assertEquals("location doesn't exist",locations,isExisting);
    }

    @Test
    public void addLocation() {
        Boolean isExisting = locationService.addLocation(locations);
        Assert.assertEquals("location doesn't exist",true,isExisting);
    }

    @Test
    public void update() {
        Locations locationUpdate = new Locations();
        Locations update = locationService.updateLocation(locationsUpdate);
        Assert.assertEquals("Failed to update order", locationUpdate, update);
    }

    @Test
    public void delete() {
        Locations delete = locationService.deleteByName(locations.getName());
        Assert.assertEquals("Failed to delete the location", locations, delete);
    }
}

//package com.example.passport.thc.service;
//
//import com.example.passport.thc.model.Locations;
//import com.example.passport.thc.repository.LocationRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class LocationServiceImplTest{
//    @Bean
//    public LocationService getService(){return new LocationServiceImpl();}
//
//    @Autowired
//    LocationService locationService;
//
//    @MockBean
//    private LocationRepository locationRepository;
//    private Locations locations;
//
//    @Before
//    public void setup(){
//        //set locations property
//        locations = new Locations();
//            locations.setLocationId(8L);
//            locations.setName("Thc6");
//            locations.setAddress_line1("25200 carlos Bee");
//            locations.setAddress_line2("b123");
//            locations.setCity("Hayward");
//            locations.setZipCode(94542);
//            locations.setLocationStatus("OPEN");
//        System.out.println("Start testing Location Service");
//
//        Mockito.when(locationRepository.findById(locations.getLocationId())).thenReturn(Optional.of(locations));
//        Mockito.when(locationRepository.save(locations)).thenReturn(locations);
//    }
//
//    @After
//    public void cleanUp(){System.out.println("Done testing Location Service");}
//
//
//
//    @Test
//    public void findAll() throws Exception {
//        List<Locations> result = locationService.findAll();
//        Assert.assertEquals("Orders list should match",locations,result);
//    }
//
//    @Test
//    public void findOne() {
//        Locations isExisting = locationService.findOne(locations.getLocationId());
//        Assert.assertEquals("Customer doesnt exist",locations,isExisting);
//    }
//}

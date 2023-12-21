package org.fmiplovdiv.TravelAgencyApp.web;

import org.fmiplovdiv.TravelAgencyApp.dto.requests.CreateHolidayDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.CreateLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.UpdateLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.responds.ResponseLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.model.Location;
import org.fmiplovdiv.TravelAgencyApp.service.LocationService;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping()
    public ResponseEntity<Object> saveNewLocation(
            @RequestBody CreateLocationDTO createLocationDTO) {
        locationService.saveNewLocation(createLocationDTO);
        return new ResponseEntity<>("Saved successfully.", HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<ResponseLocationDTO> updateLocation(
            @RequestBody UpdateLocationDTO updateLocationDTO) {
        return new ResponseEntity<>(locationService.updateLocation(updateLocationDTO), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<ResponseLocationDTO>> allLocations() {
        return new ResponseEntity<>(locationService.getAllLocations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(
            @PathVariable int id) {
        return new ResponseEntity<>(locationService.findLocationEntityById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLocation(@PathVariable int id) {
    locationService.deleteLocationById(id);
        return new ResponseEntity<>("Location ID:" + id + "has been deleted successfully.", HttpStatus.OK);
    }

}

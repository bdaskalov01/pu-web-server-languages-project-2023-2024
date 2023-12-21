package org.fmiplovdiv.TravelAgencyApp.service.serviceimpl;

import org.fmiplovdiv.TravelAgencyApp.dao.LocationRepository;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.CreateLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.UpdateLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.responds.ResponseLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.model.Location;
import org.fmiplovdiv.TravelAgencyApp.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location findLocationEntityById(int id) {
        return locationRepository.findById(id).get();
    }

    @Override
    public List<ResponseLocationDTO> getAllLocations() {
        return locationRepository.findAll().stream().map(this::locationToLocationResponseMapper).toList();
    }

    @Override
    public void saveNewLocation(CreateLocationDTO createLocationDTO) {
        Location locationToSave = locationRequestToLocationMapper(createLocationDTO);
        locationRepository.save(locationToSave);

    }

    @Override
    public void deleteLocationById(int id) {
        locationRepository.deleteById(id);
    }

    @Override
    public ResponseLocationDTO updateLocation(UpdateLocationDTO updateLocationDTO) {
       Location searchedLocation = this.findLocationEntityById(Math.toIntExact(updateLocationDTO.getId()));
        Location updatedLocation = this.updateSavedLocation(searchedLocation, updateLocationDTO);
        return this.locationToLocationResponseMapper(updatedLocation);

    }

    @Override
    public ResponseLocationDTO locationToLocationResponseMapper(Location location) {
        return new ResponseLocationDTO(location.getId(), location.getStreet(), location.getNumber(), location.getCity(), location.getCountry(), location.getImageUrl());
    }

    @Override
    public Location locationRequestToLocationMapper(CreateLocationDTO createLocationDTO) {
        return new Location(createLocationDTO.getStreet(), createLocationDTO.getNumber(), createLocationDTO.getCity(), createLocationDTO.getCountry(), createLocationDTO.getImageUrl());
    }

    public Location updateSavedLocation(Location location, UpdateLocationDTO updateLocationDTO) {
        location.setCity(updateLocationDTO.getCity());
        location.setCountry(updateLocationDTO.getCountry());
        location.setNumber(updateLocationDTO.getNumber());
        location.setStreet(updateLocationDTO.getStreet());
        location.setImageUrl(updateLocationDTO.getImageUrl());
        return locationRepository.save(location);
    }



}

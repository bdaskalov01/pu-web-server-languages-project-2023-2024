package org.fmiplovdiv.TravelAgencyApp.service;

import org.fmiplovdiv.TravelAgencyApp.dto.requests.CreateLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.UpdateLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.responds.ResponseLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.model.Location;

import java.util.List;

public interface LocationService {
    Location findLocationEntityById(int id);
    List<ResponseLocationDTO> getAllLocations();
    void saveNewLocation(CreateLocationDTO createLocationDTO);
    void deleteLocationById(int id);
    ResponseLocationDTO updateLocation(UpdateLocationDTO updateLocationDTO);

    ResponseLocationDTO locationToLocationResponseMapper(Location location);

    Location locationRequestToLocationMapper(CreateLocationDTO createLocationDTO);
}

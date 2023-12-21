package org.fmiplovdiv.TravelAgencyApp.dao;

import org.fmiplovdiv.TravelAgencyApp.dto.responds.ResponseHolidayDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.responds.ResponseLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}

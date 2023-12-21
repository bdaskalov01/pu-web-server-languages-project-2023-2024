package org.fmiplovdiv.TravelAgencyApp.dao;

import org.fmiplovdiv.TravelAgencyApp.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HolidaysRepository extends JpaRepository<Holiday, Integer> {
}

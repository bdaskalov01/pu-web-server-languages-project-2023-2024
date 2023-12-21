package org.fmiplovdiv.TravelAgencyApp.dao;

import org.fmiplovdiv.TravelAgencyApp.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Reservation findReservationByPhoneNumber(String phoneNumber);
}

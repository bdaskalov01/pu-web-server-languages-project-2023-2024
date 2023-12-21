package org.fmiplovdiv.TravelAgencyApp.service;

import org.fmiplovdiv.TravelAgencyApp.dto.requests.CreateLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.CreateReservationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.UpdateLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.UpdateReservationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.responds.ResponseLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.responds.ResponseReservationDTO;
import org.fmiplovdiv.TravelAgencyApp.model.Location;
import org.fmiplovdiv.TravelAgencyApp.model.Reservation;

import java.util.List;

public interface ReservationService {
    void saveNewReservation(CreateReservationDTO createReservationDTO);
    void deleteReservationById(int id);

    List<ResponseReservationDTO> getAllReservations();

    Reservation findReservationById(int id);

    Reservation findReservationByPhoneNumber(String phoneNumber);

    ResponseReservationDTO updateReservation(UpdateReservationDTO updateReservationDTO);

    ResponseReservationDTO reservationToReservationResponseMapper(Reservation reservation);

    Reservation reservationRequestToreservationMapper(CreateReservationDTO createReservationDTO);
}

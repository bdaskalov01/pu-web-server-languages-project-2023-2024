package org.fmiplovdiv.TravelAgencyApp.service.serviceimpl;

import org.fmiplovdiv.TravelAgencyApp.dao.ReservationRepository;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.CreateReservationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.UpdateLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.UpdateReservationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.responds.ResponseReservationDTO;
import org.fmiplovdiv.TravelAgencyApp.model.Location;
import org.fmiplovdiv.TravelAgencyApp.model.Reservation;
import org.fmiplovdiv.TravelAgencyApp.service.HolidaysService;
import org.fmiplovdiv.TravelAgencyApp.service.ReservationService;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

import javax.imageio.spi.RegisterableService;
import javax.imageio.spi.ServiceRegistry;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;

    private HolidaysService holidaysService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, HolidaysService holidaysService) {
        this.reservationRepository = reservationRepository;
        this.holidaysService = holidaysService;
    }

    @Override
    public void saveNewReservation(CreateReservationDTO createReservationDTO) {
        Reservation reservationToSave = reservationRequestToreservationMapper(createReservationDTO);
        reservationRepository.save(reservationToSave);
    }

    @Override
    public void deleteReservationById(int id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<ResponseReservationDTO> getAllReservations() {
        return reservationRepository.findAll().stream().map(this::reservationToReservationResponseMapper).toList();
    }

    @Override
    public Reservation findReservationById(int id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public ResponseReservationDTO updateReservation(UpdateReservationDTO updateReservationDTO) {
        Reservation searchedReservation = this.findReservationById(Math.toIntExact(updateReservationDTO.getId()));
        Reservation updatedReservation = this.updateSavedLocation(searchedReservation, updateReservationDTO);
        return this.reservationToReservationResponseMapper(updatedReservation);
    }

    @Override
    public ResponseReservationDTO reservationToReservationResponseMapper(Reservation reservation) {
        return new ResponseReservationDTO(reservation.getId(), reservation.getContactName(), reservation.getPhoneNumber(), holidaysService.holidayToHolidayResponseMapper(holidaysService.getHolidayById((int) reservation.getHoliday())));
    }

    @Override
    public Reservation reservationRequestToreservationMapper(CreateReservationDTO createReservationDTO) {
        return new Reservation(createReservationDTO.getContactName(), createReservationDTO.getPhoneNumber(), createReservationDTO.getHoliday());
    }

    @Override
    public Reservation findReservationByPhoneNumber(String phoneNumber) {
        return reservationRepository.findReservationByPhoneNumber(phoneNumber);
    }
    public Reservation updateSavedLocation(Reservation reservation, UpdateReservationDTO updateReservationDTO) {
        reservation.setContactName(updateReservationDTO.getContactName());
        reservation.setPhoneNumber(updateReservationDTO.getPhoneNumber());
        reservation.setHoliday(updateReservationDTO.getHoliday());
        return reservationRepository.save(reservation);
    }
}

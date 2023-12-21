package org.fmiplovdiv.TravelAgencyApp.web;

import org.fmiplovdiv.TravelAgencyApp.dto.requests.CreateLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.CreateReservationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.UpdateLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.UpdateReservationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.responds.ResponseLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.responds.ResponseReservationDTO;
import org.fmiplovdiv.TravelAgencyApp.model.Location;
import org.fmiplovdiv.TravelAgencyApp.model.Reservation;
import org.fmiplovdiv.TravelAgencyApp.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping()
    public ResponseEntity<Object> saveNewReservation(
            @RequestBody CreateReservationDTO createReservationDTO) {
        reservationService.saveNewReservation(createReservationDTO);
        return new ResponseEntity<>("Saved successfully.", HttpStatus.OK);
    }
    @PutMapping()
    public ResponseEntity<ResponseReservationDTO> updateReservation(
            @RequestBody UpdateReservationDTO updateReservationDTO) {
        return new ResponseEntity<>(reservationService.updateReservation(updateReservationDTO), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<ResponseReservationDTO>> allReservations() {
        return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable int id) {
        return new ResponseEntity<>(reservationService.findReservationById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReservationById(@PathVariable int id) {
        reservationService.deleteReservationById(id);
        return new ResponseEntity<>("Reservation ID: " + id + "has been deleted successfully.", HttpStatus.OK);

    }

}

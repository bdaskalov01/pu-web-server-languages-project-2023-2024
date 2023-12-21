package org.fmiplovdiv.TravelAgencyApp.web;

import org.apache.coyote.Response;
import org.fmiplovdiv.TravelAgencyApp.dao.HolidaysRepository;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.CreateHolidayDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.UpdateHolidayDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.UpdateLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.responds.ResponseHolidayDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.responds.ResponseLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.model.Holiday;
import org.fmiplovdiv.TravelAgencyApp.model.Location;
import org.fmiplovdiv.TravelAgencyApp.service.HolidaysService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/holidays")
public class HolidaysController {

    private HolidaysService holidaysService;

    public HolidaysController(HolidaysService holidaysService) {
        this.holidaysService = holidaysService;
    }

    @PostMapping()
    public ResponseEntity<Object> saveNewHoliday(
            @RequestBody CreateHolidayDTO createHolidayDTO) {
        holidaysService.saveNewHoliday(createHolidayDTO);
        return new ResponseEntity<>("Saved successfully.", HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<ResponseHolidayDTO> updateHoliday(
            @RequestBody UpdateHolidayDTO updateHolidayDTO) {
        return new ResponseEntity<>(holidaysService.updateHoliday(updateHolidayDTO), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<ResponseHolidayDTO>> getAllHolidays() {
        return new ResponseEntity<>(holidaysService.getAllHolidays(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Holiday> getLocationById(@PathVariable int id) {
        return new ResponseEntity<>(holidaysService.getHolidayById(id), HttpStatus.OK);
    }


   @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable int id) {
        holidaysService.deleteHolidayByID(id);
        return new ResponseEntity<>("User ID: " + id + "has been deleted successfully.!", HttpStatus.OK);

    }

}

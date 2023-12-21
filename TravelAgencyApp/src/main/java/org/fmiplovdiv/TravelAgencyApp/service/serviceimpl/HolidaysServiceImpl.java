package org.fmiplovdiv.TravelAgencyApp.service.serviceimpl;

import org.fmiplovdiv.TravelAgencyApp.dao.HolidaysRepository;
import org.fmiplovdiv.TravelAgencyApp.dao.LocationRepository;
import org.fmiplovdiv.TravelAgencyApp.dao.ReservationRepository;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.CreateHolidayDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.UpdateHolidayDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.UpdateLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.responds.ResponseHolidayDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.responds.ResponseLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.model.Holiday;
import org.fmiplovdiv.TravelAgencyApp.model.Location;
import org.fmiplovdiv.TravelAgencyApp.service.HolidaysService;
import org.fmiplovdiv.TravelAgencyApp.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HolidaysServiceImpl implements HolidaysService {
    private final HolidaysRepository holidaysRepository;

    private final LocationRepository locationRepository;
    private final LocationService locationService;

    public HolidaysServiceImpl(HolidaysRepository holidaysRepository, LocationRepository locationRepository, LocationService locationService) {
        this.holidaysRepository = holidaysRepository;
        this.locationRepository = locationRepository;
        this.locationService = locationService;
    }

    @Override
    public Holiday getHolidayById(int holidayId) {
        return holidaysRepository.findById(holidayId).get();
    }

    @Override
    public List<ResponseHolidayDTO> getAllHolidays() {
        return holidaysRepository.findAll().stream().map(this::holidayToHolidayResponseMapper).toList();
    }

    @Override
    public void saveNewHoliday(CreateHolidayDTO createHolidayRequestDTO) {
        Holiday holidayToSave = holidayRequestToHolidayMapper(createHolidayRequestDTO);
        holidaysRepository.save(holidayToSave);
    }



    @Override
    public void deleteHolidayByID(int id) {
        holidaysRepository.deleteById(id);
    }

    @Override
    public ResponseHolidayDTO holidayToHolidayResponseMapper(Holiday holiday) {
        return new ResponseHolidayDTO(holiday.getId(), locationService.locationToLocationResponseMapper(locationService.findLocationEntityById((int) holiday.getLocation())), holiday.getTitle(), holiday.getStartDate(), holiday.getDuration(), holiday.getPrice(), holiday.getFreeSlots());
    }

    @Override
    public Holiday holidayRequestToHolidayMapper(CreateHolidayDTO createHolidayDTO) {
        return new Holiday(createHolidayDTO.getLocation(), createHolidayDTO.getTitle(), createHolidayDTO.getStartDate(), createHolidayDTO.getDuration(), createHolidayDTO.getPrice(), createHolidayDTO.getFreeSlots());
    }

    @Override
    public ResponseHolidayDTO updateHoliday(UpdateHolidayDTO updateHolidayDTO) {
        Holiday searchedHoliday = this.getHolidayById(Math.toIntExact(updateHolidayDTO.getId()));
        Holiday updatedHoliday = this.updateSavedLocation(searchedHoliday, updateHolidayDTO);
        return this.holidayToHolidayResponseMapper(updatedHoliday);

    }

    public Holiday updateSavedLocation(Holiday holiday, UpdateHolidayDTO updateHolidayDTO) {
        holiday.setLocation(updateHolidayDTO.getLocation());
        holiday.setTitle(updateHolidayDTO.getTitle());
        holiday.setStartDate(updateHolidayDTO.getStartDate());
        holiday.setDuration(updateHolidayDTO.getDuration());
        holiday.setPrice(updateHolidayDTO.getPrice());
        holiday.setFreeSlots(updateHolidayDTO.getFreeSlots());
        return holidaysRepository.save(holiday);
    }

}
package org.fmiplovdiv.TravelAgencyApp.service;

import org.fmiplovdiv.TravelAgencyApp.dto.requests.CreateHolidayDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.requests.UpdateHolidayDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.responds.ResponseHolidayDTO;
import org.fmiplovdiv.TravelAgencyApp.dto.responds.ResponseLocationDTO;
import org.fmiplovdiv.TravelAgencyApp.model.Holiday;

import java.util.List;

public interface HolidaysService {
    Holiday getHolidayById(int holidayId);
    List<ResponseHolidayDTO> getAllHolidays();
    void saveNewHoliday(CreateHolidayDTO createHolidayRequestDTO);
    void deleteHolidayByID(int id);

    ResponseHolidayDTO holidayToHolidayResponseMapper(Holiday holiday);

    Holiday holidayRequestToHolidayMapper(CreateHolidayDTO createHolidayDTO);

    ResponseHolidayDTO updateHoliday(UpdateHolidayDTO updateHolidayDTO);
}

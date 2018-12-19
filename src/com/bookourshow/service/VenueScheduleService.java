package com.bookourshow.service;

import org.springframework.stereotype.Service;

import com.bookourshow.dao.VenueScheduleDAO;
import com.bookourshow.exception.BookOurShowException;

@Service
public class VenueScheduleService implements IVenueSchedule {

	@Override
	public int getVenueScheduleId(int movieId, int cityId, int languageId, int venueId, int timingId)
			throws BookOurShowException {
		VenueScheduleDAO venueScheduleDAO=new VenueScheduleDAO();
		return venueScheduleDAO.getVenueScheduleId(movieId, cityId, languageId, venueId, timingId);
	}

}

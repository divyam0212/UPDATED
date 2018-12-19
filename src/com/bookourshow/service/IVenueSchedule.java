package com.bookourshow.service;

import com.bookourshow.exception.BookOurShowException;

public interface IVenueSchedule {
	public int getVenueScheduleId(int movieId,int cityId,int languageId,int venueId,int timing_id) throws BookOurShowException;
}

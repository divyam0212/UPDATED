package com.bookourshow.app;

import java.util.List;

import com.bookourshow.dao.LanguageDAO;
import com.bookourshow.dao.MovieCategoryDAO;
import com.bookourshow.dao.ReceiptDAO;
import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.Language;

public class CheckApp {

	public CheckApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*MovieCategoryDAO movieCategoryDao=new MovieCategoryDAO();
		List<MovieCategory> movieCategory=movieCategoryDao.fetchAllMovie();
		System.out.println(movieCategory);*/
		
		/*ReceiptDAO receiptDao=new ReceiptDAO();*/
		try {
			/*List<String> allSeatList=receiptDao.fetchAllSeats();
			System.out.println("\n");
			
			List<String> bookedSeatList=receiptDao.fetchBookedSeats();*/
			
			LanguageDAO languageDAO=new LanguageDAO();
			List<Language> languageList=languageDAO.fetchLanguageByMovieAndCity(3,4);
			System.out.println(languageList);
			
		} catch (BookOurShowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

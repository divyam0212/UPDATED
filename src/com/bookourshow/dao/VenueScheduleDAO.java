package com.bookourshow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.util.ConnectionUtil;


public class VenueScheduleDAO {
	public VenueScheduleDAO(){
		
	}
	public int getVenueScheduleId(int movieId,int cityId,int languageId,int venueId,int timingId) throws BookOurShowException
	{
		int id=0;
		String query="select vs.venue_schedule_id "
					 +"from address a join venue v join venue_schedule vs join  movie_category mc join language l join movie m join timings t "
					 +"on v.fk_address_id=a.address_id and vs.fk_venue_id=v.venue_id and "
					 +"vs.fk_movie_category_id=mc.movie_category_id and mc.fk_language_id = l.language_id and "
					 +"mc.fk_movie_id=m.movie_id and t.timing_id=vs.fk_timings_id "
					 +"where m.movie_id=? and a.fk_city_id=? and l.language_id=? and v.venue_id=? and t.timing_id=?;";
					 





		PreparedStatement pstmt=null;
		ResultSet result=null;
		Connection connection=null;
		try
		{
			connection=ConnectionUtil.getConnection();
			connection.setAutoCommit(false);
			pstmt=connection.prepareStatement(query);
			pstmt.setInt(1,movieId);
			pstmt.setInt(2,cityId);
			pstmt.setInt(3,languageId);
			pstmt.setInt(4,venueId);
			pstmt.setInt(5,timingId);
			result = pstmt.executeQuery();
			while (result.next())
			{
				id=result.getInt("venue_schedule_id");
			}
			connection.commit();
			
		}catch(SQLException se)
	    {
			se.printStackTrace();
	        throw new BookOurShowException("SQL EXCEPTION");
	        
	    }
		finally
		{
	        try{
	              if(result!=null){
	                     result.close();
	              }
	              if(pstmt!=null){
	                     pstmt.close();
	              }
	              if(connection!=null)
	              {
	            	  connection.close();
	              }
	        }
	        catch(SQLException sqle)
	        {
	              sqle.printStackTrace();
	        }
	        
		}
		return id;
		
	}

}

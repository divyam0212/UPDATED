package com.bookourshow.service;

import java.sql.Connection;

import com.bookourshow.exception.BookOurShowException;
import com.bookourshow.model.User;

public interface IUser {

	public int loginCheck(Connection connObj,User user) throws BookOurShowException;
	public int registerUser(Connection connObj,User user) throws BookOurShowException;
}

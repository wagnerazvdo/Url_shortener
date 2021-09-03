package com.url_short.persistence;

import java.sql.Connection;
<<<<<<< HEAD

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/////// CLASSE DE ACESSO AO BANCO DE DADOS (DATA ACCESS OBJECT) ///////
=======
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
>>>>>>> branch 'master' of https://github.com/wagnerazvdo/Url_shortener.git

public class DAO {
	
	protected ResultSet resultSet;
	protected Connection connection;
	protected PreparedStatement statement;
	
	private static final String DATABASE = "url_shortener?serverTimezone=UTC";
	private static final String USER	 = "root";
	private static final String PASS 	 = "admin123";
	private static final String DRIVER   = "com.mysql.cj.jdbc.Driver";
	private static final String URL		 = "jdbc:mysql://localhost:3306/";

	public void open()throws Exception {
		 Class.forName(DRIVER);
		 connection = DriverManager.getConnection(URL+DATABASE,USER,PASS);
	}
	
	public void close()throws Exception{
		if(!connection.isClosed())
			connection.close();
	}
}

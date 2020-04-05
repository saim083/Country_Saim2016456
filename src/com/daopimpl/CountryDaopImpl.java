package com.daopimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Country;
import com.connection.DbConnection;
import com.daop.CountryDaop;

public class CountryDaopImpl implements CountryDaop {
	private Connection con;                 //Connection
	private PreparedStatement pst;          //Prepared Statement
	private ResultSet rst;                  //Result Set

	@Override
	public List<Country> getAllCountries() {
		List<Country> countries = new ArrayList<Country>();
		try {
			String sql = "SELECT * FROM country"; //SELECT STATEMENT
			con = DbConnection.getConnection();
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while (rst.next()) {
				Country country = new Country();
				country.setCode(rst.getString("Code"));
				country.setName(rst.getString("Name"));
				country.setContinent(rst.getString("continent"));
				country.setSurfacearea(rst.getFloat("Surfacearea"));
				country.setHeadofState(rst.getString("HeadOfState"));
				countries.add(country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countries;
	}

	@Override
	public Boolean addCountry(Country country) {  //Using Try-Catch Statements             
		try {
			String sql = "INSERT INTO country(Code, Name, Continent, Surfacearea, HeadofState) VALUES(?,?,?,?,?)";
			con = DbConnection.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, country.getCode());
			pst.setString(2, country.getName());
			pst.setString(3, country.getContinent());
			pst.setFloat(4, country.getSurfacearea());
			pst.setString(5, country.getHeadofState());
			return (pst.executeUpdate() > 0);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Country searchCountryCode(String code) {
		Country country = null;
		try {
			String sql = "SELECT *FROM country WHERE Code=?";
			con = DbConnection.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, code);
			rst = pst.executeQuery();
			while (rst.next()) {
				country = new Country();
				country.setCode(rst.getString("Code"));
				country.setName(rst.getString("Name"));
				country.setContinent(rst.getString("Continent"));
				country.setSurfacearea(rst.getFloat("Surfacearea"));
				country.setHeadofState(rst.getString("HeadOfState"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return country;
	}

	@Override
	public List<Country> searchCountryName(String name) {
		List<Country> countries = new ArrayList<>();
		try {
			String sql = "SELECT *FROM country WHERE Name=?";
			con = DbConnection.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			rst = pst.executeQuery();
			while (rst.next()) {
				Country country = new Country();
				country.setCode(rst.getString("Code"));
				country.setName(rst.getString("Name"));
				country.setContinent(rst.getString("continent"));
				country.setSurfacearea(rst.getFloat("Surfacearea"));
				country.setHeadofState(rst.getString("HeadOfState"));
				countries.add(country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countries;
	}

}

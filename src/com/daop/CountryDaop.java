package com.daop;

import java.util.List;

import com.beans.Country;

public interface CountryDaop {
	public List<Country> getAllCountries();
    public Boolean addCountry(Country country);
    public Country searchCountryCode(String Code);
    public List<Country> searchCountryName(String Name);
}

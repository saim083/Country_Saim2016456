package com.client;

import java.io.BufferedReader; //imports
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.beans.Country;
import com.daop.CountryDaop;
import com.daopimpl.CountryDaopImpl;

public class Client {
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void menu() {
		CountryDaop countryDaop = new CountryDaopImpl();
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("Press 1 and add a Country:");  //Options to select)
		System.out.println("Press 2 and view all Countries:");
		System.out.println("Press 3 and Find Country Name:");
		System.out.println("Press 4 and Find Country Code:");
		System.out.println("Press 5 and Exit program:");
		System.out.print("Press Require Option-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-:");//Enter Your Choice
		try {
			String choice = input.readLine();
			switch (choice) {
			case "1":                             //Cases
				Country country = new Country();
				System.out.print("Submit Code of the  country : "); //Options To Select
				country.setCode(input.readLine());
				System.out.print("Submit Name of the  country : ");
				country.setName(input.readLine());
				System.out.print("Submit Continent of the country : ");
				country.setContinent(input.readLine());
				System.out.print("Submit Surface area of the country : ");
				country.setSurfacearea(Float.parseFloat(input.readLine()));
				System.out.print("Submit Head of the state : ");
				country.setHeadofState(input.readLine());
				if (countryDaop.addCountry(country)) {
					System.out.println("Country Added Successfully!"); //Added Successfully
				} else {
					System.out.println("Error Occurred!"); //Error
				}
				menu();                                    //Menu
				break;                                     //Break
			case "2":
				List<Country> countries = new ArrayList<>();
				countries = countryDaop.getAllCountries();
				if (countries.size() > 0) {
					System.out.println("Code\tName\t\tContinent\tSurface Area\tHead Of State");
					System.out.println(
							"----------------------------------------------------------------------------------------------------------");
					for (Country countryBean : countries) {
						System.out.println(countryBean.getCode() + "\t" + countryBean.getName() + "\t\t"
								+ countryBean.getContinent() + "\t" + countryBean.getSurfacearea() + "\t"
								+ countryBean.getHeadofState());
					}
				} else {
					System.out.println("No Data Found");
				}
				System.out.println(
						"----------------------------------------------------------------------------------------------------------");
				menu();
				break;
			case "3":
				System.out.print("Enter Country Name : ");
				countries = countryDaop.searchCountryName(input.readLine());
				if (countries.size() > 0) {
					System.out.println("Code\tName\t\tContinent\tSurface area\tHead Of State");
					System.out.println(
							"----------------------------------------------------------------------------------------------------------");
					for (Country countryBean : countries) {
						System.out.println(countryBean.getCode() + "\t" + countryBean.getName() + "\t\t"
								+ countryBean.getContinent() + "\t" + countryBean.getSurfacearea() + "\t"
								+ countryBean.getHeadofState());
					}
				} else {
					System.out.println("No Data Found");
				}
				System.out.println(
						"----------------------------------------------------------------------------------------------------------");
				menu();
				break;

			case "4":
				System.out.print("Enter Country Code : ");
				String code = input.readLine();
				country = countryDaop.searchCountryCode(code);
				System.out.println("Code\t\tName\t\tContinent\t\tSurface Area\t\tHead Of State");
				System.out.println(
						"----------------------------------------------------------------------------------------------------------");
				if (country != null) {
					System.out.println(country.getCode() + "\t\t" + country.getName() + "\t\t" + country.getContinent()
							+ "\t\t" + country.getSurfacearea() + "\t\t" + country.getHeadofState());
				} else {
					System.out.println("No Data Found");
				}
				System.out.println(
						"----------------------------------------------------------------------------------------------------------");
				menu();
				break;
			case "5":
				System.out.println("System Exited...");
				System.exit(0);
			default:
				System.out.println("Enter Correct input!");
				menu();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		menu();
	}
}


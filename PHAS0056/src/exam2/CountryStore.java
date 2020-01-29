package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class CountryStore {
	
	ArrayList<Country> countries;
	HashMap<String,StringBuilder> idCountryMap= new HashMap<String,StringBuilder>();
	
	public CountryStore(String urlName) throws IOException{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line=br.readLine();
		this.countries= new ArrayList<Country>();
		while(line!=null) {
			Country country= new Country(line);
			idCountryMap.put(country.getCountryID(), country.getName());
			countries.add(country);
			line=br.readLine();
		}
	}
	
	public String toString() {
		return countries.toString();
	}

	/**
	 * @return the countries
	 */
	public ArrayList<Country> getCountries() {
		return countries;
	}

	/**
	 * @param countries the countries to set
	 */
	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries;
	}

	/**
	 * @return the idCountryMap
	 */
	public HashMap<String, StringBuilder> getIdCountryMap() {
		return idCountryMap;
	}

	/**
	 * @param idCountryMap the idCountryMap to set
	 */
	public void setIdCountryMap(HashMap<String, StringBuilder> idCountryMap) {
		this.idCountryMap = idCountryMap;
	}


}

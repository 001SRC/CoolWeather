package model;

public class Country {
	private int id;
	private int City_id;
	private String Country_name;
	private String Country_code;

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCity_id() {
		return this.City_id;
	}
	public void setCity_id(int city_id) {
		this.City_id = city_id;
	}
	public String getCountry_name() {
		return this.Country_name;
	}
	public void setCountry_name(String country_name) {
		this.Country_name = country_name;
	}
	public String getCountry_code() {
		return this.Country_code;
	}
	public void setCountry_code(String country_code) {
		this.Country_code = country_code;
	}
}

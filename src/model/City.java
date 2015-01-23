package model;

public class City {
	private int id;
	private int province_id;
	private String city_name;
	private String city_code;
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProvince_id() {
		return this.province_id;
	}
	public void setProvince_id(int province_id) {
		this.province_id = province_id;
	}
	public String getCity_name() {
		return this.city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getCity_code() {
		return this.city_code;
	}
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}
}

package model;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import db.CoolWeatherOpenHelper;

public class CoolWeatherDB {
	/**
	 * 数据库名
	 */
	public static final String DB_NAME = "coolweather";
	/**
	 * 数据库版本号
	 */
	public static final int DB_VERSION = 1;

	public static CoolWeatherDB coolWeatherDB;
	public SQLiteDatabase db;

	/**
	 * 将构造方法私有化
	 */
	private CoolWeatherDB(Context context) {
		CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context,
				DB_NAME, null, DB_VERSION);
		db = dbHelper.getWritableDatabase();
	}

	/**
	 * 获取 CoolWeatherDB 实例
	 */
	public synchronized static CoolWeatherDB getInstance(Context context) {
		if (coolWeatherDB == null) {
			coolWeatherDB = new CoolWeatherDB(context);
		}
		return coolWeatherDB;
	}

	/**
	 * 将 Province 实例存入数据库
	 */
	public void saveProvince(Province province) {
		if (province != null) {
			ContentValues values = new ContentValues();
			values.put("province_name", province.getProvince_name());
			values.put("province_code", province.getProvince_code());
			db.insert("Province", null, values);
		}
	}

	/**
	 * 从全国数据库中读取所有省份信息
	 */
	public List<Province> loadProvinces() {
		List<Province> list = new ArrayList<Province>();
		Cursor cursor = db.query("Province", null, null, null, null, null,
				null, null);
		if (cursor.moveToFirst()) {
			do {
				Province province = new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id")));
				province.setProvince_name(cursor.getString(cursor
						.getColumnIndex("province_name")));
				province.setProvince_code(cursor.getString(cursor
						.getColumnIndex("province_code")));
				list.add(province);
			} while (cursor.moveToNext());
		}
		return list;
	}

	/**
	 * 将 city 实例存储到数据库
	 */
	public void saveCity(City city) {
		if (city != null) {
			ContentValues values = new ContentValues();
			values.put("city_name", city.getCity_name());
			values.put("city_code", city.getCity_code());
			values.put("province_id", city.getProvince_id());
			db.insert("City", null, values);
		}
	}

	/**
	 * 从全国数据库中读取所有城市信息
	 */
	public List<City> loadCities(int provinceId) {
		List<City> list = new ArrayList<City>();
		Cursor cursor = db.query("City", null, "province_id = ?",
				new String[]{String.valueOf(provinceId)}, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				City city = new City();
				city.setId(cursor.getInt(cursor.getColumnIndex("id")));
				city.setCity_name(cursor.getString(cursor
						.getColumnIndex("city_name")));
				city.setCity_code(cursor.getString(cursor
						.getColumnIndex("city_code")));
				city.setProvince_id(provinceId);
				list.add(city);
			} while (cursor.moveToNext());
		}
		return list;
	}

	/**
	 * 将 Country 实例存储到数据库
	 */
	public void saveCity(Country country) {
		if (country != null) {
			ContentValues values = new ContentValues();
			values.put("country_name", country.getCountry_name());
			values.put("country_code", country.getCountry_code());
			values.put("city_id", country.getCity_id());
			db.insert("Country", null, values);
		}
	}

	/**
	 * 从全国数据库中读取所有县城信息
	 */
	public List<Country> loadCountites(int cityId) {
		List<Country> list = new ArrayList<Country>();
		Cursor cursor = db.query("Country", null, "city_id = ?",
				new String[]{String.valueOf(cityId)}, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				Country country = new Country();
				country.setId(cursor.getInt(cursor.getColumnIndex("id")));
				country.setCountry_name(cursor.getString(cursor
						.getColumnIndex("country_name")));
				country.setCountry_code(cursor.getString(cursor
						.getColumnIndex("country_code")));
				country.setCity_id(cityId);
				list.add(country);
			} while (cursor.moveToNext());
		}
		return list;
	}
}

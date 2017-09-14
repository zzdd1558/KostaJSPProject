package team.dto;

public class CityDTO {
	private int cityNum; // city_num
	private String cityName; // city_name
	
	public CityDTO() {
	}

	public CityDTO(int cityNum, String cityName) {
		super();
		this.cityNum = cityNum;
		this.cityName = cityName;
	}

	public int getCityNum() {
		return cityNum;
	}

	public void setCityNum(int cityNum) {
		this.cityNum = cityNum;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}

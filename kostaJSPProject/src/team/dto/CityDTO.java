package team.dto;

 /** city 테이블 DTO*/
public class CityDTO {
	private int cityNum; // city_num
	private String cityName; // city_name

	// 기본 생성자
	public CityDTO() {
	}

	public CityDTO(int cityNum, String cityName) {
		super();
		this.cityNum = cityNum;
		this.cityName = cityName;
	}

	/**
	 *  setter/getter
	 */

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

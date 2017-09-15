package team.dto;

public class ConcertDTO {
	private int idx;
	private String name;
	private String place;
	private String startDate; // start_date
	private String endDate; // end_date
	private String startTime; // start_time
	private String runningTime; // running_time
	private String cast;
	private String imageUri; // image_uri
	private int adminIdx; // admin_idx
	private int typeNum; // type_num
	private int cityNum; // city_num
	private String joinCityName;
	private String joinTypeName;

	// 기본 생성자
	public ConcertDTO() {
	}

	
	public ConcertDTO(String name, String place,  String joinCityName , String joinTypeName, String startDate, String endDate, String startTime, String runningTime,
			String cast, String imageUri) {
		this.name = name;
		this.place = place;
		this.joinCityName = joinCityName;
		this.joinTypeName = joinTypeName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.runningTime = runningTime;
		this.cast = cast;
		this.imageUri = imageUri;
		
	}

	// 데이터 INSERT 시 사용
	public ConcertDTO(int idx, String name, String place, String startDate, String endDate, String startTime,
			String runningTime, String cast, String imageUri, int adminIdx, int typeNum, int cityNum) {
		super();
		this.idx = idx;
		this.name = name;
		this.place = place;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.runningTime = runningTime;
		this.cast = cast;
		this.imageUri = imageUri;
		this.adminIdx = adminIdx;
		this.typeNum = typeNum;
		this.cityNum = cityNum;
	}
	
	

	public ConcertDTO(int idx, String name, String place, String startDate, String endDate, String startTime,
			String runningTime, String cast, String imageUri, int adminIdx, int typeNum, int cityNum,
			String joinCityName, String joinTypeName) {
		super();
		this.idx = idx;
		this.name = name;
		this.place = place;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.runningTime = runningTime;
		this.cast = cast;
		this.imageUri = imageUri;
		this.adminIdx = adminIdx;
		this.typeNum = typeNum;
		this.cityNum = cityNum;
		this.joinCityName = joinCityName;
		this.joinTypeName = joinTypeName;
	}


	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public int getAdminIdx() {
		return adminIdx;
	}

	public void setAdminIdx(int adminIdx) {
		this.adminIdx = adminIdx;
	}

	public int getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(int typeNum) {
		this.typeNum = typeNum;
	}

	public int getCityNum() {
		return cityNum;
	}

	public void setCityNum(int cityNum) {
		this.cityNum = cityNum;
	}

	public String getJoinCityName() {
		return joinCityName;
	}

	public void setJoinCityName(String joinCityName) {
		this.joinCityName = joinCityName;
	}

	public String getJoinTypeName() {
		return joinTypeName;
	}

	public void setJoinTypeName(String joinTypeName) {
		this.joinTypeName = joinTypeName;
	}

}

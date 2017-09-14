package team.dto;

public class ConcertDTO {
	private int idx;
	private String name;
	private String place;
	private String startDate; // start_date
	private String endDate; // end_date
	private String startTime; // start_time
	private String runningTime; //running_time
	private String cast;
	private String image_uri; // image_uri
	private int adminIdx;	// admin_idx
	private int type_num;	// type_num
	private int city_num;	// city_num
	
	
	// 기본 생성자
	public ConcertDTO() {
	}

	
	public ConcertDTO(int idx, String name, String place, String startDate, String endDate, String startTime,
			String runningTime, String cast, String image_uri, int adminIdx, int type_num, int city_num) {
		super();
		this.idx = idx;
		this.name = name;
		this.place = place;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.runningTime = runningTime;
		this.cast = cast;
		this.image_uri = image_uri;
		this.adminIdx = adminIdx;
		this.type_num = type_num;
		this.city_num = city_num;
	}


	 
	// setter/getter
	 
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


	public String getImage_uri() {
		return image_uri;
	}


	public void setImage_uri(String image_uri) {
		this.image_uri = image_uri;
	}


	public int getAdminIdx() {
		return adminIdx;
	}


	public void setAdminIdx(int adminIdx) {
		this.adminIdx = adminIdx;
	}


	public int getType_num() {
		return type_num;
	}


	public void setType_num(int type_num) {
		this.type_num = type_num;
	}


	public int getCity_num() {
		return city_num;
	}


	public void setCity_num(int city_num) {
		this.city_num = city_num;
	}
	
}

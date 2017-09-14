package team.dto;

public class AdminDTO {
	private int adminIdx; // admin_idx
	private String id;
	private String password;
	private String phoneNum;
	private String email;

	// 기본생성자
	public AdminDTO() {
	}

	public AdminDTO(int adminIdx, String id, String password, String phoneNum, String email) {
		super();
		this.adminIdx = adminIdx;
		this.id = id;
		this.password = password;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	// setter/getter

	public int getAdminIdx() {
		return adminIdx;
	}

	public void setAdminIdx(int adminIdx) {
		this.adminIdx = adminIdx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

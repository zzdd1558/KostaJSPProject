package team.dto;

public class AdminDTO {
	private int adminIdx; // admin_idx
	private String id;
	private String password;
	
	public AdminDTO() {
	}

	public AdminDTO(int adminIdx, String id, String password) {
		super();
		this.adminIdx = adminIdx;
		this.id = id;
		this.password = password;
	}

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

}

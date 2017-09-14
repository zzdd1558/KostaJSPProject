package team.dto;

public class TypeDTO {
	
	private int typeNum; // type_num
	private String typeName; // type_name
	
	
	// 기본 생성자
	public TypeDTO() {
	}

	
	// setter/getter

	public TypeDTO(int typeNum, String typeName) {
		super();
		this.typeNum = typeNum;
		this.typeName = typeName;
	}


	public int getTypeNum() {
		return typeNum;
	}


	public void setTypeNum(int typeNum) {
		this.typeNum = typeNum;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}

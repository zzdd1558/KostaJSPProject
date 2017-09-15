package team.dto;

public class TypeDTO {
	
	private int typeNum; // type_num
	private String typeName; // type_name
	
	
	// 기본 생성자
	public TypeDTO() {
	}
	
	public TypeDTO(int typeNum, String typeName) {
		super();
		this.typeNum = typeNum;
		this.typeName = typeName;
	}

	// setter/getter

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

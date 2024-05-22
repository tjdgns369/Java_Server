package model_ver1;

public class People_DTO {

	private String name;
	private String major;
	private String phone;
	
	public People_DTO(String name, String major, String phone) {
		this.name = name;
		this.major = major;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public String getMajor() {
		return major;
	}
	public String getPhone() {
		return phone;
	}
}

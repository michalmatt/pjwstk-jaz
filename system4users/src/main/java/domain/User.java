package domain;

public class User {
	private String name;
	private String password;
	private String email;
	private boolean premiumAccess = false;
	private boolean adminAccess = false;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isPremiumAccess() {
		return premiumAccess;
	}
	public void setPremiumAccess(boolean premiumAccess) {
		this.premiumAccess = premiumAccess;
	}
	public boolean isAdminAccess() {
		return adminAccess;
	}
	public void setAdminAccess(boolean adminAccess) {
		this.adminAccess = adminAccess;
	}

}

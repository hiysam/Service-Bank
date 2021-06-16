package endpoint.service.bank.dto;

public class TransaksiDto {

	private String username;
	private int nominal;
	private String usernameTujuan;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getNominal() {
		return nominal;
	}
	public void setNominal(int nominal) {
		this.nominal = nominal;
	}
	public String getUsernameTujuan() {
		return usernameTujuan;
	}
	public void setUsernameTujuan(String usernameTujuan) {
		this.usernameTujuan = usernameTujuan;
	}
}

package endpoint.service.bank.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaksi")
public class Transaksi {
	
	@Id
	@Column(name = "id_transaksi")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTransaksi;
		
	@Column(name = "username")
	private String username;
		
	@Column(name = "status")
	private String status;
	
	@Column(name = "username_tujuan")
	private String usernameTujuan;
		
	@Column(name = "nominal")
	private int nominal;
		
	@Column(name = "create_transaksi")
	private Date createTransaksi;

	public int getIdTransaksi() {
		return idTransaksi;
	}

	public void setIdTransaksi(int idTransaksi) {
		this.idTransaksi = idTransaksi;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsernameTujuan() {
		return usernameTujuan;
	}

	public void setUsernameTujuan(String usernameTujuan) {
		this.usernameTujuan = usernameTujuan;
	}

	public int getNominal() {
		return nominal;
	}

	public void setNominal(int nominal) {
		this.nominal = nominal;
	}

	public Date getCreateTransaksi() {
		return createTransaksi;
	}

	public void setCreateTransaksi(Date createTransaksi) {
		this.createTransaksi = createTransaksi;
	}
}

package es.unileon.ulebank.office;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "office")
public class Office implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Id of the office
	 */
	private String idOffice;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * The address of the office
	 */
	private String address;
	private Double balance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdOffice() {
		return idOffice;
	}

	public void setIdOffice(String idOffice) {
		this.idOffice = idOffice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Address: " + address + ";");
		buffer.append("Balance: " + this.getBalance());
		return buffer.toString();
	}

}

package Hospitalmanagement.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Billing {
	@Id
	private int Billing_id;
	private String payment_status;
	private  long payment_amount;
	private String payment_method;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Patient Patient_id;
	public int getBilling_id() {
		return Billing_id;
	}
	public void setBilling_id(int billing_id) {
		Billing_id = billing_id;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	
	public long getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(long payment_amount) {
		this.payment_amount = payment_amount;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public Billing() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient getPatient_id() {
		return Patient_id;
	}
	public void setPatient_id(Object newPatient_id) {
		Patient_id = (Patient) newPatient_id;
	}
	public void setBilling_amount1(long nextLong) {
		// TODO Auto-generated method stub
		
	}
	public void setBilling_amount(long nextLong) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "Billing [Billing_id=" + Billing_id + ", payment_status=" + payment_status + ", payment_amount="
				+ payment_amount + ", payment_method=" + payment_method + ", Patient_id=" + Patient_id + "]";
	}
	public void Patient(Patient patient) {
		// TODO Auto-generated method stub
		
	}
	public void setPatient(Patient newPatient) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}

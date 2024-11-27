package Hospitalmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Patient {
	@Id
	private int  Patient_id;
	private  String Patientname;
	private int age;
	private String Gender;
	private  String Contactinfo;
	private String email;
	private String address;
	public int getPatient_id() {
		return Patient_id;
	}
	public void setPatient_id(int patient) {
		Patient_id = patient;
	}
	public String getPatientname() {
		return Patientname;
	}
	public void setPatientname(String patientname) {
		Patientname = patientname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getContactinfo() {
		return Contactinfo;
	}
	public void setContactinfo(String contactinfo) {
		Contactinfo = contactinfo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Patient [Patient_id=" + Patient_id + ", Patientname=" + Patientname + ", age=" + age + ", Gender="
				+ Gender + ", Contactinfo=" + Contactinfo + ", email=" + email + ", address=" + address + "]";
	}
		// TODO Auto-generated method stub
	public void setPatient_id1(int patient_id) {
		// TODO Auto-generated method stub
		
	}
		
	}




package Hospitalmanagement.entities;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Rooms {
	@Id
          private int Prescription_id;
          private Date Prescription_date;
          
          
          @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
          @JoinColumn(name="doctor_id")
          private Doctor doctor;
          
		@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
          @JoinColumn(name="patient_id")
          private Patient patient;
		public int getPrescription_id() {
			return Prescription_id;
		}
		public void setPrescription_id(int prescription_id) {
			Prescription_id = prescription_id;
		}
		public Date getPrescription_date() {
			return Prescription_date;
		}
		public void setPrescription_date(Date prescription_date) {
			Prescription_date = prescription_date;
		}
		public Doctor getDoctor() {
			return doctor;
		}
		public Rooms() {
			super();
			// TODO Auto-generated constructor stub
		}
		public void setDoctor(Doctor doctor) {
			this.doctor = doctor;
		}
		public Patient getPatient() {
			return patient;
		}
		public void setPatient(Patient patient) {
			this.patient = patient;
		}
		//public void setPatient(Patient patient) {
			// TODO Auto-generated method stub
			
		//}
		//public void setDoctor(Doctor doctor) {
			// TODO Auto-generated method stub
			
		//}
	
		@Override
		public String toString() {
			return "Prescription [Prescription_id=" + Prescription_id + ", Prescription_date=" + Prescription_date
					+ ", doctor_id=" + doctor+ ", patient_id=" + patient + ", getPrescription_id()="
					+ getPrescription_id() + ", getPrescription_date()=" + getPrescription_date() + ", getDoctor_id()="
					+ getDoctor() + ", getPatient_id()=" + getPatient() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
		public void setRoom_type(String next) {
			// TODO Auto-generated method stub
			
		}
		public void setRoom_status(String next) {
			// TODO Auto-generated method stub
			
		}
		public void setRoom_id(int room_id) {
			// TODO Auto-generated method stub
			
		} 

}

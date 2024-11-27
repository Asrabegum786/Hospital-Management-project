package Hospitalmanagement.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Medical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recordsId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // Add cascade here
    @JoinColumn(name="patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public int getRecordsId() {
        return recordsId;
    }

    public void setRecordsId(int recordsId) {
        this.recordsId = recordsId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Medical() {
        // Default constructor
    }

    public Medical(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

	@Override
	public String toString() {
		return "Medical [recordsId=" + recordsId + ", patient=" + patient + ", doctor=" + doctor + ", getRecordsId()="
				+ getRecordsId() + ", getPatient()=" + getPatient() + ", getDoctor()=" + getDoctor() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}

















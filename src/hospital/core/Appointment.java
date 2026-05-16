
package hospital.core;
import java.io.Serializable;

public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;
    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String dateTime;
    private String status;

    public Appointment(String appointmentId, Patient patient, Doctor doctor, String dateTime) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.status = "Pending";
    }

    public String getAppointmentId() { return appointmentId; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public String getDateTime() { return dateTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

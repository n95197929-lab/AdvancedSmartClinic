package hospital.core;
import java.io.Serializable;

public class MedicalRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private String recordId;
    private String patientId;
    private String diagnosis;
    private String prescription;

    public MedicalRecord(String recordId, String patientId, String diagnosis, String prescription) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

    public String getRecordId() { return recordId; }
    public String getPatientId() { return patientId; }
    public String getDiagnosis() { return diagnosis; }
    public String getPrescription() { return prescription; }
}

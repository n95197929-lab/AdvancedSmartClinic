
package hospital.core;

public class Patient extends User {
    private int age;
    private String medicalHistory;

    public Patient(String id, String name, int age, String medicalHistory) {
        super(id, name, "Patient");
        this.age = age;
        this.medicalHistory = medicalHistory;
    }

    public int getAge() { return age; }
    public String getMedicalHistory() { return medicalHistory; }
}

package hospital.core;

public class Doctor extends User {
    private String specialization;
    private boolean isAvailable;

    public Doctor(String id, String name, String specialization) {
        super(id, name, "Doctor");
        this.specialization = specialization;
        this.isAvailable = true;
    }

    public String getSpecialization() { return specialization; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}

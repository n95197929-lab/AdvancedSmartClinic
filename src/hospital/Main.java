package hospital;

import hospital.core.*;
import hospital.network.ClinicClient;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Clinic Client Test...");

        ClinicClient client = new ClinicClient();

        Doctor doctor = new Doctor("D01", "Dr. Ahmed", "Cardiology");
        Patient patient = new Patient("P01", "Nour", 20, "No chronic diseases");

        Appointment appointment = new Appointment("A101", patient, doctor, "2026-05-17 10:00 AM");

        System.out.println("Sending appointment to server...");
        client.sendAppointment(appointment);
    }
}

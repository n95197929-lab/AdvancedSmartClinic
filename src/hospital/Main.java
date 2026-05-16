package hospital;

import hospital.core.*;
import hospital.network.ClinicClient;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Clinic Client Test...");

        // 1. عمل كائن كليّنت للتوصيل بالشبكة
        ClinicClient client = new ClinicClient();

        // 2. عمل بيانات طبيب ومريض وهمية للتجربة
        Doctor doctor = new Doctor("D01", "Dr. Ahmed", "Cardiology");
        Patient patient = new Patient("P01", "Nour", 20, "No chronic diseases");

        // 3. عمل حجز موعد جديد
        Appointment appointment = new Appointment("A101", patient, doctor, "2026-05-17 10:00 AM");

        // 4. إرسال الموعد عبر الشبكة للسيرفر
        System.out.println("Sending appointment to server...");
        client.sendAppointment(appointment);
    }
}

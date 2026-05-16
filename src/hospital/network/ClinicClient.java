package hospital.network;

import hospital.core.*;
import java.io.*;
import java.net.*;

public class ClinicClient {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public void sendAppointment(Appointment appointment) {
        try (Socket socket = new Socket(HOST, PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            out.writeObject("ADD_APPOINTMENT");
            out.writeObject(appointment);
            out.flush();

            String response = (String) in.readObject();
            System.out.println("Server says: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMedicalRecord(MedicalRecord record) {
        try (Socket socket = new Socket(HOST, PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            out.writeObject("ADD_RECORD");
            out.writeObject(record);
            out.flush();

            String response = (String) in.readObject();
            System.out.println("Server says: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

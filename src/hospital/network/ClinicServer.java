package hospital.network;

import hospital.core.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class ClinicServer {
    private static final int PORT = 12345;
    private static List<Appointment> appointments = Collections.synchronizedList(new ArrayList<>());
    private static List<MedicalRecord> records = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        System.out.println("Hospital Server is running...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                 ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

                String requestType = (String) in.readObject();
                if ("ADD_APPOINTMENT".equals(requestType)) {
                    Appointment app = (Appointment) in.readObject();
                    appointments.add(app);
                    out.writeObject("SUCCESS: Appointment added.");
                } else if ("ADD_RECORD".equals(requestType)) {
                    MedicalRecord rec = (MedicalRecord) in.readObject();
                    records.add(rec);
                    out.writeObject("SUCCESS: Medical record added.");
                } else if ("GET_APPOINTMENTS".equals(requestType)) {
                    out.writeObject(new ArrayList<>(appointments));
                } else {
                    out.writeObject("ERROR: Unknown request.");
                }
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
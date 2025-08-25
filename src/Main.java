import java.util.Scanner;

/**
 * This file creates the console menus that the user interacts with,
 * and it connects to the managers
 * validate IDs before booking
 *
 *
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static final PatientManager pm = new PatientManager();
    private static final DoctorManager dm = new DoctorManager();
    private static final AppointmentManager am = new AppointmentManager(pm, dm);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Hospital Management Main Menu ===");
            System.out.println("1) Patients");
            System.out.println("2) Doctors");
            System.out.println("3) Appointments");
            System.out.println("0) Exit");
            int ch = readInt("Choose: ");
            if (ch == 0) {
                System.out.println("Goodbye!");
                break;
            }
            switch (ch) {
                case 1: patientsMenu(); break;
                case 2: doctorsMenu(); break;
                case 3: appointmentsMenu(); break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    /* ================= Patients Menu ================= */
    private static void patientsMenu() {
        while (true) {
            System.out.println("\n-- Patients --");
            System.out.println("1) Add");
            System.out.println("2) Update");
            System.out.println("3) Delete");
            System.out.println("4) List");
            System.out.println("0) Back");
            int ch = readInt("Choose: ");
            if (ch == 0) return;
            switch (ch) {
                case 1: addPatient(); break;
                case 2: updatePatient(); break;
                case 3: deletePatient(); break;
                case 4: pm.list(); break;
                default: System.out.println("Invalid.");
            }
        }
    }
    private static void addPatient() {
        System.out.println("-- Add Patient --");
        String first  = read("First name: ");
        String last   = read("Last name: ");
        String dob    = read("DOB (string): ");
        String gender = read("Gender: ");
        Patient p = pm.add(first, last, dob, gender);
        System.out.println(p != null ? "Added Patient ID: " + p.getId() : "Storage full.");
    }
    private static void updatePatient() {
        System.out.println("-- Update Patient --");
        int id       = readInt("Patient ID: ");
        String first = read("New first (blank = skip): ");
        String last  = read("New last (blank = skip): ");
        String dob   = read("New DOB (blank = skip): ");
        String gender= read("New gender (blank = skip): ");
        boolean ok = pm.update(id, first, last, dob, gender);
        System.out.println(ok ? "Updated." : "Patient not found.");
    }
    private static void deletePatient() {
        System.out.println("-- Delete Patient --");
        int id = readInt("Patient ID: ");
        System.out.println(pm.delete(id) ? "Deleted." : "Patient not found.");
    }

    /* ================= Doctors Menu ================= */
    private static void doctorsMenu() {
        while (true) {
            System.out.println("\n-- Doctors --");
            System.out.println("1) Add");
            System.out.println("2) Update");
            System.out.println("3) Delete");
            System.out.println("4) List");
            System.out.println("0) Back");
            int ch = readInt("Choose: ");
            if (ch == 0) return;
            switch (ch) {
                case 1: addDoctor(); break;
                case 2: updateDoctor(); break;
                case 3: deleteDoctor(); break;
                case 4: dm.list(); break;
                default: System.out.println("Invalid.");
            }
        }
    }
    private static void addDoctor() {
        System.out.println("-- Add Doctor --");
        String first  = read("First name: ");
        String last   = read("Last name: ");
        String dob    = read("DOB (string): ");
        String gender = read("Gender: ");
        String spec   = read("Specialty: ");
        Doctor d = dm.add(first, last, dob, gender, spec);
        System.out.println(d != null ? "Added Doctor ID: " + d.getId() : "Storage full.");
    }
    private static void updateDoctor() {
        System.out.println("-- Update Doctor --");
        int id        = readInt("Doctor ID: ");
        String first  = read("New first (blank = skip): ");
        String last   = read("New last (blank = skip): ");
        String dob    = read("New DOB (blank = skip): ");
        String gender = read("New gender (blank = skip): ");
        String spec   = read("New specialty (blank = skip): ");
        boolean ok = dm.update(id, first, last, dob, gender, spec);
        System.out.println(ok ? "Updated." : "Doctor not found.");
    }
    private static void deleteDoctor() {
        System.out.println("-- Delete Doctor --");
        int id = readInt("Doctor ID: ");
        System.out.println(dm.delete(id) ? "Deleted." : "Doctor not found.");
    }

    /* =============== Appointments Menu =============== */
    private static void appointmentsMenu() {
        while (true) {
            System.out.println("\n-- Appointments --");
            System.out.println("1) Book");
            System.out.println("2) Cancel");
            System.out.println("3) Reschedule");
            System.out.println("4) List");
            System.out.println("0) Back");
            int ch = readInt("Choose: ");
            if (ch == 0) return;
            switch (ch) {
                case 1: bookAppt(); break;
                case 2: cancelAppt(); break;
                case 3: rescheduleAppt(); break;
                case 4: am.list(); break;
                default: System.out.println("Invalid.");
            }
        }
    }
    private static void bookAppt() {
        System.out.println("-- Book Appointment --");
        int pid    = readInt("Patient ID: ");
        int did    = readInt("Doctor ID: ");
        String when= read("DateTime (e.g. 2025-08-25 10:00): ");
        String reason = read("Reason: ");
        Appointment a = am.book(pid, did, when, reason);
        System.out.println(a != null ? "Booked Appointment ID: " + a.getId() : "Booking failed.");
    }
    private static void cancelAppt() {
        System.out.println("-- Cancel Appointment --");
        int id = readInt("Appointment ID: ");
        System.out.println(am.cancel(id) ? "Cancelled." : "Appointment not found.");
    }
    private static void rescheduleAppt() {
        System.out.println("-- Reschedule Appointment --");
        int id = readInt("Appointment ID: ");
        String when = read("New DateTime: ");
        System.out.println(am.reschedule(id, when) ? "Rescheduled." : "Failed.");
    }





















    /* ================== helpers ================== */
    private static String read(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Enter a number.");
            }
        }
    }
}

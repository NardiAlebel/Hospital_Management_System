public class AppointmentManager {
    private Appointment[] arr = new Appointment[200];
    private int count = 0;
    private int nextId = 5000;

    // managers to validate patient and doctor IDs
    private PatientManager pm;
    private DoctorManager dm;

    public AppointmentManager(PatientManager pm, DoctorManager dm) {
        this.pm = pm;
        this.dm = dm;
    }

    public Appointment book(int patientId, int doctorId, String dateTime, String reason) {
        if (!pm.exists(patientId)) {
            System.out.println("Patient not found.");
            return null;
        }
        if (!dm.exists(doctorId)) {
            System.out.println("Doctor not found.");
            return null;
        }
        if (count >= arr.length) {
            System.out.println("Appointment storage full.");
            return null;
        }

        // check conflict: same doctor, same dateTime, and not cancelled
        for (int i = 0; i < count; i++) {
            Appointment a = arr[i];
            if (a.getDoctorId() == doctorId &&
                    a.getDateTime().equals(dateTime) &&
                    !a.getStatus().equals("CANCELLED")) {
                System.out.println("Conflict: doctor already booked at that time.");
                return null;
            }
        }

        Appointment ap = new Appointment(nextId++, patientId, doctorId, dateTime, reason, "BOOKED");
        arr[count++] = ap;
        return ap;
    }

    public boolean cancel(int apptId) {
        int i = indexOf(apptId);
        if (i == -1) return false;
        arr[i].setStatus("CANCELLED");
        return true;
    }

    public boolean reschedule(int apptId, String newDateTime) {
        int i = indexOf(apptId);
        if (i == -1) return false;

        Appointment ap = arr[i];
        if (ap.getStatus().equals("CANCELLED")) {
            System.out.println("Cannot reschedule a cancelled appointment.");
            return false;
        }

        // conflict check again
        for (int k = 0; k < count; k++) {
            Appointment other = arr[k];
            if (other.getId() != ap.getId() &&
                    other.getDoctorId() == ap.getDoctorId() &&
                    other.getDateTime().equals(newDateTime) &&
                    !other.getStatus().equals("CANCELLED")) {
                System.out.println("Conflict: doctor already booked at that time.");
                return false;
            }
        }

        ap.setDateTime(newDateTime);
        return true;
    }

    public void list() {
        if (count == 0) {
            System.out.println("No appointments.");
            return;
        }
        System.out.println("ID | PatientID | DoctorID | DateTime | Reason | Status");
        for (int i = 0; i < count; i++) {
            Appointment a = arr[i];
            System.out.println(a.getId() + " | " + a.getPatientId() + " | " + a.getDoctorId() + " | " +
                    a.getDateTime() + " | " + a.getReason() + " | " + a.getStatus());
        }
    }

    public boolean exists(int id) { return indexOf(id) != -1; }

    private int indexOf(int id) {
        for (int i = 0; i < count; i++)
            if (arr[i].getId() == id) return i;
        return -1;
    }
}

public class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private String dateTime;
    private String reason;
    private String status;

    public Appointment(int id, int patientId, int doctorId, String dateTime, String reason, String status) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.dateTime = dateTime;
        this.reason = reason;
        this.status = status;
    }

    public int getId() { return id; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getDateTime() { return dateTime; }
    public String getReason() { return reason; }
    public String getStatus() { return status; }

    public void setDateTime(String dateTime) { this.dateTime = dateTime; }
    public void setReason(String reason) { this.reason = reason; }
    public void setStatus(String status) { this.status = status; }
}

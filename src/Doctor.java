public class Doctor extends Human {
    private String specialty;
    public Doctor(int id, String first, String last, String dob, String gender, String specialty) {
        super(id, first, last, dob, gender);
        this.specialty = specialty;
    }
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    @Override
    public String getFullName() { return "Dr. " + getFirstName() + " " + getLastName(); }
}

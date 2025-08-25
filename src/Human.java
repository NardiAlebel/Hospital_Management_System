import java.util.Date;

abstract class Human {
    private  int id;
     private String firstName;
    private  String lastName;
    private   String dob;
     private String gender;

    public Human(int id,String firstName,String lastName,String dob,String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
    }

    /**
     *
     * abstract method  when implemented it should  return full name
     */
    public abstract String getFullName();


    /**
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return  the current first name
     */

    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return the current  lastname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return  the Dob
     */
    public String getDob() {
        return dob;
    }

    /**
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * setters in case there is an update
     * @param firstName is the new firstname
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @param lastName is the new lastname
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @param dob is the new date of birth
     */

    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     *
     * @param gender is the new gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }



}

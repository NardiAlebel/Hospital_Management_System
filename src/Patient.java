import java.util.Date;

public class Patient extends Human {
    public Patient(int id,String firstName,String lastName,String dob,String gender){
       super(id,firstName,lastName,dob,gender);


   }
    @Override
    public String getFullName(){
        return getFirstName() + " " + getLastName();
    }



}

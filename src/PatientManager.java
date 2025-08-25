public class PatientManager {
    /**
     * created array tha will store patient information
     * how many slots are used in the array
     * generates unique patient id
     */
    private Patient[] arr = new Patient[50];
    private int count = 0;
    private int nextId = 1;

    /**
     * creates a new patient
     * if array is full return null
     * uses the current id and increment  for the next one
     * store patient at the next free position
     * return the created patient
     *
     *
     */
    public Patient add(String first, String last, String dob, String gender) {
        if (count >= arr.length)
            return null;
        Patient p = new Patient(nextId++, first, last, dob, gender);
        arr[count++] = p;
        return p;
    }

    /**
     *
     * updates the field for existing patients
     * tracks where the array the id lives
     * if id is not found stop
     * get the pattient object at that index
     * only the fields that are not left blank is updated
     */

    public boolean update(int id, String first, String last, String dob, String gender) {
        int i = indexOf(id);
        if (i == -1)
            return false;
        Patient p = arr[i];
        if (!first.equals(""))  p.setFirstName(first);
        if (!last.equals(""))   p.setLastName(last);
        if (!dob.equals(""))    p.setDob(dob);
        if (!gender.equals("")) p.setGender(gender);
        return true;
    }

    /**
     *
     * use the index of id to track where in the array
     * we need to shift to the left
     * the index of obj to be deleted
     * erarses any duplicate
     *
     */
    public boolean delete(int id) {
        int i = indexOf(id);
        if (i == -1)
            return false;
        for (int j = i; j < count - 1; j++) arr[j] = arr[j + 1];
        arr[--count] = null;
        return true;
    }

    /**
     * prints header row
     * gets the object at this index
     * uses the getter
     */
    public void list() {
        if (count == 0)
        { System.out.println("No patients.");
            return;
        }
        System.out.println("ID | Name | DOB | Gender");
        for (int i = 0; i < count; i++) {
            Patient p = arr[i];
            System.out.println(p.getId() + " | " + p.getFullName() + " | " + p.getDob() + " | " + p.getGender());
        }
    }

    public boolean exists(int id)
    {
        return indexOf(id) != -1;
    }

    /**
     *
     * loop through the array
     * compare the id of each object with the id
     */
    private int indexOf(int id) {
        for (int i = 0; i < count; i++)
            if (arr[i].getId() == id)
                return i;
        return -1;
    }
}

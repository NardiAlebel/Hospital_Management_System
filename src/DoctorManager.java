
    public class DoctorManager {
        private Doctor[] arr = new Doctor[100];
        private int count = 0;
        private int nextId = 1000;

        public Doctor add(String first, String last, String dob, String gender, String specialty) {
            if (count >= arr.length) return null;
            Doctor d = new Doctor(nextId++, first, last, dob, gender, specialty);
            arr[count++] = d;
            return d;
        }

        public boolean update(int id, String first, String last, String dob, String gender, String specialty) {
            int i = indexOf(id);
            if (i == -1) return false;
            Doctor d = arr[i];
            if (!first.equals("")) d.setFirstName(first);
            if (!last.equals("")) d.setLastName(last);
            if (!dob.equals("")) d.setDob(dob);
            if (!gender.equals("")) d.setGender(gender);
            if (!specialty.equals("")) d.setSpecialty(specialty);
            return true;
        }

        public boolean delete(int id) {
            int i = indexOf(id);
            if (i == -1) return false;
            for (int j = i; j < count - 1; j++) arr[j] = arr[j + 1];
            arr[--count] = null;
            return true;
        }

        public void list() {
            if (count == 0) {
                System.out.println("No doctors.");
                return;
            }
            System.out.println("ID | Name | DOB | Gender | Specialty");
            for (int i = 0; i < count; i++) {
                Doctor d = arr[i];
                System.out.println(d.getId() + " | " + d.getFullName() + " | " + d.getDob() + " | " + d.getGender() + " | " + d.getSpecialty());
            }
        }

        public boolean exists(int id) {
            return indexOf(id) != -1;
        }

        private int indexOf(int id) {
            for (int i = 0; i < count; i++) if (arr[i].getId() == id) return i;
            return -1;
        }
    }

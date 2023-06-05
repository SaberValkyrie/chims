package SQL;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    private String img;




    public Student(String firstName, String lastname, String email,String img){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastname;
        this.email = email;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student(int id, String firstName, String lastname, String email,String img){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastname;
        this.email = email;
        this.img = img;
    }
    @Override
    public String toString(){
        return "Student [id=" + id + ",firstName=" + firstName + ", lastName=" + lastName + ",email=" + email + ",img=" + img +"]";
    }
}


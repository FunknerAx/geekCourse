public class Employee {
    private String firstname;
    private String surname;
    private String lastname;
    private int age;
    private String eMail;
    private String phone;
    private String position;
    private int salary;
    private String salaryCurrency;

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String geteMail() {
        return eMail;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getPosition() {
        return position;
    }

    public String getSalaryCurrency() {
        return salaryCurrency;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSalaryCurrency(String salaryCurrency) {
        this.salaryCurrency = salaryCurrency;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "full name='" + firstname + " " + surname + " " + lastname + '\'' +
                ", age=" + age +
                ", eMail='" + eMail + '\'' +
                ", phone='" + phone + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary + " " + salaryCurrency +
                '}';
    }

    public Employee(String firstname, String surname, String lastname, int age, String eMail, String phone, String position, int salary, String salaryCurrency) {
        this.firstname = firstname;
        this.surname = surname;
        this.lastname = lastname;
        this.age = age;
        this.eMail = eMail;
        this.phone = phone;
        this.position = position;
        this.salary = salary;
        this.salaryCurrency = salaryCurrency;
    }
}

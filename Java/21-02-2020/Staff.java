
public class Staff extends Person {
    private String school = "";
    private double pay;//primitive
    //private Double pay = 0.0;
    Staff() {}
    Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }
    //getter, setter 
    Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
    //setter
    public void setSchool(String school) {
        this.school = school;
    }
    public void setPay(double pay) {
        this.pay = pay;
    }
    //getter
    public String getSchool() {
        return this.school;
    }
    public double getPay() {
        return pay;
    }

}
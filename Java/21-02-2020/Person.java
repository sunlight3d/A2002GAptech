public class Person {
    private String name, address;
    //setter 
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    //getter
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    @Override //override from Object
    public String toString() {
        return "Name: "+this.name+
                ",Address : "+this.address;
    }
    //construtor
    //default constructor
    Person() {
        this.name = "";
        this.address = "";
    }
    Person(String name) {
        this.name = name;
        this.address = "";
    }
    //...overloading
    Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
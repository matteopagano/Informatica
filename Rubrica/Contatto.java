public class Contatto {
    private String name;
    private String surname;
    private long number;
    private String email;
    private String address;

    public Contatto(String name, String surname, long number, String email, String address) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.email = email;
        this.address = address;
    }

    public Contatto(String name, long number) {
        this.name = name;
        this.number = number;
    }

    public Contatto(String name, String surname, long number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
    }

    public Contatto(String name, String surname, long number, String email) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contatto;"+getName()+";"+getSurname()+";"+getNumber()+";"+getEmail()+";"+getAddress()+";\n";
    }
}

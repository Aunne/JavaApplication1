package javaapplication1;

public class Author {
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    private String name;
    private String email;
    private char gender;


    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public char getGender() {
        return this.gender;
    }

    public String toString() {
        return this.name + "(" + this.gender + ")";
    }
}

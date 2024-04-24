package com.example.oblig1;
public class Oblig1 {
    private String film;
    private int antall;
    private String name;
    private String surname;
    private int phone;
    private String email;

    public Oblig1(String film, int antall, String name, String surname, int phone, String email) {
        this.film = film;
        this.antall = antall;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;

    }

    public String getFilm() {
        return film;
    }

    public int getAntall() {
        return antall;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setFilm
            (String film) {
        this.film = film;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

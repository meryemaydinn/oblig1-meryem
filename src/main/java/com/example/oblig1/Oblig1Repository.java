package com.example.oblig1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class Oblig1Repository {
    @Autowired
    private JdbcTemplate db;
    public void lagreBillet(Oblig1 billet){
        String sql = "INSERT INTO Oblig1(film, antall, name, surname, phone, email) VALUES(?,?,?,?,?,?)";
        db.update(sql, billet.getFilm(), billet.getAntall(), billet.getName(), billet.getSurname(), billet.getPhone(), billet.getEmail());
    }

    public List<Oblig1> hentAlleBilletter() {
        String sql = "SELECT * FROM Oblig1 ORDER BY surname";
        List<Oblig1> hentAlle = db.query(sql, new BeanPropertyRowMapper<>(Oblig1.class));
        return hentAlle;
    }

    public void slettAlleBilletter(){
        String sql = "Delete From Oblig1";
        db.update(sql);
    }

}



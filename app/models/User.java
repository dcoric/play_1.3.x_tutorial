package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created by Denis on 16.7.2016..
 */
@Entity
public class User extends Model {
    public String email;
    public String fullName;
    public String password;
    public boolean isAdmin;

    public static User connect(String email, String password) {
        return find("byEmailAndPassword", email, password).first();
    }

    public User(String email, String password, String fullName) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }
}

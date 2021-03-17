package kz.webProgram.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Basket {
   private Long id;
   private String username;
   private int toyid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getToyid() {
        return toyid;
    }

    public void setToyid(int toyid) {
        this.toyid = toyid;
    }

    public Basket(Long id, String username, int toyid) {
        this.id = id;
        this.username = username;
        this.toyid = toyid;
    }

    public Basket() {
    }
}

package kz.webProgram.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Toys {
    private Long id;
    private String nametoys;
    private String company;
    private String kat;
    private int price;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNametoys() {
        return nametoys;
    }

    public void setNametoys(String nametoys) {
        this.nametoys = nametoys;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getKat() {
        return kat;
    }

    public void setKat(String kat) {
        this.kat = kat;
    }

    public Toys(Long id, String nametoys, String company, String kat, int price) {
        this.id = id;
        this.nametoys = nametoys;
        this.company = company;
        this.kat = kat;
        this.price = price;
    }

    public Toys() {
    }
}

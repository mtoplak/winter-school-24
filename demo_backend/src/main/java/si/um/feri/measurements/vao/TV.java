package si.um.feri.measurements.vao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class TV {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String naziv;

    private float cena;

    private int steviloProgramov;

    private boolean casovniZamik;

    private String dodatno;

    public TV(Long id, String naziv, float cena, int steviloProgramov, boolean casovniZamik, String dodatno) {
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
        this.steviloProgramov = steviloProgramov;
        this.casovniZamik = casovniZamik;
        this.dodatno = dodatno;
    }

    public TV(TV tv) {
        this.naziv = tv.getNaziv();
        this.cena = tv.getCena();
        this.dodatno = tv.getDodatno();
        this.steviloProgramov = tv.getSteviloProgramov();
        this.casovniZamik = tv.isCasovniZamik();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public int getSteviloProgramov() {
        return steviloProgramov;
    }

    public void setSteviloProgramov(int steviloProgramov) {
        this.steviloProgramov = steviloProgramov;
    }

    public boolean isCasovniZamik() {
        return casovniZamik;
    }

    public void setCasovniZamik(boolean casovniZamik) {
        this.casovniZamik = casovniZamik;
    }

    public String getDodatno() {
        return dodatno;
    }

    public void setDodatno(String dodatno) {
        this.dodatno = dodatno;
    }
}

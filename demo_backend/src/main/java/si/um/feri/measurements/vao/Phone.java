package si.um.feri.measurements.vao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String naziv;

    private float cena;

    private float prenosPodatkov;

    private int steviloMinut;

    private String hitrost;

    public Phone(String naziv, float cena, float prenosPodatkov, int steviloMinut, String hitrost) {
        this.naziv = naziv;
        this.cena = cena;
        this.prenosPodatkov = prenosPodatkov;
        this.steviloMinut = steviloMinut;
        this.hitrost = hitrost;
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

}

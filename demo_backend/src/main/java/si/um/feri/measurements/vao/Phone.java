package si.um.feri.measurements.vao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import si.um.feri.measurements.dto.InternetDTO;

@Entity
@Data
@NoArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String naziv;

    private float cena;

    public Phone(Long id, String naziv, float cena) {
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
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

    public Phone(Phone dto) {
        this.id = dto.getId();
        this.cena= dto.getCena();
        this.naziv = dto.getNaziv();
    }

    public InternetDTO toDto() {
        return new InternetDTO(id, naziv, cena);
    }
}

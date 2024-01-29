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
public class Internet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String naziv;

    private float cena;

    public Internet(Long id, String naziv, float cena) {
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
    }
}

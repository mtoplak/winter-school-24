package si.um.feri.measurements.vao;

import jakarta.persistence.*;
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

    private String hitrost;

    private String dodatno;

    public Internet(Long id, String naziv, float cena, String hitrost, String dodatno) {
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
        this.hitrost = hitrost;
        this.dodatno = dodatno;
    }

    public Internet(Internet dto) {
        this.naziv = dto.getNaziv();
        this.cena = dto.getCena();
        this.hitrost = dto.getHitrost();
        this.dodatno = dto.getDodatno();
    }
}

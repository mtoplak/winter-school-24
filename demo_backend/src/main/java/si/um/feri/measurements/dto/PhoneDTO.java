package si.um.feri.measurements.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record PhoneDTO(
        Long id,

        String naziv,

        float cena
) {

}

package si.um.feri.measurements.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import si.um.feri.measurements.vao.Phone;

@ApplicationScoped

public class PhoneRepository implements PanacheRepository<Phone> {


}

package si.um.feri.measurements.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import si.um.feri.measurements.dto.InternetDTO;
import si.um.feri.measurements.vao.Internet;
import si.um.feri.measurements.vao.Product;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class InternetRepository implements PanacheRepository<Internet> {


}

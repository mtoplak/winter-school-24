package si.um.feri.measurements.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import si.um.feri.measurements.dto.TVDTO;
import si.um.feri.measurements.vao.Product;
import si.um.feri.measurements.vao.TV;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TVRepository implements PanacheRepository<TV>  {


}

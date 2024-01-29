package si.um.feri.measurements.rest;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import si.um.feri.measurements.dao.TVRepository;
import si.um.feri.measurements.dto.TVDTO;
import si.um.feri.measurements.vao.Product;
import si.um.feri.measurements.vao.TV;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class TVController implements PanacheRepository<TV> {

}

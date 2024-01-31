package si.um.feri.measurements.rest;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import si.um.feri.measurements.dao.TVRepository;
import si.um.feri.measurements.vao.TV;
import si.um.feri.measurements.dto.TVDTO;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Path("/tv")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TVController implements PanacheRepository<TV> {
    private static final Logger log = Logger.getLogger(TVController.class.getName());

    @Inject
    TVRepository tvRepository;

    @GET
    public List<TV> getAllTVs() {
        return tvRepository.listAll().stream()
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public Response getTVById(@PathParam("id") int id) {
        TV tv = tvRepository.findById((long) id);
        if (tv == null) {
            log.info(() -> "/tv/" + id + " ; TV not found!");
            return Response.status(Response.Status.NOT_FOUND).entity("TV not found").build();
        }
        return Response.ok(tv).build();
    }

    @POST
    @Transactional
    public Response postTV(TV dto) {
        TV tv = new TV(dto);
        tvRepository.persist(tv);
        return Response.ok(tv).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response putTV(@PathParam("id") int id, TVDTO dto) {
        TV tv = tvRepository.findById((long) id);
        if (tv == null) {
            log.info(() -> "/tv/" + id + " ; TV not found!");
            return Response.status(Response.Status.NOT_FOUND).entity("TV not found").build();
        }
        tvRepository.persist(tv);
        return Response.ok(tv).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteTV(@PathParam("id") int id) {
        TV tv = tvRepository.findById((long) id);
        if (tv == null) {
            log.info(() -> "/tv/" + id + " ; TV not found!");
            return Response.status(Response.Status.NOT_FOUND).entity("TV not found").build();
        }
        tvRepository.delete(tv);
        return Response.ok("TV deleted").build();
    }
}

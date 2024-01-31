package si.um.feri.measurements.rest;

import si.um.feri.measurements.dao.InternetRepository;
import si.um.feri.measurements.dto.InternetDTO;
import si.um.feri.measurements.vao.Internet;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Path("/internet")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InternetController {
    private static final Logger log = Logger.getLogger(InternetController.class.getName());

    @Inject
    InternetRepository internetRepository;

    @GET
    public List<Internet> getAllInternet() {
        return internetRepository.listAll().stream()
                .collect(Collectors.toList());
    }

    @POST
    @Transactional
    public Response postInternet(Internet dto) {
        internetRepository.persist(dto);
        Internet internet = new Internet(dto);
        //internetRepository.save(internet);
        return Response.ok(internet).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response putInternet(@PathParam("id") int id, InternetDTO dto) {
        Internet internet = internetRepository.findById((long) id);
        if (internet == null) {
            log.info(() -> "/internet/" + id + " ; Internet not found!");
            return Response.status(Response.Status.NOT_FOUND).entity("Internet not found").build();
        }
        internetRepository.persist(internet);
        return Response.ok(internet).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteInternet(@PathParam("id") int id) {
        Internet internet = internetRepository.findById((long) id);
        if (internet == null) {
            log.info(() -> "/internet/" + id + " ; Internet not found!");
            return Response.status(Response.Status.NOT_FOUND).entity("Internet not found").build();
        }
        internetRepository.delete(internet);
        return Response.ok("Internet deleted").build();
    }
}

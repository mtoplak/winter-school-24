package si.um.feri.measurements.rest;

import si.um.feri.measurements.dao.PhoneRepository;
import si.um.feri.measurements.dto.PhoneDTO;
import si.um.feri.measurements.vao.Phone;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Path("/phone")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PhoneController {

    private static final Logger log = Logger.getLogger(PhoneController.class.getName());

    @Inject
    PhoneRepository phoneRepository;

    @GET
    public List<Phone> getAllPhones() {
        return phoneRepository.listAll().stream()
                .collect(Collectors.toList());
    }

    @POST
    @Transactional
    public Response postPhone(Phone dto) {
        Phone phone = new Phone(dto.getNaziv(), dto.getCena(), dto.getPrenosPodatkov(), dto.getSteviloMinut(), dto.getHitrost());
        phoneRepository.persist(phone);
        return Response.ok(dto).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response putPhone(@PathParam("id") int id, PhoneDTO dto) {
        Phone phone = phoneRepository.findById((long) id);
        if (phone == null) {
            log.info(() -> "/phone/" + id + " ; Phone not found!");
            return Response.status(Response.Status.NOT_FOUND).entity("Phone not found").build();
        }
        phoneRepository.persist(phone);
        return Response.ok(phone).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletePhone(@PathParam("id") int id) {
        Phone phone = phoneRepository.findById((long) id);
        if (phone == null) {
            log.info(() -> "/phone/" + id + " ; Phone not found!");
            return Response.status(Response.Status.NOT_FOUND).entity("Phone not found").build();
        }
        phoneRepository.delete(phone);
        return Response.ok("Phone deleted").build();
    }
}

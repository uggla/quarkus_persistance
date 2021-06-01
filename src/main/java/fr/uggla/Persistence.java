package fr.uggla;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Persistence {

    @GET
    public Set<String> hello() {
        List<Person> allPersons = Person.listAll();
        return allPersons.stream().map(person -> person.name).collect(Collectors.toSet());
    }

    @Transactional
    @POST
    public Response add(Person person) {
        try {
            person.persist();
            return Response.ok(person).status(201).build();
        }
        catch(Exception e){
            return Response.serverError().build();
        }
    }
}
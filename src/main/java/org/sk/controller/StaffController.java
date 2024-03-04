package org.sk.controller;

import io.smallrye.mutiny.Uni;
import org.sk.model.Patient;
import org.sk.model.Staff;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.CompletionStage;

@Path("/staff")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StaffController {

/*
    @GET
    @Path("/search/{name}")
    public Uni<List<Staff>> searchStaffByName(@PathParam("name") String name) {
        // Sök efter läkare med det angivna namnet
        return Staff.find("firstName like ?1 or lastName like ?2", name + "%", name + "%").list();
    }
    */
    @GET
    @Path("/search/{name}")
    public Uni<List<Staff>> searchStaffByName(@PathParam("name") String name) {
        // Sök efter läkare med det angivna namnet
        return Staff.findByStaffName(name);
    }

}
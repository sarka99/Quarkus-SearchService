package org.sk.controller;

import java.util.List;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;

import org.sk.model.Condition;
import org.sk.model.Patient;

@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientController {


    @GET
    @Path("/search/{name}")
    public Uni<List<Patient>> searchPatientsByName(@PathParam("name") String name) {
        Uni<List<Patient>> patientsFound = Patient.find("firstName like ?1", name + "%").list();
        return patientsFound;
    }
    @GET
    @Path("/searchByGender/{gender}")
    public Uni<List<Patient>> searchPatientsByGender(@PathParam("gender") String gender) {
        return Patient.findByGender(gender);
    }
    @GET
    @Path("/searchByCondition/{conditionName}")
    public Uni<Patient> searchPatientsByCondition(@PathParam("conditionName") String conditionName) {
        return Condition.findByConditionName(conditionName)
                .onItem().transformToUni(condition -> Patient.findById(condition.getPatient().getId()));
    }

}

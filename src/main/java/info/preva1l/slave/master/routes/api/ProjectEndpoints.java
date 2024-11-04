package info.preva1l.slave.master.routes.api;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/project")
public class ProjectEndpoints {
    @POST
    @Path("/edit/{shortId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response editProject(@PathParam("shortId") String shortId) {
        return Response.accepted().build();
    }
}

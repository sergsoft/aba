package ru.sergsw.aba.openshift.rest;

import ru.sergsw.aba.openshift.services.AuthService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("auth")
@Produces("application/json")
public class AuthResource {

    private @Inject AuthService authService;

    @Path("login/{login}")
    @GET
    public String auth(@PathParam("login") String login, String password) {
        return authService.login(login, password);
    }
}

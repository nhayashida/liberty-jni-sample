package dev.nhayashida.liberty.jni.sample;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@RequestScoped
@Path("/message")
public class Message {

  static {
    System.loadLibrary("jnisample");
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getMessage() {
    return Response.ok(JNISample.getMessage()).build();
  }
}

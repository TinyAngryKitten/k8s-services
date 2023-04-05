package tiny.angry.kitten

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/1")
class GreetingResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Ohayo!"
}
#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by KryukovMV on 23.03.2017.
 */
@Path("/order")
@Produces("text/plain;charset=UTF-8")
public interface OrderRest {
    @GET
    @Path("/findby/name/{name}/id/{id}")
    Response findByNameAndId(@PathParam("name") String name,
                             @PathParam("id") Long id);

}
package org.acme.products;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductService productService;
    
    @GET
    @Path("/product/{id}")
    public Response getProduct(@PathParam("id") String id) {
        Product product = productService.getProduct(id);
        if (product == null) {
            return Response.status(Status.NOT_FOUND).build();
        } else {
            return Response.ok(product).build();
        }
    }

    @GET
    @Path("/products")
    public Response getProducts() {
        return Response.ok(productService.getProducts()).build();
    }

}

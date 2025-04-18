package com.bookstore.resource;

import com.bookstore.model.Author;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.*;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {

    private static Map<Integer, Author> authors = new HashMap<>();
    private static int nextId = 1;

    @GET
    public Response getAllAuthors() {
        List<Author> authorList = new ArrayList<>(authors.values());
        return Response.ok(authorList).build();
    }

    @POST
    public Response createAuthor(Author author) {
        author.setId(nextId++);
        authors.put(author.getId(), author);
        return Response.status(Response.Status.CREATED).entity(author).build();
    }

    @GET
    @Path("/{id}")
    public Response getAuthorByID(@PathParam("id") int id) {
        Author author = authors.get(id);
        if (author == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"error\":\"Author not found\"}").build();
        }
        return Response.ok(author).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAuthor(@PathParam("id") int id) {
        if (!authors.containsKey(id)) {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"error\":\"Author not found\"}").build();
        }
        authors.remove(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}/books")
    public Response getBooksByAuthor(@PathParam("id") int authorId) {
        return Response.ok(new ArrayList<>()).build();
    }
}

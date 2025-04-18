package com.bookstore.resource;

import com.bookstore.model.Book;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.*;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    private static Map<Integer, Book> books = new HashMap<>();
    private static int nextID = 1;

    @GET
    public Response getAllBooks() {
        List<Book> bookList = new ArrayList<>(books.values());
        return Response.ok(bookList).build();
    }

    @POST
    public Response createBook(Book book) {
        book.setId(nextID++);
        books.put(book.getId(), book);
        return Response.status(Response.Status.CREATED).entity(book).build();
    }

    @GET
    @Path("/{id}")
}

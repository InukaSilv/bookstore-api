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
    public Response getBookById(@PathParam("id") int id) {
        Book book = books.get(id);
        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Book not found").build();
        }
        return Response.ok(book).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBook(@PathParam("id") int id, Book updatedBook) {
        if (!books.containsKey(id)) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Book not found").build();
        }
        updatedBook.setId(id);
        books.put(id, updatedBook);
        return Response.ok(updatedBook).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") int id) {
        if (!books.containsKey(id)) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Book not found").build();
        }
        books.remove(id);
        return Response.noContent().build();
    }
}

package org.easybookmark.api;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.quarkus.security.Authenticated;

@Path("/bookmark")
@Authenticated
public class BookmarkResource {

    @Inject
    BookmarkService bookmarkService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bookmark> getBookmarks() {
        return bookmarkService.findAll();
    }

    @GET
    @Path("/{taskid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bookmark getBookmarkByTaskId(@PathParam("taskid") String taskId) {
        return bookmarkService.findByTaskId(taskId);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newBookmark(@Valid Bookmark bookmark) {
        bookmarkService.add(bookmark);
        return Response.status(Status.CREATED).entity(bookmark).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBookmark(@Valid Bookmark bookmark) {
        bookmarkService.update(bookmark);
        return Response.status(Status.OK).entity(bookmark).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBookmark(@PathParam("id") Long id){
        bookmarkService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
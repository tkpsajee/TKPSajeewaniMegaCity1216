package com.megacitycab.webservice;

import com.megacitycab.dao.UserDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Path("/users")
public class UserResource {

    private final UserDAO userDAO;

    public UserResource() {
        this.userDAO = new UserDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsernames() {
        try {
            List<String> usernames = userDAO.getAllUsernames();
            return Response.ok(usernames).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error retrieving usernames: " + e.getMessage())
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UserRequest userRequest) {
        try {
            boolean isCreated = userDAO.createUser(userRequest.getUs_loginusername(), userRequest.getUs_Password(), userRequest.getUs_Email(), userRequest.getUs_fullname(),userRequest.getUs_Contact_No(), userRequest.getUs_NIC(), userRequest.getUs_Address());
            if (isCreated) {
                return Response.status(Response.Status.CREATED)
                        .entity("User created successfully")
                        .build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Failed to create user")
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error creating user: " + e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("username") String username, UserRequest userRequest) {
        try {
            boolean isUpdated = userDAO.updateUser(username, userRequest.getUs_Password(), userRequest.getUs_Email());
            if (isUpdated) {
                return Response.ok("User updated successfully").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("User not found or update failed")
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error updating user: " + e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("username") String username) {
        try {
            boolean isDeleted = userDAO.deleteUser(username);
            if (isDeleted) {
                return Response.ok("User deleted successfully").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("User not found or delete failed")
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error deleting user: " + e.getMessage())
                    .build();
        }
    }
    
    @POST
    @Path("/authenticate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateUser(AuthRequest authRequest) {
        try {
            Map<String, String> userDetails = userDAO.authenticateUser(authRequest.getUsername(), authRequest.getPassword());
            if (!userDetails.isEmpty()) {
                return Response.ok(userDetails).build();
                // {us_loginusername:'admin', us_Usertype:'driver'}
            } else {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Authentication failed: Invalid username or password")
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error during authentication: " + e.getMessage())
                    .build();
        }
    }
    
//        @OPTIONS
//        @Path("/{path : .*}")
//        public Response options() {
//            return Response.ok()
//                    .header("Access-Control-Allow-Origin", "*")
//                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
//                    .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
//                    .header("Access-Control-Allow-Credentials", "true")
//                    .build();
//        }

}



class UserRequest {
    private String us_loginusername;
    private String us_Password;
    private String us_Email;
    private String us_fullname;
    private String us_Contact_No;
    private String us_NIC;
    private String us_Address;
    

    // Getters and Setters

    public String getUs_loginusername() {
        return us_loginusername;
    }

    public void setUs_loginusername(String us_loginusername) {
        this.us_loginusername = us_loginusername;
    }

    public String getUs_Password() {
        return us_Password;
    }

    public void setUs_Password(String us_Password) {
        this.us_Password = us_Password;
    }

    public String getUs_Email() {
        return us_Email;
    }

    public void setUs_Email(String us_Email) {
        this.us_Email = us_Email;
    }

    public String getUs_fullname() {
        return us_fullname;
    }

    public void setUs_fullname(String us_fullname) {
        this.us_fullname = us_fullname;
    }

    public String getUs_Address() {
        return us_Address;
    }

    public void setUs_Address(String us_Address) {
        this.us_Address = us_Address;
    }

    public String getUs_Contact_No() {
        return us_Contact_No;
    }

    public void setUs_Contact_No(String us_Contact_No) {
        this.us_Contact_No = us_Contact_No;
    }

    public String getUs_NIC() {
        return us_NIC;
    }

    public void setUs_NIC(String us_NIC) {
        this.us_NIC = us_NIC;
    }

    
    
    
    
}

class AuthRequest {
    private String username;
    private String password;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
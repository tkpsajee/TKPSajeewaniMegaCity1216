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
            boolean isCreated = userDAO.createUser(userRequest.getUs_full_name(),userRequest.getUs_login_user_name(), userRequest.getUs_password(), userRequest.getUs_email(), userRequest.getUs_type(),userRequest.getUs_address(),userRequest.getUs_contact_no(),userRequest.getUs_nic());           
                    //boolean isCreated = userDAO.createUser(userRequest.getFullname(),
//userRequest.getUsername(), userRequest.getPassword(), userRequest.getEmail(), userRequest.getEmail());
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
            boolean isUpdated = userDAO.updateUser(username, userRequest.getUs_password(), userRequest.getUs_email());
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
                // {username:'admin', usertype:'driver'}
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
    private String us_full_name;
    private String us_login_user_name;
    private String us_password;
    private String us_email;
    private String us_type;
    private String us_address;
    private String us_contact_no;
    private String us_nic;

    // Getters and Setters

    public String getUs_full_name() {
        return us_full_name;
    }

    public void setUs_full_name(String us_full_name) {
        this.us_full_name = us_full_name;
    }

    public String getUs_login_user_name() {
        return us_login_user_name;
    }

    public void setUs_login_user_name(String us_login_user_name) {
        this.us_login_user_name = us_login_user_name;
    }

    public String getUs_password() {
        return us_password;
    }

    public void setUs_password(String us_password) {
        this.us_password = us_password;
    }

    public String getUs_email() {
        return us_email;
    }

    public void setUs_email(String us_email) {
        this.us_email = us_email;
    }

    public String getUs_type() {
        return us_type;
    }

    public void setUs_type(String us_type) {
        this.us_type = us_type;
    }

    public String getUs_address() {
        return us_address;
    }

    public void setUs_address(String us_address) {
        this.us_address = us_address;
    }

    public String getUs_contact_no() {
        return us_contact_no;
    }

    public void setUs_contact_no(String us_contact_no) {
        this.us_contact_no = us_contact_no;
    }

    public String getUs_nic() {
        return us_nic;
    }

    public void setUs_nic(String us_nic) {
        this.us_nic = us_nic;
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
package sk.akademiasovy.tipos.server;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Registration {
    @JsonProperty("firstname")
    public String firstname;
    @JsonProperty("lastname")
    public String lastname;
    @JsonProperty("login")
    public String login;
    @JsonProperty("email")
    public String email;
    @JsonProperty ("password")
    public String password;
}


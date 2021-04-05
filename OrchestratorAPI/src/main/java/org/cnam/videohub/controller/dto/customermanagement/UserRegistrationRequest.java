package org.cnam.videohub.controller.dto.customermanagement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRegistrationRequest {


        public String name;
        public String firstname;
        public String mail;

        @JsonCreator
        public UserRegistrationRequest(@JsonProperty("name") String name, @JsonProperty("firstname") String firstname, @JsonProperty("mail") String mail) {
            this.name = name;
            this.firstname = firstname;
            this.mail = mail;

        }

}

package org.cnam.videohub.domain.entity;

public class UserToCreate {

    public String name;
    public String firstname;
    public String mail;
    public Integer fidelity_points;



    public UserToCreate(String name, String firstname, String mail,Integer fidelity_points) {
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
        this.fidelity_points = fidelity_points;
    }
}

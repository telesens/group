package com.telesens.afanasiev;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by oleg on 12/22/15.
 */
public class ApplicantIT implements java.io.Serializable {
    private static final long serialVersionUID = -1L;
    private long ID;

    private String firstName;
    private String lastName;
    private String email;
    private Set<String> itLanguages;

    public ApplicantIT() {

    }

    public ApplicantIT(long ID, String firstName, String lastName, String email, String... languages) {
        this.ID = ID;
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);

        itLanguages = new HashSet<>();
        itLanguages.addAll(Arrays.asList(languages));
    }

    public long getID() {
        return ID;
    }

    public void setID(long id )  {
        ID = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addLanguage(String language) {
        itLanguages.add(language);
    }

    public String[] getLanguages() {
        return itLanguages.toArray(new String[0]);
    }

    public Set<String> getItLanguages() {
        return itLanguages;
    }

    public void setItLanguages(Set<String> itLanguages) {
        this.itLanguages = itLanguages;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("***** %s %s ***** %n", firstName, lastName));
        sb.append(String.format("email: %s %n", email));
        sb.append(String.format("skills:  %n"));

        for (String entry : itLanguages)
            sb.append(String.format("%2s%-20s %n", " ", entry));

        sb.append(String.format("total: %d", itLanguages.size()));

        return sb.toString();
    }
}

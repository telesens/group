package com.telesens.afanasiev;

import java.util.*;

/**
 * Created by oleg on 12/22/15.
 */
public class ListApplicants implements java.io.Serializable {
    private static final long serialVersionUID = -1L;
    private Map<Long, ApplicantIT> listApplicants;

    public ListApplicants() {

    }

    public ListApplicants(ApplicantIT... applicants) {
        listApplicants = new TreeMap<>();

        for (ApplicantIT applicant : applicants)
            add(applicant);
    }

    public Map<Long, ApplicantIT> getListApplicants() {
        return listApplicants;
    }

    public void setListApplicants(Map<Long, ApplicantIT> listApplicants) {
        this.listApplicants = listApplicants;
    }

    public boolean isRegistered(ApplicantIT applicant) {
        return listApplicants.containsKey(applicant.getID());
    }

    public boolean add(ApplicantIT applicant) {
        if (isRegistered(applicant))
            return false;

        listApplicants.put(applicant.getID(), applicant);
        return true;
    }

    public ApplicantIT getById(long id) {
        return listApplicants.get(id);
    }

    private SortedSet<Map.Entry<Long, ApplicantIT>> entriesSortedByLastName(Map<Long, ApplicantIT> map) {
        SortedSet<Map.Entry<Long, ApplicantIT>> sortedEntries = new TreeSet<>(
                (o1, o2)->(o1.getValue().getLastName().compareTo(o2.getValue().getLastName()))
        );

        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%nList of applicants %n"));
        for (Map.Entry<Long, ApplicantIT> entry : entriesSortedByLastName(listApplicants))
            sb.append(String.format("%n%s %n", entry.getValue()));

        return sb.toString();
    }
}

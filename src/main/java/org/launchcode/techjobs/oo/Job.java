package org.launchcode.techjobs.oo;

import java.lang.reflect.Field;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // done: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // Done: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    // done: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Employer getEmployer() {

        return employer;
    }

    public void setEmployer(Employer employer) {

        this.employer = employer;
    }

    public Location getLocation() {

        return location;
    }

    public void setLocation(Location location) {

        this.location = location;
    }

    public PositionType getPositionType() {

        return positionType;
    }

    public void setPositionType(PositionType positionType) {

        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {

        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {

        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String nameField = getName().equals("") ? "Data not available" : getName();
        String employerField = getEmployer().getValue().equals("") ? "Data not available" : getEmployer().toString();
        String locationField = getLocation().getValue().equals("")? "Data not available" : getLocation().toString();
        String positionTypeField = getPositionType().getValue().equals("") ? "Data not available" : getPositionType().toString();
        String coreCompetencyField = getCoreCompetency().getValue().equals("") ? "Data not available" : getCoreCompetency().toString();

//        String[] labels = {"ID: ", "Name: ", "Employer: ", "Location: ", "Position Type: ", "Core Competency: "};
//
//        Field[] fields = Job.class.getDeclaredFields();
//        String unavailable = "Data not available";
//        String message = "\n";
//        int index = 0;


        return "\n"  +
                "ID:" + " " + getId() + '\n' +
                "Name:" + " " + nameField + '\n' +
                "Employer:" + " " + employerField + '\n' +
                "Location:" + " " + locationField + '\n' +
                "Position Type:" + " " + positionTypeField + '\n' +
                "Core Competency:" + " " + coreCompetencyField +"\n";
    }
}

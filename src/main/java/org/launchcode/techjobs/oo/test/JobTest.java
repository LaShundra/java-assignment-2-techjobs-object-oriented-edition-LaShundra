package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    public JobTest(){
    }

    @Before
    public void createJobObjects(){
        Job job1 = new Job();
        Job job2 = new Job();
    }

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();

        //job1 & job2 values are not the same
        assertNotEquals(job1.getId(), job2.getId());

    }

    private void assertEquals(boolean equals) {
    }


    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob instanceof Job);

        Assert.assertEquals(testJob.getName(), "Product tester");

        assertTrue(testJob.getEmployer() instanceof Employer);

        Assert.assertEquals(testJob.getEmployer().getValue(), "ACME");

        assertTrue(testJob.getLocation() instanceof Location);

        Assert.assertEquals(testJob.getLocation().getValue(), "Desert");

        assertTrue(testJob.getPositionType() instanceof PositionType);

        Assert.assertEquals(testJob.getPositionType().getValue(), "Quality control");

        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

        Assert.assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
    }



    @Test
    public void testJobsForEquality(){
        Job Job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job Job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertEquals(Job1, Job2);
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String newLine = "\n"  +
                "ID: " + " " + testJob.getId() + '\n' +
                "Name: " + " " + testJob.getName() + '\n' +
                "Employer: " + " " + testJob.getEmployer() + '\n' +
                "Location: " + " " + testJob.getLocation() + '\n' +
                "Position Type:" + " " + testJob.getPositionType() + '\n' +
                "Core Competency: " + " " + testJob.getCoreCompetency() + '\n';


        int lastIndex = (testJob.toString().length() - 1);
        char firstChar = testJob.toString().charAt(0);
        char lastChar = testJob.toString().charAt(lastIndex);


        Assert.assertEquals(firstChar, "\n");
        Assert.assertEquals(lastChar, "\n");

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String labels = "\n"  +
                "ID:" + " " +testJob.getId() + '\n' +
                "Name:" + " " + testJob.getName() + '\n' +
                "Employer:" + " " + testJob.getEmployer() + '\n' +
                "Location:" + " " + testJob.getLocation() + '\n' +
                "Position Type:" + " " + testJob.getPositionType() + '\n' +
                "Core Competency:" + " " + testJob.getCoreCompetency() +"\n";
                ;


        Assert.assertEquals(labels, testJob.toString());

        Assert.assertEquals('\n', '\n');



    }



    @Test
    public void testToStringHandlesEmptyField(){

        Job testjob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String toString = testjob.toString();
        String emptyName = testjob.getName().equals("") ? " Data not available": testjob.getName();
        String emptyEmployer = testjob.getEmployer().getValue().equals("") ? "Data not available": testjob.getEmployer().toString();
        String emptyLocation = testjob.getLocation().getValue().equals("") ? "Data not available": testjob.getLocation().toString();
        String emptyPosition = testjob.getPositionType().getValue().equals("") ? "Data not available": testjob.getPositionType().toString();
        String emptyCore = testjob.getCoreCompetency().getValue().equals("") ? "Data not available": testjob.getCoreCompetency().toString();
        String emptyJob = "\n"  +
                "ID:" + " " + testjob.getId() + '\n' +
                "Name:" + " " + emptyName + '\n' +
                "Employer:" + " " + emptyEmployer + '\n' +
                "Location:" + " " + emptyLocation + '\n' +
                "Position Type:" + " " + emptyPosition + '\n' +
                "Core Competency:" + " " + emptyCore + '\n';


        Assert.assertEquals(emptyJob.toString(), testjob.toString());
    }




}

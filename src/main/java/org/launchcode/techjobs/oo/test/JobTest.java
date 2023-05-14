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

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Before
    public void createJobObjects(){
        Job job1 = new Job();
        Job job2 = new Job();
    }
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        //job1 & job2 values are not the same
        assertNotEquals(job1.getId(), job2.getId());
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
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));

    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        int lastIndex = (testJob.toString().length() - 1);

        Assert.assertEquals(testJob.toString().charAt(0),'\n');

       Assert.assertEquals(testJob.toString().charAt(lastIndex),'\n');

    }

    private void assertEquals(boolean b) {

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String output = "\n"  +
                "ID:" + " " + testJob.getId() + '\n' +
                "Name:" + " " + testJob.getName() + '\n' +
                "Employer:" + " " + testJob.getEmployer() + '\n' +
                "Location:" + " " + testJob.getLocation() + '\n' +
                "Position Type:" + " " + testJob.getPositionType() + '\n' +
                "Core Competency:" + " " + testJob.getCoreCompetency() +"\n";
        Assert.assertEquals(output, testJob.toString());

    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String toString = testJob.toString();

        String emptyName = testJob.getName().equals("") ? " Data not available": testJob.getName();
        String emptyEmployer = testJob.getEmployer().getValue().equals("") ? "Data not available": testJob.getEmployer().toString();
        String emptyLocation = testJob.getLocation().getValue().equals("") ? "Data not available": testJob.getLocation().toString();
        String emptyPosition = testJob.getPositionType().getValue().equals("") ? "Data not available": testJob.getPositionType().toString();
        String emptyCore = testJob.getCoreCompetency().getValue().equals("") ? "Data not available": testJob.getCoreCompetency().toString();
        String output = "\n"  +
                "ID:" + " " + testJob.getId() + '\n' +
                "Name:" + " " + emptyName + '\n' +
                "Employer:" + " " + emptyEmployer + '\n' +
                "Location:" + " " + emptyLocation + '\n' +
                "Position Type:" + " " + emptyPosition + '\n' +
                "Core Competency:" + " " + emptyCore + '\n';

        Assert.assertEquals(output.toString(), testJob.toString());
    }

}
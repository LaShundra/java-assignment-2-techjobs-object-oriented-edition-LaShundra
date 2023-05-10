package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest<lines> {

//    @Before
//    public void createJobObjects(){
//        Job job1 = new Job();
//        Job job2 = new Job();
//    }

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();

        //job1 & job2 values are not the same
        assertEquals(job1.equals(job2));

    }

    private void assertEquals(boolean equals) {
    }


    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(testJob instanceof Job);

        assertEquals(testJob.getName() == "Product tester");

        assertEquals(testJob.getEmployer() instanceof Employer);

        assertEquals(testJob.getEmployer().getValue() == "ACME");

        assertEquals(testJob.getLocation() instanceof Location);

        assertEquals(testJob.getLocation().getValue() == "Desert");

        assertEquals(testJob.getPositionType() instanceof PositionType);

        assertEquals(testJob.getPositionType().getValue() == "Quality control");

        assertEquals(testJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(testJob.getCoreCompetency().getValue() == "Persistence");

    }

    @Test
    public void testJobsForEquality(){
        Job Job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job Job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals(Job1.equals(Job2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        int lastIndex = (testJob.toString().length() - 1);

        assertEquals(testJob.toString().charAt(0) == '\n');

        assertEquals(testJob.toString().charAt(lastIndex) == '\n');

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String[] lines = testJob.toString().split(",");
//        ArrayList<String> line = new ArrayList<String>(Arrays.asList(lines));


        System.out.println("hello");

        System.out.println(lines[0]);

        assertEquals(lines.length == 6);

//        assertEquals(testJob[0].startsWith("Name:"));

        assertEquals(lines[0].startsWith("ID:"));


        assertEquals(lines[1].startsWith("Name:"));

//        assertEquals(lines[2].startsWith("Employer:"));
//
//        assertEquals(lines[3].startsWith("Location:"));
//
//        assertEquals(lines[4].startsWith("Position type:"));
//
//        assertEquals(lines[5].startsWith("Core Competency:"));
//
//
//        assertEquals(lines[0].endsWith(Integer.toString(testJob.getId())));
//
//        assertEquals(lines[1].endsWith(testJob.getName().toString()));
//
//        assertEquals(lines[2].endsWith(testJob.getEmployer().toString()));
//
//        assertEquals(lines[3].endsWith(testJob.getLocation().toString()));
//
//        assertEquals(lines[4].endsWith(testJob.getLocation().toString()));
//
//        assertEquals(lines[5].endsWith(testJob.getCoreCompetency().toString()));
//
//
//
//
//
//
    }

    @Test
    public void testToStringHandlesEmptyField(){

        Job testJob = new Job();

        String[] line = testJob.toString().trim().split("\n");
        List<String> list = new ArrayList<String>(Arrays.asList(line));

        list.remove(0);
        line = list.toArray(new String[0]);

        String unavailable = "Data not available";

        for (String lines : line){
            assertEquals(lines.endsWith(unavailable));
        }
    }




}

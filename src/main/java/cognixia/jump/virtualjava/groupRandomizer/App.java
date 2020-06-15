package cognixia.jump.virtualjava.groupRandomizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args)
    {
    	Scanner appSC = new Scanner(System.in);
    	boolean isSystemOn = true;
    	  	
    	while (isSystemOn)
    	{
    		System.out.println( "Welcome to Cognixia JUMP's Class Generator App!" );
            System.out.println(" ");
            System.out.println("Which class would you like generate lists/groups for?:");
            System.out.println("1) 11AM EST Class");
            System.out.println("2) 9AM EST Class");
            System.out.println(" ");
            System.out.println("3) EXIT App");
            
            int classChoiceUserInput = appSC.nextInt();
            
            switch(classChoiceUserInput)
        	{
        	  case 1:
        		ArrayList<String> studentsMG = new ArrayList<String>(Arrays.asList("Adebayo Ajayi", "Anthony Russell" , "Anthony Shahid", "Calvin Houser", "Carleton Thompson", "Colette Onenda", "Colt Lehr", "David Morales", "Haley Howell", "Haripriya Vasireddy", "Jack Liegey", "Jamie Vue", "Jayde Doetschman", "Kevin Fang", "Krishna Thapa", "Lindsay Prescott", "Malik East", "Mathias Taylor", "Michael Mejia", "Ramon ('Dylan') Aboy", "Robert Pytel", "Santos Tapia", "Tersa Almaw", "Tom Burch", "Vinson Sorenson"));
              	
              	System.out.println("--> CLASS SELECTED: Matt's & Gordon's <--");
              	System.out.println(" ");
              	System.out.println("Which would you like generate?:");
              	System.out.println("1) Random Student List Generator");
              	System.out.println("2) Random Group/Team Leader Generator");
              	
              	int generatorChoiceUserInputMG = appSC.nextInt();
              	
              	switch(generatorChoiceUserInputMG)
              	{
              	  case 1:
              		randomStudentListGenerator(studentsMG);
              	    break;
              	  case 2:
              		randomGroupGenerator(studentsMG);
              	    break;
              	  default:
              		System.out.println("Whoops.......that wasn't '1' or '2'......hmmmm, try again!");
              		System.out.println(" ");
              		break;
              	}
        	    break;
        	  case 2:
        		ArrayList<String> studentsOD = new ArrayList<String>(Arrays.asList("Abrham ", "Ainsley McWaters", "Alek Sung", "Bill Knobbe", "Caroline Rives", "Carson Jobe", "Cheick Kane", "D'Andre Guess", "Dante' Taylor", "Darreal Chambers", "Dezmon Hall", "Elton Wee", "Fatih Erkayiran", "Gabriella Middleton", "Jennifer Echavarria", "Joetta Hall", "Jun Liang", "Kacper Bebel", "Ken Cheng", "Larkin Ingram", "Lori White", "Nahom Zena", "Phocas Sunzu", "Ryan Tan", "Samidh Patel", "Seth Campbell", "Sidiki Camara", "Tara Kelly", "Taylor Rotolo", "Thomas Martinez", "Vinita Ray"));
              	
        		System.out.println("--> CLASS SELECTED: Orquidia's & Daniel's <--");
              	System.out.println(" ");
              	System.out.println("Which would you like generate?:");
              	System.out.println("1) Random Student List Generator");
              	System.out.println("2) Random Group/Team Leader Generator");
              	
              	int generatorChoiceUserInputOD = appSC.nextInt();
              	
              	switch(generatorChoiceUserInputOD)
              	{
  	          	  case 1:
  	          		randomStudentListGenerator(studentsOD);
  	          	    break;
  	          	  case 2:
  	          		randomGroupGenerator(studentsOD);
  	          	    break;
  	          	  default:
  	          		System.out.println("Whoops.......that wasn't '1' or '2'......hmmmm, try again!");
  	          		System.out.println(" ");
  	          		break;
              	}
        	    break;
        	  case 3:
        		  isSystemOn = false;
        		  break;
        	  default:
        		System.out.println("Whoops.......that wasn't '1' or '2'......hmmmm, try again!");
        		System.out.println(" ");
        		break;
        	}
    	}
    	appSC.close();
    	System.out.println("Thank you for using Cognixia JUMP's Class Generator App!");
		System.out.println("<<< Gordon Allen - 2020 >>>");
    }
    
    public static void generatedTeamConsolePrinter(List<String> teamTempStor, int teamNum)
    {    	
    	System.out.println("   Team " + teamNum);
		System.out.println("<---------->");

		for (int x = 0; x < teamTempStor.size(); x++)
		{
			if (x == 0)
			{
				System.out.println("Team Leader: " + teamTempStor.get(x));
				x++;
				System.out.println(" ");
				System.out.println("Team Members: ");
				System.out.println(" ");
			}
			System.out.println(teamTempStor.get(x));
		}
		
		System.out.println("<---------->");
		System.out.println(" ");
    }
    
    public static List<String> randomGroupSortSelectTL(List<String> teamTempStor)
    {  	
    	Collections.sort(teamTempStor);
    	int randIdx = (int)(teamTempStor.size() * Math.random());
    	String teamLead = teamTempStor.get(randIdx);
    	teamTempStor.set(randIdx, teamTempStor.get(0));
    	teamTempStor.set(0, teamLead);
    	return teamTempStor;
    }
    
    public static void randomStudentListGenerator(List<String> students)
	{
    	int numStudents =  students.size();
    	int count = 1;
    	
    	while (numStudents > 0)
    	{
    		int randInt = (int)(numStudents * Math.random());	
    		String randStudent = students.get(randInt);
    		System.out.println("Student " + count + ": " + randStudent); 
    		
    		students.remove(randInt);
    		count++;
    		numStudents--;
    	}
    	System.out.println(" ");
	}	
	
	public static void randomGroupGenerator(List<String> students)
	{
		int numStudents =  students.size();
		int teamNum = 1;
		List<String> teamTempStor = new ArrayList<String>();		
		
		for (int idx = 0; idx <= numStudents; idx++)
		{
			while(numStudents > 0)
			{
				int randInt = (int)(numStudents * Math.random());

				if (numStudents - 1 == 0) 
				{
					teamTempStor.add(students.get(randInt));
					students.remove(randInt);
										
					//* Calling helper method to sort group and randomly select Team Leader *
					randomGroupSortSelectTL(teamTempStor);
					
					//* Calling helper method to print randomly generated Team Leader/Team to console *
					generatedTeamConsolePrinter(teamTempStor, teamNum);										
									
					numStudents--;
					idx--;
				}
				
				//* RANDOMLY GENERATED GROUP SIZE // USER SPECIFICATION *
				//Here, the user may specify their desired group size: we have selected (5) 
				else if (teamTempStor.size() < 5)
				{
					teamTempStor.add(students.get(randInt));
					students.remove(randInt);
					numStudents--;
					idx--;
				}
				else if (teamTempStor.size() == 5)
				{
					randomGroupSortSelectTL(teamTempStor);
					generatedTeamConsolePrinter(teamTempStor, teamNum);
					numStudents--;
					idx--;
					teamTempStor.clear();
					teamNum++;
					
					teamTempStor.add(students.get(randInt));
					students.remove(randInt);					
				}				
			}
		}
	}
}

package cognixia.jump.virtualjava.groupRandomizer.cognixia.jump.virtualjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App 
{
	public static void groupRandomizeGenerator(List<String> students) {
		
		int numStudents =  students.size();
		
		int teamNum = 1;
		
		List<String> teamTempStor = new ArrayList<String>();		
				
		for (int idx = 0; idx <= numStudents; idx++) {
			while(numStudents > 0) {
				int randInt = (int)(numStudents * Math.random());
				
				if (teamTempStor.size() < 5) {
					teamTempStor.add(students.get(randInt));
					
					students.remove(randInt);
					numStudents--;
					idx--;
				
				}
				else if (teamTempStor.size() == 5){
					System.out.println("Team " + teamNum);
					System.out.println(" ");
					
					for (String i: teamTempStor) {
						System.out.println(i);
					}					
					System.out.println(" ");
					
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
	
    public static void main(String[] args )
    {
    	ArrayList<String> students = new ArrayList<String>(Arrays.asList("Adebayo Ajayi", "Anthony Russell" , "Brooks McCament", "Carleton Thompson", "Colette Onenda", "Colt Lehr", "Dakota Purvis", "David Morales", "Dezmon Hall", "Gurmat Sandhu", "Haley Howell", "Haripriya Vasireddy", "Humza Sheikh", "Jack Liegey", "Jamie Vue", "Jayde Doetschman", "Kevin Fang", "Krishna Thapa",  "Kahan Raval", "Lindsay Prescott", "Malik E.", "Mathias Taylor", "Maurice B.", "Michael Mejia", "Mishal Baig", "Ramon Aboy", "Robert Pytel", "Santos Tapia", "Tersa Almaw", "Tom Burch", "Vinson Sorenson"));
        System.out.println( "Cognixia JUMP Program Group Generator & Randomizer!" );
        System.out.println(" ");
        System.out.println("Here are your newly generated and randomized teams:");
        System.out.println(" ");
        
        groupRandomizeGenerator(students);
    }
}

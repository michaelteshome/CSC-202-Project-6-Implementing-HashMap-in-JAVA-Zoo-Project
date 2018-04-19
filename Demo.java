import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;
public class Demo {

	static ArrayList<String>list = new ArrayList<String>();
	static ArrayList<String>animalName = new ArrayList<String>(list.size());
	static HashMap<String, Character> map = new HashMap<String, Character>(500);
	static Scanner kybd = new Scanner(System.in);
	static String choice;
	static String decision;
	
	static int size;
	public static void main(String[] args) {
		boolean result;
		readFile("animalspecies.txt");
		System.out.println("Amount of Mammals/Animals -->: " + getListSize());
		checkAnimal();
		
		System.out.println("Animal Names:");
		printAnimalName();
		
		determineMammal();
		System.out.println("choose an a species you would like to check: ");
		choice = kybd.nextLine();
		
		System.out.println(choice + " is M or A -->" + map.get(choice));
		
		System.out.println("Would you like to check other species: ");
		decision = kybd.nextLine();
		
		while(decision.equalsIgnoreCase("yes")) {
			printAnimalName();
			determineMammal();
			System.out.println("choose an a species you would like to check: ");
			choice = kybd.nextLine();
			System.out.println(choice + " is M or A -->" + map.get(choice));
			System.out.println("Would you like to check other species: ");
			decision = kybd.nextLine();
			
			if(decision.equalsIgnoreCase("no")) {
				System.out.println("Have a nice day! ");
				System.out.println("Load Size --> " + map.getLoadSize() + " % of the HashMap used");
				System.exit(0);
			}
			
		}
		
		//System.out.println("Load Size --> " + map.getLoadSize() + " % of the HashMap used");
		
	}
	public static void createFile(String in) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(in);
			
		}
		
		catch(Exception e) {
			System.out.println("File could not be created");
		}
		
	}
	
	public static void determineMammal() {
		
		//System.out.println(list.get(0).charAt(l));
		
		for(int x = 0; x < 101; x++) {
			int l = list.get(x).indexOf(",") + 1;
			int i = list.get(x).indexOf(",") + 7;
			if(list.get(x).charAt(l) == '1' && list.get(x).charAt(i) == '1') {
				//System.out.println(animalName.get(x) + " is a Mammal");
				map.put(animalName.get(x), 'M');
			}
			
			if(list.get(x).charAt(l) == '0' && list.get(x).charAt(i) == '0') {
				//System.out.println(animalName.get(x) + " is a Animal");
				map.put(animalName.get(x), 'A');
			}
			
			map.setLoadSize(x);
		}
		
		
	}
	
	
	
	public static void readFile(String in) {
		int count = 0;
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new File(in));
		}
		catch(Exception e) {
			System.out.println("File not found");
		}
		
		while(inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			count++;
			setListSize(count);
			list.add(line);
			
			System.out.println(line);
		}
		inputStream.close();
	}
	
	public static void checkAnimal() {
		
		for(int x = 0; x < 101; x++) {
			animalName.add(x, list.get(x).substring(list.get(x).indexOf(""), list.get(x).indexOf(",")));
		}
	}
	
	public static void printAnimalName() {
		for(int x = 0; x < animalName.size(); x++) {
			System.out.println(animalName.get(x));
		} 
		
	}
	
	
	
	
	public static void setListSize(int j) {
		size = j;
	}
	
	public static int getListSize() {
		return size;
	}
	
		
	
	
}

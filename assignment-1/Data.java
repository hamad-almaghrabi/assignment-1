

import java.util.ArrayList;
 

/**
 *
 * @author Hamad s3619196
 */
public class Data {
	private static ArrayList<Child> childProfileList;
	private static ArrayList<Adult> adultProfileList ;
	
	public Data() { 
		childProfileList = new ArrayList<>();
		adultProfileList = new ArrayList<>();
	}
	
	//Method to fill and return data for Adult profiles
		public static ArrayList<Adult> fillAdultProfileList()
		{
			
			Adult adult = new Adult();
			adult.setName("Will Smith");
			adult.setGender("M");
			adult.setAge(37);
			adult.setStatus("Working at KFC");
			adult.makeChild(11);
			adult.makeFriend(3);
			adult.makeFriend(5);
			adult.makeFriend(6);
			adult.makeFriend(9);
			adultProfileList.add(adult);

			adult = new Adult();
			adult.setName("John Doe");
			adult.setGender("M");
			adult.setAge(28);
			adult.setStatus("Student at RMIT");
			adult.makeFriend(3);
			adult.makeFriend(7);
			adult.makeFriend(4);
			adultProfileList.add(adult);

			adult = new Adult();
			adult.setName("Kerry Brantley");
			adult.setGender("F");
			adult.setAge(35);
			adult.setStatus("Freelance");
			adult.makeChild(11);
			adult.makeFriend(1);
			adult.makeFriend(2);
			adult.makeFriend(4);
			adult.makeFriend(6);
			adultProfileList.add(adult);

			adult = new Adult();
			adult.setName("Carol Anderson");
			adult.setGender("F");
			adult.setAge(40);
			adult.setStatus("Working at Coca cola");
			adult.makeChild(12);
			adult.makeFriend(3);
			adult.makeFriend(4);
			adult.makeFriend(5);
			adult.makeFriend(9);
			adultProfileList.add(adult);

			adult = new Adult();
			adult.setName("Michael Glover");
			adult.setGender("M");
			adult.setAge(33);
			adult.setStatus("Looking for job");
			adult.makeFriend(1);
			adult.makeFriend(4);
			adult.makeFriend(10);
			adultProfileList.add(adult);


			adult = new Adult();
			adult.setName("Julie Sessoms");
			adult.setGender("F");
			adult.setAge(37);
			adult.setStatus("Student at RMIT");
			adult.makeChild(12);
			adult.makeFriend(1);
			adult.makeFriend(3);
			adult.makeFriend(7);
			adult.makeFriend(8);
			adultProfileList.add(adult);

			adult = new Adult();
			adult.setName("Barbara Wilson");
			adult.setGender("F");
			adult.setAge(30);
			adult.setStatus("Freelance");
			adult.makeChild(13);
			adult.makeFriend(2);
			adult.makeFriend(6);
			adult.makeFriend(10);
			adultProfileList.add(adult);

			adult = new Adult();
			adult.setName("Jerry Adkins");
			adult.setGender("M");
			adult.setAge(29);
			adult.setStatus("Working at Microsoft");
			adult.makeChild(13);
			adult.makeFriend(6);
			adult.makeFriend(9);
			adult.makeFriend(10);
			adultProfileList.add(adult);

			adult = new Adult();
			adult.setName("Thomas Stickney");
			adult.setGender("M");
			adult.setAge(30);
			adult.setStatus("Working at Apple");
			adult.makeFriend(4);
			adult.makeFriend(8);
			adult.makeFriend(1);
			adultProfileList.add(adult);

			adult = new Adult();
			adult.setName("Edward Green");
			adult.setGender("M");
			adult.setAge(45);
			adult.setStatus("Working at Google");
			adult.makeFriend(5);
			adult.makeFriend(7);
			adult.makeFriend(8);
			adultProfileList.add(adult);

			return adultProfileList;
		}

		//Method to fill and return data for Adult profiles
		public static ArrayList<Child> fillChildProfileList()
		{
		
			Child child = new Child();
			child.setName("Iva McDaniel");
			child.setGender("F");
			child.setAge(11);
			child.makeParent(1,3);
			child.makeFriend(12);
			child.setStatus("Playing with my friend");
			childProfileList.add(child);

			child = new Child();
			child.setName("Larry Brennan");
			child.setGender("M");
			child.setAge(13);
			child.makeParent(4,6);
			child.makeFriend(11);
			child.setStatus("Going to park");
			childProfileList.add(child);

			child = new Child();
			child.setName("Ryan Stewart");
			child.setGender("M");
			child.setAge(10);
			child.makeParent(7,8);
			child.setStatus("Enjoying picnic");
			childProfileList.add(child);

			return childProfileList;

		}

}

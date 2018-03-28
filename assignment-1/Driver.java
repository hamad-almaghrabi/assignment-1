


import java.util.ArrayList;
import java.util.Scanner;
 
/**
 *
 * @author Hamad stududent No: s3619196
 */
public class Driver {


	Data d ;
	int choice ;
	public Driver()
	{
		d=new Data();

		//array to hold the profiles for adults    
		ArrayList<Adult> adultProfileList = d.fillAdultProfileList();

		//array to hold the profiles for child
		ArrayList<Child> childProfileList = d.fillChildProfileList();

		String menuOptions [] = {
				"Add a person  "
				,"List everyone "
				,"Select a person   "
				,"Exit"
				
				
		} ;
		Menu mainMenu = new Menu ("Mininet" , menuOptions);

		int choice = 1;

		Scanner input = new Scanner(System.in);
		do {

			//Displaying main menu
			mainMenu.display();

			choice = mainMenu.getValidChoice();

			//1. Add a person
			if (choice == 1) {
				int addChoice = 1;
				while (addChoice >= 1 && addChoice <= 3) {
					//Submenu for adding a person

					String submenuOptions [] = {
							"Add an adult person  "
							,"Add a child person"
							," Go back   "
					} ;
					Menu subMenu = new Menu ("Add Person" , submenuOptions);
					subMenu.display();
					addChoice = subMenu.getValidChoice();
					//Add an adult person
					if (addChoice == 1) {
						System.out.println("Enter name of the person");

						String name = input.nextLine();
						int personAge = 0;
						while (personAge == 0) {
							System.out.println("Enter age of the person");
							personAge = input.nextInt();
							if (personAge <= 0) {
								System.out.println("Age cannot be less than or equals to 0.");
								personAge = 0;
							} else if (personAge < 16 || personAge > 100) {
								System.out.println("Age cannot be less than 16 or more than 100.");
								personAge = 0;
							}
						}

						String personGender = "M";
						String g = "";
						while (personGender.equals("M") || personGender.equals("F")) {
							System.out.println("Enter gender of the person (M or F only)");
							personGender = input.next();
							if (!(personGender.toLowerCase().equals("m")
									|| personGender.toLowerCase().equals("f"))) //toLowerCase() is used, so both upper case and lower case inputs treated as same
							{
								System.out.println("Invalid selection. Please enter a valid choice.");
								personGender = "M";
							} else {
								g = personGender.toUpperCase(); //If the input is m or f, We will again convert it to upper case for storing
								personGender = "A";
							}
						}
						//Adding person to the network
						Adult adult = new Adult();
						adult.setName(name);
						adult.setGender(g);
						adult.setAge(personAge);
						adultProfileList.add(adult);
						System.out.println("Adult person has been added.");
					}

					//Add a child
					else if (addChoice == 2) {
						System.out.println("Enter name of the child");
						input.nextLine();
						String name = input.nextLine();
						int childAge = 0;
						while (childAge == 0) {
							System.out.println("Enter age of the child");
							childAge = input.nextInt();
							if (childAge <= 0) {
								System.out.println("Age cannot be less than or equals to 0.");
								childAge = 0;
							} else if (childAge > 16) {
								System.out.println("Age cannot be greater than 16.");
								childAge = 0;
							}
						}
						String childGender = "M";
						String g = "";
						while (childGender.equals("M") || childGender.equals("F")) {
							System.out.println("Enter gender of the child (M or F only)");
							childGender = input.next();
							if (!(childGender.toLowerCase().equals("m")
									|| childGender.toLowerCase().equals("f"))) //toLowerCase() is used, so both upper case and lower case inputs treated as same
							{
								System.out.println("Invalid selection. Please enter a valid choice.");
								childGender = "M";
							} else {
								g = childGender.toUpperCase(); //If the input is m or f, We will again convert it to upper case for storing
								childGender = "A";
							}
						}
						//Now taking parent ids for this newly created child object
						boolean found = false;
						int p1 = 0, p2 = 0;
						//Taking father id
						while (!found) {
							System.out.println("Enter Id of the father of the child.");
							p1 = input.nextInt();
							boolean parentFound = false;

							//Loop to check id from existing profiles
							for (Adult adult : adultProfileList) {
								if (adult.getId() == p1)
									parentFound = true;
							}
							boolean isMale = false;
							if (parentFound) {
								for (Adult adult : adultProfileList) {
									if (adult.getId() == p1) {
										//If id is from existing profiles, we will check if the id is of Male profile
										if (adult.getGender().equals("M"))
											isMale = true;
										else {
											System.out.println(
													"This is Id of the Female. Please enter id of Male.");
										}
									}
								}
								if (isMale)
									found = true;
							}
							//If id is invalid, displaying message
							else {
								System.out.println("No profile found against this id.");
							}
						}

						found = false;

						//Taking mother id
						while (!found) {
							System.out.println("Enter Id of the mother of the child.");
							p2 = input.nextInt();
							boolean parentFound = false;

							//Loop to check id from existing profiles
							for (Adult adult : adultProfileList) {
								if (adult.getId() == p2)
									parentFound = true;
							}
							boolean isFemale = false;
							if (parentFound) {
								//If id is from existing profiles, we will check if the id is of Female profile
								for (Adult adult : adultProfileList) {
									if (adult.getId() == p2) {
										if (adult.getGender().equals("F"))
											isFemale = true;
										else {
											System.out.println(
													"This is Id of the Male. Please enter id of Female.");
										}
									}
								}
								if (isFemale)
									found = true;
							}

							//If id is invalid, displaying message
							else {
								System.out.println("No profile found against this id.");
							}
						}
						//Finally adding child to the network
						Child c = new Child();
						c.setName(name);
						c.setAge(childAge);
						c.setGender(g);
						c.makeParent(p1, p2);
						childProfileList.add(c);

						//Adding the id of this newly created child to his/her respected parents as well
						for (Adult adult : adultProfileList) {
							if (adult.getId() == p1)
								adult.makeChild(c.getId());
							if (adult.getId() == p2)
								adult.makeChild(c.getId());
						}

						System.out.println("Child has been added.");
					}

					//Go back
					else if (addChoice == 3) {
						break;
					}

					//invalid choice
					else {
						System.out.println("Invalid selection. Please enter a valid choice.");
						addChoice = 1;
					}

				}

			}

			//2. List everyone
			else if (choice == 2) {
				//Listing all adult profiles
				System.out.println("Adult profiles\n");
				int i = 1;
				for (Adult adult : adultProfileList) {
					System.out.println(i);
					adult.displayProfile();
					++i;
				}
				System.out.println();
				System.out.println();

				//Listing all child profiles
				System.out.println("Child profiles\n");
				i = 1;
				for (Child childObj : childProfileList) {
					System.out.println(i);
					childObj.displayProfile();
					++i;
				}
				System.out.println();
				System.out.println();
			}

			//3. Select a person
			else if (choice == 3) {
				int profileChoice = 1;
				while (profileChoice >= 1 && profileChoice <= 3) {
					//Listing sub choices
					String submenuOptions [] = {
							"Select from Adult profile  "
							,"Select from Child profile"
							,"Go back   "
					} ;
					Menu selectProfileMenu = new Menu ("Select Profile Type" , submenuOptions);
					selectProfileMenu.display();
					profileChoice = selectProfileMenu.getValidChoice();
					  

					//1. Select from Adult profile
					if (profileChoice == 1) {
						System.out.println("Enter partial or full name of the person");
						input.nextLine();
						String name = input.nextLine();
						for (int i = 0; i < adultProfileList.size(); ++i) {
							if (adultProfileList.get(i).getName().contains(name)) //contains method is used, so can it work for both partial or full name 
							{

								int adultChoice = 1;
								while (adultChoice >= 1 && adultChoice <= 5) {
									//Displaying the submenu if the profile is found
									
									String profileOptions [] = {
											"Display the profile"
											,"Update the profile"
											,"Delete the person   "
											,"Make this person friend of another person"
											,"Find out whether a person is a direct friend of another person"
											,"Find out person's friend(s)"
											,"Find out person's child(ren)"
											,"Go back"
									} ;
									Menu profileMenu = new Menu ("Select Profile Type" , submenuOptions);
									profileMenu.display();
									adultChoice = selectProfileMenu.getValidChoice();
									   
									//1. Display the profile
									if (adultChoice == 1) {
										adultProfileList.get(i).displayProfile();
									}

									//2. Update the profile
									else if (adultChoice == 2) { //change name
										System.out.print("Enter new name: ");
										input.nextLine();
										//change age
										String newName = input.nextLine();
										System.out.print("Enter new age: ");
										int newAge = input.nextInt();
										//change status
										System.out.print("Enter new status: ");
										input.nextLine();
										String newStatus = input.nextLine();
										adultProfileList.get(i).updateProfile(newName, newAge, newStatus);
										System.out.println("Profile has been updated");
										System.out.println();
									}

									//3. Delete the person
									else if (adultChoice == 3) {
										adultProfileList.remove(adultProfileList.get(i));
										System.out.println("The person has been deleted.");
										break;
									}

									//4. Make this person friend of another person
									else if (adultChoice == 4) {
										System.out.println("Enter the Profile ID of the person: ");
										int id = input.nextInt();
										boolean isAlreadyFriend = false;

										//Checking if the person is already friend of this id
										for (int friendId : adultProfileList.get(i).getFriendList()) {
											if (id == friendId)
												isAlreadyFriend = true;
										}
										if (isAlreadyFriend)
											System.out.println(
													"These two persons are already friends of each other.");

										//If the person is not already friend of this id, we will then add this id to his/her friend list
										else {
											adultProfileList.get(i).makeFriend(id);

											//Adding this person's id to his/her friend's list of friends
											for (Adult adult : adultProfileList) {
												if (adult.getId() == id)
													adult.makeFriend(adultProfileList.get(i).getId());
											}
											System.out.println("Added as a friend.");
										}
									}

									//5. Find out whether a person is a direct friend of another person.
									else if (adultChoice == 5) {
										System.out.println("Enter the Profile ID of the person: ");
										int id = input.nextInt();
										boolean isFriend = false;

										//Checking for friendship
										for (int friendId : adultProfileList.get(i).getFriendList()) {
											if (id == friendId) //If id is found, setting isFriend to true
												isFriend = true;
										}
										if (isFriend)
											System.out.println(
													"Yes, these two persons are friends of each other.");
										else {
											System.out.println(
													"No, these two persons are not friends of each other.");
										}
									}

									//6. Find out person's friend(s).
									else if (adultChoice == 6) {

 										int n = 0;
										for (int friendId : adultProfileList.get(i).getFriendList()) {

 											//Looping through array of profiles to display the friends
											for (Adult adult : adultProfileList) {

 												if (adult.getId() == friendId) {
													System.out.println(n);
													adult.displayProfile();
													++n;
												} else
													System.out.println("ther is no friend for this person");
											}
										}
									}

									//7. Find out person's child(ren).
									else if (adultChoice == 7) {
										int n = 1;
										for (int childId : adultProfileList.get(i).getChildList()) {
											//Looping through array of profiles to display the childrens
											for (Child c : childProfileList) {
												if (c.getId() == childId) {
													System.out.println(n);
													c.displayProfile();
													++n;
												}
											}
										}
									}

									//8. Go back
									else if (adultChoice == 8) {
										break;
									}

									//Invalid selection
									else {
										System.out.println("Invalid selection. Please enter a valid choice.");
										adultChoice = 1;
									}
								}
								break;
							}else {
								System.out.println("This person is not exist");
							}
						}
					}

					//1. Select from Child profile
					else if (profileChoice == 2) {
						System.out.println("Enter partial or full name of the child");
						input.nextLine();
						String name = input.nextLine();
						for (int i = 0; i < childProfileList.size(); ++i) {
							if (childProfileList.get(i).getName().contains(name)) //contains method is used so can it work for both partial or full name 
							{

								int childChoice = 1;
								while (childChoice >= 1 && childChoice <= 5) {
									//Displaying the submenu if the profile is found
									System.out.println("1. Display the profile.");
									System.out.println("2. Update the profile.");
									System.out.println("3. Delete the person.");
									System.out.println("4. Make this child friend of another child");
									System.out.println(
											"5. Find out whether a child is a direct friend of another child.");
									System.out.println("6. Find out child's friend(s).");
									System.out.println("7. Find out child's parents.");
									System.out.println("8. Go back");

									childChoice = input.nextInt();

									//1. Display the profile.
									if (childChoice == 1) {
										childProfileList.get(i).displayProfile();
									}

									//2. Update the profile.
									else if (childChoice == 2) {
										System.out.print("Enter new name: ");
										input.nextLine();
										String newName = input.nextLine();
										System.out.print("Enter new age: ");
										int newAge = input.nextInt();
										System.out.print("Enter new status: ");
										input.nextLine();
										String newStatus = input.nextLine();
										childProfileList.get(i).updateProfile(newName, newAge, newStatus);
										System.out.println("Profile has been updated");
										System.out.println();
									}

									//3. Delete the person.
									else if (childChoice == 3) {
										childProfileList.remove(childProfileList.get(i));
										System.out.println("The child has been deleted.");
										break;
									}

									//4. Make this child friend of another child
									else if (childChoice == 4) {
										System.out.println("Enter the Profile ID of the child: ");
										int id = input.nextInt();
										boolean isAlreadyFriend = false;

										//Checking if the person is already friend of this id
										for (int friendId : childProfileList.get(i).getFriendList()) {
											if (id == friendId)
												isAlreadyFriend = true;
										}
										if (isAlreadyFriend)
											System.out.println(
													"These two children are already friends of each other.");

										//If the person is not already friend of this id, we will then add this id to his/her friend list
										//But first we will make sure that the age difference is 3 or less, and the age is greater than 2
										else {
											boolean flag = false;
											for (Child c : childProfileList) {
												if (c.getId() == id) {
													if (c.getAge() > 2
															&& childProfileList.get(i).getAge() > 2) {
														//Getting the difference for both profiles
														int difference = childProfileList.get(i).getAge()
																- c.getAge();

														//If the difference is in negative, we will convert it to pisitive
														if (difference < 0)
															difference = -difference;

														//Now checking for the difference
														//If difference is 3 or less
														if (difference <= 3) {
															childProfileList.get(i).makeFriend(id);

															//Adding the id of the selected profile to profile of Id entered
															for (Child cc : childProfileList) {
																if (cc.getId() == id)
																	cc.makeFriend(
																			childProfileList.get(i).getId());
															}
															System.out.println("Added as a friend.");
														} else
															System.out.println(
																	"The age difference between these two childs is more than 3 years, so they cannot make friends of each other.");
													} else
														System.out.println(
																"One of these two childs are 2 years or below, so they cannot make friends of each other.");
												}
											}

										}
									}

									//5. Find out whether a child is a direct friend of another child.
									else if (childChoice == 5) {
										System.out.println("Enter the Profile ID of the child: ");
										int id = input.nextInt();
										boolean isFriend = false;

										//Checking for friendship
										for (int friendId : childProfileList.get(i).getFriendList()) {
											//If id is found, setting isFriend to true
											if (id == friendId)
												isFriend = true;
										}
										if (isFriend)
											System.out.println(
													"Yes, these two childrens are friends of each other.");
										else {
											System.out.println(
													"No, these two childrens are not friends of each other.");
										}
									}

									//6. Find out child's friend(s).
									else if (childChoice == 6) {
										int n = 1;
										for (int friendId : childProfileList.get(i).getFriendList()) {
											System.out.println(friendId);
											//Looping through array of profiles to display the friends
											for (Child c : childProfileList) {
												if (c.getId() == friendId) {
													System.out.println(n);
													c.displayProfile();
													++n;
												}
											}
										}
									}

									//7. Find out child's parents.
									else if (childChoice == 7) {
										int n = 1;
										for (int parentId : childProfileList.get(i).getParentList()) {
											//Looping through array of profiles to display the parents
											for (Adult adult : adultProfileList) {
												if (adult.getId() == parentId) {
													System.out.println(n);
													adult.displayProfile();
													++n;
												}
											}
										}
									}

									//8. Go back
									else if (childChoice == 8) {
										break;
									}

									//Invalid choice
									else {
										System.out.println("Invalid selection. Please enter a valid choice.");
										childChoice = 1;
									}
								}
								break;
							}
						}
					}

					//Go back
					else if (profileChoice == 3) {
						break;
					}

					//invalid choice
					else {
						System.out.println("Invalid selection. Please enter a valid choice.");
						profileChoice = 1;
					}
				}

			}

			//Invalid choice
			else if(choice==4){
				System.out.println(" Good Bye.");
			}else {
				System.out.println("Invalid selection. Please enter a valid choice.");
				choice = 1;
			}

		} while(choice!=4);


	}
}

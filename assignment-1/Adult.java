


import java.util.ArrayList; 

/**
 *
 * @author Hamad s3619196
 */
public class Adult extends Person implements Profile{

    //Assign the child to the profile
    private ArrayList<Integer> childList;
    public void makeChild(int id)
    {
        this.childList.add(id);
    }
    
    //Constructor
    public Adult()
    {
        super();
        initializeChildList();
    }
    
    //Initilize list of the children
    private void initializeChildList()
    {
        childList = new ArrayList<>() ;
    }
    
    //return the list of children
    public ArrayList<Integer> getChildList() {
        return childList;
    }

    @Override
    public ArrayList<Integer> getFriendList() {
      return friendList;   
    }

    @Override
    public void makeFriend(int id) {
        this.friendList.add(id);   
    }

    @Override
    public void updateProfile(String name, int age, String status) {
        setName(name);
        setAge(age);
        setStatus(status);  
    }

    @Override
    public void displayProfile() {
        System.out.println("Profile ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Status: " + getStatus());
        System.out.println(); 
    }
    
    }


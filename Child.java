



import java.util.ArrayList;

/**
 *
 * @author Hamad s3619196
 */
public class Child extends Person implements Profile{
    private ArrayList<Integer> parentList;
    
    //Assign the parents to the profile
    public void makeParent(int parent1,int parent2)
    {
        if(this.parentList.size()!=2)
        {
            this.parentList.add(parent1);
            this.parentList.add(parent2);
        }
    }
    
    //Constructor
    public Child()
    {
        super();
        initializeParentList();
    }
    
    // initialize List of Parents
    private void initializeParentList()
    {
        parentList = new ArrayList<>() ;
    }
    
    // return the List of Parents
    public ArrayList<Integer> getParentList() {
        return parentList;
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





import java.util.ArrayList;

/**
 *
 * @author Hamad s3619196
 */
abstract class Person {
    private static int pId = 1; //static data member, which will increment after assigning to a profile 
    private int id; //Id of the profile
    private int age; //Age of the profile
    private String name; //name of the profile
    private String status; //status of the profile
    private String gender; //gender of the profile
    ArrayList<Integer> friendList; //friend list of the profile
    
     //Constructor
    public Person()
    {
        this.setId(getNextPid());
        this.setAge(0);
        this.setName("");
        this.setStatus("");
        this.initializeFriendList();
    }
   //Setters
    private void setId(int id)
    {
        this.id=id;
    }

    private void setPid(int pId)
    {
        this.pId=pId;
    }
    
    public void setGender(String gender)
    {
        this.gender=gender;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    //Getters
    public int getId()
    {
        return this.id;
    }
    
    public String getGender()
    {
        return this.gender;
    }
    
    public int getpId()
    {
        return this.pId;
    }
    
    //Assign an Id to a profile and increment Pid
    private int getNextPid()
    {
        int temp = getpId();
        setPid(temp+1);
        return temp;
    }
    
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
     
        //Method to initialize friend list
    private void initializeFriendList()
    {
        this.friendList=new ArrayList<>();
    }
}

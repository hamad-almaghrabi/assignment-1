



import java.util.ArrayList;

/**
 *
 * @author Hamad s3619196
 */
public interface Profile {
        //Method to return friend list
    public ArrayList<Integer> getFriendList();
    
    //Method to make friend
    public void makeFriend(int id);
    
    //Method to update the profile
    public void updateProfile(String name, int age, String status);
    //Method to the display profile
    public void displayProfile();
}

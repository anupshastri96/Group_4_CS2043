
public class Admin extends User{

   
    //creating admin
	public Admin(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName, true, false, false);
        adminList.add(this);
        
	}

    //creating admin, docs and nurses
    public void createUser(String username, String password, String firstName, String lastName, boolean isAdmin, boolean isDoctor, boolean isNurse){
        if(isAdmin){
           new Admin(username, password, firstName, lastName);
        }
        if(isDoctor){
           new Doctor(username, password, firstName, lastName);
        }
        if(isNurse){
            new Nurse(username, password, firstName, lastName);
        }
    }

    

    //deleting user from list
    public void deleteUser(String username){
        User tempUser = null;
        //searching for user with a matching username
        for(int i =0 ; i < userList.size(); i++){
            if (userList.get(i).getUserName() == username){
                tempUser = userList.get(i);
            }
        }
        if (tempUser.isAdmin()){
            adminList.remove(tempUser);
            userList.remove(tempUser);
        }
        if(tempUser.isDoctor()){
            docsList.remove(tempUser);
            userList.remove(tempUser);
        }
        if(tempUser.isNurse()){
            nursesList.remove(tempUser);
            userList.remove(tempUser);
        }
    }

    //updating users by deleting the user then creating a new user
    public void updateUser(String oldUsername, String newUsername, String password, String firstName, String lastName, boolean isAdmin, boolean isDoctor, boolean isNurse){
       
        deleteUser(oldUsername);
        createUser(newUsername, password, firstName, lastName, isAdmin, isDoctor, isNurse);
    }

    //view entire staff records
    public String viewStaffRecords(){
        String info =""; 
        for(int i = 0 ; i < adminList.size(); i++){
            info += ("Admin: " + adminList.get(i).toString() + "\n");
        }
        for(int i = 0 ; i < docsList.size(); i++){
            info += ("Doctor: " + docsList.get(i).toString() + "\n");
        }
        for(int i = 0 ; i < nursesList.size(); i++){
            info += ("Nurse: " + nursesList.get(i).toString() + "\n");
        }

        return info;
    }


}

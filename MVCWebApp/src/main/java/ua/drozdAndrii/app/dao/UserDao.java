package ua.drozdAndrii.app.dao;

import org.springframework.stereotype.Component;
import ua.drozdAndrii.app.model.User;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDao {
    private List<User> users;
    private int USER_ID;

    {
        users =new ArrayList<>();
        users.add(new User(++USER_ID,"testEmail1@gmail.com","1","Alex"));
        users.add(new User(++USER_ID,"testEmail2@gmail.com","1","Misha"));
        users.add(new User(++USER_ID,"testEmail3@gmail.com","1","Andrii"));
        users.add(new User(++USER_ID,"testEmail4@gmail.com","1","Grisha"));
        users.add(new User(++USER_ID,"testEmail5@gmail.com","1","Max"));
    }

    public List<User> getAllUsers(){
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }

    public User getUserByEmailAndPassword(String email, String password){
        for(int i = 0; i< users.size(); i++){
            User user = users.get(i);
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public int getUSER_ID() {
        return USER_ID;
    }
}

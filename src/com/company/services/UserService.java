package com.company.services;

import com.company.models.User;
import com.company.repository.UserRepository;
import com.company.utils.Inputs;

public class UserService {

    UserRepository repository;
    Inputs inputs;

    public UserService(){
        this.repository =  new UserRepository();
        this.inputs = new Inputs();
    }

    public void addUser(User toAdd) { repository.getAll().put(toAdd.getID(), toAdd); }


    public User getUserByID(Long id) { return repository.getAll().get(id); }

    public void updateUser(User user, int option){
        switch (option){
            case 1:
                user.setName(inputs.inputString());
                break;
            case 2:
                user.setLastName(inputs.inputString());
                break;
            case 3:
                user.setDNI(inputs.inputString());
                break;
            case 4:
                user.setAdress(inputs.inputString());
                break;
            case 5:
                user.setPhone(inputs.inputString());
                break;
            case 6:
                user.setEmail(inputs.inputString());
                break;
            case 7:
                user.setGenre(inputs.inputString());
                break;
            case 8:
                user.setUserId(inputs.inputString());
                break;
            case 9:
                user.setPassword(inputs.inputString());
                break;
        };
    }

    public void showUserDetails(User user){
        System.out.println("\n1. ID: "+user.getUserId()
                +"\n2. Name: "+user.getName()
                +"\n3. Last Name: "+user.getLastName()
                +"\n4. DNI: "+user.getDNI()
                +"\n5. Adress: "+user.getAdress()
                +"\n6. Phone: "+user.getPhone()
                +"\n7. Email: "+user.getEmail()
                +"\n8. Genre: "+user.getGenre()
                +"\n9. UserID: "+user.getUserId()
                +"\n10. Password: "+user.getPassword()
        );
    }

    private void showUsersOnSearch(User user){
        System.out.println("\n ID: "+ user.getID()
                +"\n Name: "+ user.getName()
                +"\n Last Name: "+ user.getLastName()
                +"\n DNI: "+ user.getDNI()
        );
    }

    public Long searchUser(String userId){
        long exists = 0;
        Integer key = 1;
        while (key <= repository.getUsers().size() && exists == 0) {
            if (userId.equals(repository.getUsers().get(key.longValue()).getUserId()))
                exists = key.longValue();
            key++;
        }
        return exists;
    }

    public User searchByUserName(String userName) {
        return repository.getByUserName(userName);
    }

    public void register(User user) {
        repository.register(user);
    }
}

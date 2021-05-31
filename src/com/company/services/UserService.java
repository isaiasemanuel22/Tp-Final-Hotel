package com.company.services;

import com.company.models.User;
import com.company.repository.UserRepository;
import com.company.utils.Archivos;
import com.company.utils.Inputs;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserService {
    UserRepository repository;
    Inputs inputs = new Inputs();
    HashMap<Long, User> users;

    public UserService() throws IOException {
        this.repository =  new UserRepository();
        this.inputs = new Inputs();
        this.users = repository.getAll();
    }

    public int traerUsuario(String userName){
        int acceso = 0;
        if(userName.equals("Isaias")){
            System.out.println(userName);
            acceso = 1;
        }else if(userName.equals("Octavio")){
            System.out.println(userName);
            acceso = 2;
        }else if(userName.equals("Emanuel")){
            System.out.println(userName);
            acceso = 3;
        }
        return acceso;
    }

    public User getUserByID(HashMap<Integer, User> users, Long id){
        return users.get(id);
    }

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
        }
    }

    private void showUserDetails(User user){
        System.out.println("\n ID: "+user.getID()
                +"\n Name: "+user.getName()
                +"\n Last Name: "+user.getLastName()
                +"\n DNI: "+user.getDNI()
                +"\n Adress: "+user.getAdress()
                +"\n Phone: "+user.getPhone()
                +"\n Email: "+user.getEmail()
                +"\n Genre: "+user.getGenre()
                +"\n UserID: "+user.getUserId()
                +"\n Password: "+user.getPassword()
        );
    }

    private void showUsersOnSearch(HashMap<Integer, User> users){
        for (Integer key: users.keySet()) {
            System.out.println("\n ID: "+ users.get(key).getID()
                    +"\n Name: "+ users.get(key).getName()
                    +"\n Last Name: "+ users.get(key).getLastName()
                    +"\n DNI: "+ users.get(key).getDNI()
            );
        }
    }

    public void showUsers(HashMap<Integer, User> users){
        for (Integer key: users.keySet())
            showUsersOnSearch(users);

        System.out.print("\n Elija el ID del usuario que quiere ver: ");
        showUserDetails(users.get(new Scanner(System.in).nextInt()));
    }
}

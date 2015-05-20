/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Franz
 */
@Stateless
@LocalBean
public class UsersHandlerSessionBean {
    private List<User> Users = new ArrayList<User>();    
    
    public void createUser(String name, int id, String password) {
        for (User user : Users) {
            if (user.getId()== id) {
                System.out.println("Ya existe el usuario");
                return;
            }
        }
        User newUser = new User(name, password,id);
        Users.add(newUser);
        System.out.println("AGREGO");
    }
    
    public void modifyUser(String newName, int id, String newPassword) {
        for (User user : Users) {
            if (user.getId()== id) {
                user.setName(newName);
                user.setPassword(newPassword);
                System.out.println("Usuario modificado");
                return;
            }
        }        
        System.out.println("No existe el usuario");
    }
    
    public void deleteUser(int id) {
        if(Users.removeIf(u->u.getId()==id)){
            System.out.println("Usuario eliminado");
        }
        else{
            System.out.println("No existe el usuario");
        }
    }
    
    public List<User> getUsers(){
        return this.Users;
    }
    
    public User getUser(int id){
        for (User user : Users) {
            if (user.getId()== id) {
                return user;
            }
        }
        System.out.println("No existe el usuario");
        return null;
    }
    
}

    


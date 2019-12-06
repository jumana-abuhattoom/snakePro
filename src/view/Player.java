/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Jumana abuHattoum
 */
public class Player {
    public String name; 
    public String password; 
    public int highscore; 

    Player(String name, String password){ 
        this.name = name; 
        this.password = password;
        highscore = 0;
    }
    
}

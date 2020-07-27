/* Based on the ecs 100 template
 * Code for album rating software
 * Name: Nathan Kaffes
 * Date: 24/07/20
 */


import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;


/** <description of class MusicGUI>
 */
public class MusicGUI{
    private Playlist music = new Playlist();
    private String chosenName;
    private String chosenGenre;
    /**
     * initialises the GUI and sets all of the buttons
     */
    public MusicGUI(){
        UI.initialise();
        UI.addButton("Add Album", this::newAlbum);
        UI.addTextField("Search", this::setName);
        UI.addButton("Search", this::searchAlbum);
        UI.addTextField("Search by Genre", this::setGenre);
        UI.addButton("Search by Genre", this::searchGenre);
        UI.addButton("Search All", this::searchAll);
        UI.addButton("Quit", UI::quit);
    }
    
    /**
     * This method will create a new album and then call a method to put the info in the hashmap
     */
    public void newAlbum(){
        //clears the output field
        UI.clearText();
        //asks for each part of the hashmap relating to a specific album
        String name = UI.askString("Please enter Album Name: ");
        String art = UI.askString("Please the Album's Artist's name: ");
        int pub = UI.askInt("Please enter the Album's Year of Publication: ");
        String gen = UI.askString("Please enter the Album's Genre: ");
        //calls the addAlbum method to put the album in the hashmap
        music.addAlbum(name, art, pub, gen);
        UI.println("\nName: " + name + "\nArtist: " + art + "\nYear: " + pub + "\nGenre: " + gen);
    }
    
    /**
     * This method stores the text field's string in a variable
     */
    public void setName(String name){
        chosenName = name;
    }
    
    /**
     * This method will let the user search for an album by name
     */
    public void searchAlbum(){
        music.printChosen(chosenName);
    }
    
    /**
     * This method stores the text field's string in a variable
     */
    public void setGenre(String genre){
        chosenGenre = genre;
    }
    
    /**
     * This method will let the user search for an album or albums by genre
     */
    public void searchGenre(){
        music.printGenre(chosenGenre);
    }
    
    /**
     * This method will let the user search for all the albums in the hashmap
     */
    public void searchAll(){
        music.printAll();
    }
    
    /**
     * Main function
     */
    public static void main(String[] args){
        //creates a new instance of the constructor
        MusicGUI obj = new MusicGUI();
    }
}

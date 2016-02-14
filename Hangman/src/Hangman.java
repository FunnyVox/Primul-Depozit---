//import java.util.Scanner;
public class Hangman {
    
    public static void main(String[] args) {
      if(args.length == 0){
        System.out.println("You must introduce a word to be guessed!\n");
        System.exit(0);
      }
    
      Game game = new Game(args[0].toLowerCase());
      
      
      Prompter prompter = new Prompter (game);
      prompter.play();
        // Enter amazing code here:
    }

}
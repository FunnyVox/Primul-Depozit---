public class Game{
  private String mAnswer;
  private String mHits;
  private String mMisses;
  public static final int MAX_MISSES = 7;
  
  public Game(String answer){
    mAnswer = answer;
    mHits = "";
    mMisses = "";   
  }
  
  private char validateGuess(char letter){
 if(!Character.isLetter(letter)){
    throw new IllegalArgumentException("Please give a letter!");
    }
    letter = Character.toLowerCase(letter);
    if(mMisses.indexOf(letter) != -1 || mHits.indexOf(letter) != -1 ){
    throw new IllegalArgumentException(letter+" has already been guessed!");
    }
  return letter;
  }
  
  
  
  public boolean applyGuess(String guess){
    if(guess.length()==0){
      throw new IllegalArgumentException("No letters found.");
    }
        return applyGuess(guess.charAt(0));
  }
  
  public boolean applyGuess(char guess){    
    guess = validateGuess(guess);
  for(int i=0;i<mAnswer.length();i++){
  if(guess==mAnswer.charAt(i)){
     mHits += guess;
    
  return true;
  }
  }
    mMisses += guess;
    return false;
  }
  
  public String getCurrentProgress(){
     String progress = ""; 
    for(char letter:mAnswer.toCharArray()){
      char display = '-';
      if(mHits.indexOf(letter)>=0){
        display = letter;
      }
       progress += display;
      
    }
        return progress;
  
  }

  public int getRemainingTries(){
  return MAX_MISSES-mMisses.length();
  }
  
  public boolean isSolved(){
    return getCurrentProgress().indexOf('-') == -1;
  
  }
  public String getAnswer(){
  return mAnswer;
  }
  
}
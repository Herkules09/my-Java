package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Wisielec {

    List<String> words = List.of("vehicle","cat","programming","computer");
    String word;
    int lives =3;
    char[] userWord;



    public void play(){
        Scanner scanner = new Scanner(System.in);

        Random random= new Random();
        word = words.get(random.nextInt(words.size()));
        userWord=new char[word.length()];
        Arrays.fill(userWord, '_');
        System.out.println(userWord);

        while (!gameEnded()){
            System.out.println(userWord);
            System.out.println();
            System.out.println("your lives:"+lives);
            System.out.println("Enter next letter: ");

            char letter = scanner.nextLine().charAt(0);

            checkLetter(letter);



        }
        if(lives==0){
            System.out.println("Unfortunately you failed :(");
        }else {
            System.out.println("Congratulations you won :)");
        }
        System.out.println("This word is: "+word);
        scanner.close();
    }

    private void checkLetter(char letter) {
        boolean foundLetter =false;
        for (int i =0;i<word.length();i++){
            if(word.charAt(i)==letter){
                userWord[i]=letter;
                foundLetter=true;
            }
        }
        if(!foundLetter){
            lives--;
        }
    }

    private boolean gameEnded() {

        return lives==0 ||word.equals(String.valueOf(userWord));

    }
}

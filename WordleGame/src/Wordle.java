import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Wordle implements ActionListener {



    class WordPanel extends JPanel{
        JLabel[]wordColumns = new JLabel[5];

        public WordPanel(){
            this.setLayout(new GridLayout(1,5));
            Border border=BorderFactory.createLineBorder(Color.GRAY);
            for(int i=0;i<5;i++){
                wordColumns[i]=new JLabel();
                wordColumns[i].setOpaque(true);
                wordColumns[i].setBorder(border);
                this.add(wordColumns[i]);
            }
        }
        public void setTextPanel(String charValue,int position,Color color){
            this.wordColumns[position].setText(charValue);
            this.wordColumns[position].setHorizontalAlignment(JTextField.CENTER);
            this.wordColumns[position].setFont(new Font("Arial",Font.BOLD,15));
            this.wordColumns[position].setBackground(color);

        }

    }


    class UserPanel extends JPanel{
        private JTextField userInput;
        private JButton okButton;

        public UserPanel(){
            this.setLayout(new GridLayout(1,2));
            userInput= new JTextField();
            userInput.setFont(new Font("Arial",Font.BOLD,18));
            userInput.setDocument(new JTextFieldLimit(5));
            userInput.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if(userInput.getText().length()<5){
                        okButton.setEnabled(false);
                    }else{
                        okButton.setEnabled(true);
                    }
                }
            });
            okButton= new JButton("OK");
            this.add(userInput);
            this.add(okButton);

        }

        public JTextField getUserInput() {
            return userInput;
        }

        public void setUserInput(JTextField userInput) {
            this.userInput = userInput;
        }

        public JButton getOkButton() {
            return okButton;
        }

        public void setOkButton(JButton okButton) {
            this.okButton = okButton;
        }

    }


    private JFrame gameFrame;
    private WordPanel[] wordPanel=new WordPanel[6];
    private UserPanel userPanel;
    private String WordleWord;
    private int count=0;
    private boolean win=false;
    public static boolean play=false;



    @Override
    public void actionPerformed(ActionEvent e) {

            if (userPanel.okButton.equals(e.getSource())&& count<7) {
                String userGuess = userPanel.getUserInput().getText().toUpperCase();
                isWordleWordEqualTo(userGuess);
                count++;
            }if (userPanel.okButton.equals(e.getSource())&& count==6 &&win==false) {
                JOptionPane.showMessageDialog(null,"You failed :( The word is "+WordleWord);
                endPanel();

               // System.exit(0);
            }

    }

    public String getWordleWord(){
         Path path= Paths.get("C:\\Users\\michk\\IdeaProjects\\WordleGame\\src\\words.txt");
         ArrayList<String>wordList=new ArrayList<>();
         try{
             wordList= (ArrayList<String>) Files.readAllLines(path);
         }catch (IOException e){
             e.printStackTrace();
         }
         Random random= new Random();
         int position=random.nextInt(wordList.size());

        return wordList.get(position).trim().toUpperCase();
    }

    private void isWordleWordEqualTo(String guessWord){
      List<String> wordleWordsList= Arrays.asList(WordleWord.split(""));
      String[] guessWordArr=guessWord.split("");
      int goodCount=0;

      for (int i=0;i<5;i++){
          if(wordleWordsList.get(i).equals(guessWordArr[i])){
                getActivePanel().setTextPanel(guessWordArr[i],i,Color.GREEN);
                goodCount++;
                if(goodCount==5){
                    //Win game
                    win=true;
                    JOptionPane.showMessageDialog(null,"You win! The word is "+WordleWord);
                    endPanel();
                }
          }else if(wordleWordsList.contains(guessWordArr[i])){
              getActivePanel().setTextPanel(guessWordArr[i],i,Color.YELLOW);
          }else{
              getActivePanel().setTextPanel(guessWordArr[i],i,null);
          }
      }
    }

    public WordPanel getActivePanel(){
       return this.wordPanel[count];
    }

    public void endPanel(){
       int option= JOptionPane.showConfirmDialog(null,"Do you want to play again? ",null,JOptionPane.YES_NO_OPTION);

        switch (option) {
            case JOptionPane.YES_OPTION:

              play=true;//TODO nie dziala ponowne uruchomienie
            case JOptionPane.NO_OPTION:
               System.exit(0);
        }
    }

    public Wordle() {
        gameFrame= new JFrame("Wordle Game");
        gameFrame.setSize(400,400);
        gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameFrame.setLayout(new GridLayout(7,1));
        gameFrame.setResizable(false);
        gameFrame.setVisible(true);
        gameFrame.setLocationRelativeTo(null);


        for(int i=0;i<6;i++){
            wordPanel[i]= new WordPanel();
            gameFrame.add(wordPanel[i]);
        }

        WordleWord=getWordleWord();
        //System.out.println(WordleWord);
        userPanel= new UserPanel();
        gameFrame.add(userPanel);
        userPanel.okButton.addActionListener(this);
        gameFrame.revalidate();
    }





    public static void main(String[] args) {

           new Wordle();
      





    }
}

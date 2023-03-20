import javax.swing.*;

public class MyThread extends Wordle implements Runnable{



    @Override
    public void run() {
         try {
             Thread.sleep(1000);
         }catch (InterruptedException e){
             e.printStackTrace();

         }
    }





}

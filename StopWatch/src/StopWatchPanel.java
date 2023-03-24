import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopWatchPanel extends JPanel {

    private JPanel userPanel = new JPanel();
    private JFrame frame = new JFrame();
    private Label timeDisplay = new Label("00:00:00", SwingConstants.CENTER);
    private JButton startButton = new JButton("START");
    private JButton stopButton = new JButton("STOP");
    private JButton resetButton = new JButton("RESET");
    private Timer refreshRate = new Timer(100, new ActionListen());
    private int milliseconds, seconds, minutes, hours;

    public StopWatchPanel() {
        userPanel.setPreferredSize(new Dimension(400, 100));
        userPanel.setBackground(new Color(200, 200, 255));

        startButton.addActionListener(new ActionListen());
        stopButton.addActionListener(new ActionListen());
        resetButton.addActionListener(new ActionListen());

        frame.setResizable(false);
        frame.setTitle("STOPWATCH");
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(450,200);
        timeDisplay.setPreferredSize(new Dimension(400, 100));
        
        userPanel.setVisible(true);
        userPanel.add(timeDisplay);
        userPanel.add(startButton);
        userPanel.add(stopButton);
        userPanel.add(resetButton);
        frame.add(userPanel);

        add(frame);


    }

    private int milSec() {
        milliseconds += 100;
        if (milliseconds >= 1000) {
            milliseconds = 0;
            seconds++;
        }
        return milliseconds;
    }

    private int sec() {
        if (seconds > 59) {
            seconds = 0;
            minutes++;
        }
        return seconds;
    }

    private int min() {
        if (minutes > 59) {
            minutes = 0;
            hours++;
        }
        return minutes;
    }

    private int hours() {
        if (hours > 23) {
            hours = 0;
        }
        return hours;
    }


    public class ActionListen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(startButton)) {
                refreshRate.start();
            }else if(e.getSource().equals(refreshRate)){
                int tms=milSec();
                int ts =sec();
                int tm = min();
                int th = hours();

                timeDisplay.setText(th+":"+tm+":"+ts+":"+tms/100);
            }else if(e.getSource().equals(stopButton)){
                refreshRate.stop();
            }else if(e.getSource().equals(resetButton)){
                timeDisplay.setText("00:00:00");
                milliseconds=0;
                seconds=0;
                minutes=0;
                hours=0;
            }
        }
    }
}
package LearningJava;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.Timer;

public class InnerClassTest {
}

class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        TimePrinter timePrinter = new TimePrinter();
        Timer timer = new Timer();
//        timer. ();
    }

    public class TimePrinter implements ActionListener {
         static int o = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone,the time is" + Instant.ofEpochMilli(e.getWhen()));
            if (TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}


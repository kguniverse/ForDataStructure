package Page;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Page7{
    private JTextField time;
    private Calendar cal;
    public Page7() {
        JFrame frame = new JFrame("智慧校园导览系统");
        JPanel jpnel=new JPanel();
        jpnel.setLayout(null);
        frame.setBounds(850, 450, 290, 100);
        time = new JTextField();
        cal = Calendar.getInstance();
        time.setText(String.valueOf(cal.getTime()));
        time.setBounds(20, 5, 230, 50);
        jpnel.add(time);
        jpnel.setBackground(Color.pink);
        frame.add(jpnel);
        frame.setVisible(true);
    }
    public void refreshTime() {
        cal.add(Calendar.SECOND, Page0.getTimeRate());
        time.setText(String.valueOf(cal.getTime()));
    }

}
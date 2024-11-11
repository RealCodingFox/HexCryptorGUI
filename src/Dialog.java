import javax.swing.*;
import java.awt.*;

public class Dialog{
    private JPanel panel1;
    public Dialog(String title, String message, int messageType){
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JOptionPane.showMessageDialog(frame, message, title, messageType);
        frame.setVisible(true);
        frame.setAlwaysOnTop(false);
        frame.setVisible(false);
        frame.dispose();
    }
}

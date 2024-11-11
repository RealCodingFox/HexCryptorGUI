import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main extends JFrame {
    private JPanel MainForm;
    private JButton binaryToHexASCIIButton;
    private JButton hexASCIIToBinaryButton;
    private JButton encryptButton;
    private JButton decryptButton;
    private JButton ASCIIToBinaryHexButton;

    public Main() {
        setTitle(MainForm.getName());
        //System.out.println(UIManager.getSystemLookAndFeelClassName());
        setSize(650,200);
        setPreferredSize(new Dimension(650,200));
        setMinimumSize(new Dimension(650,200));
        setDefaultLookAndFeelDecorated(true);
        setResizable(false);
        setMaximumSize(new Dimension(650,200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(MainForm);
        setLocationRelativeTo(null);
        setVisible(true);
        binaryToHexASCIIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                BinaryToHex window = new BinaryToHex();
            }
        });
        addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                //System.out.println("Size changed to " + getSize());
                if(getSize() != new Dimension(550, 300)){
                    setSize(550,300);
                }
            }
        });
        hexASCIIToBinaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                HexToBinary hexToBinary = new HexToBinary();
            }
        });
        ASCIIToBinaryHexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ASCIIToBinary asciiToBinary = new ASCIIToBinary();
            }
        });
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Encrypt encrypt = new Encrypt();
            }
        });
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Decrypt decrypt = new Decrypt();
            }
        });
    }

    public static void main(String[] args) {
        try {
        if(UIManager.getSystemLookAndFeelClassName() != "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"){

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }else{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
            e.printStackTrace();
        }
        Main form = new Main();
    }
}

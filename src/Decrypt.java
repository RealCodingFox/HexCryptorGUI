import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Decrypt extends JFrame{
    private JTextField textField1;
    private JButton addButton;
    private JList list1;
    private JButton startDecryptionButton;
    private JPanel MainForm;
    private JButton button1;
    private JButton clearButton;
    private ArrayList<String> strings = new ArrayList<>();
    private ArrayList<String> results = new ArrayList<>();
    private ArrayList<String> res1 = new ArrayList<>();


    private static String convertToAscii(String hexString) throws Exception {
        if (hexString.length() %2 !=0) {
            System.err.println("Input hex string is invlaid");
            //throw new Exception("Input input");
            return "(none)";
        }

        StringBuilder builder = new StringBuilder();
        for (int i=0 ; i<hexString.length(); i=i+2) {
            // splitting strings into two character group
            String str = hexString.substring(i, i+2);
            // converting each character group using valueOf(...) method
            int n = Integer.valueOf(str, 16);
            // casting to char and appending to builder
            builder.append((char)n);
        }

        return builder.toString();
    }

    private static String binaryToHex(String bin){
        try{
            String binary = bin.toString();
            int decimal = Integer.parseInt(binary, 2);
            String hex = Integer.toHexString(decimal);
            return hex;
        } catch (Exception e) {
            Dialog dialog = new Dialog("Error",
                    "Sorry, an internal exception has occured:\n" + e.getClass() + " " + e.getMessage(),
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }

    public Decrypt() {
        setTitle(MainForm.getName());
        //label.setText("or Enter binary string\n(seperated by space):");
        setSize(MainForm.getPreferredSize());
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(MainForm);
        setLocationRelativeTo(null);
        setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField1.getText();
                //System.out.println(text);
                strings.add(text);
                list1.setListData(strings.toArray());
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index = list1.getSelectedIndex();
                strings.remove(index);
                list1.setListData(strings.toArray());
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                strings.clear();
                list1.setListData(strings.toArray());
            }
        });
        startDecryptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                for(String y : strings){
                    String[] z = y.split(" ");
                    String n = "";
                    for(String x : z) {
                        //System.out.println(convertToAscii(x.trim()));
                        n += convertToAscii(x.trim());
                    }
                    //System.out.println(n);
                    String h = "";
                    for(String g : n.split(" ")){
                        if(g.length() < 8){
                            g = "0" + g;
                        }
                        h += binaryToHex(g);
                    }
                    //System.out.println(h);
                    String m = convertToAscii(h);
                    //System.out.println(m);
                    String result = "";
                    for(String j : m.split(" ")){
                        result += convertToAscii(j);
                    }
                    //System.out.println(result);
                    results.add(result);
                    EncryptResults showResults = new EncryptResults(results, strings, 1);
                }
                } catch (Exception ex) {
                    Dialog dialog = new Dialog("Error", "Sorry, an internal exception has occured. \n Details will be printed to the console.", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }

        });
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Encrypt extends JFrame{
    private JTextField textField1;
    private JButton addButton;
    private JList list1;
    private JButton startEncryptionButton;
    private JPanel MainForm;
    private JButton button1;
    private JButton clearButton;
    private ArrayList<String> strings = new ArrayList<>();
    private ArrayList<String> results = new ArrayList<>();

    public static String asciiToHex(String asciiValue) {
        char[] chars = asciiValue.toCharArray();
        StringBuilder hex = new StringBuilder();
        for (char ch : chars) {
            hex.append(Integer.toHexString((int) ch));
            hex.append(" ");
        }
        return hex.toString();
    }

    public static String hexToBinary(String hexValue){
        int decimal = Integer.parseInt(hexValue, 16);

        String binary = Integer.toBinaryString(decimal);
        ////System.out.println(binary);
        while(binary.length() < 8){
            binary = "0" + binary;
        }
        return binary;
    }

    public Encrypt() {
        setTitle(MainForm.getName());
        //label.setText("or Enter binary string\n(seperated by space):");
        setSize(MainForm.getPreferredSize());
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(MainForm);
        setLocationRelativeTo(null);
        setVisible(true);

        startEncryptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(String s : strings){
                    String x = asciiToHex(s);
                    ////System.out.println("x:"+x);
                    String y = asciiToHex(x);
                    ////System.out.println("y:"+y);
                    String z = "";
                    for(String h : y.split(" ")){
                        z += hexToBinary(h) + " ";
                    }
                    String result = asciiToHex(z);
                    System.out.println("Encrypted string: " + result);
                    results.add(result);

                    EncryptResults showResuts = new EncryptResults(strings, results, 0);
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField1.getText();
                ////System.out.println(text);
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
    }
}

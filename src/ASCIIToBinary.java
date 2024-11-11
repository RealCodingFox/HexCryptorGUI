import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ASCIIToBinary extends JFrame{
    private JButton addButton;
    private JPanel MainForm;
    private JButton convertButton;
    private JList list1;
    private JButton button1;
    private JButton clearButton;
    private JTextField textField1;
    private ArrayList<String> ascii = new ArrayList<String>();
    private ArrayList<String> Results = new ArrayList<String>();

    public static String asciiToHex(String asciiValue) {
        char[] chars = asciiValue.toCharArray();
        StringBuilder hex = new StringBuilder();
        for (char ch : chars) {
            hex.append(Integer.toHexString((int) ch));
        }
        return hex.toString();
    }

    public ASCIIToBinary(){
        setTitle(MainForm.getName());
        setSize(650, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(MainForm);
        setLocationRelativeTo(null);
        setVisible(true);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ascii.add(textField1.getText());
                textField1.setText("");
                list1.setListData(ascii.toArray());
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ascii.clear();
                list1.setListData(ascii.toArray());
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index = list1.getSelectedIndex();
                ascii.remove(index);
                list1.setListData(ascii.toArray());
            }
        });
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<String> bytes = new ArrayList<>();
                for(String s : ascii){
                    char[] chars = s.toCharArray();
                    for (char ch : chars) {
                        String hex = Integer.toHexString((int) ch);
                        Results.add(hex);

                        int decimal = Integer.parseInt(hex, 16);
                        String binary = Integer.toBinaryString(decimal);
                        //System.out.println(binary);
                        while(binary.length() < 8) {
                            binary = "0" + binary;
                        }
                        bytes.add(binary);
                    }
                }
                try{BintoHex_Results showResults = new BintoHex_Results(Results, bytes);} catch(Exception ex){}
            }
        });
    }
}

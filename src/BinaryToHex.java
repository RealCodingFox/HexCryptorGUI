import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BinaryToHex extends JFrame {
    private JPanel MainForm;
    private JCheckBox checkBox1;
    private JCheckBox a0CheckBox;
    private JCheckBox a0CheckBox1;
    private JCheckBox a0CheckBox2;
    private JCheckBox a0CheckBox3;
    private JCheckBox a0CheckBox4;
    private JCheckBox a0CheckBox5;
    private JCheckBox a0CheckBox6;
    private JButton convertButton;
    private JList list1;
    private JButton addButton;
    private JButton button1;
    private JButton clearButton;
    private JButton addButton1;
    private JTextField textField1;
    private JLabel label;
    private ArrayList<String> bytes = new ArrayList<String>();
    private ArrayList<String> hexResults = new ArrayList<String>();

    public BinaryToHex() {
        setTitle(MainForm.getName());
        //label.setText("or Enter binary string\n(seperated by space):");
        setSize(890, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(MainForm);
        setLocationRelativeTo(null);
        setVisible(true);
        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(checkBox1.isSelected()){
                    checkBox1.setText("1");
                }
                else{
                    checkBox1.setText("0");
                }
            }
        });
        a0CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(a0CheckBox.isSelected()){
                    a0CheckBox.setText("1");
                }
                else{
                    a0CheckBox.setText("0");
                }
            }
        });
        a0CheckBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(a0CheckBox1.isSelected()){
                    a0CheckBox1.setText("1");
                }
                else{
                    a0CheckBox1.setText("0");
                }
            }
        });
        a0CheckBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(a0CheckBox2.isSelected()){
                    a0CheckBox2.setText("1");
                }
                else{
                    a0CheckBox2.setText("0");
                }
            }
        });
        a0CheckBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(a0CheckBox3.isSelected()){
                    a0CheckBox3.setText("1");
                }
                else{
                    a0CheckBox3.setText("0");
                }
            }
        });
        a0CheckBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(a0CheckBox4.isSelected()){
                    a0CheckBox4.setText("1");
                }
                else{
                    a0CheckBox4.setText("0");
                }
            }
        });
        a0CheckBox5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(a0CheckBox5.isSelected()){
                    a0CheckBox5.setText("1");
                }
                else{
                    a0CheckBox5.setText("0");
                }
            }
        });
        a0CheckBox6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(a0CheckBox6.isSelected()){
                    a0CheckBox6.setText("1");
                }
                else{
                    a0CheckBox6.setText("0");
                }
            }
        });
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               hexResults.clear();
                if (bytes.isEmpty()){
                    // Create a frame to be the parent of the message dialog
                   /* JFrame frame = new JFrame();

                    frame.setAlwaysOnTop(true);

                    JOptionPane.showMessageDialog(frame, "Nothing to convert!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    frame.dispose();
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setVisible(false);*/
                    Dialog dialog = new Dialog("Failure", "Nothing to convert!\nPlease add values by using the 'Add' " +
                            "buttton.", JOptionPane.ERROR_MESSAGE);
                }else{
                    for(Object bin : bytes.toArray()){
                            try{
                                String binary = bin.toString();
                                int decimal = Integer.parseInt(binary, 2);
                                String hex = Integer.toHexString(decimal);
                                hexResults.add(hex.toUpperCase());
                            } catch (Exception e) {
                                Dialog dialog = new Dialog("Error",
                                        "Sorry, an internal exception has occured:\n" + e.getClass()+" "+ e.getMessage(),
                                        JOptionPane.ERROR_MESSAGE);
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }{

                        }
                        }
                    try {
                        BintoHex_Results showResults = new BintoHex_Results(hexResults, bytes);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String binary = "";
                binary += checkBox1.isSelected() ? "1" : "0";
                binary += a0CheckBox.isSelected() ? "1" : "0";
                binary += a0CheckBox1.isSelected() ? "1" : "0";
                binary += a0CheckBox2.isSelected() ? "1" : "0";
                binary += a0CheckBox3.isSelected() ? "1" : "0";
                binary += a0CheckBox4.isSelected() ? "1" : "0";
                binary += a0CheckBox5.isSelected() ? "1" : "0";
                binary += a0CheckBox6.isSelected() ? "1" : "0";
                //System.out.println(binary);
                bytes.add(binary);
                list1.setListData(bytes.toArray());
                for(Object s : bytes.toArray()){
                    //System.out.println(s);
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index = list1.getSelectedIndex();
                bytes.remove(index);
                list1.setListData(bytes.toArray());
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bytes.clear();
                list1.setListData(bytes.toArray());
            }
        });
        addButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField1.getText();
                if (!text.isEmpty()) {
                    if (text.contains(" ")) {
                        for (String t : text.split(" ")) {
                            bytes.add(t);
                        }
                    } else {
                        bytes.add(text);
                    }
                    list1.setListData(bytes.toArray());
                    textField1.setText("");
                }
                else{
                    Dialog d = new Dialog("Message", "String cannot be empty.",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}

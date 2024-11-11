import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;

public class HexToBinary extends JFrame{
    private JButton addButton;
    private JPanel MainForm;
    private JButton convertButton;
    private JList list1;
    private JButton button1;
    private JButton clearButton;
    private JTextField textField1;
    private ArrayList<String> hexBytes = new ArrayList<String>();
    private ArrayList<String> Results = new ArrayList<String>();

    public HexToBinary() {
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
                hexBytes.add(textField1.getText());
                textField1.setText("");
                list1.setListData(hexBytes.toArray());
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index = list1.getSelectedIndex();
                hexBytes.remove(index);
                list1.setListData(hexBytes.toArray());
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                hexBytes.clear();
                list1.setListData(hexBytes.toArray());
            }
        });
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Results.clear();
                ArrayList<String> list = new ArrayList<String>();
                for(String hex : hexBytes){
                    try {
                        int decimal = Integer.parseInt(hex, 16);

                        String binary = Integer.toBinaryString(decimal);
                        //System.out.println(binary);
                        while(binary.length() < 8){
                            binary = "0" + binary;
                        }
                        list.add(hex);
                        Results.add(binary);
                    }catch(Exception ex){
                        if(hex.contains(" ")) {
                            for (String x : hex.split(" ")) {
                                int decimal = Integer.parseInt(x, 16);

                                String binary = Integer.toBinaryString(decimal);
                                //System.out.println(binary);
                                while (binary.length() < 8) {
                                    binary = "0" + binary;
                                }
                                list.add(x);
                                Results.add(binary);
                            }
                        }
                        else Results.add("(none)");
                    }
                }
                try {
                    BintoHex_Results results = new BintoHex_Results(list, Results);
                } catch(Exception ex){
                }
            }
        });
    }
}

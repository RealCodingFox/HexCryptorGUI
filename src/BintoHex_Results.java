import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;


public class BintoHex_Results extends JFrame {
    private JPanel MainForm;
    private JList list1;
    private JList list2;
    private JList list3;
    private JButton saveButton;
    private ArrayList<String> ascii = new ArrayList<String>();

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

    public BintoHex_Results(List<String> hexResults, List<String> bytes) throws Exception{

        setTitle("Results");
        setSize(300,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setContentPane(MainForm);
        setVisible(true);

        list1.setListData(bytes.toArray());
        list2.setListData(hexResults.toArray());
        for(String s : hexResults){
            ascii.add(convertToAscii(s));
            //System.out.println(convertToAscii(s));
        }
        list3.setListData(ascii.toArray());
        saveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame = new JFrame();
                frame.setTitle("Save");
                frame.setAlwaysOnTop(true);
                frame.setSize(300, 200);
                frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                JFileChooser fileChooser = new JFileChooser();
                int userSelection = fileChooser.showSaveDialog(frame);
                frame.setVisible(true);
                frame.setAlwaysOnTop(false);
                frame.setVisible(false);
                frame.dispose();
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    try (FileWriter fileWriter = new FileWriter(fileToSave)) {
                        String file = "# Results generated using HexCryptorGUI - by CodingFox(@RealCodingFoxes)\n# Format: Binary | Hex | ASCII\n";

                        int length = bytes.toArray().length;
                        ////System.out.println(length);
                        for(int it = 0; it < length + 1; it++){
                            try {
                                file += bytes.get(it) + " | " + hexResults.get(it) + " | " + ascii.get(it) + "\n";
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                        fileWriter.write(file);
                        ////System.out.println("File saved: " + fileToSave.getAbsolutePath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}

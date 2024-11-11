import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EncryptResults extends JFrame{
    private JPanel MainForm;
    private JList list1;
    private JList list2;
    private JButton saveButton;
    private JLabel k;

    public EncryptResults(List<String> decrypted, List<String> encrypted, int decrypt){
        if(decrypt == 1){
            k.setText("Encrypted string:");
        }
        setTitle("Results");
        setSize(600,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setContentPane(MainForm);
        setVisible(true);

        list1.setListData(decrypted.toArray());
        list2.setListData(encrypted.toArray());

        saveButton.addActionListener(new ActionListener() {
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
                        String file = "# Results generated using HexCryptorGUI - by CodingFox(@RealCodingFoxes)\n# Format: Decrypted | Encrypted\n";

                        int length = decrypted.toArray().length;
                        //System.out.println(length);
                        for(int it = 0; it < length + 1; it++){
                            try {
                                file += decrypted.get(it) + " | " + encrypted.get(it) + "\n";
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                        fileWriter.write(file);
                        //System.out.println("File saved: " + fileToSave.getAbsolutePath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}

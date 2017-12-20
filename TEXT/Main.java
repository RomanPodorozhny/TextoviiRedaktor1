package TEXT;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main implements ActionListener {

    File file = new File("");
    public Main () {


        JFrame frame = new JFrame("Text edit") ;
        frame.setSize (800,600);
        frame.setVisible(true);

        JButton buttonOpen = new JButton("Open");
        buttonOpen.setLocation(10,10);
        buttonOpen.setSize(100,50);

        JButton buttonSave = new JButton("Save");
        buttonSave.setLocation(120,10);
        buttonSave.setSize(100,50);

        JButton buttonNew = new JButton("New File");
        buttonNew.setLocation(230,10);
        buttonNew.setSize(100,50);

        JTextArea area = new JTextArea();
        area. setLocation(10,70);
        area.setSize(790,530);
        //////////////////////////////////////////
        buttonOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(frame);
                file = chooser.getSelectedFile();

                try (FileReader reader = new FileReader(file)) {

                    char[] buf = new char[(int) file.length()];

                    reader.read(buf);
                    area.setText(new String(buf));


                } catch (Exception e2) {

                }
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(area.getText());
                    writer.flush();

                } catch (Exception e) {

                }
            }
        });
          buttonNew.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {

                  JFileChooser chooser = new JFileChooser();
                  if (chooser.showSaveDialog(null)== JFileChooser.APPROVE_OPTION) {
                      file =chooser.getSelectedFile();
                      try (FileWriter writer = new FileWriter(file)) {

                          writer.write("");
                          writer.flush();

                      } catch (Exception e1) {

                      }


                  }

              }
          });

        //////////////////////////////////////////
        frame.add(buttonOpen);
        frame.add(buttonSave);
        frame.add(buttonNew);
        frame.add(area);
        frame.add(new JLabel());
    }

    public  static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

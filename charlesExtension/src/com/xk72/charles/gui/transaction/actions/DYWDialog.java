package com.xk72.charles.gui.transaction.actions;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class DYWDialog {

    static int curIndex = -1;
    
    //避免影响原功能，所以新弹出一个窗口展示结果更为合适
    public static  void WaringDialog(String title,String content) {
         JFrame JFrame = new JFrame(title);
         JFrame.setPreferredSize(new Dimension(800, 500));
         JTextArea textArea = new JTextArea();
         textArea.setText(content + "\n");
         textArea.setLineWrap(true);
         textArea.setWrapStyleWord(true);
         textArea.setEditable(false);
         textArea.setSelectedTextColor(Color.red);
         textArea.addKeyListener(new DYWFindKeyListener(JFrame, textArea));
 
         JScrollPane jScrollPane  = new JScrollPane(textArea);
         jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
 
         jScrollPane.setAutoscrolls(false);
         JFrame.setContentPane(jScrollPane);
         JFrame.pack();
         JFrame.setVisible(true);
         
     }

     public static void FindRelaceDiglog(Container container, JTextArea textArea) {
        JFrame jFrame = new JFrame("Find Content");
        jFrame.setPreferredSize(new Dimension(500, 100));
        jFrame.setVisible(true);
        jFrame.pack();

        JPanel panel = new JPanel();
        jFrame.setContentPane(panel);

        JLabel lJLabel = new JLabel("Find Content:");
        lJLabel.setPreferredSize(new Dimension(100, 20));
        panel.add(lJLabel);

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 20));
        panel.add(textField);
        textField.getDocument().addDocumentListener(new DYWFindDocumentListener(textArea));
        textField.addKeyListener(new DYWSelectTextKeyListener(textField, textArea));

        // JButton button = new JButton("next");
        // panel.add(button);
        // button.addActionListener((ActionListener) new ActionListener() {

        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         selectText(textField, textArea);
        //     }

            
        // });
        
     }

     public static void selectText(JTextField textField, JTextArea textArea) {
        String word = textField.getText();
        int index = textArea.getText().indexOf(word, curIndex + 1);
        textArea.select(index, index + word.length());
        curIndex = index;
     }


}



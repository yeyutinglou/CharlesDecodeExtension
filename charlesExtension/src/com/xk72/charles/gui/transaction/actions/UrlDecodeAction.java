package com.xk72.charles.gui.transaction.actions;

import com.xk72.charles.CharlesContext;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.net.URLDecoder;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public abstract class UrlDecodeAction  extends AbstractAction {
    private final Component source;

    protected UrlDecodeAction(Component paramComponent) {
        super("URL Decode");
        this.source = paramComponent;
      }

    protected abstract String getBody();

    public void actionPerformed(ActionEvent paramActionEvent) {
        try {
            String urlDecode = URLDecoder.decode(getBody(), "utf-8");
            urlDecode = urlDecode.replace("},{", "}\n\n{");
            DYWDialog.WaringDialog("URL Decode Result",urlDecode);
        } catch (Exception exception) {
            CharlesContext.getInstance().error("Failed to decode url. Probably not valid url input.");
        }
    }

    //避免影响原功能，所以新弹出一个窗口展示结果更为合适
    public  void WaringDialog(String title,String content) {
         JFrame JFrame = new JFrame(title);
         JFrame.setPreferredSize(new Dimension(800, 500));
         JTextArea textArea = new JTextArea();
         textArea.setText(content + "\n");
         textArea.setLineWrap(true);
         textArea.setWrapStyleWord(true);
 
         JScrollPane jScrollPane  = new JScrollPane(textArea);
         jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
 
         jScrollPane.setAutoscrolls(false);
         JFrame.setContentPane(jScrollPane);
         JFrame.pack();
         JFrame.setVisible(true);
     }

}

package com.xk72.charles.gui.transaction.actions;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

class DYWFindKeyListener implements KeyListener {
    private JFrame frame;
    private JTextArea textArea;
    DYWFindKeyListener(JFrame var1, JTextArea var2) {
      this.frame = var1;
      this.textArea = var2;
   }

   public void keyPressed(KeyEvent var1) {
      if (var1.isMetaDown() && var1.getKeyCode() == 70) {
         System.out.println("show find window");
         DYWDialog.FindRelaceDiglog(this.frame.getContentPane(), this.textArea);
      }

   }

   public void keyTyped(KeyEvent var1) {
   }

   public void keyReleased(KeyEvent var1) {
   }
}

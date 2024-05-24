// Source code is decompiled from a .class file using FernFlower decompiler.
package com.xk72.charles.gui.transaction.actions;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class DYWSelectTextKeyListener implements KeyListener {
    private JTextField textField;
    private JTextArea textArea;
    DYWSelectTextKeyListener(JTextField var1, JTextArea var2) {
      this.textField = var1;
      this.textArea = var2;
   }

   public void keyTyped(KeyEvent var1) {
   }

   public void keyPressed(KeyEvent var1) {
      if (var1.getKeyCode() == 10) {
         DYWDialog.selectText(this.textField, this.textArea);
      }

   }

   public void keyReleased(KeyEvent var1) {
   }
}


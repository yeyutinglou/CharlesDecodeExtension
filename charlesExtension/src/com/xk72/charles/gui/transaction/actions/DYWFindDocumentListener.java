// Source code is decompiled from a .class file using FernFlower decompiler.
package com.xk72.charles.gui.transaction.actions;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

class DYWFindDocumentListener implements DocumentListener {
    private JTextArea textArea;
    DYWFindDocumentListener(JTextArea var1) {
      this.textArea = var1;
   }

   public void insertUpdate(DocumentEvent var1) {
      this.changeWord(var1);
   }

   public void removeUpdate(DocumentEvent var1) {
      this.changeWord(var1);
   }

   public void changedUpdate(DocumentEvent var1) {
   }

   public void changeWord(DocumentEvent var1) {
      try {
         Document var2 = var1.getDocument();
         String var3 = var2.getText(0, var2.getLength());
         System.out.println(var3);
         int var4 = this.textArea.getText().indexOf(var3);
         if (var4 != -1) {
            this.textArea.select(var4, var4 + var3.length());
            DYWDialog.curIndex = var4;
         }
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }
}


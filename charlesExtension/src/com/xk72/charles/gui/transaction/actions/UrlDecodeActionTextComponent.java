package com.xk72.charles.gui.transaction.actions;

import javax.swing.text.JTextComponent;

public class UrlDecodeActionTextComponent extends UrlDecodeAction {

     private final JTextComponent component;
 
      public UrlDecodeActionTextComponent(JTextComponent jTextComponent) {
         super(jTextComponent);
          this.component = jTextComponent;
     }
 
     protected String getBody() {
          String var1 = this.component.getSelectedText();
          if (var1 == null) {
             var1 = this.component.getText();
          }
          return var1;
     }
    
}

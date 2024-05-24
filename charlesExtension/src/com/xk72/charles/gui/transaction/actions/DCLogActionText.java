package com.xk72.charles.gui.transaction.actions;

import java.awt.Component;

public class DCLogActionText extends DCLogAction {
  private final String text;
  
  public DCLogActionText(String paramString) {
    super(null);
    this.text = paramString;
  }
  
  public DCLogActionText(String paramString, Component paramComponent) {
    super(paramComponent);
    this.text = paramString;
  }
  
  protected String getBody() {
    return this.text;
  }
}


/* Location:              /Users/happyelements/development/charles.jar!/com/xk72/charles/gui/transaction/actions/Base64DecodeAction$Text.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */

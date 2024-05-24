package com.xk72.charles.gui.transaction.actions;

import java.awt.Component;

public class UrlDecodeActionText extends UrlDecodeAction {
  private final String text;
  
  public UrlDecodeActionText(String paramString) {
    super(null);
    this.text = paramString;
  }
  
  public UrlDecodeActionText(String paramString, Component paramComponent) {
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

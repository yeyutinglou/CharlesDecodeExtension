package com.xk72.charles.gui.transaction.popups;

import com.xk72.charles.gui.session.popups.TransactionPopupMenu;
// import com.xk72.charles.gui.transaction.actions.Base64DecodeAction;
import com.xk72.charles.gui.transaction.actions.Base64DecodeAction$Text;
import com.xk72.charles.gui.transaction.actions.Base64DecodeAction$TextComponent;
// import com.xk72.charles.gui.transaction.actions.CopyToClipboardAction;
import com.xk72.charles.gui.transaction.actions.CopyToClipboardAction$Text;
import com.xk72.charles.gui.transaction.actions.CopyToClipboardAction$TextComponent;
import com.xk72.charles.gui.transaction.actions.DCLogActionText;
import com.xk72.charles.gui.transaction.actions.DCLogActionTextComponent;
import com.xk72.charles.gui.transaction.actions.UrlDecodeActionText;
import com.xk72.charles.gui.transaction.actions.UrlDecodeActionTextComponent;
import com.xk72.charles.model.Transaction;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.text.JTextComponent;

public class TransactionViewerPopupMenu extends TransactionPopupMenu {
  public TransactionViewerPopupMenu(Transaction paramTransaction) {
    super(paramTransaction, null, null, null);
  }
  
  protected void prepare(MouseEvent paramMouseEvent) {
    Component component = (Component)paramMouseEvent.getSource();
    if (component instanceof JTable) {
      JTable jTable = (JTable)component;
      Point point = paramMouseEvent.getPoint();
      int i = jTable.rowAtPoint(point);
      int j = jTable.columnAtPoint(point);
      if (i >= 0 && j >= 0) {
        Object object = jTable.getValueAt(i, j);
        if (object != null) {
          add((Action)new CopyToClipboardAction$Text(object.toString()));
          if (object instanceof String)
          add((Action)new Base64DecodeAction$Text((String)object, component));
          add((Action)new UrlDecodeActionText((String)object, component));
          add((Action)new DCLogActionText((String)object, component));
          addSeparator();
        } 
      } 
    } else if (component instanceof JTextComponent) {
      add((Action)new CopyToClipboardAction$TextComponent((JTextComponent)component));
      add((Action)new Base64DecodeAction$TextComponent((JTextComponent)component));
      add((Action)new UrlDecodeActionTextComponent((JTextComponent)component));
      add((Action)new DCLogActionTextComponent((JTextComponent)component));
      addSeparator();
    } 
    prepare(false);
  }
}


/* Location:              /Users/happyelements/development/charles.jar!/com/xk72/charles/gui/transaction/popups/TransactionViewerPopupMenu.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */
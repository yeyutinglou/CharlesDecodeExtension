package com.xk72.charles.gui.transaction.actions;

import com.xk72.charles.CharlesContext;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.InflaterInputStream;

import javax.swing.AbstractAction;

public abstract class DCLogAction  extends AbstractAction {
    private final Component source;

    protected DCLogAction(Component paramComponent) {
        super("DCLog");
        this.source = paramComponent;
      }

    protected abstract String getBody();

    public void actionPerformed(ActionEvent paramActionEvent) {
        try {
            String urlDecode = URLDecoder.decode(getBody(), "utf-8");
            urlDecode = urlDecode.replace("},{", "}\n\n{");
            byte[] bytes = Base64.getDecoder().decode(urlDecode);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
            InflaterInputStream gzipInputStream = new InflaterInputStream(inputStream);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = gzipInputStream.read(buffer, 0, buffer.length)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            String result = outputStream.toString(StandardCharsets.UTF_8);
            DYWDialog.WaringDialog("DCLog Result",result);
        } catch (Exception exception) {
            CharlesContext.getInstance().error("Failed to DCLog url. Probably not valid url input.");
        }
    }


}

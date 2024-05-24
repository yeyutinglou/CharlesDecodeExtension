
package com.xk72.charles.gui.transaction;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.format.DecimalStyle;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.InflaterOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import com.xk72.charles.gui.transaction.actions.DYWDialog;


// import com.xk72.charles.gui.transaction.popups.TransactionViewerPopupMenu;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        //  TransactionViewerPopupMenu menu = new TransactionViewerPopupMenu(null) ;
        String webDecode = "eJztmFFv2zYQx7+K4acWiByRoiipwx5kWeqAzl2BduiAZRBoiZEJy6IqUnaTYt99RylxM6fa7KVO26EvCUVRd7y7H//HJF0wnS3TDStb/uPvH8YFW/MNb5SQ1fjZmEyQM7HHZ+OsFLzSH18gb+LCtFBp1iot16nILxnMm7Vpq3gDE/BoIXguq6Ib+p0hpnkhmyuYUVwZa6nSrNHwSvFMVrlKLxuw93z+Bpb4MC2V8QcDlmmx4b3hqYfRLMZTy/bC0CLJzLWmIZ1Z0yiaxW5gYxpGncl3/XrzfduNwin2QoKJhb0ksAihieXTKbJiQkPXcwj1UGKCYFmqr2puvrU9mNBizWGn67qLHlGHBj72McbGTb76RM4gJZvDHRr76bWsjMdQCXZx/nrJqmLJhEkh0x9TuF3fZq4LyPVpYic4oTZyyMyNg5jGEXXiZJZQEgTUJH0rcr2EtY5nqlZxvZXN6ia8ripLLoql8eEj3FWpaQRv4Jm6ruN2P7rKVuJduuJd9UQhpEqx4zp9rKb8BKGpF1NskSixLWKHMyv0SGCFU+S5xMdhEEXjP88+DGTT9f1j63QpK50qcQ2RIG+QoTvUiUrowyMWKl63kH0Jb+x7iSwlGO4Q3go4RSaWM3uQh0Ujt6pzMZfXoiyhxO7EHj0Rr5ZQ9h9G0atfR/149MvrEfJSd1SKFR/NWWYmfns6Cuu65G/54oXQF+fUdidogtzRkxc/vZn/fNYvfs6zlXw6msuFKPnFOXJjRPz+pLZVDZuSFSshXflN5XcnBN8DA9n/kbZOK26M9AEh58ycwHpVVKAvMJ3J9QQIWsvFBCiabAUULV/lfC3/TUCOIe3YM8hyKJsWSlRFqhuWrcyAV2xR7vI1IISgopo3V6lioFC7L4AYlTWcVzmvlNAGP+IHsHxAZXdS949i0G+hFu95aZYj7L7HxKH7MpHJttKwpUzmxkz0EuZyvhEZ3wmb8XQbJmv1Ujbi+gZozXRrduPsaeGdWEsIAXaABtvAkFjskgVOwKgDRz7vGYzQjExJbKEQJ1Am27f8mR9bAZ3ZXhRg24u9nuW1qMyRBEdGTY5rWqpdpHcEAQRDwbJDu1n3ePtNv2SowRV53RzQ13ZH0HlAkyL2LTf7sur42PnM7WhALE/ZpXox2ldtk+G04UVf32Hp/XyN64Go1TV76LWpbsSGZVeHXJgKDslRuhGZvi/45FS0df3mm74SfRq2k1+KHsZW1qHV/eor/UiU7YByTwWU630H6vGB+ttlcfgC+diU0VNRRsn/tEl+1S2R5W2p9+90j0+VdzKqgu9UfQGqCv4FIDr6nxeHQuQ53yBEpgbwJ539NfD0x19yoett";
        String urlDecode = "eJztmFFv2zYQx7%2BK4acWiByRoiipwx5kWeqAzl2BduiAZRBoiZEJy6IqUnaTYt99RylxM6fa7KVO26EvCUVRd7y7H%2F%2FHJF0wnS3TDStb%2FuPvH8YFW%2FMNb5SQ1fjZmEyQM7HHZ%2BOsFLzSH18gb%2BLCtFBp1iot16nILxnMm7Vpq3gDE%2FBoIXguq6Ib%2Bp0hpnkhmyuYUVwZa6nSrNHwSvFMVrlKLxuw93z%2BBpb4MC2V8QcDlmmx4b3hqYfRLMZTy%2FbC0CLJzLWmIZ1Z0yiaxW5gYxpGncl3%2FXrzfduNwin2QoKJhb0ksAihieXTKbJiQkPXcwj1UGKCYFmqr2puvrU9mNBizWGn67qLHlGHBj72McbGTb76RM4gJZvDHRr76bWsjMdQCXZx%2FnrJqmLJhEkh0x9TuF3fZq4LyPVpYic4oTZyyMyNg5jGEXXiZJZQEgTUJH0rcr2EtY5nqlZxvZXN6ia8ripLLoql8eEj3FWpaQRv4Jm6ruN2P7rKVuJduuJd9UQhpEqx4zp9rKb8BKGpF1NskSixLWKHMyv0SGCFU%2BS5xMdhEEXjP88%2BDGTT9f1j63QpK50qcQ2RIG%2BQoTvUiUrowyMWKl63kH0Jb%2Bx7iSwlGO4Q3go4RSaWM3uQh0Ujt6pzMZfXoiyhxO7EHj0Rr5ZQ9h9G0atfR%2F149MvrEfJSd1SKFR%2FNWWYmfns6Cuu65G%2F54oXQF%2BfUdidogtzRkxc%2FvZn%2FfNYvfs6zlXw6msuFKPnFOXJjRPz%2BpLZVDZuSFSshXflN5XcnBN8DA9n%2FkbZOK26M9AEh58ycwHpVVKAvMJ3J9QQIWsvFBCiabAUULV%2FlfC3%2FTUCOIe3YM8hyKJsWSlRFqhuWrcyAV2xR7vI1IISgopo3V6lioFC7L4AYlTWcVzmvlNAGP%2BIHsHxAZXdS949i0G%2BhFu95aZYj7L7HxKH7MpHJttKwpUzmxkz0EuZyvhEZ3wmb8XQbJmv1Ujbi%2BgZozXRrduPsaeGdWEsIAXaABtvAkFjskgVOwKgDRz7vGYzQjExJbKEQJ1Am27f8mR9bAZ3ZXhRg24u9nuW1qMyRBEdGTY5rWqpdpHcEAQRDwbJDu1n3ePtNv2SowRV53RzQ13ZH0HlAkyL2LTf7sur42PnM7WhALE%2FZpXox2ldtk%2BG04UVf32Hp%2FXyN64Go1TV76LWpbsSGZVeHXJgKDslRuhGZvi%2F45FS0df3mm74SfRq2k1%2BKHsZW1qHV%2Feor%2FUiU7YByTwWU630H6vGB%2BttlcfgC%2BdiU0VNRRsn%2FtEl%2B1S2R5W2p9%2B90j0%2BVdzKqgu9UfQGqCv4FIDr6nxeHQuQ53yBEpgbwJ539NfD0x19yoett";
        // String urlDecode = URLDecoder.decode("eJztUk2P0zAU/C8518XfdpD24CQOJ05wA2SZxJtYbZLd2G21IP47dip2JcSBSuyNS+SM35vnNzPmq43daM72eHJ3n74Xg53c2a3BL3PxtqB7RPaw2BXd0bs5vlwgsWcJ7k+rjRvCKNkVPpjuFOIyGd/f21SWW80puDUBuQuhBBznIZ0BkhuxjW5Y1qeEBBcyu3Fzny6C65a5D+Z+TXTv3n9MBTLBS8g86WC76M/uyqtqokijNdCI14AqRUHFmgbUWENWMVHTut0oH6/1nKa/07W1wkJRTAEWbQko5S2QvEJAU66YIJQLlFuN7Ux8enB5OBQJiH5yIdrpYRMDccIhK2WJsyqhP/xBwiTJ+e8HZn7zbZnzRBW8/fzmw2jnYbQ+K2jji4KX6Zdw20ICVy2DbS1KBWkjKgUrwlgrEceEa52l6y6+j2OqJSI/d3bxsqyH5/U2W0bnhzFPkQhvNq2rd2vWjjHCts/m7ewfzcFt9vnBL8Fgwsh12xwAilAlNMcgOQABhaoBStASqAoJRiVWZV0XP3a35u7fBC35t8Ybo0ZQyQXHHMBGUkC1JMm+tgW6YZxXDUTst6ix14gah5BJ8j9qt0fty08ORl0v", "utf-8");
        urlDecode = URLDecoder.decode(urlDecode, "utf-8");
       System.out.println(webDecode.equals(urlDecode));
        // System.out.println(urlDecode);
        byte[] bytes = Base64.getDecoder().decode(urlDecode);
        System.out.println(bytes);
        urlDecode = Base64.getEncoder().encodeToString(bytes);
        System.out.println(webDecode.equals(urlDecode));
        // urlDecode = new String(bytes, StandardCharsets.UTF_8);
        // System.out.println(urlDecode);
        urlDecode = decompress(bytes);
        System.out.println(urlDecode);
        DYWDialog.WaringDialog("test", urlDecode);

        // String jsonStr = "_batch_value=[{\"gameversion\":\"4.13.0\",\"clientversion\":\"17.5\",\"is_custom_idfa\":\"0\",\"_user_id\":\"-1\",\"lng\":\"-180\",\"category\":\"session_start\",\"seconds_from_GMT\":\"8\",\"os\":\"1\",\"active_id\":\"B721DE2B-07AA-4FD5-BA6D-BCCDE59026AC\",\"seq_id\":\"1\",\"uid\":\"AB27A424-27F9-446F-86B1-E46A5734671F\",\"_ac_type\":\"107\",\"timestamp\":\"1716369828222\",\"sdkversion\":\"4.13.0\",\"idfv\":\"AB27A424-27F9-446F-86B1-E46A5734671F\",\"time_zone\":\"Asia\\/Shanghai\",\"lat\":\"-180\",\"wmsession_id\":\"586F0F2F60134D5E9E6EC63EFDF64996\",\"cwidth\":\"375\",\"networktype\":\"0\",\"cheight\":\"812\",\"carrier\":\"6553565535\",\"_uniq_key\":\"sigios_2353\",\"idfa\":\"411B7E62-4CF0-40AD-A749-AB175482A9CC\"},{\"timestamp\":\"1716369828588\",\"uid\":\"AB27A424-27F9-446F-86B1-E46A5734671F\",\"font_size\":17,\"seconds_from_GMT\":\"8\",\"category\":\"init\",\"cheight\":\"812\",\"carrier\":\"6553565535\",\"isEmulator\":0,\"cwidth\":\"375\",\"location_switch\":\"1,0\",\"sdkversion\":\"4.13.0\",\"browser\":\"Mozilla\\/5.0 (iPhone; CPU iPhone OS 17_5 like Mac OS X) AppleWebKit\\/605.1.15 (KHTML, like Gecko) Mobile\\/15E148\",\"is_unpersonalized\":\"0\",\"seq_id\":\"2\",\"networktype\":\"100\",\"wmsession_id\":\"586F0F2F60134D5E9E6EC63EFDF64996\",\"clienttype\":\"iPhone13,1\",\"pkgname\":\"com.sigmob.ios.windsdkdemo\",\"_user_id\":\"-1\",\"lng\":\"-180\",\"idfa\":\"411B7E62-4CF0-40AD-A749-AB175482A9CC\",\"idfv\":\"AB27A424-27F9-446F-86B1-E46A5734671F\",\"advertising_tracking_enabled\":\"0\",\"clientversion\":\"17.5\",\"battery_save_enabled\":0,\"screendensity\":\"489\",\"gameversion\":\"4.13.0\",\"os\":\"1\",\"time_zone\":\"Asia\\/Shanghai\",\"clientpixel\":\"1125x2436\",\"lat\":\"-180\",\"country_code\":\"CN\",\"device_type\":\"1\",\"tracking_authorization_status\":\"3\",\"_ac_type\":\"1\",\"battery_level\":1,\"is_custom_idfa\":\"0\",\"_uniq_key\":\"sigios_2353\",\"battery_state\":3,\"udid\":\"2C1D4B4E-1A2F-4408-8D8E-96D07C9207E7\",\"is_minor\":\"0\"},{\"gameversion\":\"4.13.0\",\"clientversion\":\"17.5\",\"sub_category\":\"consent\",\"is_custom_idfa\":\"0\",\"_user_id\":\"-1\",\"user_consent\":\"0\",\"lng\":\"-180\",\"category\":\"gdpr\",\"seconds_from_GMT\":\"8\",\"os\":\"1\",\"seq_id\":\"3\",\"uid\":\"AB27A424-27F9-446F-86B1-E46A5734671F\",\"_ac_type\":\"401\",\"timestamp\":\"1716369838230\",\"idfv\":\"AB27A424-27F9-446F-86B1-E46A5734671F\",\"time_zone\":\"Asia\\/Shanghai\",\"carrier\":\"6553565535\",\"lat\":\"-180\",\"wmsession_id\":\"586F0F2F60134D5E9E6EC63EFDF64996\",\"cwidth\":\"375\",\"networktype\":\"100\",\"cheight\":\"812\",\"gdpr_region\":\"0\",\"sdkversion\":\"4.13.0\",\"_uniq_key\":\"sigios_2353\",\"idfa\":\"411B7E62-4CF0-40AD-A749-AB175482A9CC\"},{\"gameversion\":\"4.13.0\",\"clientversion\":\"17.5\",\"sub_category\":\"coppa\",\"is_custom_idfa\":\"0\",\"_user_id\":\"-1\",\"lng\":\"-180\",\"category\":\"privacy\",\"seconds_from_GMT\":\"8\",\"os\":\"1\",\"age_restricted\":\"0\",\"seq_id\":\"4\",\"uid\":\"AB27A424-27F9-446F-86B1-E46A5734671F\",\"_ac_type\":\"401\",\"timestamp\":\"1716369838248\",\"sdkversion\":\"4.13.0\",\"idfv\":\"AB27A424-27F9-446F-86B1-E46A5734671F\",\"time_zone\":\"Asia\\/Shanghai\",\"lat\":\"-180\",\"wmsession_id\":\"586F0F2F60134D5E9E6EC63EFDF64996\",\"cwidth\":\"375\",\"networktype\":\"100\",\"cheight\":\"812\",\"carrier\":\"6553565535\",\"_uniq_key\":\"sigios_2353\",\"idfa\":\"411B7E62-4CF0-40AD-A749-AB175482A9CC\"},{\"gameversion\":\"4.13.0\",\"clientversion\":\"17.5\",\"sub_category\":\"ccpa\",\"ccpa\":\"0\",\"is_custom_idfa\":\"0\",\"_user_id\":\"-1\",\"lng\":\"-180\",\"category\":\"privacy\",\"seconds_from_GMT\":\"8\",\"os\":\"1\",\"seq_id\":\"5\",\"uid\":\"AB27A424-27F9-446F-86B1-E46A5734671F\",\"_ac_type\":\"401\",\"timestamp\":\"1716369838257\",\"sdkversion\":\"4.13.0\",\"idfv\":\"AB27A424-27F9-446F-86B1-E46A5734671F\",\"time_zone\":\"Asia\\/Shanghai\",\"lat\":\"-180\",\"wmsession_id\":\"586F0F2F60134D5E9E6EC63EFDF64996\",\"cwidth\":\"375\",\"networktype\":\"100\",\"cheight\":\"812\",\"carrier\":\"6553565535\",\"_uniq_key\":\"sigios_2353\",\"idfa\":\"411B7E62-4CF0-40AD-A749-AB175482A9CC\"},{\"gameversion\":\"4.13.0\",\"clientversion\":\"17.5\",\"sub_category\":\"personalized\",\"is_unpersonalized\":\"0\",\"is_custom_idfa\":\"0\",\"_user_id\":\"-1\",\"lng\":\"-180\",\"category\":\"privacy\",\"seconds_from_GMT\":\"8\",\"os\":\"1\",\"seq_id\":\"6\",\"uid\":\"AB27A424-27F9-446F-86B1-E46A5734671F\",\"_ac_type\":\"401\",\"timestamp\":\"1716369838264\",\"idfv\":\"AB27A424-27F9-446F-86B1-E46A5734671F\",\"time_zone\":\"Asia\\/Shanghai\",\"carrier\":\"6553565535\",\"lat\":\"-180\",\"wmsession_id\":\"586F0F2F60134D5E9E6EC63EFDF64996\",\"cwidth\":\"375\",\"networktype\":\"100\",\"cheight\":\"812\",\"sdkversion\":\"4.13.0\",\"_uniq_key\":\"sigios_2353\",\"idfa\":\"411B7E62-4CF0-40AD-A749-AB175482A9CC\"},{\"gameversion\":\"4.13.0\",\"clientversion\":\"17.5\",\"sub_category\":\"adult\",\"is_minor\":\"0\",\"is_custom_idfa\":\"0\",\"_user_id\":\"-1\",\"lng\":\"-180\",\"category\":\"privacy\",\"seconds_from_GMT\":\"8\",\"os\":\"1\",\"seq_id\":\"7\",\"uid\":\"AB27A424-27F9-446F-86B1-E46A5734671F\",\"_ac_type\":\"401\",\"timestamp\":\"1716369838269\",\"idfv\":\"AB27A424-27F9-446F-86B1-E46A5734671F\",\"time_zone\":\"Asia\\/Shanghai\",\"carrier\":\"6553565535\",\"lat\":\"-180\",\"wmsession_id\":\"586F0F2F60134D5E9E6EC63EFDF64996\",\"cwidth\":\"375\",\"networktype\":\"100\",\"cheight\":\"812\",\"sdkversion\":\"4.13.0\",\"_uniq_key\":\"sigios_2353\",\"idfa\":\"411B7E62-4CF0-40AD-A749-AB175482A9CC\"},{\"gameversion\":\"4.13.0\",\"clientversion\":\"17.5\",\"sub_category\":\"age\",\"is_custom_idfa\":\"0\",\"_user_id\":\"-1\",\"lng\":\"-180\",\"category\":\"privacy\",\"seconds_from_GMT\":\"8\",\"os\":\"1\",\"seq_id\":\"8\",\"uid\":\"AB27A424-27F9-446F-86B1-E46A5734671F\",\"_ac_type\":\"401\",\"timestamp\":\"1716369838273\",\"idfv\":\"AB27A424-27F9-446F-86B1-E46A5734671F\",\"time_zone\":\"Asia\\/Shanghai\",\"carrier\":\"6553565535\",\"lat\":\"-180\",\"wmsession_id\":\"586F0F2F60134D5E9E6EC63EFDF64996\",\"cwidth\":\"375\",\"age\":\"20\",\"networktype\":\"100\",\"cheight\":\"812\",\"sdkversion\":\"4.13.0\",\"_uniq_key\":\"sigios_2353\",\"idfa\":\"411B7E62-4CF0-40AD-A749-AB175482A9CC\"}]";
        // byte[] jsonbytes = zip(jsonStr);
        // String str = Base64.getEncoder().encodeToString(jsonbytes);
        // System.out.println(str);
        // String result = new String(jsonbytes);
        // System.out.println(result);
        
    }

    //避免影响原功能，所以新弹出一个窗口展示结果更为合适
    public static  void WaringDialog(String title,String content) {
         JFrame JFrame = new JFrame(title);
         JFrame.setPreferredSize(new Dimension(800, 500));
         JTextArea textArea = new JTextArea();
         textArea.setText(content + "\n");
         textArea.setLineWrap(true);
         textArea.setWrapStyleWord(true);
         textArea.setEditable(false);

         
         KeyListener keyListener = new KeyListener() {


            @Override
            public void keyPressed(KeyEvent e) {
                if (e.isMetaDown() && e.getKeyCode() == KeyEvent.VK_F) {
                    System.out.println("show find window");
                    FindRelaceDiglog(JFrame.getContentPane(), textArea);
                }
                // throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
            }

            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
            
         };
         textArea.addKeyListener(keyListener);
 
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
        textField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                changeWord(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changeWord(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }

            public void changeWord(DocumentEvent e) {
                try {
                    Document document = e.getDocument();
                String word = document.getText(0, document.getLength());
                System.out.println(word);
                int index = textArea.getText().indexOf(word);
                System.out.println(index);
                // textArea.select(index, index + word.length());
                // textArea.setSelectedTextColor(Color.red);
                textArea.setSelectionStart(index);
                textArea.setSelectionEnd(index + word.length());
                textArea.setSelectionColor(Color.red);
                selectText(textField, textArea);
                } catch (Exception error) {
                    error.printStackTrace();
                }
            }


            
        });

        JButton button = new JButton("next");
        panel.add(button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
            
        });
        
     }

     public static void selectText(JTextField textField, JTextArea textArea) {
        String word = textField.getText();
        int index = textArea.getText().indexOf(word);
        int nextIndex = textArea.getText().indexOf(word, index + 1);
        textArea.select(index, index + word.length());
        textArea.setSelectedTextColor(Color.orange);
     }

    public static String uncompress(byte[] input, boolean nowrap) throws IOException {
    Inflater inflater = new Inflater(nowrap);
    inflater.setInput(input);
    ByteArrayOutputStream baos = new ByteArrayOutputStream(input.length);
    try {
        byte[] buff = new byte[1024];
        while (!inflater.finished()) {
            int count = inflater.inflate(buff);
            baos.write(buff, 0, count);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        baos.close();
    }
    inflater.end();
    byte[] output = baos.toByteArray();
    return new String(output);
}

public static byte[] compress(byte[] data, boolean nowrap) throws IOException {
    byte[] output;
    Deflater compress = new Deflater(Deflater.DEFAULT_COMPRESSION, nowrap);

    compress.reset();
    compress.setInput(data);
    compress.finish();
    ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length);
    try {
        byte[] buf = new byte[1024];
        while (!compress.finished()) {
            int i = compress.deflate(buf);
            bos.write(buf, 0, i);
        }
        output = bos.toByteArray();
    } catch (Exception e) {
        output = data;
        e.printStackTrace();
    } finally {
        bos.close();
    }
    compress.end();
    return output;
}


    public static String decodeGzipString(String value) {
        // byte[] gzipBytes = gizpString.getBytes();
        // GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(gzipBytes));
        // ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // byte[] buffer = new byte[1024];
        // int len;
        // while ((len = gzipInputStream.read(buffer)) != -1) {
        //     byteArrayOutputStream.write(buffer, 0, len);
        // }

        // gzipInputStream.close();

        // byte[] uncompressedBytes = byteArrayOutputStream.toByteArray();
        // String result = new String(uncompressedBytes);
        // return result;
        if (value == null || value.length() == 0) {
            throw new IllegalArgumentException("Cannot decompress null value");
        }
        try {
         GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(value)));
	    BufferedReader bf = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
	    String outStr = "";
	    String line;
	    while ((line=bf.readLine())!=null) {
	      outStr += line;
	    }
	    System.out.println("Output String lenght : " + outStr.length());
	    return outStr;
        } catch (IOException e) {
            return null;
        }
    }

    public static String unGzip(String string) {
        String result = null;
        if (string == null) {
            return result;
        }
        ByteArrayOutputStream out = null;
        ByteArrayInputStream in = null;
        GZIPInputStream ungzip = null;
        byte[] bytes = string.getBytes(StandardCharsets.ISO_8859_1);
        try {
            out = new ByteArrayOutputStream();
            in = new ByteArrayInputStream(bytes);
            ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = ungzip.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            result = out.toString(StandardCharsets.UTF_8.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ungzip != null) {
                    ungzip.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public static byte[] compress(String json) throws IOException {
        byte[] input = json.getBytes(StandardCharsets.UTF_8);
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//             GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream) {{
//                 设置压缩比
//                 def.setLevel(Deflater.BEST_COMPRESSION);
//             }}
             GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)
        ) {

            gzipOutputStream.write(input);
            gzipOutputStream.finish();
            return outputStream.toByteArray();
        }
    }

    public static String decompress(byte[] compressed) throws IOException {
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(compressed);
             InflaterInputStream gzipInputStream = new InflaterInputStream(inputStream);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = gzipInputStream.read(buffer, 0, buffer.length)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            return outputStream.toString(StandardCharsets.UTF_8);
        }
    }

   

    public static byte[] uncompress(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    public static byte[] zip(final String str) {
        if ((str == null) || (str.length() == 0)) {
            throw new IllegalArgumentException("Cannot zip null or empty string");
        }

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
                gzipOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
            }
            return byteArrayOutputStream.toByteArray();
        } catch(IOException e) {
            throw new RuntimeException("Failed to zip content", e);
        }
    }

    public static String unzip(final byte[] compressed) {
        if ((compressed == null) || (compressed.length == 0)) {
            throw new IllegalArgumentException("Cannot unzip null or empty bytes");
        }
        if (!isZipped(compressed)) {
            return new String(compressed);
        }

        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressed)) {
            try (GZIPInputStream gzipInputStream = new GZIPInputStream(byteArrayInputStream)) {
                try (InputStreamReader inputStreamReader = new InputStreamReader(gzipInputStream, StandardCharsets.UTF_8)) {
                    try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                        StringBuilder output = new StringBuilder();
                        String line;
                        while((line = bufferedReader.readLine()) != null){
                            output.append(line);
                        }
                        return output.toString();
                    }
                }
            }
        } catch(IOException e) {
            throw new RuntimeException("Failed to unzip content", e);
        }
    }

    public static boolean isZipped(final byte[] compressed) {
        return (compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC))
                && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8));
    }
    
}

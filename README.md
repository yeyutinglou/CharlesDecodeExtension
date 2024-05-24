# CharlesDecodeExtension
charles添加urldecode和gzip解压扩展插件
## 开发步骤

- 通过gui工具查看charles.jar包Base 64 Decode所在package 
- 新建Java项目 引入原charles.jar
- 新建com.xk72.charles.gui.transaction.actions packe 添加UrlDecode和DCLog解码方式
- 新建com.xk72.charles.gui.transaction.popups packe 修改TransactionViewerPopupMenu 引入新增解码方式
- 编译class文件
- 执行chales.sh脚本进行class文件注入jar包

注入命令如下：
```
jar -uvf charles.jar com/xk72/charles/gui/transaction/actions/*.class
```

gui工具如果因Java版本无法启动，可执行如下命令打开
```
java -jar /Applications/JD-GUI.app/Contents/Resources/Java/jd-gui-1.6.6-min.jar
```
package com.example.webflux;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.stream.IntStream;

public class OpenTwitter {
    public OpenTwitter() {
    }

    public static void keyCtrl(Robot var0, int var1) {
        var0.keyPress(17);
        var0.keyPress(var1);
        var0.keyRelease(17);
        var0.keyRelease(var1);
        var0.delay(100);
    }

    public static void main(String[] var0) throws IOException, InterruptedException {
        BufferedReader[] var1 = new BufferedReader[]{null};
        IntStream.of(2).forEach((var1x) -> {
            Runtime var2 = Runtime.getRuntime();
            Process var3 = null;

            try {
                var3 = var2.exec("powershell  cd C:/Users/w;./Lantern.lnk");
            } catch (IOException var5) {
                var5.printStackTrace();
            }

            var1[0] = new BufferedReader(new InputStreamReader(var3.getInputStream()));
        });
        String var2 = null;

        while((var2 = var1[0].readLine()) != null) {
            System.out.println(new String(var2.getBytes(), "UTF-8"));
        }

        var1[0].close();
        Thread.sleep(5000L);

        try {
            Desktop var3 = Desktop.getDesktop();
            var3.browse(new URI("https://twitter.com/home/"));
            Robot var4 = new Robot();
            var4.delay(2000);
            var4.mouseMove(489, 290);
            var4.delay(1000);
            var4.mousePress(1024);
            var4.mouseRelease(1024);
            Clipboard var5 = Toolkit.getDefaultToolkit().getSystemClipboard();
            keyCtrl(var4, 86);
            var4.keyPress(10);
            var4.keyRelease(10);
            var4.keyPress(10);
            var4.keyRelease(10);
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }
}

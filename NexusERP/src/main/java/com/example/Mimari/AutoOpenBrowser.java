package com.example.Mimari;

import org.springframework.stereotype.Component;
import java.awt.Desktop;
import java.net.URI;

@Component
public class AutoOpenBrowser {

    public AutoOpenBrowser() {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                URI uri = new URI("http://localhost:8081");  // Burada portu doğru ayarladığınızdan emin olun
                desktop.browse(uri);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

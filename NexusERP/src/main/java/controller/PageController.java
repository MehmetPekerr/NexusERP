package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String showHomePage() {
        return "index";  // index.html dosyasına yönlendirme
    }

    @GetMapping("/depo")
    public String showDepoPage() {
        return "depo";  // depo.html dosyasına yönlendirme
    }

    @GetMapping("/firma")
    public String showFirmaPage() {
        return "firma";  // firma.html dosyasına yönlendirme
    }

    @GetMapping("/firmabilgi")
    public String showFirmaBilgiPage() {
        return "firmabilgi";  // firmabilgi.html dosyasına yönlendirme
    }

    @GetMapping("/insankaynaklari")
    public String showInsanKaynaklariPage() {
        return "insankaynaklari";  // insankaynaklari.html dosyasına yönlendirme
    }

    @GetMapping("/isplani")
    public String showIsPlaniPage() {
        return "isplani";  // isplani.html dosyasına yönlendirme
    }

    @GetMapping("/nakliyat")
    public String showNakliyatPage() {
        return "nakliyat";  // nakliyat.html dosyasına yönlendirme
    }

    @GetMapping("/satiskanallari")
    public String showSatisKanallariPage() {
        return "satiskanallari";  // satiskanallari.html dosyasına yönlendirme
    }

    @GetMapping("/siparis")
    public String showSiparisPage() {
        return "siparis";  // siparis.html dosyasına yönlendirme
    }

    @GetMapping("/sonuc")
    public String showSonucPage() {
        return "sonuc";  // sonuc.html dosyasına yönlendirme
    }

    @GetMapping("/urun")
    public String showUrunPage() {
        return "urun";  // urun.html dosyasına yönlendirme
    }
}

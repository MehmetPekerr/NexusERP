# NexusERP

**NexusERP**, Java Spring Boot ile geliştirilmiş kapsamlı bir Kurumsal Kaynak Planlama (ERP) sistemidir. İnsan kaynakları, satış, lojistik, ürün yönetimi ve finansal operasyonları tek bir platform üzerinden yönetmek için tasarlanmıştır.

---

## 🚀 Özellikler

| Modül | Açıklama |
|---|---|
| 👥 **İnsan Kaynakları** | Personel bilgileri, eğitim programları, pozisyon yönetimi |
| 🛒 **Satış Yönetimi** | Siparişler, satış işlemleri, satış kanalları ve stratejileri |
| 📦 **Ürün Yönetimi** | Envanter, paketleme, kalite testleri, maliyet analizi, geri bildirim |
| 🏭 **Depo & Lojistik** | Depo yönetimi, nakliyat, ithalat/ihracat operasyonları |
| 💰 **Finans** | Faturalama, yatırım yönetimi, tedarikçi ilişkileri |
| 📊 **İş Zekası** | Pazar araştırması, risk değerlendirme, performans analizi |
| 💡 **İnovasyon** | İnovasyon proje yönetimi |
| 🔧 **Teknik Destek** | Yardım masası ve teknik destek takibi |
| 🔒 **Güvenlik** | Bilgi güvenliği politikaları ve erişim kontrolü |
| ⚙️ **Ekipman Bakım** | Bakım ve onarım takibi |

---

## 🛠️ Teknoloji Yığını

- **Java 21**
- **Spring Boot 3.4.1**
- **Spring Security** (JWT tabanlı kimlik doğrulama)
- **Spring Data JPA / Hibernate**
- **PostgreSQL**
- **Thymeleaf** (sunucu taraflı şablonlama)
- **ModelMapper**
- **Spring Boot Actuator**
- **Maven**

---

## 📐 Mimari

Proje, katmanlı mimari prensiplerine uygun olarak geliştirilmiştir:

```
src/main/java/
├── controller/        # REST Controller katmanı (35 controller)
├── service/           # İş mantığı servisleri
├── model/             # JPA Entity sınıfları (33 entity)
├── repository/        # Spring Data JPA repository'leri
├── dto/               # Data Transfer Object'leri (33 DTO)
├── config/            # Uygulama konfigürasyonları
├── security/          # JWT kimlik doğrulama & yetkilendirme
├── exception/         # Özel exception sınıfları
├── util/              # Yardımcı sınıflar
└── designpatterns/    # Tasarım deseni implementasyonları
```

Projede kullanılan tasarım desenleri: **Observer**, **Adapter**, **Factory**

---

## ⚡ Kurulum

### Gereksinimler

- Java 21+
- Maven 3.8+
- PostgreSQL 14+

### Adımlar

1. **Repoyu klonlayın:**
   ```bash
   git clone https://github.com/MehmetPekerr/NexusERP.git
   cd NexusERP
   ```

2. **Veritabanını oluşturun:**
   ```sql
   CREATE DATABASE nexuserp;
   ```

3. **Yapılandırma dosyasını hazırlayın:**
   ```bash
   cp src/main/resources/application.properties.example src/main/resources/application.properties
   ```
   Ardından `application.properties` dosyasını kendi veritabanı bilgilerinizle güncelleyin.

4. **Uygulamayı başlatın:**
   ```bash
   mvn spring-boot:run
   ```

5. Uygulama varsayılan olarak **`http://localhost:8083`** adresinde çalışır.

---

## 🔌 API

Tüm endpoint'ler RESTful standartlarına uygun olup JWT token ile güvence altına alınmıştır.

**Standart CRUD Endpoint Yapısı:**

```
GET    /api/{kaynak}         → Tüm kayıtları listele
GET    /api/{kaynak}/{id}    → ID ile getir
POST   /api/{kaynak}         → Yeni kayıt oluştur
PUT    /api/{kaynak}/{id}    → Güncelle
DELETE /api/{kaynak}/{id}    → Sil
```

**Başlıca Endpoint Grupları:**

| Endpoint | Açıklama |
|---|---|
| `/api/personel-bilgileri` | Personel yönetimi |
| `/api/satis` | Satış işlemleri |
| `/api/siparis` | Sipariş yönetimi |
| `/api/urunler` | Ürün yönetimi |
| `/api/depo` | Depo yönetimi |
| `/api/nakliyat` | Nakliyat operasyonları |
| `/api/tedarikci` | Tedarikçi yönetimi |
| `/api/fatura-bilgileri` | Fatura yönetimi |
| `/api/insan-kaynaklari` | İK yönetimi |
| `/api/risk-degerlendirme` | Risk analizi |

---

## 🗂️ Proje Yapısı

```
NexusERP/
├── src/
│   ├── main/
│   │   ├── java/              # Uygulama kaynak kodları
│   │   └── resources/
│   │       ├── application.properties.example   # Yapılandırma şablonu
│   │       └── templates/     # Thymeleaf HTML şablonları
│   └── test/                  # Test dosyaları
├── pom.xml
├── mvnw / mvnw.cmd
└── README.md
```

---

## 📄 Lisans

Bu proje MIT Lisansı kapsamında lisanslanmıştır.

1. Proje Yapısı ve Kullanılan Teknolojiler Hakkında Ayrıntılı Bilgilendirme
Ana Paket: com.kitap.ekitap

EkitapApplication.java:
Projenin ana giriş noktasıdır. Spring Boot uygulaması buradan başlatılır.

Controller Katmanı (com.kitap.ekitap.controller):

RootController.java:
Ana root URL ("/") için basit bir endpoint sağlar, uygulamanın çalıştığını doğrulayan mesaj döner.

KitapController.java:
Kitaplarla ilgili CRUD işlemlerini yöneten REST API endpoint’lerini barındırır. Örneğin, kitap listeleme (GET /api/kitaplar), yeni kitap ekleme (POST /api/kitaplar) gibi.

Model Katmanı (com.kitap.ekitap.model):

Kitap.java:
Kitap varlığını (entity) temsil eder.
Alanlar:

id: Otomatik üretilen birincil anahtar

baslik: Kitabın başlığı

yazar: Kitap yazarı

kategori: Kitap türü/kategorisi

yayinTarihi: Kitabın yayın tarihi (java.time.LocalDate)

stoktaVarMi: Kitabın stokta olup olmadığı bilgisi (boolean)

Repository Katmanı (com.kitap.ekitap.repository):

KitapRepository.java:
Spring Data JPA JpaRepository arayüzünden türetilmiş, kitaplarla ilgili veritabanı işlemlerini sağlar.

Veritabanı:
Proje geliştirme ve deploy aşamasında H2 veritabanı kullanılmıştır. H2, gömülü (in-memory) bir veritabanıdır ve hızlı prototipleme için idealdir.
Railway üzerinde deploy ederken eğer başka bir veritabanı (PostgreSQL gibi) bağlanmadıysa, H2 olabilir veya Railway’nin kendi veritabanı servisi kullanılmış olabilir.
H2’nin application.properties dosyasındaki temel ayarları şu şekildedir:

properties
Kopyala
Düzenle
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
Teknolojiler:

Java 17+ (veya kullandığınız sürüm)

Spring Boot 3.x

Spring Web (REST API geliştirme)

Spring Data JPA (veritabanı erişimi için)

H2 Database (geliştirme aşamasında in-memory veritabanı)

Maven (proje ve bağımlılık yönetimi)

Railway.app (Uygulamanın deploy edildiği bulut platformu)

Çalışma Şekli:

Uygulama RESTful API olarak kitap verilerini yönetir.

/api/kitaplar endpoint’i üzerinden kitaplar listelenebilir, eklenebilir.

Ana sayfaya (/) gidildiğinde uygulamanın çalıştığını belirten bir mesaj gösterilir.

API Kullanım Örnekleri
Kitapları listeleme (GET):

bash
Kopyala
Düzenle
curl -X GET https://ekitap-production.up.railway.app/api/kitaplar
Yeni kitap ekleme (POST):
JSON formatında aşağıdaki gibi veri gönderilir:

bash
Kopyala
Düzenle
curl -X POST https://ekitap-production.up.railway.app/api/kitaplar \
  -H "Content-Type: application/json" \
  -d '{
    "baslik": "Deneme Kitabı",
    "yazar": "Yazar Adı",
    "kategori": "Roman",
    "yayinTarihi": "2023-01-01",
    "stoktaVarMi": true
  }'

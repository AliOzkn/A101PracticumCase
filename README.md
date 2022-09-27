<h1 align="center"> A101 & Patika.dev Practicum Case - A101 Web Sitesi ve Mobil Uygulamasından Ürün Satın Alma  </h1>

### Test Senaryosu
#### 1) Giyim--> Aksesuar--> Kadın İç Giyim-->Dizaltı Çorap bölümüne girilir
#### 2) Açılan ürünün siyah olduğu doğrulanır.
#### 3) Sepete ekle butonuna tıklanır.
#### 4) Sepeti Görüntüle butonuna tıklanır.
#### 5) Sepeti Onayla butonuna tıklanır.
#### 6) Üye olmadan devam et butonuna tıklanır.
#### 7) Mail adresi yazılarak devam edilir.
#### 8) Sonrasında adres ekranı gelir. Adres oluştur dedikten sonra ödeme ekranı gelir.
#### 9) Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiği ,doğru ekrana yönlendirildiği kontrol edilir.

---

### MOBİL

#### Mobil test için TestNG framework'ü kullanılmıştır. Test, src/test/testng.xml dosyasından çalıştırılmalıdır.

#### Android için capability JSON dosyası aşağıdaki şekildedir. Bu dosyaya src/main/test/resources/capabilities yolu ile ulaşılabilir. Ayrıca testin gerçekleştirildiği cihazın Android sürümü 12.0.0 olarak belirlenmiştir.
```java
{
    "platformName": "Android",
    "appium:udid": "emulator-5554",
    "appium:deviceName": "Pixel_3_XL_API_31",
    "appium:platformVersion": "12.0.0",
    "appium:automationName": "A101",
    "noReset": true,
    "appium:newCommandTimeout": 5
}
```
#### Raporlama için Allure Report kullanılmıştır. Test raporu görseli aşağıdaki gibidir.
![allure1](https://user-images.githubusercontent.com/107454207/192508115-257bd9e0-097b-4b47-a704-04370b6ffa27.png)

---

### WEB

#### Web Testi, Cucumber ile yapılmıştır.
#### Test, Chrome, Firefox ve Edge tarayıcılarında yürütülebilir. src/main/resources/config.properties dosyasındaki, browser ismini değiştirmek yeterlidir.
#### Test raporu görseli aşağıdaki gibidir. 
![cucumber-results](https://user-images.githubusercontent.com/107454207/192509121-17550dcf-353e-462f-9000-c9874367c8c8.png)

Feature: US1014 Amazon Testleri
  @wip
  Scenario: TC18 dropdown testi

    Given kullanici "amazonUrl" anasayfaya gider
    Then Arama kutusunun solundaki dropdown menuye handle edin
    And dropdown menudeki opsiyonlari liste olarak yazdirii
    Then dropdown menude 28 eleman oldugunu test  edin
  @wip
    Scenario:
      When dropdown menuden elektronik bolumu secer
      And arama kutusuna "iphone" yazip aratir
      And bulunan sonuc sayisini yazdirir
      And arama sonuclarinin "iphone" icerdigini test eder
      Then ikinci urune tiklar
      And urunun title'ni ve fiyatini variable'a assing edip urunu sepete ekleyelim

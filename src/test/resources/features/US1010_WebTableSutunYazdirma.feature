
Feature: US1010 Kullanici baslik ile istedigi sutunu yazdirir

  Scenario: TC14 kullanici istedigi sutunu yazdirabilmeli

    Given kullanici "guruUrl" anasayfaya gider
    And "Company", sutunundaki tum degerleri yazdirir
    And sayfayi kapatir
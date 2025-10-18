# stringApkYukle.feature
Feature: İstenen APK'yı feature içinde değiştirerek yüklemek



  @calculator
  Scenario: Calculator APK yükleme ve test
    Given Kullanici "calculator" apk dosyasini yukler
    Then Calculator uygulamasinin yuklendigini dogrular
    And Calculator uygulamasinin acildigini dogrular

  @arabam
  Scenario: Arabam APK yükleme ve test
    Given Kullanici "arabam" apk dosyasini yukler
    Then Arabam uygulamasinin yuklendigini dogrular

  @dynamic
  Scenario Outline: Dinamik APK yükleme
    Given Kullanici "<apkAdi>" apk dosyasini yukler
    Then "<appPackage>" paketinin yuklendigini dogrular

    Examples:
      | apkAdi     | appPackage                    |
      | calculator | com.google.android.calculator |
      | arabam     | com.dogan.arabam.app          |
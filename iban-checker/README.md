# IBAN Checker

Programa patikrina IBAN numerius.

## Pradžia

Programa paleidžiama iš .jar failo
* [iban-checker-0.0.1-SNAPSHOT.jar](http://NUORODA) 
```
java -jar iban-checker-0.0.1-SNAPSHOT.jar
```

### Back-end
```
Java SE 11
Spring Boot 2.2.1
Maven 3.6.1
```

### Front-end
```
FreeMarker
Bootstrap
```

### Programos veikimo pavyzdys

Paleidus programą, atsidaro (http://localhost:8080/) vartotojo interfeisas, kuriame jis gali pasirinkti kaip tikrinti IBAN numerį: vieną ar pateikti kelią iki failo su IBAN numerių sąrašu.
Pasirinkus tikrinti vieną IBAN, reikia įvesti IBAN numerį, paspausti CHECK mygtuką ir į ekraną išvedamas įvestas IBAN numerius su patikrinimo rezultatu:
```
Checking results:
LT647044001231465456 is valid.
```
Pasirinkus tikrinti sąrašą, reikia įvesti kelią iki direktorijos, kurioje guli failas su IBAN sąrašais, bei failo pavadinimą.
Paspaudus CHECK, į ekrada išvedamas pranešimas:
```
Checking results:
The results are saved in the path you specified in the sample.out file.
```
sample failo turinys:
```
AA051245445454552117989
LT647044001231465456
LT517044077788877777
LT227044077788877777
CC051245445454552117989
```
sample.out failo turinys:
```
AA051245445454552117989;false
LT647044001231465456;true
LT517044077788877777;true
LT227044077788877777;false
CC051245445454552117989;false
```

Išimtys programoje gaudomos, jei neteisingas kelio iki direktrorijos arba failo vardo įvedimas, išvedamas pranešimas:
```
Checking results:
Problems reading the file, please, check the path you entered and the file name and try again.
```
ir galima bandyti vesti dar kartą.

## IBAN tikrinimo algoritmas

* iš vartotojo įvesto IBAN numerio pašalinami visi tušti tarpai.
* tikrinamas IBAN ilgis - ar daugiau nei 4 ir mažiau 35, jei taip,
* tikrinami pirmi du IBAN simboliai, ar atitinka valstybės kodą, jei taip,
* tikrinama modifikuoto IBAN dalyba iš 97, ar liekana lygi 1, jei taip,
* IBAN numeris teisingas

## Testai

Programoje yra paprasti integraciniai, kurie testuoja puslapių veikimą, bei moduliniai, kurie testuoja IbanService metodus, testai



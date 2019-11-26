# IBAN Checker

Servisas (REST) patikrina IBAN numerius.

## Pradžia

Servisas paleidžiamas iš .jar failo
* [iban-checker-rest.jar](https://github.com/SergejJerma/iban-checker/blob/master/iban-checker-rest/iban-checker-rest.jar) 
```
java -jar iban-checker-rest.jar
```

### Back-end

```
Java SE 11 
Spring Boot 2.2.1
Maven 3.6.1
```

### Programos veikimo pavyzdys

Paleidus programą bei pateikus POST metodu per Postman IBAN sąrašą:
```
[
	{
		"iban":"AA051245445454552117989"
	},
	{
		"iban":"LT647044001231465456"
	},
	{
		"iban":"LT517044077788877777"
	},	
	{
		"iban":"LT227044077788877777"
	},
	{
		"iban":"CC051245445454552117989"
	}
]
```
gaunamas rezultatas:
```
[
    {
        "iban": "AA051245445454552117989",
        "valid": false
    },
    {
        "iban": "LT647044001231465456",
        "valid": true
    },
    {
        "iban": "LT517044077788877777",
        "valid": true
    },
    {
        "iban": "LT227044077788877777",
        "valid": false
    },
    {
        "iban": "CC051245445454552117989",
        "valid": false
    }
]
```
## IBAN tikrinimo algoritmas

* iš vartotojo įvesto IBAN numerio pašalinami visi tušti tarpai.
* tikrinamas IBAN ilgis - ar daugiau nei 4 ir mažiau 35, jei taip,
* tikrinami pirmi du IBAN simboliai, ar atitinka valstybės kodą, jei taip,
* tikrinama modifikuoto IBAN dalyba iš 97, ar liekana lygi 1, jei taip,
* IBAN numeris teisingas

## Testai

Programoje yra paprasti moduliniai testai, kurie testuoja IbanService metodus.



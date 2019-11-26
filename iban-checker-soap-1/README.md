# IBAN Checker

Servisas (SOAP) patikrina IBAN numerius.

## Pradžia

Servisas paleidžiamas iš .jar failo
* [iban-checker-soap.jar](https://github.com/SergejJerma/iban-checker/blob/master/iban-checker-soap-1/iban-checker-soap.jar) 
```
java -jar iban-checker-soap.jar
```

### Back-end

```
Java SE 11 
Spring Boot 2.2.1
Maven 3.6.1
```

### Programos veikimo pavyzdys

Paleidus programą bei pateikus POST metodu per SoapUI IBAN sąrašą:
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
xmlns:gs="http://serjer.com/iban">
<soapenv:Header/>
  <soapenv:Body>
    <gs:IbansRequest>
      <gs:ibans>
        <gs:ibanNumber>AA051245445454552117989</gs:ibanNumber>
      </gs:ibans>
      <gs:ibans>
        <gs:ibanNumber>LT647044001231465456</gs:ibanNumber>
      </gs:ibans> 
      <gs:ibans>
        <gs:ibanNumber>LT517044077788877777</gs:ibanNumber>
      </gs:ibans>   
      <gs:ibans>
        <gs:ibanNumber>LT227044077788877777</gs:ibanNumber>
      </gs:ibans> 
      <gs:ibans>
        <gs:ibanNumber>CC051245445454552117989</gs:ibanNumber>
      </gs:ibans> 			
    </gs:IbansRequest>
  </soapenv:Body>
</soapenv:Envelope>

```
gaunamas rezultatas:
```
HTTP/1.1 200 
Accept=text/xml, text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2
SOAPAction=""
Content-Type=text/xml;charset=utf-8
Content-Length=765
Date=Tue, 26 Nov 2019 14:42:48 GMT

<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope
SOAP-ENV:Header/>
<SOAP-ENV:Body>
<ns2:IbansResponse xmlns:ns2="http://serjer.com/iban">
<ns2:ibans>
  <ns2:ibanNumber>AA051245445454552117989</ns2:ibanNumber>
  <ns2:isValid>false</ns2:isValid></ns2:ibans>
<ns2:ibans>
  <ns2:ibanNumber>LT647044001231465456</ns2:ibanNumber>
  <ns2:isValid>true</ns2:isValid></ns2:ibans>
<ns2:ibans>
  <ns2:ibanNumber>LT517044077788877777</ns2:ibanNumber>
  <ns2:isValid>true</ns2:isValid></ns2:ibans>
<ns2:ibans>
  <ns2:ibanNumber>LT227044077788877777</ns2:ibanNumber>
  <ns2:isValid>false</ns2:isValid></ns2:ibans>
<ns2:ibans>
  <ns2:ibanNumber>CC051245445454552117989</ns2:ibanNumber>
  <ns2:isValid>false</ns2:isValid>
</ns2:ibans>
</ns2:IbansResponse>
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>

```
## IBAN tikrinimo algoritmas

* iš vartotojo įvesto IBAN numerio pašalinami visi tušti tarpai.
* tikrinamas IBAN ilgis - ar daugiau nei 4 ir mažiau 35, jei taip,
* tikrinami pirmi du IBAN simboliai, ar atitinka valstybės kodą, jei taip,
* tikrinama modifikuoto IBAN dalyba iš 97, ar liekana lygi 1, jei taip,
* IBAN numeris teisingas

## Testai

Programoje yra paprasti moduliniai testai, kurie testuoja IbanService metodus.



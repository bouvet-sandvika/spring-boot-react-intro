# Bli Full-Stack Utvikler i Ditt Eget Hobbyprosjekt!
Dette repositoriet inneholder to deler; en frontend og en backend.
Instruksjonene som følger for å installere og starte front- og backend er testet på Ubuntu 18.04.

### Frontend
Frontend-mappen inneholder en enkel React-applikasjon. For å kjøre den må du ha installert node og npm. Instruksjoner for dette kan du for eksempel finne her: https://www.digitalocean.com/community/tutorials/how-to-install-node-js-on-ubuntu-18-04
For å starte frontend-applikasjonen, kjør følgende kommandoer:
```
cd frontend
npm install
npm start
```
Nettleseren din bør da åpne seg på adressen `http://localhost:3000`.

### Backend
Backend-mappen inneholder en enkel Java Spring-Boot-applikasjon som snakker med en MongoDB. Prosjektet er satt opp for å bygge med Apache Maven, så totalt trenger du å installere

* Maven - https://linuxize.com/post/how-to-install-apache-maven-on-ubuntu-18-04/

* Java 11 - http://ubuntuhandbook.org/index.php/2018/11/how-to-install-oracle-java-11-in-ubuntu-18-04-18-10/

* MongoDB - https://www.digitalocean.com/community/tutorials/how-to-install-mongodb-on-ubuntu-18-04

for å kunne kjøre opp applikasjonen. Når dette er installert kan du starte backend-applikasjonen ved å kjøre følgende kommandoer:
```
# For å starte MongoDB-serveren på localhost
sudo service mongod start

# For å starte Spring-Boot backend-applikasjonen
cd backend
mvn install
java -jar target/demo-0.0.1-SNAPSHOT.jar
```
Dette skal starte backend-applikasjonen på adressen `http://localhost:8080`.

### Google OAuth 2.0
Her kan du lese om hvordan du registrerer et prosjekt for å bruke innlogging med Google OAuth 2.0: https://developers.google.com/identity/protocols/OAuth2

I front- og back-end-eksemplene i dette repositoriet er det lagd eksempler på hvordan en kan faktisk gjøre en autentisering. Det eneste du trenger for å få dette til å virke med ditt prosjekt er å sette inn client-id-en til ditt prosjekt.

### Nyttige linker
* Komme i gang med React: https://reactjs.org/docs/create-a-new-react-app.html
* Komme i gang med Spring Boot: https://start.spring.io/
* Sjekk dine sikkerhets-headere: https://securityheaders.com/
* Gratis HTTPS til serveren din: https://letsencrypt.org/
* Gratis 512MB MongoDB for å komme i gang: https://www.mongodb.com/
* Google Cloud SDK (CLI for å jobbe mot Google Cloud): https://cloud.google.com/sdk/
* Google Cloud App Engine-dokumentasjon: https://cloud.google.com/appengine/docs/
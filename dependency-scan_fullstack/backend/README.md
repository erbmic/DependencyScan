# Backend von dependency-scan

## Wie entwickle ich
Dieses Projekt beinhaltet ein Docker Compose, welches die Inbetriebnahme der Docker Container verwaltet.

### Docker Compose bilden
Falls ich Änderungen an meinen Tests oder Source Code vorgenommen habe, muss ich das Docker Image neu builden.
> docker-compose build

### Docker Compose starten
Mit dem folgenden Befehl kann das Backend gestartet werden.
> docker-compose up -d --build

Sobald dieser Befehl abgearbeitet ist, stehen folgende Funktionalitäten zur Verfügung:
* Aktuelles Backend unter http://localhost:8080

### Docker Compose herunterfahren
Sobald die lokale Instanz heruntergefahren werden soll, kann folgendes Kommando verwendet werden.
> docker-compose down

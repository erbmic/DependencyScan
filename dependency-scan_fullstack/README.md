# dependency-scan
In diesem Repository befindet sich der Source Code vom Projekt dependency-scan. Das Projekt ist wie folgt gruppiert:
* [backend](backend/README.md "dependency-scan backend"): Backend vom Projekt dependency-scan
* [frontend](frontend/README.md "dependency-scan frontend"): Frontend vom Projekt dependency-scan

## Lokales aufsetzen von dependency-scan
Anschliessend kann mit dem folgenden Befehl (in der Kommandozeile in diesem Verzeichnis) das Projekt aufgestartet werden.
> docker-compose up -d --build

Beim ersten Ausführen werden alle noch nicht vorhandenen Docker Images gebildet und anschliessend gestartet. Sobald dieser Befehl abgearbeitet ist, kann die dependency-scan Applikation im Chrom Webbrowser unter http://localhost:80 erreicht werden.

Um die Container wieder herunterzufahren ist der folgende Befehl notwendig:
> docker-compose down

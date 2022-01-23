# dependency-scan

Softwarepakete basieren auf etlichen Abhängigkeiten zu Softwareartefakten. Visualisiert bilden alle diese
aufeinander abhängigen Artefakte einen Graphen. Skaliert man diesen in einem grossen Umfeld, wird der Graph
unüberschaubar gross. Der Graph wächst indem jedes der Artefakte inkrementell eine neue Version erhält, was
zu einem neuen Knoten im Graphen führt. 

`dependency-scan` ist eine Applikation um Abhängigkeiten von Softwareartefakten in einer Graphdatenbank zu speichern und über ein Webinterface abzufragen.


## Get started

In diesem Repository befindet sich der Source Code vom Projekt dependency-scan. Das Projekt ist wie folgt gruppiert:

* [backend](backend/README.md "dependency-scan backend"): Backend vom Projekt dependency-scan
* [frontend](frontend/README.md "dependency-scan frontend"): Frontend vom Projekt dependency-scan

### Lokales aufsetzen von dependency-scan

Anschliessend kann mit dem folgenden Befehl (in der Kommandozeile in diesem Verzeichnis) das Projekt aufgestartet werden.
```sh
docker-compose up -d --build
```

Beim ersten Ausführen werden alle noch nicht vorhandenen Docker Images gebildet und anschliessend gestartet. Sobald dieser Befehl abgearbeitet ist, kann die dependency-scan Applikation im Chrom Webbrowser unter http://localhost:80 erreicht werden.

Um die Container wieder herunterzufahren ist der folgende Befehl notwendig:
```bash
docker-compose down
```

#### Automatisches laden von Dummy Daten in die Datenbank
Das Python Skript kann ausgeführt werden, sobald das Docker-Compose läuft.
Die Konsole muss auf dem Projektfolder dependency-scan_fullstack geöffnet sein und Python 3 muss installiert sein.
```bash
python3 ./loadDependencies.py
```

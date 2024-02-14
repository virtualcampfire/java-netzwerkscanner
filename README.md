# Java-Netzwerkscanner

### 1.  Projektbeschreibung 
#### Worum geht es? 

Unsers Firma ist auf die Entwicklung von Digital Signage spezialisiert und beliefert erfolgreich große Ketten. Jedes Signage-Gerät durchläuft einen individuellen Bespielungsprozess, der die Konfiguration von BIOS, Linux und AWX umfasst. Dieser Vorgang beansprucht etwa 15 Minuten pro Gerät. Angesichts einer bedeutenden Bestellung von über 4000 Signage-Geräten stellt sich die Frage: Wer hat die Lust und Zeit, mehr als 1000 Stunden damit zu verbringen, jedes einzelne Gerät manuell zu bespielen? Hier liegt die Herausforderung, eine effiziente und zeitsparende Lösung zu finden, um diesen umfangreichen Auftrag erfolgreich abzuwickeln.

#### Was ist die aktuelle Situation? 

In der aktuellen Situation steht jedes Signage-Gerät vor einer manuellen Bespielung, bestehend aus drei Hauptkomponenten: dem Bildschirm, dem Rechner und der Software. Die Softwareanpassungen umfassen mehrere Schritte. Zunächst erfolgt die automatische Einstellung des BIOS über den Arduino Leonardo. Im Anschluss müssen jedoch die IP- und MAC-Adressen manuell abgefragt, gespeichert und SSH-Änderungen vorgenommen werden. Schließlich erfolgt die automatische Bespielung der Signage-App über AWX. Diese Prozesse erfordern derzeit ein hohes Maß an manuellem Aufwand und Zeitinvestition für jedes einzelne Gerät.

#### Wie können wir bestehende Systeme verbessern? 

Automatisierte IP/MAC-Adressen-Abfrage und SSH-Änderungen:

Netzwerkscan:
- Das System sollte das Netzwerk automatisch scannen, um alle verfügbaren Geräte zu identifizieren.

Portsuche:
- Nach dem Netzwerkscan sucht das System nach bestimmten offenen Ports, um die Geräte präzise zu identifizieren.
  
Geräteidentifikation und Kopieren:
- Nach der Identifikation eines Geräts werden die IP- und MAC-Adressen automatisch abgerufen und können auf Wunsch kopiert werden.
  
Quick-Tasks über SSH:
- Das System sollte die Möglichkeit bieten, Quick-Tasks über SSH auszuführen. Dadurch können automatisierte Änderungen oder Konfigurationen auf den Geräten durchgeführt werden.
  
Start für AWX:
- Nach Abschluss der vorherigen Schritte gibt das System den Startschuss für AWX, um die automatische Installation der Signage-App zu initiieren.

#### Grundsätzliche Schlüsselstellen sind: 
- Identifikation der eigenen IP-Adresse 
- Scannen des gesamten restlichen Netzwerkes (255.255.255.0)
- Check der offenen Ports der erkannten Geräte
- Ausführen der Quick-Tasks über SSH
- Übersichtliche UI (JFrame)


### Projekte Organisation auf GitHub
Unsere gesamte Projektabwicklung erfolgt transparent und effizient über GitHub. Dies umfasst nicht nur die eigentliche Codierung und Versionierung, sondern auch die Planung, Dokumentation und zeitliche Organisation.

#### Komponenten:

![Tabelle](https://github.com/virtualcampfire/java-netzwerkscanner/blob/main/assets-doc/tabelle.png)

Projekte:
- Die Hauptprojekte sind auf GitHub strukturiert und beinhalten alle relevanten Informationen, Ressourcen und den Quellcode.
  
Dokumentation:
- Alle wichtigen Informationen werden in der Dokumentation zentralisiert und gepflegt.
  
Roadmap (Zeitmanagement):
- Eine klare Roadmap definiert die zeitliche Strukturierung und Meilensteine für die Entwicklung. Diese ermöglicht eine übersichtliche Planung und Verfolgung des Fortschritts.

![Roadmap](https://github.com/virtualcampfire/java-netzwerkscanner/blob/main/assets-doc/roadmap.png)
  
Codierung und Versionierung:
- GitHub dient als Plattform für die sichere Verwaltung des Codes und die transparente Versionierung.
  
Agile Softwareentwicklung:
- Wir setzen auf agile Softwareentwicklung, um flexibel auf Anforderungsänderungen reagieren zu können und auf kontinuierlichem Feedback basierend zu entwickeln.
  
Sprint-basierte Planung:
- Für jede Entwicklungsiteration wird ein separates Projekt angelegt, gekennzeichnet durch die Kalenderwoche und das Jahr. Hier finden sich die spezifische Roadmap sowie ein Board zur Visualisierung der Arbeitsprozesse.

![Sprint](https://github.com/virtualcampfire/java-netzwerkscanner/blob/main/assets-doc/Sprint.png)
  
#### Board-Struktur:
- Jedes Board gliedert sich in vier Spalten:
  
Sprint Backlog (User Story, Top-Task):
- Hier werden die definierten User Stories und Top-Tasks für den jeweiligen Sprint festgehalten.
  
Todo:
- Aufgaben, die noch erledigt werden müssen, werden in dieser Spalte priorisiert und geplant.
  
In Progress:
- Hier befinden sich die Aufgaben, die sich aktuell in Bearbeitung befinden.
  
Done:
- Abgeschlossene Aufgaben werden in dieser Spalte übersichtlich dokumentiert.

![Board](https://github.com/virtualcampfire/java-netzwerkscanner/blob/main/assets-doc/board.png)
  
Diese Organisationsstruktur ermöglicht uns eine transparente, kollaborative und erfolgreiche Projektdurchführung.


### 3.	EPK

![EPK Netzwerkscanner](https://github.com/virtualcampfire/java-netzwerkscanner/blob/main/assets-doc/epk.png)

### Verwendete Technologien und Packete: 

- Programmiersprache: Java
- Genutze Packete:
    - javax.swing.*; // Hier kurze Erklärung 
    - java.awt.*; // Hier kurze Erklärung 
    - java.awt.event.ActionEvent; // Hier kurze Erklärung 
    - java.awt.event.ActionListener; // Hier kurze Erklärung 
    - java.net.InetAddress; // Hier kurze Erklärung 
    - java.net.InetSocketAddress; // Hier kurze Erklärung 
    - java.net.Socket; // Hier kurze Erklärung 
    - java.util.concurrent.ExecutorSe // Hier kurze Erklärung 
    - java.util.concurrent.Executors; // Hier kurze Erklärung

### 4.	UML

![UML](https://github.com/virtualcampfire/java-netzwerkscanner/blob/main/assets-doc/UML.png)

### .	GUI-Design
### .	Event Handling
### .	SSH-Kommunikation
### .	IP-Adressen abrufen 
### .	Fehlerbehandlung



# Java-Netzwerkscanner

### 1.  Projektbeschreibung 
Unsere Firma entwickelt Signage-Geräte, bestehend aus einem Bildschirm und einem Mini-PC. Die Signage-Software muss vor der Auslieferung auf dem Mini-PC installiert werden. Der Initialeinstellungsprozess erfolgt über einen Arduino Leonardo, gefolgt von der Integration in unser Netzwerk, bei dem IP- und MAC-Adressen abgerufen und gespeichert werden. Bei speziellen Kundenanforderungen müssen zusätzliche SSH-Konfigurationen auf den Geräten vorgenommen werden. Anschließend müssen die IP-Adressen der Geräte manuell in AWX eingegeben werden, das dann einen Job startet, um unsere Signage-App zu installieren.

Aktuelle Situation: 
- (a) BIOS muss eingestellt werden (Automatisch) 
- (b) Abfragen und Speichern der IP/MAC-Adressen und Änderungen über SSH vornehmen. (manuell) 
- (c) Signage App wird bespielt (Automatisch) 

### 2.	Projektziele
In der aktuellen Situation, wie in der Projektbeschreibung dargestellt, soll der gesamte Prozess automatisiert werden. Hierbei ist das Ziel, eine nahtlose Integration der verschiedenen Prozesse zu ermöglichen.

Ziele: 
-	Abfrage der Geräte IPs und MAC-Adressen
-	Quick-Tasks (Wiederholende SSH Befehle automatisch abrufen)
-	Schnelles und Effizientes bespielen 
-	Integrierung an a und c

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
### .	IP- und MAC-Adressen abrufen
### .	Datenbank 
### .	Fehlerbehandlung
### .	Benutzerfreundlichkeit
### .	Sicherheit
### .	Testen



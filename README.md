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

### 3.	Projektstruktur
### 4.	GUI-Design
### 5.	Event Handling
### 6.	SSH-Kommunikation
### 7.	IP- und MAC-Adressen abrufen
### 8.	Datenbank 
### 9.	Fehlerbehandlung
### 10.	Benutzerfreundlichkeit
### 11.	Sicherheit
### 12.	Testen



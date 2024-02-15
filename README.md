# Java-Netzwerkscanner

### 1.  Projektbeschreibung 
#### Worum geht es? 

Unsers Firma ist auf die Entwicklung von Digital Signage spezialisiert und beliefert erfolgreich große Ketten. Jedes Signage-Gerät durchläuft einen individuellen Bespielungsprozess, der die Konfiguration von BIOS, Linux und AWX umfasst. Dieser Vorgang beansprucht etwa 15 Minuten pro Gerät. Angesichts einer bedeutenden Bestellung von über 4000 Signage-Geräten stellt sich die Frage: Wer hat die Lust und Zeit, mehr als 1000 Stunden damit zu verbringen, jedes einzelne Gerät manuell zu bespielen? Hier liegt die Herausforderung, eine effiziente und zeitsparende Lösung zu finden, um diesen umfangreichen Auftrag erfolgreich abzuwickeln.

#### Was ist die aktuelle Situation? 

In der aktuellen Situation steht jedes Signage-Gerät vor einer manuellen Bespielung, bestehend aus drei Hauptkomponenten: dem Bildschirm, dem Rechner und der Software. Die Softwareanpassungen umfassen mehrere Schritte. Zunächst erfolgt die automatische Einstellung des BIOS über den Arduino Leonardo. Im Anschluss müssen jedoch die IP- und MAC-Adressen manuell abgefragt, gespeichert und SSH-Änderungen vorgenommen werden. Schließlich erfolgt die automatische Bespielung der Signage-App über AWX. Diese Prozesse erfordern derzeit ein hohes Maß an manuellem Aufwand und Zeitinvestition für jedes einzelne Gerät.

#### Wie können wir bestehende Systeme verbessern? 

Automatisierte IP-Adressen-Abfrage und SSH-Änderungen:

Netzwerkscan:
- Das System sollte das Netzwerk automatisch scannen, um alle verfügbaren Geräte zu identifizieren.

Portsuche:
- Nach dem Netzwerkscan sucht das System nach bestimmten offenen Ports, um die Geräte präzise zu identifizieren.
  
Geräteidentifikation und Kopieren:
- Nach der Identifikation eines Geräts wird die IP-Adressen automatisch abgerufen und können auf Wunsch kopiert werden.
  
Quick-Tasks über SSH:
- Das System sollte die Möglichkeit bieten, Quick-Tasks über SSH auszuführen. Dadurch können automatisierte Änderungen oder Konfigurationen auf den Geräten durchgeführt werden.
  
Start für AWX:
- Nach Abschluss der vorherigen Schritte gibt das System den Startschuss für AWX, um die automatische Installation der Signage-App zu initiieren.

#### Grundsätzliche Schlüsselstellen sind: 
- Scannen des gesamten Netzwerkes (255.255.255.0)
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

![EPK Netzwerkscanner](https://github.com/virtualcampfire/java-netzwerkscanner/blob/main/assets-doc/EPK.png)

### Verwendete Sprache: 

- Programmiersprache: Java

### 4.	UML

![UML](https://github.com/virtualcampfire/java-netzwerkscanner/blob/main/assets-doc/uml.png)

### 5.  GUI-Design
Das ganze Design wurde mit Figma gemacht. Figma ist ein Online-Tool fürs Designen und Prototypen, das Designern und Teams hilft, gemeinsam zu arbeiten. Es bietet einfache Möglichkeiten, Designs zu erstellen und zu teilen, und das alles ziemlich benutzerfreundlich.
![Figma Design](https://github.com/virtualcampfire/java-netzwerkscanner/blob/main/assets-doc/figmaDesign.png)

### 6. Event Handling

![Event Handling](https://github.com/virtualcampfire/java-netzwerkscanner/blob/main/assets-doc/eventhandling.png)

### 7. SSH-Kommunikation

```java
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.InputStream;

public class SSHCommandExecution {
    public static void main(String[] args) {
        String host = "server-host";
        String user = "user-name";
        String password = "user-pw";
        int port = 22;
        String command = "ip -a";  // Der auszuführende Befehl

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            
            System.out.println("Verbindung wird hergestellt...");
            session.connect();

            // Channel für die Ausführung von Befehlen öffnen
            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);

            // Ausgabe-Stream vom Server bekommen
            InputStream in = channel.getInputStream();

            // Channel verbinden
            channel.connect();

            // Ausgabe lesen
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    if (in.available() > 0) continue;
                    System.out.println("exit-status: " + channel.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {}
            }

            // Channel und Session schließen
            channel.disconnect();
            session.disconnect();
            System.out.println("Verbindung getrennt.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 8. IP-Adressen abrufen 

- IP-Adressen-Scan: Durchläuft alle IP-Adressen im lokalen Subnetz des ausführenden Geräts.
- Port-Überprüfung: Prüft, ob der angegebene Port auf den gefundenen Geräten offen ist.
- Geräteerkennung: Identifiziert erreichbare Geräte im Netzwerk und sammelt Informationen wie IP-Adresse.
- Multithreading: Verwendet einen Thread-Pool, um parallele Scans durchzuführen und die Scan-Zeit zu reduzieren.

### 9. Entwicklungsprozess

## Grundsätzliche Fragestellungen: 
- Wie funktioniert das aktuelle System?
- Wie könnte man dieses Verbessern? 
- Was wird dafür benötigt? 

## Grundsätzliche Schlüsselstellen: 
- Organisation (Organisation auf GitHub)
- Entwicklung Ereignisgesteuerte Prozesskette
- Entwicklung Unified Modeling Language
- Entwürf GUI-Design
- Struktur des Event Handlings 
- SSH-Kommunikation (Welches Packet könnte man nutzen)
- Implementierung Netzwerk und Portscan


### 10. Aufgetretene Probleme und Problemlösungen:

- Optimierung der Durchlaufgeschwindigkeit:
    - Ursprünglich benötigte ein vollständiger Scandurchlauf mehrere Minuten. Eine signifikante Beschleunigung wurde durch die Integration von 50 zusätzlichen virtuellen Threads erreicht.
- Probleme mit unterschiedlichen Packeten und des Classpathes


### 11. Maximal- Minimalziel

$ = Erreicht
! = Nicht erreicht

- Minimalziel:
    - $ Netzwerkscanner
- Mittleresziel
    - $ Erkennung der offenen Ports
- Maximalziel
    - ! Implementierung der SSH-Verbindung (Komplikationen mit Classpathes)

## Nutzerdokumentation

1. Starten Sie den Netzwerkscanner durch Auswahl der entsprechenden Anwendung.
2. Nach dem Öffnen erscheinen zwei separate Fenster: eines für den Netzwerkscanner und ein weiteres für den Task-Manager.
3. Durch Betätigen der Schaltfläche „Netzwerk scannen“ werden alle im Netzwerk befindlichen Geräte aufgelistet, einschließlich derjenigen, die den Port 8081 geöffnet haben.
4. Ein Klick auf ein spezifisches Gerät in der Liste ermöglicht es Ihnen, über eine angezeigte Option die IP-Adresse des Geräts zu kopieren.
5. Bei Bedarf kann der Netzwerkscan jederzeit erneut durchgeführt werden, um die aktuelle Geräteliste zu aktualisieren.
6. Soll ein spezifisches Gerät eine Aufgabe ausführen, kann dies über den Task-Manager initiiert werden.
7. Im Task-Manager können die IP-Adresse des Zielgeräts sowie der auszuführende Befehl eingegeben werden.
8. Nach Bestätigung der Eingaben erfolgt eine Anmeldung am Zielgerät mittels Standardauthentifizierung über SSH, woraufhin der eingegebene Befehl ausgeführt wird.

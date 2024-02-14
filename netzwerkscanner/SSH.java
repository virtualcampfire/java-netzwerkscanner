public class SSH {
    private String id;
    private String description;
    private String command;
    private String host;
    private int port;
    private String username;
    private String password;

    // Konstruktor
    public SSH(String id, String description, String command, String host, int port, String username, String password) {
        this.id = id;
        this.description = description;
        this.command = command;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    // Getter und Setter Methoden für die Eigenschaften
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Methode zur Ausführung des SSH-Befehls
    public void executeCommand() {
        // Implementierung der SSH-Verbindung und Befehlsausführung
        // Diese Methode würde normalerweise die Verwendung einer SSH-Bibliothek wie
        // JSch erfordern
        System.out.println("Befehl \"" + command + "\" wird auf " + host + ":" + port + " als Benutzer " + username
                + " ausgeführt.");
        // Beispielhafte Implementierung ohne echte SSH-Verbindung
    }
}

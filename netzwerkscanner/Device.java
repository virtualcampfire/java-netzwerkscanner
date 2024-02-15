
/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 07.11.2023
 * @author
 */

public class Device {

  public Device(String ip) {
    this.ip = ip;
  }

  // Anfang Attribute
  private String id;
  private String ip;
  private Boolean openPort;
  // Ende Attribute

  // Anfang Methoden
  public String getId() {
    return id;
  }

  public void setPortOpen(Boolean openPortNeu) {
    openPort = openPortNeu;
  }

  public Boolean getOpenPort() {
    return openPort;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ipNeu) {
    ip = ipNeu;
  }

  // Ende Methoden
} // end of Device

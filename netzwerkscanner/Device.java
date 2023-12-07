/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 07.11.2023
 * @author
 */

public class Device {

  public Device(String ip, String mac) {
    this.ip = ip;
    this.mac = mac;
  }

  // Anfang Attribute
  private String id;
  private String ip;
  private String mac;
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

  public String getMac() {
    return mac;
  }

  public void setIp(String ipNeu) {
    ip = ipNeu;
  }

  public void setMac(String macNeu) {
    mac = macNeu;
  }

  // Ende Methoden
} // end of Device

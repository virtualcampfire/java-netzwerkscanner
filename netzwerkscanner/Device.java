/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 07.11.2023
 * @author 
 */

public class Device {
  
  // Anfang Attribute
  private String id;
  private String ip;
  private String mac;
  // Ende Attribute
  
  // Anfang Methoden
  public String getId() {
    return id;
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


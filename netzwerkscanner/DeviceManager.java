/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 07.11.2023
 * @author
 */

public class DeviceManager {

  // Anfang Attribute
  private Device[] devices; // �nderung: Verwende ein Array f�r Devices
  private Database db;
  // Ende Attribute

  // Anfang Methoden
  public Device[] getDevices() { // �nderung: Die Methode gibt jetzt ein Array von Devices zur�ck
    return devices;
  }

  public void addDevice(String ip, String mac) {
    // TODO hier Quelltext einf�gen
    
  }

  public void deleteDeviceById(String id) {
    // TODO hier Quelltext einf�gen
    
  }

  public Database getDb() {
    return db;
  }

  // Ende Methoden
} // end of DeviceManager


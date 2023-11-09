/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 07.11.2023
 * @author
 */

public class DeviceManager {

  // Anfang Attribute
  private Device[] devices; // Änderung: Verwende ein Array für Devices
  private Database db;
  // Ende Attribute

  // Anfang Methoden
  public Device[] getDevices() { // Änderung: Die Methode gibt jetzt ein Array von Devices zurück
    return devices;
  }

  public void addDevice(String ip, String mac) {
    // TODO hier Quelltext einfügen
    
  }

  public void deleteDeviceById(String id) {
    // TODO hier Quelltext einfügen
    
  }

  public Database getDb() {
    return db;
  }

  // Ende Methoden
} // end of DeviceManager


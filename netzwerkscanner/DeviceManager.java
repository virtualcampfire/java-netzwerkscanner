
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DeviceManager {

  private List<Device> devices;

  public DeviceManager() {
    this.devices = new ArrayList<>();
  }

  public Device[] getDevices() {
    return devices.toArray(new Device[0]);
  }

  public void clearDevices() {
    devices.clear();
  }

  public void addDevice(String ip, boolean portOpen) {
    Device newDevice = new Device(ip);
    newDevice.setPortOpen(portOpen);
    devices.add(newDevice);
  }

  public void deleteDeviceById(String id) {
    devices.removeIf(device -> device.getId().equals(id));
  }

  public void scanInNetworkForDevicesWithTheOpenPort(Number port) {
    try {
      String ownIp = InetAddress.getLocalHost().getHostAddress();
      List<Future<Void>> futures = new ArrayList<>();

      ExecutorService executorService = Executors.newFixedThreadPool(50); // adjust the pool size as needed

      for (int i = 1; i < 255; i++) {
        String ip = ownIp.substring(0, ownIp.lastIndexOf(".") + 1) + i;
        futures.add(executorService.submit(() -> {
          // Prüfe, ob Gerät erreichbar ist
          if (isReachable(ip)) {
            // Prüfe, ob Port offen ist
            boolean portOpen = isPortOpen(ip, port);
            // Füge Gerät hinzu
            addDevice(ip, portOpen);
          }
          return null;
        }));
      }

      // Warte auf Abschluss aller Aufgaben
      for (Future<Void> future : futures) {
        future.get();
      }

      executorService.shutdown();
    } catch (Exception e) {
      e.printStackTrace(); // Handle the exception appropriately
    }
  }

  private boolean isReachable(String ip) {
    try {
      InetAddress address = InetAddress.getByName(ip);
      return address.isReachable(200); // Reduziere den Timeout auf 500 Millisekunden
    } catch (Exception e) {
      return false;
    }
  }

  private boolean isPortOpen(String ip, Number port) {
    try (Socket socket = new Socket()) {
      socket.connect(new InetSocketAddress(ip, port.intValue()), 200); // Reduziere den Timeout auf 500 Millisekunden
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
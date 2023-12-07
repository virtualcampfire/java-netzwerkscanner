import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

  private static DeviceManager deviceManager = new DeviceManager();

  public static DeviceManager getDeviceManager() {
    return deviceManager;
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Network Scanner");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JPanel mainPanel = new JPanel(new BorderLayout());

    DefaultListModel<String> listModel = new DefaultListModel<>();
    JList<String> deviceList = new JList<>(listModel);
    JScrollPane listScrollPane = new JScrollPane(deviceList);

    // Netzwerkscan-Button
    JButton scanButton = new JButton("Scan Network");
    scanButton.addActionListener(e -> {
      scanButton.setText("Scanning...");
      listModel.clear();

      new Thread(() -> {
        Number portToScan = 4000;
        deviceManager.scanInNetworkForDevicesWithTheOpenPort(portToScan);
        Device[] devices = deviceManager.getDevices();
        for (Device device : devices) {
          SwingUtilities.invokeLater(() -> {
            listModel.addElement("IP: " + device.getIp() + ", MAC: " + device.getMac()
                + ", Openport: " + device.getOpenPort());
          });
        }
        SwingUtilities.invokeLater(() -> {
          scanButton.setText("Scan Complete");
        });
      }).start();
    });

    // für jedes Gerät ein Kontextmenü mit der Möglichkeit, die IP-Adresse zu
    // kopieren
    deviceList.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
          int index = deviceList.locationToIndex(e.getPoint());
          if (index >= 0) {
            String[] details = deviceList.getModel().getElementAt(index).split(",");
            String ip = details[0].split(":")[1].trim();
            String mac = details[1].substring(details[1].indexOf(":") + 1).trim();
            JPopupMenu popupMenu = new JPopupMenu();
            JMenuItem copyIpItem = new JMenuItem("Copy IP");
            copyIpItem.addActionListener(e1 -> {
              StringSelection stringSelection = new StringSelection(ip);
              Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
              clipboard.setContents(stringSelection, null);
            });
            JMenuItem copyMacItem = new JMenuItem("Copy MAC");
            copyMacItem.addActionListener(e1 -> {
              StringSelection stringSelection = new StringSelection(mac);
              Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
              clipboard.setContents(stringSelection, null);
            });
            popupMenu.add(copyMacItem);
            popupMenu.add(copyIpItem);
            popupMenu.show(deviceList, e.getX(), e.getY());
          }
        }
      }
    });

    // für jedes Gerät ein Kontextmenü mit Doppelkick zum etwas in die Konsole zu
    // schreiben
    deviceList.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
          int index = deviceList.locationToIndex(e.getPoint());
          if (index >= 0) {
            String[] details = deviceList.getModel().getElementAt(index).split(",");
            String ip = details[0].split(":")[1].trim();
            String mac = details[1].substring(details[1].indexOf(":") + 1).trim();
            JPopupMenu popupMenu = new JPopupMenu();
            JMenuItem copyIpItem = new JMenuItem("Copy IP");
            copyIpItem.addActionListener(e1 -> {
              StringSelection stringSelection = new StringSelection(ip);
              Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
              clipboard.setContents(stringSelection, null);
            });
            JMenuItem copyMacItem = new JMenuItem("Copy MAC");
            copyMacItem.addActionListener(e1 -> {
              StringSelection stringSelection = new StringSelection(mac);
              Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
              clipboard.setContents(stringSelection, null);
            });
            popupMenu.add(copyMacItem);
            popupMenu.add(copyIpItem);
            popupMenu.show(deviceList, e.getX(), e.getY());
          }
        }
      }
    });

    // Statusanzeige
    JPanel statusPanel = new JPanel(new BorderLayout());

    // Komponenten zur Hauptansicht hinzufügen
    mainPanel.add(listScrollPane, BorderLayout.CENTER);
    mainPanel.add(statusPanel, BorderLayout.SOUTH);

    // Scan-Button ganz unten platzieren
    mainPanel.add(scanButton, BorderLayout.PAGE_END);

    frame.getContentPane().add(mainPanel);
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
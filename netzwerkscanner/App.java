import javax.swing.*;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App {

  private static DeviceManager deviceManager = new DeviceManager();
  private static SSH ssh = new SSH("id", "description", "command", "host", 22, "username", "password");

  public static SSH getSsh() {
    return ssh;
  }

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
            listModel.addElement("IP: " + device.getIp() + ", Openport: " + device.getOpenPort());
          });
        }
        SwingUtilities.invokeLater(() -> {
          scanButton.setText("Scan Complete");
        });
      }).start();
    });

    // für jedes Gerät ein Kontextmenü mit Doppelkick zum etwas in die Konsole zu
    // schreiben
    deviceList.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1) {
          int index = deviceList.locationToIndex(e.getPoint());
          if (index >= 0) {
            String[] details = deviceList.getModel().getElementAt(index).split(",");
            String ip = details[0].split(":")[1].trim();
            JPopupMenu popupMenu = new JPopupMenu();
            JMenuItem copyIpItem = new JMenuItem("Copy IP");
            copyIpItem.addActionListener(e1 -> {
              StringSelection stringSelection = new StringSelection(ip);
              Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
              clipboard.setContents(stringSelection, null);
            });
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

    JFrame taskFrame = new JFrame("Task Manager");
    taskFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // Hauptpanel mit BorderLayout, um verschiedene Komponenten zu organisieren
    JPanel taskPanel = new JPanel(new BorderLayout());

    // Liste zur Anzeige der Aufgaben
    DefaultListModel<String> taskListModel = new DefaultListModel<>();
    JList<String> taskList = new JList<>(taskListModel);
    JScrollPane taskListScrollPane = new JScrollPane(taskList);
    taskPanel.add(taskListScrollPane, BorderLayout.CENTER);

    // Panel für die Eingabefelder und den Bestätigungs-Button
    JPanel inputPanel = new JPanel(new GridLayout(3, 2)); // Grid-Layout für geordnete Eingabefelder

    // Eingabefelder für IP-Adresse und Befehl
    JTextField ipInputField = new JTextField();
    JTextField commandInputField = new JTextField();

    // Beschriftungen für die Eingabefelder
    inputPanel.add(new JLabel("IP-Adresse:"));
    inputPanel.add(ipInputField);
    inputPanel.add(new JLabel("Befehl:"));
    inputPanel.add(commandInputField);

    // Bestätigungs-Button, um die Eingaben zu verarbeiten
    JButton confirmButton = new JButton("Bestätigen");
    confirmButton.addActionListener(e -> {
      String ip = ipInputField.getText().trim();
      String command = commandInputField.getText().trim();
      getSsh().setHost(ip);
      getSsh().setCommand(command);
      getSsh().executeCommand();
    });
    inputPanel.add(confirmButton);

    // Füge das Input-Panel am unteren Rand des Haupt-Panels hinzu
    taskPanel.add(inputPanel, BorderLayout.SOUTH);

    // Füge das Haupt-Panel zum JFrame hinzu
    taskFrame.getContentPane().add(taskPanel);
    taskFrame.setSize(400, 118);
    taskFrame.setLocationRelativeTo(null);
    taskFrame.setVisible(true);

  }
}
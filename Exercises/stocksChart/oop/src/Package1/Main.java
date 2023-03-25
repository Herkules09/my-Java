package Package1;

import Package1.drive.HDDDrive;
import Package1.drive.SSDDrive;
import Package1.usbdevice.MemoryStick;
import Package1.usbdevice.Mouse;

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        SSDDrive drive = new SSDDrive();
    //    HDDDrive drive = new HDDDrive();
        Computer computer = new Computer(monitor,drive);

//       drive.addFile(new File("jakisplik.jpg"));
//       drive.listFiles();

        MemoryStick memoryStick = new MemoryStick("Pendrive");
        Mouse mouse = new Mouse("Mysz");

        computer.addUSBDevice(memoryStick);
        computer.addUSBDevice(mouse);
        memoryStick.eject();
        computer.removeUSBDevice(memoryStick);
        computer.removeUSBDevice(mouse);



    }
}

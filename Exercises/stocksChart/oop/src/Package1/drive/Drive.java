package Package1.drive;

import Package1.File;

public interface Drive {
    void addFile(File file);
    void listFiles();
    File findFile(String name);

}

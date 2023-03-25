package Package1.drive;

import Package1.File;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SSDDrive implements Drive {

    Map<String, File> files = new HashMap<>();

   @Override
    public void addFile(File file) {
      files.put(file.toString(),file);
    }

    @Override
    public void listFiles() {
        Collection<File> filesCollection = files.values();

        for (File file: filesCollection){
            System.out.println(file.getName());
        }
    }

    @Override
    public File findFile(String name) {
        return files.get(name);
    }
}

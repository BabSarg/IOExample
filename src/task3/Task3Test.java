package task3;

import java.io.File;

public class Task3Test {

    public static void main(String[] args) {

        File file = new File("temp");
        File[] files = file.listFiles();
        removeTmpFile(files);
    }

    private static void removeTmpFile(File[] files){
        for (File file : files) {
            if(file.isDirectory()){
                if(file.listFiles() != null){
                    removeTmpFile(file.listFiles());
                }
            }else {
                if(file.getAbsolutePath().endsWith(".tmp")){
                    file.delete();
                }
            }
        }
    }
}

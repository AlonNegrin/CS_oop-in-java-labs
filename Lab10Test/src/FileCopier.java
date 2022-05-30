import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileCopier implements Runnable {

    private final String fileName;

    public FileCopier(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void run() {
        while (true) {
            try {
                FileReader fileReader = new FileReader(this.fileName);
                int i;
                while ((i = fileReader.read()) != -1)
                    System.out.print((char) i);
                fileReader.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }

        }
    }
}




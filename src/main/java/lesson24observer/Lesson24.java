package lesson24observer;

import lesson24observer.copyfiles.CopyFilesBuiltInBufferedTask;
import lesson24observer.copyfiles.Observer;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lesson24 {
    public static void main(String[] args) {
        File inputFile = new File("E:\\IntelliJ\\StudyHillel\\lesson23\\files\\german.data");
        File outputFile = new File("E:\\IntelliJ\\StudyHillel\\lesson23\\files\\out\\newFile.data");

        CopyFilesBuiltInBufferedTask copyfile = new CopyFilesBuiltInBufferedTask(inputFile, outputFile, new ConsoleLogger());
        ExecutorService executor = Executors.newSingleThreadExecutor();
        final Future<?> result2 = executor.submit(copyfile);
        executor.shutdown();
    }
}

class ConsoleLogger implements Observer {

    @Override
    public void onProgressUpdated(long receiveBytes, long totalBytes) {
        System.out.println(String.format("Progress: %d/%d", receiveBytes, totalBytes));
    }

    @Override
    public void onDownloadCompleted(File outputFile) {
        System.out.println("Completed");
    }
}

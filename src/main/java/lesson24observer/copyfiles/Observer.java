package lesson24observer.copyfiles;

import java.io.File;

/**
 * The observer interface to provide information about current progress pf the task
 */
public interface Observer {
    /**
     * Notification an observer about current progress data
     * @param receiveBytes
     * @param totalBytes
     */
    void onProgressUpdated(long receiveBytes, long totalBytes);

    /**
     *
     * @param outputFile
     */
    void onDownloadCompleted(File outputFile);
}

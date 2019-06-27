package lesson24observer.copyfiles;

import java.io.*;

public class CopyFilesBuiltInBufferedTask extends AbstractCopyFilesTask {
    private final Observer observer;
    public CopyFilesBuiltInBufferedTask(File aSource, File aDest, Observer aObserver) {
        super(aSource, aDest);
        this.observer = aObserver;
    }

    @Override
    protected void copyFiles(File source, File dest) throws IOException {
        final InputStream sourceStream = new BufferedInputStream(new FileInputStream(source));
        final OutputStream destStream = new BufferedOutputStream(new FileOutputStream(dest));

        final long totalSize = source.length();
        long readCount = 0;

        while (sourceStream.available() > 0) {
            int readByte = sourceStream.read();
            destStream.write(readByte);
            readCount++;

            observer.onProgressUpdated(readCount, totalSize);
        }
        observer.onDownloadCompleted(dest);
    }

}

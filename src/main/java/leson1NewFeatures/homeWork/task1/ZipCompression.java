package leson1NewFeatures.homeWork.task1;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompression implements CompressionStrategy{
    private final ZipEntry zipEntry;

    public ZipCompression(String inSile) {
        zipEntry = new ZipEntry(inSile);
    }

    @Override
    public OutputStream compress(OutputStream data) throws IOException {
        ZipOutputStream out = new ZipOutputStream(data);
        out.putNextEntry(zipEntry);
        out.setMethod(ZipOutputStream.STORED);
        out.setLevel(Deflater.BEST_COMPRESSION);
        return out;
    }
}

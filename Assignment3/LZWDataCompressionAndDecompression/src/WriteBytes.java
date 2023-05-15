import java.io.*;

public class WriteBytes {

    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("binaryfile.bin", "rw");

            // The range for bytes in Java is -128 - +127.
            for (byte b=-10; b<10; b++)
            {
                file.writeByte(b);
            }

            for (char c='a'; c<='z'; c++) {
                file.writeByte(c);
            }
            file.close();

        }
        catch (Exception e)
        {
            System.out.println("An IO Error occurred. " + e);
        }
    }

}
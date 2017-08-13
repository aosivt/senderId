package sender.UIObject.FillingUI.DragFileUploadPanel;

import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UploadConfigeFileCSV implements
        Receiver {
private int counter;
private int total;
private boolean sleep;
private List<Byte> bytesFiles = new ArrayList<>();



    @Override
    public OutputStream receiveUpload(String filename, String mimeType) {

        return new OutputStream() {
            private static final int searchedByte = '\n';
            @Override
            public void write(final int b) throws IOException {
                total++;
                if (b == searchedByte) {
                    counter++;
                }

                if (sleep && total % 1000 == 0) {
                    try {
                        Thread.sleep(100);
                    } catch (final InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (b==-1){
                    System.err.print("adsfasdf");
                }
                bytesFiles.add(new Byte((byte) b));


            }
        };

    }

    public int getLineBreakCount(){
        return counter;
    }

    public void setSlow(boolean value){
        sleep = value;
    }

    private byte[] getBytesFiles() {
        return bytesFiles.stream()
                .collect(
                        () -> new ByteArrayOutputStream(),
                        (z,e) -> {
                            z.write(e);
                        },(a,b) -> {}).toByteArray();
    }
    public void createRow(CreataRowAllDB creataRowAllDB){

        try {
            File temp = File.createTempFile("temp","log",null);
            FileOutputStream fostemp = new FileOutputStream(temp);
            fostemp.write(getBytesFiles());

            BufferedReader br  = new BufferedReader(new FileReader(temp));
            String line;
            while ((line = br.readLine())!=null)
            {
                String[] tempStringArray = line.split(";");
                creataRowAllDB.addObjectToDB(
                        tempStringArray[0],
                        tempStringArray[1],
                        tempStringArray[2],
                        tempStringArray[3],
                        tempStringArray[4]
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

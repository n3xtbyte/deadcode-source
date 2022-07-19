/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

public class fn {
    public static String a(File file, String string) {
        Object object;
        Date date = null;
        try {
            object = Files.readAttributes(file.toPath(), BasicFileAttributes.class, new LinkOption[0]);
            long l2 = object.creationTime().to(TimeUnit.MILLISECONDS);
            if (l2 > Long.MIN_VALUE && l2 < Long.MAX_VALUE) {
                date = new Date(object.creationTime().to(TimeUnit.MILLISECONDS));
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        object = null;
        if (date != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
            object = simpleDateFormat.format(date);
        }
        return object;
    }

    public static void a(String string, String string2) {
        fn.a(string, string2, false);
    }

    public static void a(String string, String string2, boolean bl) {
        try {
            File file = new File(string2);
            if (file.exists()) {
                if (bl) {
                    file.delete();
                } else {
                    return;
                }
            }
            URL uRL = new URL(string);
            HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
            httpURLConnection.addRequestProperty(\u200b\u2000.void()[14], \u200b\u2000.void()[13]);
            ReadableByteChannel readableByteChannel = Channels.newChannel(httpURLConnection.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream(string2);
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0L, Long.MAX_VALUE);
            fileOutputStream.close();
        }
        catch (Exception exception) {
            ChatUtils.exception("downloadFile", exception);
        }
    }

    public static BufferedImage a(String string) {
        File file = new File(string);
        try {
            return ImageIO.read(file);
        }
        catch (Exception exception) {
            ChatUtils.exception("imageFromFile", exception);
            return null;
        }
    }

    public static void a(File file, List list, boolean bl, boolean bl2) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, !bl2));
            for (String string : list) {
                bufferedWriter.write(string);
                bufferedWriter.flush();
                if (!bl) continue;
                bufferedWriter.newLine();
            }
        }
        catch (Exception exception) {
            ChatUtils.exception("writeFile", exception);
        }
        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static List a(File file) {
        ArrayList<String> arrayList = new ArrayList<String>();
        BufferedReader bufferedReader = null;
        try {
            String string;
            bufferedReader = new BufferedReader(new FileReader(file));
            while ((string = bufferedReader.readLine()) != null) {
                arrayList.add(string);
            }
        }
        catch (Exception exception) {
            ChatUtils.exception("readFile", exception);
        }
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return arrayList;
    }
}


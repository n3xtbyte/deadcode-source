/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraftforge.client.event.ScreenshotEvent
 */
package i.gishreloaded.deadcode.hacks.other;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.ScreenshotEvent;

public class AutoImgur
extends Hack {
    public ByteArrayOutputStream a;
    public ExecutorService b;

    public AutoImgur(String string) {
        super(string, HackCategory.Other);
    }

    @Override
    public String getDescription() {
        return "Automatically uploads a screenshot to Imgur.";
    }

    @Override
    public void onScreenshotEvent(ScreenshotEvent screenshotEvent) {
        this.a = new ByteArrayOutputStream();
        if (this.b == null) {
            this.b = Executors.newCachedThreadPool();
        }
        this.a(screenshotEvent.getImage());
        super.onScreenshotEvent(screenshotEvent);
    }

    public void a(BufferedImage bufferedImage) {
        this.b.execute(() -> {
            Thread.currentThread().setName("Imgur Image Uploading");
            try {
                String string;
                URL uRL = new URL(\u200b\u2000.void()[8]);
                HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Authorization", \u200b\u2000.void()[9]);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.connect();
                ImageIO.write((RenderedImage)bufferedImage, "png", this.a);
                this.a.flush();
                byte[] byArray = this.a.toByteArray();
                String string2 = Base64.getEncoder().encodeToString(byArray);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
                String string3 = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(string2, "UTF-8");
                outputStreamWriter.write(string3);
                outputStreamWriter.flush();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                while ((string = bufferedReader.readLine()) != null) {
                    stringBuilder.append(string).append("\n");
                }
                outputStreamWriter.close();
                bufferedReader.close();
                JsonObject jsonObject = new JsonParser().parse(stringBuilder.toString()).getAsJsonObject();
                String string4 = jsonObject.get("data").getAsJsonObject().get("link").getAsString();
                Wrapper.INSTANCE.getMinecraft().displayGuiScreen((GuiScreen)new GuiChat(string4));
            }
            catch (Exception exception) {
                ChatUtils.exception("uploadImage", exception);
            }
        });
    }
}


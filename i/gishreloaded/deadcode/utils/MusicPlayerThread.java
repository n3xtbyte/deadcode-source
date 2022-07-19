/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.utils;

import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public final class MusicPlayerThread
extends Thread {
    public final /* synthetic */ File a;
    public final /* synthetic */ float b;

    public MusicPlayerThread(File file, float f2) {
        this.a = file;
        this.b = f2;
    }

    @Override
    public void run() {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(this.a));
            FloatControl floatControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            floatControl.setValue(this.b);
            clip.start();
        }
        catch (Exception exception) {
            ChatUtils.exception("playSound", exception);
            ChatUtils.error("Supports only .wav audio formats!");
        }
        super.run();
    }
}


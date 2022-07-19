/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.managers;

import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import java.util.ArrayList;

public class FriendManager {
    public static ArrayList a = new ArrayList();

    public static void a(String string) {
        if (a.contains(string)) {
            FriendManager.c(string);
        } else {
            FriendManager.b(string);
        }
    }

    public static void b(String string) {
        if (!a.contains(string)) {
            a.add(string);
            FriendManager.b();
            ChatUtils.info(string + " Added to \u00a7bfriend \u00a77list.");
        }
    }

    public static void c(String string) {
        if (a.contains(string)) {
            a.remove(string);
            FriendManager.b();
            if (\u2007\u2008\u00a0.l != null) {
                \u2007\u2008\u00a0.l.a(string);
            }
            ChatUtils.info(string + " Removed from \u00a7bfriend \u00a77list.");
        }
    }

    public static void a() {
        if (!a.isEmpty()) {
            a.clear();
            FriendManager.b();
            ChatUtils.info("\u00a7bFriends \u00a77list clear.");
        }
    }

    private static /* synthetic */ void b() {
        try {
            if (\u2001\u2000\u00a0.g != null) {
                \u2001\u2000\u00a0.g.super();
            }
        }
        catch (Exception exception) {
            ChatUtils.exception("FriendManager: save", exception);
        }
    }
}


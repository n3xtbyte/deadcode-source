/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 */
package i.gishreloaded.deadcode.managers;

import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.xray.XRayData;
import java.util.LinkedList;
import net.minecraft.block.Block;

public class XRayManager {
    public static LinkedList a = new LinkedList();

    private static /* synthetic */ void b() {
        try {
            if (\u2001\u2000\u00a0.g != null) {
                \u2001\u2000\u00a0.g.case();
            }
        }
        catch (Exception exception) {
            ChatUtils.exception("XRayManager: saveXRayData", exception);
        }
    }

    public static void a() {
        if (!a.isEmpty()) {
            a.clear();
            XRayManager.b();
            ChatUtils.info("\u00a7dXRay \u00a77list clear.");
        }
    }

    public static LinkedList a(int n2) {
        LinkedList<XRayData> linkedList = new LinkedList<XRayData>();
        for (XRayData xRayData : a) {
            if (xRayData.getId() != n2) continue;
            linkedList.add(xRayData);
        }
        return linkedList;
    }

    public static XRayData b(int n2) {
        XRayData xRayData = null;
        for (XRayData xRayData2 : a) {
            if (xRayData2.getMeta() != n2) continue;
            xRayData = xRayData2;
        }
        return xRayData;
    }

    public static void a(XRayData xRayData) {
        if (Block.getBlockById((int)xRayData.getId()) == null) {
            ChatUtils.error("Block is null.");
            return;
        }
        LinkedList linkedList = XRayManager.a(xRayData.getId());
        if (linkedList.isEmpty()) {
            XRayManager.b(xRayData);
            return;
        }
        boolean bl = false;
        boolean bl2 = false;
        for (XRayData xRayData2 : linkedList) {
            if (xRayData2.getId() == xRayData.getId()) {
                bl = true;
            }
            if (xRayData2.getMeta() != xRayData.getMeta()) continue;
            bl2 = true;
        }
        if (bl && bl2) {
            return;
        }
        XRayManager.b(xRayData);
    }

    public static void b(XRayData xRayData) {
        a.add(xRayData);
        XRayManager.b();
        ChatUtils.info(String.format("\u00a77ID: \u00a73%s \u00a77META: \u00a73%s \u00a77NAME: \u00a73%s \u00a77RGB: \u00a7c%s\u00a77, \u00a7a%s\u00a77, \u00a79%s \u00a77- ADDED.", xRayData.getId(), xRayData.getMeta(), Block.getBlockById((int)xRayData.getId()).getLocalizedName(), xRayData.getRed(), xRayData.getGreen(), xRayData.getBlue()));
    }

    public static void c(int n2) {
        for (XRayData xRayData : XRayManager.a(n2)) {
            if (!a.contains(xRayData)) continue;
            a.remove(xRayData);
            XRayManager.b();
            ChatUtils.info(String.format("\u00a77ID: \u00a73%s \u00a77NAME: \u00a73%s \u00a77RGB: \u00a7c%s\u00a77, \u00a7a%s\u00a77, \u00a79%s \u00a77- REMOVED.", xRayData.getId(), Block.getBlockById((int)xRayData.getId()).getLocalizedName(), xRayData.getRed(), xRayData.getGreen(), xRayData.getBlue()));
        }
    }
}


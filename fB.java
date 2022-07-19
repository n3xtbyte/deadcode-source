/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 */
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import java.util.Iterator;
import java.util.LinkedList;
import net.minecraft.item.Item;

public class fB {
    public static LinkedList a = new LinkedList();

    private static /* synthetic */ void b() {
        try {
            if (\u2001\u2000\u00a0.g != null) {
                \u2001\u2000\u00a0.g.goto();
            }
        }
        catch (Exception exception) {
            ChatUtils.exception("PickupFilterManager: savePickupFilter", exception);
        }
    }

    public static void a(int n2) {
        try {
            if (Item.getItemById((int)n2) == null) {
                ChatUtils.error("Item is null.");
                return;
            }
            Iterator iterator = a.iterator();
            while (iterator.hasNext()) {
                int n3 = (Integer)iterator.next();
                if (n3 != n2) continue;
                ChatUtils.error("Item already added.");
                return;
            }
            a.add(n2);
            \u2001\u2000\u00a0.g.goto();
            ChatUtils.info(String.format("\u00a77ID: \u00a73%s \u00a77NAME: \u00a73%s \u00a77- ADDED.", n2, Item.getItemById((int)n2).getTranslationKey()));
        }
        catch (Exception exception) {
            ChatUtils.exception("PickUpFilterManager: addItem", exception);
        }
    }

    public static void b(int n2) {
        Iterator iterator = a.iterator();
        while (iterator.hasNext()) {
            int n3 = (Integer)iterator.next();
            if (n3 != n2) continue;
            a.remove((Object)n2);
            ChatUtils.info(String.format("\u00a77ID: \u00a73%s \u00a77- REMOVED.", n2));
            fB.b();
            return;
        }
        ChatUtils.error("Item not found.");
    }

    public static void a() {
        if (a.isEmpty()) {
            return;
        }
        a.clear();
        fB.b();
        ChatUtils.info("\u00a7dPickupFilter \u00a77list clear.");
    }
}


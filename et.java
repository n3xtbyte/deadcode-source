/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemArmor$ArmorMaterial
 *  net.minecraft.item.ItemAxe
 *  net.minecraft.item.ItemPotion
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.math.AxisAlignedBB
 */
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;

public class et {
    private static final String[] b = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "l", "n", "f", "r"};
    public static final char[] a = "0123456789ABCDEF".toCharArray();

    public static boolean a(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean a() {
        return Wrapper.INSTANCE.getLocalPlayer() == null || Wrapper.INSTANCE.getWorld() == null;
    }

    public static int a(long l2) {
        return (int)(l2 / 1024L / 1024L);
    }

    public static List b() {
        return Wrapper.INSTANCE.getWorld().getLoadedEntityList();
    }

    public static List c() {
        return Wrapper.INSTANCE.getWorld().playerEntities;
    }

    public static boolean a(ItemStack itemStack) {
        return itemStack == null || itemStack.isEmpty();
    }

    public static void a(int n2, int n3, int n4, ClickType clickType) {
        cs.a.b().windowClick(n2, n3, n4, clickType, (EntityPlayer)Wrapper.INSTANCE.getLocalPlayer());
    }

    public static void a(int n2, int n3, int n4) {
        Wrapper.INSTANCE.getLocalPlayer().addPotionEffect(new PotionEffect(Potion.getPotionById((int)n2), n3, n4));
    }

    public static void a(int n2) {
        Wrapper.INSTANCE.getLocalPlayer().removePotionEffect(Potion.getPotionById((int)n2));
    }

    public static void d() {
        for (PotionEffect potionEffect : Wrapper.INSTANCE.getLocalPlayer().getActivePotionEffects()) {
            Wrapper.INSTANCE.getLocalPlayer().removePotionEffect(potionEffect.getPotion());
        }
    }

    public static String b(String string) {
        return Character.toString(string.toLowerCase().charAt(0)).toUpperCase() + string.toLowerCase().substring(1);
    }

    public static String a(EntityPlayer entityPlayer) {
        return entityPlayer.getGameProfile() != null ? entityPlayer.getGameProfile().getName() : "null";
    }

    public static boolean b(EntityPlayer entityPlayer) {
        ItemStack itemStack = entityPlayer.getHeldItemOffhand();
        ItemStack itemStack2 = entityPlayer.getHeldItemMainhand();
        return !et.a(itemStack) && itemStack.getItem() == Items.SHIELD && entityPlayer.getItemInUseCount() > 0 || !et.a(itemStack2) && itemStack2.getItem() == Items.SHIELD && entityPlayer.getItemInUseCount() > 0;
    }

    public static boolean e() {
        ItemStack itemStack = Wrapper.INSTANCE.getLocalPlayer().getHeldItemMainhand();
        return !et.a(itemStack) && (itemStack.getItem() instanceof ItemSword || itemStack.getItem() instanceof ItemAxe);
    }

    public static boolean f() {
        ItemStack itemStack = Wrapper.INSTANCE.getLocalPlayer().getHeldItemOffhand();
        return !et.a(itemStack) && itemStack.getItem() == Items.SHIELD;
    }

    public static boolean g() {
        ItemStack itemStack = Wrapper.INSTANCE.getLocalPlayer().getHeldItemMainhand();
        return !et.a(itemStack) && itemStack.getItem() instanceof ItemPotion;
    }

    public static boolean h() {
        return Wrapper.INSTANCE.getLocalPlayer().getHealth() == 0.0f || Wrapper.INSTANCE.getLocalPlayer().isDead;
    }

    public static boolean a(EntityLivingBase entityLivingBase) {
        return !et.b((EntityLivingBase)Wrapper.INSTANCE.getLocalPlayer()).equals(et.b(entityLivingBase));
    }

    public static String b(EntityLivingBase entityLivingBase) {
        String string = entityLivingBase.getDisplayName().getFormattedText();
        if (string.contains("\u00a7")) {
            if (string.contains("\u00a71")) {
                return "\u00a71";
            }
            if (string.contains("\u00a72")) {
                return "\u00a72";
            }
            if (string.contains("\u00a73")) {
                return "\u00a73";
            }
            if (string.contains("\u00a74")) {
                return "\u00a74";
            }
            if (string.contains("\u00a75")) {
                return "\u00a75";
            }
            if (string.contains("\u00a76")) {
                return "\u00a76";
            }
            if (string.contains("\u00a77")) {
                return "\u00a77";
            }
            if (string.contains("\u00a78")) {
                return "\u00a78";
            }
            if (string.contains("\u00a79")) {
                return "\u00a79";
            }
            if (string.contains("\u00a70")) {
                return "\u00a70";
            }
            if (string.contains("\u00a7e")) {
                return "\u00a7e";
            }
            if (string.contains("\u00a7d")) {
                return "\u00a7d";
            }
            if (string.contains("\u00a7a")) {
                return "\u00a7a";
            }
            if (string.contains("\u00a7b")) {
                return "\u00a7b";
            }
            if (string.contains("\u00a7c")) {
                return "\u00a7c";
            }
            if (string.contains("\u00a7f")) {
                return "\u00a7f";
            }
        }
        return "null";
    }

    public static String c(String string) {
        if (string.contains("\u00a7")) {
            for (String string2 : b) {
                string = string.replaceAll("\u00a7" + string2, "");
            }
        }
        return string;
    }

    public static int a(EntityPlayer entityPlayer, ItemStack itemStack) {
        if (entityPlayer == null || itemStack == null || itemStack.getItem() == null || !(itemStack.getItem() instanceof ItemArmor)) {
            return -1;
        }
        ItemArmor itemArmor = (ItemArmor)itemStack.getItem();
        if (itemArmor == null || itemArmor.getArmorMaterial() != ItemArmor.ArmorMaterial.LEATHER) {
            return -1;
        }
        return itemArmor.getColor(itemStack);
    }

    public static boolean c(EntityPlayer entityPlayer) {
        int n2 = et.a(entityPlayer, entityPlayer.inventory.armorItemInSlot(0));
        int n3 = et.a(entityPlayer, entityPlayer.inventory.armorItemInSlot(1));
        int n4 = et.a(entityPlayer, entityPlayer.inventory.armorItemInSlot(2));
        int n5 = et.a(entityPlayer, entityPlayer.inventory.armorItemInSlot(3));
        int n6 = et.a((EntityPlayer)Wrapper.INSTANCE.getLocalPlayer(), cs.a.a().armorItemInSlot(0));
        int n7 = et.a((EntityPlayer)Wrapper.INSTANCE.getLocalPlayer(), cs.a.a().armorItemInSlot(1));
        int n8 = et.a((EntityPlayer)Wrapper.INSTANCE.getLocalPlayer(), cs.a.a().armorItemInSlot(2));
        int n9 = et.a((EntityPlayer)Wrapper.INSTANCE.getLocalPlayer(), cs.a.a().armorItemInSlot(3));
        return !(n2 == n6 && n6 != -1 && n2 != 1 || n3 == n7 && n7 != -1 && n3 != 1 || n4 == n8 && n8 != -1 && n4 != 1) && (n5 != n9 || n9 == -1 || n5 == 1);
    }

    public static int d(EntityPlayer entityPlayer) {
        ItemStack[] itemStackArray;
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        InventoryPlayer inventoryPlayer = entityPlayer.inventory;
        ItemStack itemStack = entityPlayer.getHeldItemMainhand();
        ItemStack itemStack2 = inventoryPlayer.armorItemInSlot(0);
        ItemStack itemStack3 = inventoryPlayer.armorItemInSlot(1);
        ItemStack itemStack4 = inventoryPlayer.armorItemInSlot(2);
        ItemStack itemStack5 = inventoryPlayer.armorItemInSlot(3);
        for (ItemStack itemStack6 : itemStackArray = new ItemStack[]{itemStack, itemStack5, itemStack4, itemStack3, itemStack2}) {
            if (et.a(itemStack6)) continue;
            arrayList.add(itemStack6);
        }
        return arrayList.size();
    }

    public static void a(double d2, double d3, double d4) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        entityPlayerSP.setPosition(d2, d3, d4);
        Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayer.Position(d2, d3, d4, entityPlayerSP.onGround));
        entityPlayerSP.attemptTeleport(d2, d3, d4);
    }

    public static void b(double d2, double d3, double d4) {
        et.a(d2, d3 + 1.0, d4);
        new dT(d2, d3, d4).start();
    }

    public static void i() {
        if (Wrapper.INSTANCE.getLocalPlayer().onGround) {
            Wrapper.INSTANCE.getLocalPlayer().motionY = 0.42f;
        }
    }

    public static boolean j() {
        return !(Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiScreen);
    }

    public static void a(Entity entity, float f2, float f3) {
        fl fl2 = fl.a(entity);
        entity.width = fl2.a;
        entity.height = fl2.b;
        double d2 = (double)f2 / 2.0;
        entity.setEntityBoundingBox(new AxisAlignedBB(entity.posX - d2, entity.posY, entity.posZ - d2, entity.posX + d2, entity.posY + (double)f3, entity.posZ + d2));
    }

    public static void a(Entity entity) {
        fl fl2 = fl.a(entity);
        entity.width = fl2.a;
        entity.height = fl2.b;
        double d2 = (double)entity.width / 2.0;
        entity.setEntityBoundingBox(new AxisAlignedBB(entity.posX - d2, entity.posY, entity.posZ - d2, entity.posX + d2, entity.posY + (double)entity.height, entity.posZ + d2));
    }

    public static String k() {
        String string = "v3.8";
        try {
            double d2 = Double.parseDouble("3.8");
            if (d2 < 1.0 && d2 > 0.09) {
                string = string + "b";
            } else if (d2 <= 0.09) {
                string = string + "a";
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return string;
    }

    public static String a(Runtime runtime, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Process process = runtime.exec(string);
            InputStream inputStream = process.getInputStream();
            int n2 = 0;
            while ((n2 = inputStream.read()) != -1) {
                stringBuilder.append((char)n2);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return stringBuilder.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package i.gishreloaded.deadcode.managers;

import net.minecraft.client.Minecraft;

public class MappingManager {
    public static String fieldSession = MappingManager.isInstanceNotNull() ? "session" : "field_71449_j";
    public static String fieldPosX = MappingManager.isInstanceNotNull() ? "x" : "field_149479_a";
    public static String fieldPosY = MappingManager.isInstanceNotNull() ? "y" : "field_149477_b";
    public static String fieldPosZ = MappingManager.isInstanceNotNull() ? "z" : "field_149478_c";
    public static String fieldMoving = MappingManager.isInstanceNotNull() ? "moving" : "field_149480_h";
    public static String fieldRotationYaw = MappingManager.isInstanceNotNull() ? "yaw" : "field_149476_e";
    public static String fieldRotationPitch = MappingManager.isInstanceNotNull() ? "pitch" : "field_149473_f";
    public static String fieldOnGround = MappingManager.isInstanceNotNull() ? "onGround" : "field_149474_g";
    public static String fieldRotationYaw1 = MappingManager.isInstanceNotNull() ? "yaw" : "field_148936_d";
    public static String fieldRotationPitch1 = MappingManager.isInstanceNotNull() ? "pitch" : "field_148937_e";
    public static String fieldIsRotating = MappingManager.isInstanceNotNull() ? "rotating" : "field_149481_i";
    public static String fieldRightClickDelayTimer = MappingManager.isInstanceNotNull() ? "rightClickDelayTimer" : "field_71467_ac";
    public static String funcGetPlayerInfo = MappingManager.isInstanceNotNull() ? "getPlayerInfo" : "func_175155_b";
    public static String fieldPlayerTextures = MappingManager.isInstanceNotNull() ? "playerTextures" : "field_187107_a";
    public static String fieldCurrentGameType = MappingManager.isInstanceNotNull() ? "currentGameType" : "field_78779_k";
    public static String fieldConnection = MappingManager.isInstanceNotNull() ? "connection" : "field_78774_b";
    public static String fieldBlockHitDelay = MappingManager.isInstanceNotNull() ? "blockHitDelay" : "field_78781_i";
    public static String fieldIsInWeb = MappingManager.isInstanceNotNull() ? "isInWeb" : "field_70134_J";
    public static String fieldCurrentBlockDamageMP = MappingManager.isInstanceNotNull() ? "curBlockDamageMP" : "field_78770_f";
    public static String fieldIsHittingBlock = MappingManager.isInstanceNotNull() ? "isHittingBlock" : "field_78778_j";
    public static String funcOnUpdateWalkingPlayer = MappingManager.isInstanceNotNull() ? "onUpdateWalkingPlayer" : "func_175161_p";
    public static String fieldFire = MappingManager.isInstanceNotNull() ? "fire" : "field_190534_ay";
    public static String fieldIsImmuneToFire = MappingManager.isInstanceNotNull() ? "isImmuneToFire" : "field_70178_ae";
    public static String fieldHitVec = MappingManager.isInstanceNotNull() ? "hitVec" : "field_179713_c";
    public static String fieldPlayerController = MappingManager.isInstanceNotNull() ? "playerController" : "field_71442_b";
    public static String fieldTimer = MappingManager.isInstanceNotNull() ? "timer" : "field_71428_T";
    public static String fieldTickLength = MappingManager.isInstanceNotNull() ? "tickLength" : "field_194149_e";
    public static String fieldWindowId = MappingManager.isInstanceNotNull() ? "windowId" : "field_149556_a";
    public static String fieldTicksSinceLastSwing = MappingManager.isInstanceNotNull() ? "ticksSinceLastSwing" : "field_184617_aD";
    public static String fieldItemColors = MappingManager.isInstanceNotNull() ? "itemColors" : "field_184128_aI";
    public static String fieldModelChanger = MappingManager.isInstanceNotNull() ? "modelManager" : "field_175617_aL";
    public static String fieldRenderItem = MappingManager.isInstanceNotNull() ? "renderItem" : "field_175621_X";
    public static String fieldItemRenderer = MappingManager.isInstanceNotNull() ? "itemRenderer" : "field_73841_b";
    public static String fieldJumpTicks = MappingManager.isInstanceNotNull() ? "jumpTicks" : "field_70773_bE";
    public static String fieldSpeedInAir = MappingManager.isInstanceNotNull() ? "speedInAir" : "field_71102_ce";

    public static boolean isInstanceNotNull() {
        try {
            return Minecraft.class.getDeclaredField("instance") != null;
        }
        catch (Exception exception) {
            return false;
        }
    }
}


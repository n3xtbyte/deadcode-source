/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.entity.MoverType
 *  net.minecraft.util.MovementInput
 *  net.minecraft.world.World
 */
import com.mojang.authlib.GameProfile;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.MoverType;
import net.minecraft.util.MovementInput;
import net.minecraft.world.World;

/*
 * Renamed from dv
 */
public class dv_0
extends EntityOtherPlayerMP {
    public static MovementInput a;

    public dv_0(World world, GameProfile gameProfile) {
        super(world, gameProfile);
    }

    public void a(MovementInput movementInput) {
        a = movementInput;
        if (movementInput.jump && this.onGround) {
            super.jump();
        }
        super.moveRelative(movementInput.moveStrafe, this.moveVertical, movementInput.moveForward, this.movedDistance);
    }

    public void a(MoverType moverType, double d2, double d3, double d4) {
        this.onGround = true;
        super.move(moverType, d2, d3, d4);
        this.onGround = true;
    }

    public boolean a() {
        return false;
    }

    public void b() {
        super.onLivingUpdate();
        this.noClip = true;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.noClip = false;
    }
}


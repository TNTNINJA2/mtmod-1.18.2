package net.tntninja2.mtmod.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.tntninja2.mtmod.MTMod;
import net.tntninja2.mtmod.networking.packet.*;
import net.tntninja2.mtmod.networking.packet.animation.SlateCannonLaserS2CPacket;
import net.tntninja2.mtmod.networking.packet.animation.SlateJumperCrouchS2CPacket;
import net.tntninja2.mtmod.networking.packet.animation.SlateJumperJumpS2CPacket;
import net.tntninja2.mtmod.networking.packet.animation.SlateJumperRollS2CPacket;

public class ModMessages {
    public static final Identifier DASH_ID = new Identifier(MTMod.MOD_ID, "dashing");
    public static final Identifier DASH_COOL_DOWN_ID = new Identifier(MTMod.MOD_ID, "dashing");
    public static final Identifier PET_SPAWN_ID = new Identifier(MTMod.MOD_ID, "pet_spawn");
    public static final Identifier EXAMPLE_ID = new Identifier(MTMod.MOD_ID, "example");
    public static final Identifier INVULNERABILITY_TICKS_ID = new Identifier(MTMod.MOD_ID, "invulnerability_ticks");

    public static final Identifier SYNC_DASH_MAX_ENERGY_ID = new Identifier(MTMod.MOD_ID, "sync_player_data_int");

    public static final Identifier LIGHT_ATTACK_ID = new Identifier(MTMod.MOD_ID, "light_attack_int");
    public static final Identifier HEAVY_ATTACK_ID = new Identifier(MTMod.MOD_ID, "heavy_attack_int");


    public static final Identifier ANIM_SLATE_JUMPER_JUMP_ID = new Identifier(MTMod.MOD_ID, "anim_slate_jumper_jump");
    public static final Identifier ANIM_SLATE_JUMPER_CROUCH_ID = new Identifier(MTMod.MOD_ID, "anim_slate_jumper_crouch");
    public static final Identifier ANIM_SLATE_JUMPER_ROLL_ID = new Identifier(MTMod.MOD_ID, "anim_slate_jumper_roll");

    public static final Identifier ANIM_SLATE_CANNON_LASER_ID = new Identifier(MTMod.MOD_ID, "anim_slate_cannon_laser");



    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(DASH_ID, DashingC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(PET_SPAWN_ID, PetSpawnC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(INVULNERABILITY_TICKS_ID, SyncInvulnerabilityTicksC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(LIGHT_ATTACK_ID, LightAttackC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(HEAVY_ATTACK_ID, HeavyAttackC2SPacket::receive);
    }

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(SYNC_DASH_MAX_ENERGY_ID, SyncDashMaxEnergyS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(ANIM_SLATE_JUMPER_JUMP_ID, SlateJumperJumpS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(ANIM_SLATE_JUMPER_CROUCH_ID, SlateJumperCrouchS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(ANIM_SLATE_JUMPER_ROLL_ID, SlateJumperRollS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(ANIM_SLATE_CANNON_LASER_ID, SlateCannonLaserS2CPacket::receive);



    }



}

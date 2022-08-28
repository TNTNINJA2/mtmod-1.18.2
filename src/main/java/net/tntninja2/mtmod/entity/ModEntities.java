package net.tntninja2.mtmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.tntninja2.mtmod.MTMod;
import net.tntninja2.mtmod.entity.custom.*;

public class ModEntities {
    public static final EntityType<MythrilGolemEntity> MYTHRIL_GOLEM = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MTMod.MOD_ID, "mythril_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MythrilGolemEntity::new)
                    .dimensions(EntityDimensions.fixed(1f,1.3f)).build());

    public static final EntityType<AcidSlimeEntity> ACID_SLIME = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MTMod.MOD_ID, "acid_slime"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AcidSlimeEntity::new)
                    .dimensions(EntityDimensions.fixed(1f,1f)).build());

    public static final EntityType<WingedBeastEntity> WINGED_BEAST = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MTMod.MOD_ID, "winged_beast"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WingedBeastEntity::new)
                    .dimensions(EntityDimensions.fixed(1f,1f)).build());

    public static final EntityType<PetTestEntity> PET_TEST = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MTMod.MOD_ID, "pet_test"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PetTestEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5625f,0.5625f)).build());

    public static final EntityType<TuffJumperEntity> TUFF_JUMPER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MTMod.MOD_ID, "tuff_jumper"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TuffJumperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.7f,1f)).build());

//static {
//    ARMOR_STAND = register("armor_stand", EntityType.Builder.create(ArmorStandEntity::new, SpawnGroup.MISC)
//            .setDimensions(0.5F, 1.975F).maxTrackingRange(10));
//}
//
//    public static final EntityType<WingedBeastPart> WINGED_BEAST_PART = Registry.register(
//            Registry.ENTITY_TYPE, new Identifier(MTMod.MOD_ID, "winged_beast_part"),
//            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WingedBeastPart::new)
//                    .dimensions(EntityDimensions.fixed(1f,1f)).build());

}

package net.tntninja2.mtmod.entity.custom;

import net.minecraft.block.AirBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MyceliumBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.tntninja2.mtmod.MTMod;
import net.tntninja2.mtmod.block.ModBlocks;
import net.tntninja2.mtmod.goal.EscapeAcidGoal;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class AcidSlimeEntity extends PathAwareEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);


    public AcidSlimeEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }



    public static DefaultAttributeContainer.Builder setAttributes() {
    return AnimalEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0f)
            .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1f);
}

    public void tick() {
        super.tick();
        BlockPos pos = getBlockPos();
        placeAcid(pos);
        placeAcid(pos.north(1));
        placeAcid(pos.south(1));
        placeAcid(pos.west(1));
        placeAcid(pos.east(1));



    }

    private void placeAcid(BlockPos pos) {
        if (this.world.getBlockState(pos) == Blocks.AIR.getDefaultState()) {

            if ((this.world.getBlockState(pos.down(1)) != Blocks.AIR.getDefaultState()) &&
                    (this.world.getBlockState(pos.down(1)) != ModBlocks.ACID_BLOCK.getDefaultState())) {
                if (this.world.getBlockState(this.getBlockPos().down(1)) != ModBlocks.ACID_BLOCK.getDefaultState()) {
                    {
                        world.setBlockState(pos, ModBlocks.ACID_BLOCK.getDefaultState());

                    }
                }
            }
        }

    }



    protected void initGoals() {


        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(0, new EscapeAcidGoal(this,1));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 0.9f));
        this.goalSelector.add(1, new WanderAroundGoal(this, 0.9f));
//
//        this.goalSelector.add(5, new LookAroundGoal(this));



    }

    private  <E extends IAnimatable> PlayState predicate(@NotNull AnimationEvent<E> event) {
//        Logic for controlling animations

        event.getController().setAnimation((new AnimationBuilder().addAnimation("animation.acid_slime.move", true)));
        return PlayState.CONTINUE;


    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController((new AnimationController(this, "controller",
                0, this::predicate)));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15f, 1f);
    }

    protected EntityNavigation createNavigation(World world) {
        return new Navigation(this, world);
    }


    private static class Navigation extends MobNavigation{

        public Navigation(MobEntity mobEntity, World world) {
            super(mobEntity, world);
        }

        protected void adjustPath() {
            super.adjustPath();
            if (world.getBlockState(new BlockPos(this.entity.getX(), this.entity.getY() + 0.5, this.entity.getZ())) == ModBlocks.ACID_BLOCK.getDefaultState()) {
                return;
            }

            for(int i = 0; i < this.currentPath.getLength(); ++i) {
                PathNode pathNode = this.currentPath.getNode(i);
                if (this.world.getBlockState(new BlockPos(this.entity.getX(), this.entity.getY() + 0.5, this.entity.getZ())) == ModBlocks.ACID_BLOCK.getDefaultState()) {
                    this.currentPath.setLength(i);
                    return;
                }
            }


        }
    }

}

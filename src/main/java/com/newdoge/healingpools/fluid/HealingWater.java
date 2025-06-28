package com.newdoge.healingpools.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.world.WorldView;

import static com.newdoge.healingpools.HealingPools.*;
import static com.newdoge.healingpools.HealingPools.HEALING_BLOCK1;

public abstract class HealingWater extends HealingFluid {
    @Override
    public Fluid getStill() {
        return STILL_HEALING_WATER;
    }

    @Override
    public Fluid getFlowing() {
        return FLOWING_HEALING_WATER;
    }

    @Override
    public Item getBucketItem() {
        return HEALING_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return HEALING_BLOCK1.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    @Override
    protected int getMaxFlowDistance(WorldView world) {
        return 0;
    }


    public static class Flowing extends HealingWater {

        @Override
        protected  void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends HealingWater {

        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }

}

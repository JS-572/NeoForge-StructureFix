package net.js.jsmenu.block.custom.fluid;

import net.js.jsmenu.fluid.ModFluids;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class BromineBlock extends LiquidBlock {
    public BromineBlock() {
        super(ModFluids.BROMINE.get(), BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(-1.0f, 3600000).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
    }
}

package net.js.jsmenu.item.custom.bucket;

import net.js.jsmenu.fluid.ModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Items;

public class LightBlueLavaItem extends BucketItem {
    public LightBlueLavaItem() {
        super(ModFluids.LIGHT_BLUE_LAVA.get(), new Properties().craftRemainder(Items.BUCKET).stacksTo(1));
    }
}

package net.js.jsmenu.item.custom.bucket;

import net.js.jsmenu.fluid.ModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Items;

public class BrownLavaItem extends BucketItem {
    public BrownLavaItem() {
        super(ModFluids.BROWN_LAVA.get(), new Properties().craftRemainder(Items.BUCKET).stacksTo(1));
    }
}

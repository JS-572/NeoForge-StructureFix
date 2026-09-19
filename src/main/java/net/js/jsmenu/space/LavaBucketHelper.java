package net.js.jsmenu.space;

import net.js.jsmenu.item.ModItems;
import net.js.jsmenu.space.star.StarClass;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class LavaBucketHelper {
    private LavaBucketHelper() {
    }

    public static Item getLavaBucketForStarClass(StarClass starClass) {
        return switch (starClass) {
            case O -> ModItems.BLUE_LAVA_BUCKET.get();
            case B -> ModItems.LIGHT_BLUE_LAVA_BUCKET.get();
            case A -> ModItems.WHITE_LAVA_BUCKET.get();
            case F -> ModItems.LIGHT_YELLOW_LAVA_BUCKET.get();
            case G -> ModItems.YELLOW_LAVA_BUCKET.get();
            case M -> ModItems.RED_LAVA_BUCKET.get();
            case B2 -> ModItems.GREEN_LAVA_BUCKET.get();
            case M_MINUS -> ModItems.BROWN_LAVA_BUCKET.get();
            case Misc -> ModItems.PINK_LAVA_BUCKET.get();
            case BLACK_DWARF -> ModItems.BLACK_LAVA_BUCKET.get();
            case K -> Items.LAVA_BUCKET;
            case R2 -> ModItems.PURPLE_LAVA_BUCKET.get();
        };
    }
}

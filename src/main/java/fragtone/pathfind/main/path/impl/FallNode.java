package fragtone.pathfind.main.path.impl;

import net.minecraft.util.Vec3;
import fragtone.util.Util;
import fragtone.pathfind.main.path.Node;
import fragtone.pathfind.main.path.PathElm;

public class FallNode extends Node implements PathElm {
    public FallNode(int x, int y, int z) {
        super(x, y, z);
    }

    @Override
    public boolean playerOn(Vec3 playerPos) {
        return Util.toBlockPos(playerPos).equals(getBlockPos());
    }
}

package fragtone.pathfind.main.path.impl;

import net.minecraft.util.Vec3;
import fragtone.util.Util;
import fragtone.pathfind.main.path.Node;
import fragtone.pathfind.main.path.PathElm;

public class TravelNode extends Node implements PathElm {

    public TravelNode(int x, int y, int z) {
        super(x, y, z);
    }

    @Override
    public boolean playerOn(Vec3 playerPos) {
        return Util.toBlockPos(playerPos).equals(getBlockPos());
    }
}

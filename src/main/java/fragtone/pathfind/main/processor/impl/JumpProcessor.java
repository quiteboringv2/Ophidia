package fragtone.pathfind.main.processor.impl;

import fragtone.pathfind.main.path.PathElm;
import fragtone.pathfind.main.processor.Processor;

import java.util.List;

//TODO add more optimisations. Connect nodes if the jump is a slab or stair, which means we can just walk up it instead of jumping.

public class JumpProcessor extends Processor {

    @Override
    public void process(List<PathElm> elms) {
    }
}

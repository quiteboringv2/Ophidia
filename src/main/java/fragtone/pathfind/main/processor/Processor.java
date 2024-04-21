package fragtone.pathfind.main.processor;

import fragtone.pathfind.main.path.PathElm;

import java.util.List;

public abstract class Processor {
    public abstract void process(List<PathElm> elms);
}

package uk.ac.hw.macs.search.example;


public class FringeNode extends Node {
    public FringeNode(State state, FringeNode parent, int gCost, int hCost) {
        super(state, parent, gCost, hCost);
    }
}

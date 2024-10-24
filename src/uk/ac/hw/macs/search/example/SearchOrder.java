package uk.ac.hw.macs.search.example;

import java.util.List;
import java.util.Set;

public interface SearchOrder {
    void addToFringe(List<FringeNode> fringeList, FringeNode parent, Set<ChildWithCost> children);
}

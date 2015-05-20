package org.aksw.gerbil.matching.impl;

import java.util.List;

import org.aksw.gerbil.transfer.nif.Marking;

public interface MatchingsCounter<T extends Marking> {

    public static final int TRUE_POSITIVE_COUNT_ID = 0;
    public static final int FALSE_POSITIVE_COUNT_ID = 1;
    public static final int FALSE_NEGATIVE_COUNT_ID = 2;

    public void countMatchings(List<T> annotatorResult, List<T> goldStandard);
    
    public List<int[]> getCounts();
}
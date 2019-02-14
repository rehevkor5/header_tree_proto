package com.nnoncarey.sha.te.domain;

import java.util.StringJoiner;

/**
 *
 */
public class Level3ABA {
    private int leafyLeaf;

    public Level3ABA() {
    }

    public Level3ABA(int leafyLeaf) {
        this.leafyLeaf = leafyLeaf;
    }

    public int getLeafyLeaf() {
        return leafyLeaf;
    }

    public void setLeafyLeaf(int leafyLeaf) {
        this.leafyLeaf = leafyLeaf;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Level3ABA.class.getSimpleName() + "[", "]")
                .add("leafyLeaf=" + leafyLeaf)
                .toString();
    }
}

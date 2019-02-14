package com.nnoncarey.sha.te.structured.structure;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 */
public abstract class Value<V extends Value<V>> {
    private Structure<V> structure;

    public Value(Structure<V> structure) {
        this.structure = structure;
    }

    @JsonIgnore
    public Structure<V> getStructure() {
        return structure;
    }
}

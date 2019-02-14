package com.nnoncarey.sha.te.structured.structure;

/**
 *
 */
public abstract class AbstractStructure<T extends Value<T>> implements Structure<T> {
    private final Structure<?> parent;

    public AbstractStructure(Structure<?> parent) {
        this.parent = parent;
    }

    @Override
    public Structure<?> getParent() {
        return parent;
    }
}

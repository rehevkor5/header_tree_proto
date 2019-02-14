package com.nnoncarey.sha.te.structured.structure;

/**
 * For representing a tree that has values at each node, not just leaves
 */
public interface Structure<T extends Value<T>> {
    Structure<?> getParent();

    // TODO: how to enforce uniqueness?
    String getName();

    default String getFullyQualifiedName() {
        final Structure<?> parent = getParent();
        String prefix = "";
        if (parent != null) {
            prefix = parent.getFullyQualifiedName() + ".";
        }
        return prefix + getName();
    }

    Class<T> getValueClass();

    T createValue();
}

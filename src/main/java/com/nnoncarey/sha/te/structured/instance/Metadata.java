package com.nnoncarey.sha.te.structured.instance;

import com.nnoncarey.sha.te.structured.structure.Structure;
import com.nnoncarey.sha.te.structured.structure.Value;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Metadata<T extends Structure> {
    private T structureRoot;

    private final Map<Class<? extends Value>, Value<?>> values = new HashMap<>();

    public Metadata(T structureRoot) {
        this.structureRoot = structureRoot;
    }

    public T getStructureRoot() {
        return structureRoot;
    }

    public <V extends Value<V>> V getOrCreateValue(Structure<V> structure) {
        // Althouh it looks unsafe, this ensures the types will always be correct
        return (V) values.computeIfAbsent(structure.getValueClass(), (klass) -> structure.createValue());
    }

    public <V extends Value<V>> V getValueForStructure(Structure<V> structure) {
        return (V) values.get(structure.getValueClass());
    }
}

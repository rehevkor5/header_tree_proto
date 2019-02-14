package com.nnoncarey.sha.te.structured.structure.plugins;

import com.nnoncarey.sha.te.domain.FooPluginValue;
import com.nnoncarey.sha.te.structured.structure.AbstractStructure;
import com.nnoncarey.sha.te.structured.structure.Structure;

/**
 *
 */
public class FooPluginStructure extends AbstractStructure<FooPluginValue> {
    public FooPluginStructure(Structure<?> parent) {
        super(parent);
    }

    @Override
    public String getName() {
        return "foo";
    }

    @Override
    public Class<FooPluginValue> getValueClass() {
        return FooPluginValue.class;
    }

    @Override
    public FooPluginValue createValue() {
        return new FooPluginValue(this);
    }
}

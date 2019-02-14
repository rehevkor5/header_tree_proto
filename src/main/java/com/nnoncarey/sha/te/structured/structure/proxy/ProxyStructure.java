package com.nnoncarey.sha.te.structured.structure.proxy;

import com.nnoncarey.sha.te.domain.ProxyValue;
import com.nnoncarey.sha.te.structured.structure.AbstractStructure;
import com.nnoncarey.sha.te.structured.structure.Structure;

/**
 *
 */
public class ProxyStructure extends AbstractStructure<ProxyValue> {
    public ProxyStructure(Structure<?> parent) {
        super(parent);
    }

    @Override
    public String getName() {
        return "proxy";
    }

    @Override
    public Class<ProxyValue> getValueClass() {
        return ProxyValue.class;
    }

    @Override
    public ProxyValue createValue() {
        return new ProxyValue(this);
    }
}

package com.nnoncarey.sha.te.structured.structure;

import com.nnoncarey.sha.te.domain.NewRootValue;
import com.nnoncarey.sha.te.structured.structure.proxy.ProxyStructure;

/**
 *
 */
public class RootStructure implements Structure<NewRootValue> {
    public UserPluginStructure getUserPluginStructure() {
        return new UserPluginStructure(this);
    }

    public ProxyStructure getProxyStructure() {
        return new ProxyStructure(this);
    }

    @Override
    public Structure<?> getParent() {
        return null;
    }

    @Override
    public String getName() {
        return "X-CGP";
    }

    @Override
    public Class<NewRootValue> getValueClass() {
        return NewRootValue.class;
    }

    @Override
    public NewRootValue createValue() {
        return new NewRootValue(this);
    }
}

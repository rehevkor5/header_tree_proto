package com.nnoncarey.sha.te.structured.structure;

import com.nnoncarey.sha.te.domain.UserPluginValue;
import com.nnoncarey.sha.te.structured.structure.plugins.FooPluginStructure;

/**
 *
 */
public class UserPluginStructure extends AbstractStructure<UserPluginValue> {
    public UserPluginStructure(Structure<?> parent) {
        super(parent);
    }

    public FooPluginStructure getFooPluginStructure() {
        return new FooPluginStructure(this);
    }

    @Override
    public String getName() {
        return "userplugin";
    }

    @Override
    public Class<UserPluginValue> getValueClass() {
        return UserPluginValue.class;
    }

    @Override
    public UserPluginValue createValue() {
        return new UserPluginValue(this);
    }
}

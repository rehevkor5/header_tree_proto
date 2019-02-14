package com.nnoncarey.sha.te.domain;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.nnoncarey.sha.te.structured.structure.Structure;
import com.nnoncarey.sha.te.structured.structure.Value;

/**
 *
 */
public class UserPluginValue extends Value<UserPluginValue> {
    private double myDouble;

    public UserPluginValue(@JacksonInject Structure<UserPluginValue> structure) {
        super(structure);
    }

    public double getMyDouble() {
        return myDouble;
    }

    public void setMyDouble(double myDouble) {
        this.myDouble = myDouble;
    }
}

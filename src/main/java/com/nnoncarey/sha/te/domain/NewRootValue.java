package com.nnoncarey.sha.te.domain;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.nnoncarey.sha.te.structured.structure.Structure;
import com.nnoncarey.sha.te.structured.structure.Value;

/**
 *
 */
public class NewRootValue extends Value<NewRootValue> {
    private String myProperty;

    public NewRootValue(@JacksonInject Structure<NewRootValue> structure) {
        super(structure);
    }

    public String getMyProperty() {
        return myProperty;
    }

    public void setMyProperty(String myProperty) {
        this.myProperty = myProperty;
    }
}

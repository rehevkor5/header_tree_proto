package com.nnoncarey.sha.te.domain;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.nnoncarey.sha.te.structured.structure.Structure;
import com.nnoncarey.sha.te.structured.structure.Value;

import java.util.StringJoiner;

/**
 *
 */
public class ProxyValue extends Value<ProxyValue> {
    private String whatever;
    private int blah;

    public ProxyValue(@JacksonInject Structure<ProxyValue> structure) {
        super(structure);
    }

    public String getWhatever() {
        return whatever;
    }

    public void setWhatever(String whatever) {
        this.whatever = whatever;
    }

    public int getBlah() {
        return blah;
    }

    public void setBlah(int blah) {
        this.blah = blah;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ProxyValue.class.getSimpleName() + "[", "]")
                .add("whatever='" + whatever + "'")
                .add("blah=" + blah)
                .toString();
    }
}

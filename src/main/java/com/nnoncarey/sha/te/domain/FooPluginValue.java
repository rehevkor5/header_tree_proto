package com.nnoncarey.sha.te.domain;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.nnoncarey.sha.te.structured.structure.Structure;
import com.nnoncarey.sha.te.structured.structure.Value;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 *
 */
public class FooPluginValue extends Value<FooPluginValue> {
    private List<String> items;
    private Map<String, String> myMap;
    private Level3ABA anotherBean;

    public FooPluginValue(@JacksonInject Structure<FooPluginValue> structure) {
        super(structure);
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public Map<String, String> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public Level3ABA getAnotherBean() {
        return anotherBean;
    }

    public void setAnotherBean(Level3ABA anotherBean) {
        this.anotherBean = anotherBean;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FooPluginValue.class.getSimpleName() + "[", "]")
                .add("items=" + items)
                .add("myMap=" + myMap)
                .add("anotherBean=" + anotherBean)
                .toString();
    }
}

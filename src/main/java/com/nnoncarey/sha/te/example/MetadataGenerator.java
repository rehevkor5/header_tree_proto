package com.nnoncarey.sha.te.example;

import com.nnoncarey.sha.te.domain.FooPluginValue;
import com.nnoncarey.sha.te.domain.Level3ABA;
import com.nnoncarey.sha.te.domain.ProxyValue;
import com.nnoncarey.sha.te.domain.UserPluginValue;
import com.nnoncarey.sha.te.structured.instance.Metadata;
import com.nnoncarey.sha.te.structured.structure.RootStructure;
import com.nnoncarey.sha.te.structured.structure.UserPluginStructure;
import com.nnoncarey.sha.te.structured.structure.plugins.FooPluginStructure;
import com.nnoncarey.sha.te.structured.structure.proxy.ProxyStructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class MetadataGenerator {
    public Metadata<RootStructure> createMetadata() {
        final RootStructure root = new RootStructure();
        final Metadata<RootStructure> meta = new Metadata<>(root);

        // Pass "root" over to the place in the code that uses it
        // I'm not going to add this value, so that we can demo what happens when it's missing.
//        final NewRootValue rootValue = meta.getOrCreateValue(root);
//        rootValue.setMyProperty("my value");


        final ProxyStructure proxyStructure = root.getProxyStructure();
        // Pass proxyStructure over to the place in the code that uses it
        final ProxyValue proxyValue = meta.getOrCreateValue(proxyStructure);
        proxyValue.setWhatever("asdlkfj asdf");
        proxyValue.setBlah(6);


        final UserPluginStructure pluginStructure = root.getUserPluginStructure();

        final UserPluginValue pluginValue = meta.getOrCreateValue(pluginStructure);
        pluginValue.setMyDouble(3.14);


        final FooPluginStructure fooPlugin = pluginStructure.getFooPluginStructure();

        final FooPluginValue fooValue = meta.getOrCreateValue(fooPlugin);
        fooValue.setItems(Arrays.asList("one", "two", "three"));
        final Map<String, String> myMap = new HashMap<>();
        myMap.put("some key", "some value");
        fooValue.setMyMap(myMap);
        fooValue.setAnotherBean(new Level3ABA(100));

        return meta;
    }
}

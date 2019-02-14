package com.nnoncarey.sha.te;

import com.nnoncarey.sha.te.domain.FooPluginValue;
import com.nnoncarey.sha.te.domain.ProxyValue;
import com.nnoncarey.sha.te.structured.HeaderDeserializer;
import com.nnoncarey.sha.te.structured.HeaderSerializer;
import com.nnoncarey.sha.te.example.MetadataGenerator;
import com.nnoncarey.sha.te.structured.instance.Metadata;
import com.nnoncarey.sha.te.structured.structure.RootStructure;
import com.nnoncarey.sha.te.structured.structure.plugins.FooPluginStructure;
import com.nnoncarey.sha.te.structured.structure.proxy.ProxyStructure;

import java.util.Arrays;
import java.util.Map;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        final MetadataGenerator metadataGenerator = new MetadataGenerator();
        final Metadata<RootStructure> metadata = metadataGenerator.createMetadata();

        final RootStructure structureRoot = metadata.getStructureRoot();
        final ProxyStructure proxyStructure = structureRoot.getProxyStructure();
        final FooPluginStructure fooPluginStruct = structureRoot.getUserPluginStructure().getFooPluginStructure();
        final Map<String, String> headers = HeaderSerializer.serializeHeaders(Arrays.asList(
                structureRoot, proxyStructure, fooPluginStruct),
                metadata);

        System.out.println("Serialized headers:");
        for (Map.Entry<String, String> header : headers.entrySet()) {
            System.out.println(header.getKey() + " -> " + header.getValue());
        }

        final HeaderDeserializer headerDeserializer = new HeaderDeserializer(headers);
        FooPluginValue maybeFooValue = headerDeserializer.deserialize(fooPluginStruct);
        System.out.println("Deserialized header values: ");
        if (maybeFooValue != null) {
            System.out.println("Deserialized Foo value " + maybeFooValue);
        }
        final ProxyValue proxyValue = headerDeserializer.deserialize(proxyStructure);
        if (proxyValue != null) {
            System.out.println("Deserialized Proxy value: " + proxyValue);
        }
    }
}

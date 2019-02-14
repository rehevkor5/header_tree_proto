package com.nnoncarey.sha.te.structured;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.nnoncarey.sha.te.structured.structure.Structure;
import com.nnoncarey.sha.te.structured.structure.Value;

import java.io.IOException;
import java.util.Map;

/**
 *
 */
public class HeaderDeserializer {
    // TODO: use centralized ObjectMapper
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private final Map<String, String> headers;

    public HeaderDeserializer(Map<String, String> headers) {
        this.headers = headers;
    }

    public <V extends Value<V>> V deserialize(Structure<V> structure) {
        final String fullyQualifiedName = structure.getFullyQualifiedName();

        final String maybeSerializedValue = headers.get(fullyQualifiedName);
        if (maybeSerializedValue == null) {
            return null;
        } else {
            try {
                // Can't create because the constructor requires a Structure!
                final InjectableValues.Std injectableValues = new InjectableValues.Std();
                injectableValues.addValue(Structure.class, structure);
                final ObjectReader reader = objectMapper.reader(injectableValues)
                        .forType(structure.getValueClass());
                return reader.readValue(maybeSerializedValue);
            } catch (IOException e) {
                // TODO: whatever we need to do here... either rethrow or log

                System.out.println("Exception! " + e);

                return null;
            }
        }
    }
}

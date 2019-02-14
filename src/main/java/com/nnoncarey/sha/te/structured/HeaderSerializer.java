package com.nnoncarey.sha.te.structured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nnoncarey.sha.te.structured.instance.Metadata;
import com.nnoncarey.sha.te.structured.structure.Structure;
import com.nnoncarey.sha.te.structured.structure.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class HeaderSerializer {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, String> serializeHeaders(List<Structure<?>> toSerialize,
                                                       Metadata metadata) {
        Map<String, String> headers = new HashMap<>(toSerialize.size());

        for (Structure<?> structure : toSerialize) {
            final String headerName = structure.getFullyQualifiedName();

            final Value<?> maybeValue = metadata.getValueForStructure(structure);

            if (maybeValue != null) {
                try {
                    // TODO: when these turn into real headers, of course they need to be encoded properly!
                    headers.put(headerName, objectMapper.writeValueAsString(maybeValue));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException("TODO", e);
                }
            } else {
                System.out.println("Info: no value present for requested structure: " + structure + " at " + headerName);
            }
        }
        return headers;
    }
}

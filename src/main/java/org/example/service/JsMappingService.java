package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.enums.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JsMappingService {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public ArrayNode mapObjects(List<?> objects, Mapper mapper) {
        return OBJECT_MAPPER.createArrayNode().addAll(objects.stream()
                .map(object -> mapObject(object, mapper))
                .collect(Collectors.toList()));
    }

    public ObjectNode mapObject(Object object, Mapper mapper) {
        return mapper.getObjectMapper().apply(OBJECT_MAPPER, object);
    }

    public ObjectNode mapResult(List<?> objects, Mapper mapper) {
        ObjectNode result = OBJECT_MAPPER.createObjectNode();
        result.put("success", true);
        result.put("result", mapObjects(objects, mapper));
        return result;
    }

    public ObjectNode mapResult(Object object, Mapper mapper) {
        ObjectNode result = OBJECT_MAPPER.createObjectNode();
        result.put("success", true);
        result.put("result", mapObject(object, mapper));
        return result;
    }
}

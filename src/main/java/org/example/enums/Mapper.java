package org.example.enums;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.entities.Location;
import org.example.entities.NonPlayerCharacter;
import org.example.entities.Quest;

import java.util.function.BiFunction;

public enum Mapper {
    QUEST((objectMapper, o) -> {
        Quest quest = (Quest) o;
        return objectMapper.createObjectNode().put("id", quest.getId())
                .put("name", quest.getName())
                .put("questType", quest.getQuestType().getDisplayName())
                .put("npc", quest.getNonPlayerCharacter().getName());
    }),
    NPC((objectMapper, o) -> {
        NonPlayerCharacter npc = (NonPlayerCharacter) o;
        return objectMapper.createObjectNode().put("id", npc.getId())
                .put("name", npc.getName())
                .put("eliteStatus", npc.isEliteStatus())
                .put("fraction", npc.getFraction().getDisplayName())
                .put("location", npc.getLocation().getName());
    }),
    LOCATION((objectMapper, o) -> {
        Location location = (Location) o;
        return objectMapper.createObjectNode().put("id", location.getId())
                .put("name", location.getName())
                .put("mainland", location.getMainland().getDisplayName())
                .put("introductionDate", location.getIntroductionDate().toString());
    }),
    QUEST_NPC((objectMapper, o) -> {
        NonPlayerCharacter npc = (NonPlayerCharacter) o;
        return objectMapper.createObjectNode().put("id", npc.getId())
                .put("name", npc.getName());
    }),
    NPC_LOCATION((objectMapper, o) -> {
        Location location = (Location) o;
        return objectMapper.createObjectNode().put("id", location.getId())
                .put("name", location.getName());
    }),
    MAINLAND((objectMapper, o) -> {
        Mainland mainland = (Mainland) o;
        return objectMapper.createObjectNode().put("name", mainland.getName())
                .put("displayName", mainland.getDisplayName());
    }),
    QUEST_TYPE((objectMapper, o) -> {
        QuestType questType = (QuestType) o;
        return objectMapper.createObjectNode().put("name", questType.getName())
                .put("displayName", questType.getDisplayName());
    }),
    FRACTION((objectMapper, o) -> {
        Fraction fraction = (Fraction) o;
        return objectMapper.createObjectNode().put("name", fraction.getName())
                .put("displayName", fraction.getDisplayName());
    }),
    OBJECT_ID((objectMapper, o) -> {
        Integer ObjectId = (Integer) o;
        return objectMapper.createObjectNode().put("id", ObjectId);
    });

    final BiFunction<ObjectMapper, Object, ObjectNode> objectMapper;

    Mapper(BiFunction<ObjectMapper, Object, ObjectNode> objectMapper) {
        this.objectMapper = objectMapper;
    }

    public BiFunction<ObjectMapper, Object, ObjectNode> getObjectMapper() {
        return objectMapper;
    }
}

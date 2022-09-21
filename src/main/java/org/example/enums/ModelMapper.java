package org.example.enums;

import org.example.entities.Location;
import org.example.entities.NonPlayerCharacter;
import org.example.entities.Quest;
import org.example.vo.LocationForm;
import org.springframework.ui.ModelMap;

import java.util.function.BiFunction;

public enum ModelMapper {
    QUEST((o, modelMap) -> {
        Quest quest = (Quest) o;
        return modelMap.addAttribute("id", quest.getId())
                .addAttribute("name", quest.getName())
                .addAttribute("questType",quest.getQuestType().getDisplayName())
                .addAttribute("npc",quest.getNonPlayerCharacter().getName());
    }),
    NPC((o, modelMap) -> {
        NonPlayerCharacter npc = (NonPlayerCharacter) o;
        return modelMap.addAttribute("id", npc.getId())
                .addAttribute("name", npc.getName())
                .addAttribute("eliteStatus",npc.isEliteStatus())
                .addAttribute("fraction",npc.getFraction().getDisplayName())
                .addAttribute("location",npc.getLocation().getName());
    }),
    LOCATION((o, modelMap) -> {
        Location location = (Location) o;
        return modelMap.addAttribute("id", location.getId())
                .addAttribute("name", location.getName())
                .addAttribute("mainlandName", location.getMainland().getDisplayName())
                .addAttribute("introductionDate", location.getIntroductionDate());
    }),
    LOCATION_FORM((o, modelMap) -> {
        LocationForm locationForm = (LocationForm) o;
        return modelMap.addAttribute("id", locationForm.getId())
                .addAttribute("name", locationForm.getName())
                .addAttribute("mainlandName", locationForm.getMainland().getDisplayName())
                .addAttribute("introductionDate", locationForm.getIntroductionDate());
    });

    final BiFunction<Object, ModelMap, ModelMap> objectMapper;

    ModelMapper(BiFunction<Object, ModelMap, ModelMap> objectMapper) {
        this.objectMapper = objectMapper;
    }

    public BiFunction<Object, ModelMap, ModelMap> getObjectMapper() {
        return objectMapper;
    }
}

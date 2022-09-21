package org.example.service;

import org.example.dao.LocationDao;
import org.example.dao.NPCDao;
import org.example.entities.NonPlayerCharacter;
import org.example.vo.NpcForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NpcService {

    private final LocationDao locationDao;

    private final NPCDao npcDao;

    @Autowired
    public NpcService(LocationDao locationDao, NPCDao npcDao) {
        this.locationDao = locationDao;
        this.npcDao = npcDao;
    }

    public NonPlayerCharacter saveNpcFromForm(NpcForm npcForm) {

        return npcDao.save(convertToNpc(npcForm));
    }

    public NonPlayerCharacter updateNpcFromForm(NpcForm npcForm) {
        NonPlayerCharacter npc = convertToNpc(npcForm);
        npcDao.update(npc);
        return npc;
    }

    public NonPlayerCharacter convertToNpc(NpcForm npcForm) {
        NonPlayerCharacter npc = new NonPlayerCharacter();
        npc.setId(npcForm.getId());
        npc.setName(npcForm.getName());
        npc.setEliteStatus(npcForm.isEliteStatus());
        npc.setFraction(npcForm.getFraction());
        npc.setLocation(locationDao.findById(npcForm.getLocationId()));
        return npc;
    }

    public NpcForm convertToNpcForm(NonPlayerCharacter npc) {
        NpcForm npcForm = new NpcForm();
        npcForm.setId(npc.getId());
        npcForm.setName(npc.getName());
        npcForm.setEliteStatus(npc.isEliteStatus());
        npcForm.setFraction(npc.getFraction());
        npcForm.setLocationId(npc.getLocation().getId());
        return npcForm;
    }
}

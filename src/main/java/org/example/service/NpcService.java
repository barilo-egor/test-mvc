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

        return npcDao.save(npcConvert(npcForm));
    }

    public NonPlayerCharacter updateNpcFromForm(NpcForm npcForm) {
        NonPlayerCharacter npc = npcConvert(npcForm);
        npcDao.update(npc);
        return npc;
    }

    public NonPlayerCharacter npcConvert(NpcForm npcForm) {
        if (npcForm.getId() != null) {
            return new NonPlayerCharacter(
                    npcForm.getId(),
                    npcForm.getName(),
                    npcForm.isEliteStatus(),
                    npcForm.getFraction(),
                    locationDao.findById(npcForm.getLocationId()));
        } else {
            return new NonPlayerCharacter(
                    npcForm.getName(),
                    npcForm.isEliteStatus(),
                    npcForm.getFraction(),
                    locationDao.findById(npcForm.getLocationId()));
        }
    }

    public NpcForm npcConvert(NonPlayerCharacter npc) {
        return new NpcForm(
                npc.getId(),
                npc.getName(),
                npc.isEliteStatus(),
                npc.getFraction(),
                npc.getLocation().getId());
    }
}

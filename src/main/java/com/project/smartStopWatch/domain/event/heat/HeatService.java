package com.project.smartStopWatch.domain.event.heat;

import com.project.smartStopWatch.domain.event.Event;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class HeatService {

    @Resource
    private HeatRepository heatRepository;


    public void createAndSaveHeats(Event event, Integer numberOfHeats) {
        List<Heat> heats = createHeats(event, numberOfHeats);
        heatRepository.saveAll(heats);
    }

    private static List<Heat> createHeats(Event event, Integer numberOfHeats) {
        List<Heat> heats = new ArrayList<>();
        for (int i = 1; i <= numberOfHeats; i++) {
            Heat heat = new Heat();
            heat.setHeatNumber(i);
            heat.setEvent(event);
            heats.add(heat);
        }
        return heats;
    }

    public void startHeat(Instant timestamp, Integer eventId, Integer heatNumber) {
        Heat heat = heatRepository.findHeatBy(true, eventId, heatNumber);
        heat.setStart(timestamp);
        heat.setHasStarted(true);
    }

    public List<Heat> findActiveHeats(Integer eventId) {
        return heatRepository.findHeatsBy(true, eventId);
    }
}

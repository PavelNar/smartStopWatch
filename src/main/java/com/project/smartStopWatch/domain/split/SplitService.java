package com.project.smartStopWatch.domain.split;

import com.project.smartStopWatch.app.stopper.dto.heat.HeatStopRequest;
import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import com.project.smartStopWatch.domain.athlete.event.AthleteEventService;
import com.project.smartStopWatch.domain.event.heat.Heat;
import com.project.smartStopWatch.domain.event.heat.HeatService;
import com.project.smartStopWatch.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

@Service
public class SplitService {

    @Resource
    private AthleteEventService athleteEventService;

    @Resource
    private HeatService heatService;

    @Resource
    private SplitRepository splitRepository;

    @Resource
    private SplitMapper splitMapper;


    public void createInitialSplits(Instant timestamp, List<AthleteEvent> athleteEvents) {
        for (AthleteEvent athleteEvent : athleteEvents) {
            addNewSplit(timestamp, athleteEvent);
        }
    }

    public void processSplits(Instant timestamp, AthleteEvent athleteEvent) {
        Heat heat = heatService.findActiveHeat(athleteEvent.getHeatNumber());
        if (isLastSplit(athleteEvent)) {
            athleteEventService.updateAthleteEventFinishTime(timestamp, athleteEvent);
        } else {
            updateLastSplitAndAddNewSplit(timestamp, athleteEvent);
        }
        List<AthleteEvent> athleteEvents = athleteEventService.findActiveAthleteEvents(athleteEvent.getEvent().getId(), athleteEvent.getHeatNumber());
        int counter = 0;
        for (AthleteEvent athleteEvent1 : athleteEvents) {
            if (athleteEvent1.getSplitCounter().equals(athleteEvent1.getSplitCountRequired()))
                counter++;
            if (counter == athleteEvents.size())
                heatService.updateHeatEnd(timestamp, heat);
        }
        // TODO:  find all AthleteEvents by active, eventId, heatNumber
        // TODO: create counter = 0
        // TODO: forloop all athleteEvents  if splitCounter and splitCountRequired are equal increase counter
        // TODO: if counter equeals athleteEvents.size() then heat is finished update heat finished (end) information
    }

    public void undoPreviousSplitProcess(AthleteEvent athleteEvent) {
        if (isInFinishedStatus(athleteEvent)) {
            athleteEventService.clearFinishedTimeStamp(athleteEvent);
        } else {
            deactivateCurrentLastSplit(athleteEvent);
        }
        clearNextLastActiveSplitEndTime(athleteEvent);
        athleteEventService.decreaseAthleteEventSplitCounter(athleteEvent);
    }

    private static boolean isInFinishedStatus(AthleteEvent athleteEvent) {
        return athleteEvent.getSplitCounter().equals(athleteEvent.getSplitCountRequired()) ;
    }

    private static boolean isLastSplit(AthleteEvent athleteEvent) {
        return athleteEvent.getSplitCounter().equals(athleteEvent.getSplitCountRequired());
    }

    private void updateLastSplit(Instant timestamp, AthleteEvent athleteEvent) {
        Split lastSplit = getLastSplit(athleteEvent);
        updateSplitEndTime(timestamp, lastSplit);
    }

    private void updateSplitEndTime(Instant timestamp, Split split) {
        split.setEnd(timestamp);
        splitRepository.save(split);
    }

    private void addNewSplit(Instant timestamp, AthleteEvent athleteEvent) {
        ValidationService.validateAllowedAddSplit(athleteEvent);
        Split split = splitMapper.athleteEventToSplit(athleteEvent);
        addSplitWithStartTime(timestamp, split);
    }

    private void addSplitWithStartTime(Instant timestamp, Split split) {
        split.setStart(timestamp);
        split.setEventId(split.getEventId());
        split.setHeatNumber(split.getHeatNumber());
        splitRepository.save(split);
    }

    private void updateLastSplitAndAddNewSplit(Instant timestamp, AthleteEvent athleteEvent) {
        Split lastSplit = getLastSplit(athleteEvent);
        updateSplitEndTime(timestamp, lastSplit);
        addNewSplit(timestamp, athleteEvent);
    }

    private void deactivateCurrentLastSplit(AthleteEvent athleteEvent) {
        Split lastSplit = getLastSplit(athleteEvent);
        lastSplit.setIsActive(false);
        splitRepository.save(lastSplit);
    }

    private void clearNextLastActiveSplitEndTime(AthleteEvent athleteEvent) {
        Split lastSplit = getLastSplit(athleteEvent);
        lastSplit.setEnd(null);
        splitRepository.save(lastSplit);
    }

    private Split getLastSplit(AthleteEvent athleteEvent) {
        List<Split> splits = splitRepository.findByIsActiveAthleteEvent(true, athleteEvent);
        return splits.get(splits.size() - 1);
    }

    public void clearAthleteEvent(List<AthleteEvent> athleteEvents) {
        athleteEventService.clearAthleteEvent(athleteEvents);
    }

    public List<Split> findActiveSplitsBy(HeatStopRequest stopRequest) {
        return splitRepository.findSplitsBy(stopRequest.getEventId(), stopRequest.getHeatNumber());
    }

    public void clearHeatAllSplits(List<Split> splits) {
        for (Split split : splits) {
            split.setEnd(null);
            split.setIsActive(false);
        }
        splitRepository.saveAll(splits);
    }
}

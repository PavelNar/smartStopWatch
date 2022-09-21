package com.project.smartStopWatch.domain.split;

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
        Heat heat = heatService.findActiveHeat(athleteEvent.getEvent().getId());
        if (isLastSplit(athleteEvent)) {
            updateLastSplit(timestamp, athleteEvent);
            athleteEventService.updateAthleteEventFinishTime(timestamp, athleteEvent);
            heatService.updateHeatEnd(timestamp, heat);
        } else {
            updateLastSplitAndAddNewSplit(timestamp, athleteEvent);
        }
        athleteEventService.updateAthleteEventLastSplitTime(timestamp, athleteEvent);
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

    public void clearAthleteEventsLastSplitTimeAndSplitCounter(List<AthleteEvent> athleteEvents) {
        for (AthleteEvent athleteEvent : athleteEvents) {
            athleteEvent.setSplitCounter(0);
            athleteEvent.setLastSplitTime(null);
        }
    }
}

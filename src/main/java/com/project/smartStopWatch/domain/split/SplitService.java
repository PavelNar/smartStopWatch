package com.project.smartStopWatch.domain.split;

import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import com.project.smartStopWatch.domain.athlete.event.AthleteEventService;
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
    private SplitRepository splitRepository;

    @Resource
    private SplitMapper splitMapper;

    public void createInitialSplits(Instant timestamp, List<AthleteEvent> athleteEvents) {
        for (AthleteEvent athleteEvent : athleteEvents) {
            addNewSplit(timestamp, athleteEvent);

        }
    }

    public void processSplits(Instant timestamp, AthleteEvent athleteEvent) {
        if (isLastSplit(athleteEvent)) {
            updateLastSplit(timestamp, athleteEvent);
            athleteEventService.updateAthleteEventFinishTime(timestamp, athleteEvent);
        } else {
            updateLastSplitAndAddNewSplit(timestamp, athleteEvent);
        }
    }

    public void undoPreviousSplitProcess(AthleteEvent athleteEvent) {
        if (isInFinishedStatus(athleteEvent)) {
            athleteEventService.clearFinishedTimeStamp(athleteEvent);
        }
        deactivateCurrentLastSplit(athleteEvent);
        clearNextLastActiveSplitEndTime(athleteEvent);
        athleteEventService.decreaseAthleteEventSplitCounter(athleteEvent);
    }

    private static boolean isInFinishedStatus(AthleteEvent athleteEvent) {
        return athleteEvent.getSplitCounter() == athleteEvent.getSplitCounter();
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
}

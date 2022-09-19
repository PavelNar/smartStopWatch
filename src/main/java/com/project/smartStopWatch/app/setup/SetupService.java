package com.project.smartStopWatch.app.setup;

import com.project.smartStopWatch.app.setup.dto.athlete.AthleteInfo;
import com.project.smartStopWatch.domain.event.EventService;
import com.project.smartStopWatch.app.setup.dto.event.AthleteEventUpdateRequest;
import com.project.smartStopWatch.app.setup.dto.event.EventSettingsRequest;
import com.project.smartStopWatch.app.setup.dto.event.EventSettingsResponse;
import com.project.smartStopWatch.app.setup.dto.split.SplitLengthDto;
import com.project.smartStopWatch.app.setup.dto.split.StrokeDto;
import com.project.smartStopWatch.domain.athlete.AthleteService;
import com.project.smartStopWatch.domain.athlete.event.AthleteEventService;
import com.project.smartStopWatch.domain.event.Event;
import com.project.smartStopWatch.domain.event.EventMapper;
import com.project.smartStopWatch.domain.event.heat.HeatService;
import com.project.smartStopWatch.domain.split.length.SplitLengthService;
import com.project.smartStopWatch.domain.stroke.StrokeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SetupService {

    @Resource
    private AthleteEventService athleteEventService;

    @Resource
    private AthleteService athleteService;

    @Resource
    private EventService eventService;

    @Resource
    private SplitLengthService splitLengthService;

    @Resource
    private StrokeService strokeService;

    @Resource
    private EventMapper eventMapper;

    @Resource
    private HeatService heatService;


    public EventSettingsResponse createEventFromSettings(EventSettingsRequest request) {
        Event event = eventService.createAndAddEvent(request);
        athleteEventService.createAndAddAthleteEvents(event, request);
        heatService.createAndSaveHeats(event, request.getNumberOfHeats());
        return eventMapper.eventToEventResponse(event);
    }

    public AthleteInfo addAthlete(String name, Integer trainerUserId) {
        return athleteService.addAthlete(name, trainerUserId);
    }

    public void updateAthleteEvent(AthleteEventUpdateRequest request) {
        athleteEventService.updateAthleteEventSettings(request);
    }

    public List<StrokeDto> findAllStrokes() {
        return strokeService.findAllStrokes();
    }

    public List<SplitLengthDto> findAllSplits() {
        return splitLengthService.findAllSplits();
    }

    public List<AthleteInfo> findActiveAthletesByUserId(Integer userId) {
        return athleteService.findActiveAthletesByUserId(userId);
    }
}

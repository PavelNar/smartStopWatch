package com.project.smartStopWatch.app.stopper;

import com.project.smartStopWatch.app.stopper.dto.dashboard.AthleteEventDto;
import com.project.smartStopWatch.app.stopper.dto.dashboard.HeatRow;
import com.project.smartStopWatch.app.stopper.dto.dashboard.StopperDashboard;
import com.project.smartStopWatch.app.stopper.dto.heat.HeatStartRequest;
import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import com.project.smartStopWatch.domain.athlete.event.AthleteEventMapper;
import com.project.smartStopWatch.domain.athlete.event.AthleteEventService;
import com.project.smartStopWatch.domain.event.EventService;
import com.project.smartStopWatch.domain.event.heat.Heat;
import com.project.smartStopWatch.domain.event.heat.HeatMapper;
import com.project.smartStopWatch.domain.event.heat.HeatService;
import com.project.smartStopWatch.domain.split.SplitService;
import com.project.smartStopWatch.validation.ValidationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class StopperService {

    @Resource
    private AthleteEventService athleteEventService;

    @Resource
    private EventService eventService;

    @Resource
    private HeatService heatService;

    @Resource
    private SplitService splitService;


    @Resource
    private AthleteEventMapper athleteEventMapper;

    @Resource
    private HeatMapper heatMapper;

    @Transactional
    public void startHeat(Instant timestamp, HeatStartRequest startRequest) {
        List<AthleteEvent> athleteEvents = athleteEventService.findActiveAthleteEventsBy(startRequest.getEventId(), startRequest.getHeatNumber());
        ValidationService.validateStartHeatIsAllowedWithAthleteEvents(athleteEvents);
        athleteEventService.updateAthleteEventsWithTimeStamp(timestamp, athleteEvents);
        splitService.createInitialSplits(timestamp, athleteEvents);
        heatService.startHeat(timestamp, startRequest.getEventId(), startRequest.getHeatNumber());
    }

    @Transactional
    public void processSplitClick(Instant timestamp, Integer athleteEventId) {
        AthleteEvent athleteEvent = athleteEventService.findAthleteEventBy(athleteEventId);
        ValidationService.validateSplitClickAllowed(athleteEvent);
        athleteEventService.increaseAthleteEventSplitCounter(athleteEvent);
        splitService.processSplits(timestamp, athleteEvent);
    }

    @Transactional
    public void processUndoClick(Integer athleteEventId) {
        AthleteEvent athleteEvent = athleteEventService.findAthleteEventBy(athleteEventId);
        ValidationService.validateUndoClickAllowed(athleteEvent);
        splitService.undoPreviousSplitProcess(athleteEvent);
    }

    // TODO: SEE ON TEIE KÕIGE TÄHTSAM TEENUS, MIS ON VAJA ASAP ära implementeerida
    public StopperDashboard getStopperDashboard(Integer eventId) {
        List<AthleteEvent> athleteEvents = athleteEventService.findActiveAthleteEventsBy(eventId);
        List<Heat> heats = heatService.findActiveHeats(eventId);

        StopperDashboard stopperDashboard = createStopperDashboard(heats, athleteEvents);
        HeatRow heatRow = new HeatRow();
        return null;
    }

    private StopperDashboard createStopperDashboard(List<Heat> heats, List<AthleteEvent> athleteEvents) {
        List<HeatRow> heatRows = createHeatRows(heats);
        List<AthleteEventDto> athleteEventDtos = createAthleteEventDtos(athleteEvents);
        // TODO: forTsukliga kaid labi koik athleteEventDtod
        // TODO: selle fortsukli sees teine fortsukel, kaid forloobiga labi heatRows
        // TODO: kui heatNumber klapib lisad athleteEventsile addiga athleteEventDto kulge

        return null;
    }

    private List<AthleteEventDto> createAthleteEventDtos(List<AthleteEvent> athleteEvents) {
        return athleteEventMapper.athleteEventsToAthleteEventDtos(athleteEvents);
    }

    private List<HeatRow> createHeatRows(List<Heat> heats) {
        return heatMapper.heatsToHeatRows(heats);
    }

    private AthleteEventDto createAthleteEvent(AthleteEvent athleteEvent) {
        AthleteEventDto athleteEventDto = new AthleteEventDto();

        athleteEventDto.setAthleteId(athleteEvent.getAthlete().getId());
        athleteEventDto.setAthleteEventId(athleteEvent.getId());
        athleteEventDto.setAthleteName(athleteEvent.getAthlete().getName());
        athleteEventDto.setStrokeId(athleteEvent.getStroke().getId());
        athleteEventDto.setStrokeType(athleteEvent.getStroke().getType());
        athleteEventDto.setAthleteEventLength(athleteEvent.getEventLength());
        athleteEventDto.setHasStarted(false);
        athleteEventDto.setStartTime(null);
        athleteEventDto.setLastSplitTime(null);
        athleteEventDto.setLastSplitLength(null);
        athleteEventDto.setHasFinished(false);
        athleteEventDto.setFinishTime(null);
        athleteEventDto.setHeatNumber(athleteEventDto.getHeatNumber());
        athleteEventDto.setLaneNumber(athleteEventDto.getLaneNumber());
        return athleteEventDto;
    }

//    private List<AthleteEventDto> CreateAthleteEvents(AthleteEventDto athleteEventDto) {
//        List<AthleteEventDto> athleteEventDtos = new ArrayList<>();
//        for (int i = 1; i < ; i++) {
//
//        }
//        return  athleteEventDtos;
//    }
}

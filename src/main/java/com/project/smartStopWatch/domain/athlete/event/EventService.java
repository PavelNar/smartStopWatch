package com.project.smartStopWatch.domain.athlete.event;

import com.project.smartStopWatch.app.athleteevent.AthleteEventRequest;
import com.project.smartStopWatch.app.athleteevent.AthleteEventResponse;
import com.project.smartStopWatch.app.event.*;
import com.project.smartStopWatch.domain.split.SplitLength;
import com.project.smartStopWatch.domain.split.SplitLengthRepository;
import com.project.smartStopWatch.domain.split.SplitService;
import com.project.smartStopWatch.domain.stroke.Stroke;
import com.project.smartStopWatch.domain.stroke.StrokeRepository;
import com.project.smartStopWatch.domain.stroke.StrokeService;
import com.project.smartStopWatch.domain.user.User;
import com.project.smartStopWatch.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EventService {

    @Resource
    private EventRepository eventRepository;

    @Resource
    private EventMapper eventMapper;

    @Resource
    private UserService userService;


    @Resource
    private SplitLengthRepository splitLengthRepository;

    @Resource
    private AthleteEventMapper athleteEventMapper;

    @Resource
    private AthleteEventRepository athleteEventRepository;

    @Resource
    private StrokeService strokeService;

    @Resource
    private SplitService splitService;

    @Resource
    private AthleteEventService athleteEventService;


    public AthleteEventResponse createAthleteEvent(AthleteEventRequest request) {
        AthleteEvent athleteEvent = athleteEventMapper.athleteEventRequestToAthleteEvent(request);
        athleteEventRepository.save(athleteEvent);
        return athleteEventMapper.athleteEventToAthleteEventResponse(athleteEvent);

    }
    public EventResponse createGlobalSettings(EventRequest request) {
        Event event = eventMapper.eventRequestToEvent(request);
        User user = userService.findUserByUserId(request.getUserId());
        event.setUser(user);

        Stroke stroke = strokeService.findStrokeByStrokeId(request.getStrokeId());
        event.setStroke(stroke);
        SplitLength splitLength = splitLengthRepository.findSplitLengthBySplitLengthId(request.getSplitLengthId());
        event.setSplitLength(splitLength);
        eventRepository.save(event);

        saveAthleteEvents(request, event);

        return eventMapper.eventToEventResponse(event);
    }


    private void saveAthleteEvents(EventRequest request, Event event) {
        for (int laneNumber = 1; laneNumber < event.getNumberOfLanes()+1; laneNumber++) {
            for (int heatNumber = 1; heatNumber < event.getNumberOfHeats()+1; heatNumber++) {
                AthleteEvent athleteEvent = new AthleteEvent();
                athleteEvent.setEvent(event);
                athleteEvent.setEventLength(request.getEventLength());
                athleteEvent.setStroke(getStrokeById(request));
                athleteEvent.setLaneNumber(laneNumber);
                athleteEvent.setHeatNumber(heatNumber);
                athleteEvent.setIsActive(true);
                athleteEvent.setSplitCounter(request.getEventLength() / event.getSplitLength().getMeters());
                athleteEvent.setSplitLength(event.getSplitLength().getMeters());
                athleteEventService.saveAllAthleteEvents(athleteEvent);
            }
        }
    }


    private Stroke getStrokeById(EventRequest request) {
        return strokeService.findById(request.getStrokeId());
    }


    public List<StrokeDto> findAllStrokes() {
       return strokeService.findAllStrokes();
    }

    public List<SplitLengthDto> findAllSplits() {
        return splitService.findAllSplits();
    }

//    public GlobalSettingsDropdownDto getDropdownMenu() {
//        GlobalSettingsDropdownDto menu = new GlobalSettingsDropdownDto();
//        List<SplitLengthDto> splitList = findAllSplits();
//        List<StrokeDto> strokeList = findAllStrokes();
//        menu.setSplitLengthDtos(splitList);
//        menu.setStrokeDtos(strokeList);
//        menu.setSplitLengthDtos(findAllSplits());
//        menu.setStrokeDtos(findAllStrokes());
//        return menu;
//    }
}

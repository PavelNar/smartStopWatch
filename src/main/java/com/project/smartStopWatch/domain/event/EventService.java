package com.project.smartStopWatch.domain.event;

import com.project.smartStopWatch.app.athleteevent.AthleteEventRequest;
import com.project.smartStopWatch.app.athleteevent.AthleteEventResponse;
import com.project.smartStopWatch.app.event.*;
import com.project.smartStopWatch.domain.athlete.event.AthleteEvent;
import com.project.smartStopWatch.domain.athlete.event.AthleteEventMapper;
import com.project.smartStopWatch.domain.athlete.event.AthleteEventRepository;
import com.project.smartStopWatch.domain.split.Split;
import com.project.smartStopWatch.domain.stroke.Stroke;
import com.project.smartStopWatch.domain.split.SplitLength;
import com.project.smartStopWatch.domain.split.SplitLengthRepository;
import com.project.smartStopWatch.domain.stroke.StrokeRepository;
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
    private StrokeRepository strokeRepository;

    @Resource
    private SplitLengthRepository splitLengthRepository;

    @Resource
    private AthleteEventMapper athleteEventMapper;

    @Resource
    private AthleteEventRepository athleteEventRepository;

    public EventResponse createGlobalSettings(EventRequest request) {
        Event event = eventMapper.eventRequestToEvent(request);
        User user = userService.findUserByUserId(request.getUserId());
        event.setUser(user);
        Stroke stroke = strokeRepository.findStrokeByStrokeId(request.getStrokeId());
        event.setStroke(stroke);
        SplitLength splitLength = splitLengthRepository.findSplitLengthBySplitLengthId(request.getSplitLengthId());
        event.setSplitLength(splitLength);
        eventRepository.save(event);
        return eventMapper.eventToEventResponse(event);
    }

    public AthleteEventResponse createAthleteEvent(AthleteEventRequest request) {
        AthleteEvent athleteEvent = athleteEventMapper.athleteEventRequestToAthleteEvent(request);
        athleteEventRepository.save(athleteEvent);
        return athleteEventMapper.athleteEventToAthleteEventResponse(athleteEvent);

    }


    public List<StrokeDto> findAllStrokes() {
        List<Stroke> strokes = strokeRepository.findAll();
        return eventMapper.strokeListToStrokeDtoList(strokes);
    }

    public List<SplitDto> findAllSplits() {
        List<SplitLength> splits = splitLengthRepository.findAll();
        return eventMapper.splitlengthListToSplitDtoList(splits);
    }

}

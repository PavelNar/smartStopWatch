package com.project.smartStopWatch.domain.event;

import com.project.smartStopWatch.app.event.EventRequest;
import com.project.smartStopWatch.app.event.EventResponse;
import com.project.smartStopWatch.domain.stroke.Stroke;
import com.project.smartStopWatch.domain.split.SplitLength;
import com.project.smartStopWatch.domain.split.SplitLengthRepository;
import com.project.smartStopWatch.domain.stroke.StrokeRepository;
import com.project.smartStopWatch.domain.user.User;
import com.project.smartStopWatch.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}

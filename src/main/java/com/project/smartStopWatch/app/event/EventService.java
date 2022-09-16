package com.project.smartStopWatch.app.event;

import com.project.smartStopWatch.app.setup.dto.event.EventSettingsRequest;
import com.project.smartStopWatch.domain.athlete.event.Event;
import com.project.smartStopWatch.domain.athlete.event.EventMapper;
import com.project.smartStopWatch.domain.athlete.event.EventRepository;
import com.project.smartStopWatch.domain.split.length.SplitLength;
import com.project.smartStopWatch.domain.split.length.SplitLengthService;
import com.project.smartStopWatch.domain.stroke.Stroke;
import com.project.smartStopWatch.domain.stroke.StrokeService;
import com.project.smartStopWatch.domain.user.User;
import com.project.smartStopWatch.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EventService {

    @Resource
    private SplitLengthService splitLengthService;

    @Resource
    private StrokeService strokeService;

    @Resource
    private UserService userService;

    @Resource
    private EventMapper eventMapper;

    @Resource
    private EventRepository eventRepository;

    public Event createAndAddEvent(EventSettingsRequest request) {
        User user = userService.findUserByUserId(request.getUserId());
        Stroke stroke = strokeService.findStrokeByStrokeId(request.getStrokeId());
        SplitLength splitLength = splitLengthService.findSplitLengthBy(request.getSplitLengthId());
        Event event = eventMapper.eventSettingsRequestToEvent(request);
        event.setUser(user);
        event.setStroke(stroke);
        event.setSplitLength(splitLength);
        eventRepository.save(event);
        return event;
    }

}

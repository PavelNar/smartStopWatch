package com.project.smartStopWatch.domain.event;

import com.project.smartStopWatch.app.event.EventRequest;
import com.project.smartStopWatch.app.event.EventResponse;
import com.project.smartStopWatch.domain.Event;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EventService {

    @Resource
    private EventRepository eventRepository;

    @Resource
    private EventMapper eventMapper;

    public EventResponse createGlobalSettings(EventRequest request) {
        Event event = eventMapper.eventRequestToEvent(request);
        // TODO: 12.09.2022 usserRepos otsid useri kasutades uerID
//        event.setUser();


        eventRepository.save(event);
        return null;
    }
}

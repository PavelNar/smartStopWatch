package com.project.smartStopWatch.domain.stroke;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StrokeService {

    @Resource
    private StrokeRepository strokeRepository;

    public Stroke findById(Integer strokeId) {
        return strokeRepository.findById(strokeId).get();
    }
}

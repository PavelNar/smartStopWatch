package com.project.smartStopWatch.domain.stroke;

import com.project.smartStopWatch.app.event.StrokeDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StrokeService {

    @Resource
    private StrokeRepository strokeRepository;

    @Resource
    private StrokeMapper strokeMapper;

    public Stroke findById(Integer strokeId) {
        return strokeRepository.findById(strokeId).get();
    }

    public Stroke findStrokeByStrokeId(Integer strokeId) {
        return strokeRepository.findStrokeByStrokeId(strokeId);
    }

    public List<StrokeDto> findAllStrokes() {
        List <Stroke> strokes = strokeRepository.findAll();
        return strokeMapper.strokeListToStrokeDtoList(strokes);
    }
}
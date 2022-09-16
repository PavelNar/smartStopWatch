package com.project.smartStopWatch.domain.stroke;

import com.project.smartStopWatch.app.setup.dto.split.StrokeDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StrokeMapper {

    List<StrokeDto> strokeListToStrokeDtoList(List<Stroke> strokes);

}
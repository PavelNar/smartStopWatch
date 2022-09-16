package com.project.smartStopWatch.domain.split.length;

import com.project.smartStopWatch.app.setup.dto.split.SplitLengthDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SplitLengthMapper {

    SplitLengthDto splitLengthToSplitLengthDto(SplitLength splitLengths);

    List<SplitLengthDto> splitLengthsToSplitLengthDtos(List<SplitLength> splitLengths);

}

package com.project.smartStopWatch.domain.split;

import com.project.smartStopWatch.app.event.SplitLengthDto;
import com.project.smartStopWatch.app.split.SplitRequest;
import com.project.smartStopWatch.app.split.SplitResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SplitMapper {
    @Mapping(source = "athleteId", target = "athlete.id")
    @Mapping(source = "athleteEventId", target = "athleteEvent.id")
    Split splitRequestToSplit(SplitRequest splitRequest);

    @InheritInverseConfiguration(name = "splitRequestToSplit")
    SplitRequest splitToSplitRequest(Split split);

    @InheritConfiguration(name = "splitRequestToSplit")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Split updateSplitFromSplitRequest(SplitRequest splitRequest, @MappingTarget Split split);

    Split splitResponseToSplit(SplitResponse splitResponse);

    SplitResponse splitToSplitResponse(Split split);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Split updateSplitFromSplitResponse(SplitResponse splitResponse, @MappingTarget Split split);

    List<SplitLengthDto> splitLengthListToSplitDtoList(List<SplitLength> splits);
}

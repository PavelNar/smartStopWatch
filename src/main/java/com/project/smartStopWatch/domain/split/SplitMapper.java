package com.project.smartStopWatch.domain.split;

import com.project.smartStopWatch.app.setup.dto.split.SplitLengthDto;
import com.project.smartStopWatch.domain.split.length.SplitLength;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SplitMapper {

    List<SplitLengthDto> splitLengthListToSplitDtoList(List<SplitLength> splits);

}

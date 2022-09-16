package com.project.smartStopWatch.app.event.dropdown;

import com.project.smartStopWatch.app.event.SplitLengthDto;
import com.project.smartStopWatch.app.event.StrokeDto;
import lombok.Data;

import java.util.List;

@Data
public class GlobalSettingsDropdownDto {

    private List<SplitLengthDto> splitLengthDtos;
    private List<StrokeDto> strokeDtos;

}

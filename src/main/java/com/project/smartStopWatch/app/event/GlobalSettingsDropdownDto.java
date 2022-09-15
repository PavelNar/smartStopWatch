package com.project.smartStopWatch.app.event;

import lombok.Data;

import java.util.List;

@Data
public class GlobalSettingsDropdownDto {

    private List<SplitLengthDto> splitLengthDtos;
    private List<StrokeDto> strokeDtos;

}

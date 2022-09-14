package com.project.smartStopWatch.app.event;

import lombok.Data;

import java.util.List;

@Data
public class GlobalSettingsDropdownDto {

    private List<SplitDto> splitDtos;
    private List<StrokeDto> strokeDtos;

}

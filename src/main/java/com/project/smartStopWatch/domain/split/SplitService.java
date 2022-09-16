package com.project.smartStopWatch.domain.split;

import com.project.smartStopWatch.app.event.SplitLengthDto;
import com.project.smartStopWatch.app.split.SplitRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SplitService {


    @Resource
    private SplitRepository splitRepository;

    @Resource
    private SplitMapper splitMapper;

    @Resource
    private SplitLengthRepository splitLengthRepository;


    public List<SplitLengthDto> findAllSplits() {
        List<SplitLength> splits = splitLengthRepository.findAll();
        return splitMapper.splitLengthListToSplitDtoList(splits);
    }
}

package com.project.smartStopWatch.domain.split.length;

import com.project.smartStopWatch.app.setup.dto.split.SplitLengthDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SplitLengthService {

    @Resource
    private SplitLengthRepository splitLengthRepository;

    @Resource
    private SplitLengthMapper splitLengthMapper;

    public List<SplitLengthDto> findAllSplits() {
        List<SplitLength> splitLengths = splitLengthRepository.findAll();
        return splitLengthMapper.splitLengthsToSplitLengthDtos(splitLengths);
    }

    public SplitLength findSplitLengthBy(Integer splitLengthId) {
        return splitLengthRepository.findSplitLengthBy(splitLengthId);
    }

}

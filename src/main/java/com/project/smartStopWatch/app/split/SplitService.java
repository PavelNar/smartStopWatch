package com.project.smartStopWatch.app.split;

import com.project.smartStopWatch.domain.split.SplitMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SplitService {


    @Resource
    private SplitRepository splitRepository;

    @Resource
    private SplitMapper splitMapper;


}

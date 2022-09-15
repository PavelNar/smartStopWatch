package com.project.smartStopWatch.app.split;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/split")
public class SplitController {

    @Resource
    private SplitService splitService;

    @PostMapping("/result")
    @Operation(summary = "Save one athlete split result")

}

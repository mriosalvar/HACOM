package com.prueba.controller;

import com.prueba.dto.DateRangeRequest;
import com.prueba.model.TraceMsg;
import com.prueba.service.TraceMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/tracemsg")
public class TraceMsgController {

    private static Logger logger = LoggerFactory.getLogger(TraceMsgController.class);

    private final TraceMsgService service;

    public TraceMsgController(TraceMsgService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<ResponseEntity<TraceMsg>> insertTraceMsg(@RequestBody TraceMsg traceMsg) {
        logger.info("insertTraceMsg - Controller : " + traceMsg.toString());
        return service.insertTrace(traceMsg).map(ResponseEntity::ok);
    }

    @GetMapping
    public Flux<TraceMsg> getTracesByDate(@RequestBody @Valid DateRangeRequest dateRangeRequest) {
        logger.info("getTracesByDate - Controller : " + dateRangeRequest.toString());
        return service.getTracesByDate(dateRangeRequest.getFrom(), dateRangeRequest.getTo());
    }

}

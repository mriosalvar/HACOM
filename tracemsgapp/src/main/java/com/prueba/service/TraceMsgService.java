package com.prueba.service;

import com.prueba.model.TraceMsg;
import com.prueba.repository.TraceMsgRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
public class TraceMsgService {

    private static final Logger logger = LoggerFactory.getLogger(TraceMsgService.class);

    private final TraceMsgRepository repository;
    private final Counter insertCounter;

    public TraceMsgService(TraceMsgRepository repository, MeterRegistry mr) {
        this.repository = repository;
        this.insertCounter = mr.counter("hacom.test.developer.insert.rx");
    }

    public Mono<TraceMsg> insertTrace(TraceMsg trace) {
        logger.info("Request insertTraceMsg: " + trace.toString());
        insertCounter.increment();
        return repository.save(trace)
                .doOnSuccess(traceReturn -> logger.info("Insertado en BD: {}", traceReturn));
    }

    public Flux<TraceMsg> getTracesByDate(Instant from, Instant to) {
        logger.info("Request msg entre {} y {}", from, to);
        return repository.findByTsBetween(from, to);
    }


}

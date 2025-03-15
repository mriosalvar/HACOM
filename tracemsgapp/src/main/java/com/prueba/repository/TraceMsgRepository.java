package com.prueba.repository;

import com.prueba.model.TraceMsg;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.time.Instant;

public interface TraceMsgRepository extends ReactiveMongoRepository<TraceMsg, String> {
    Flux<TraceMsg> findByTsBetween(Instant from, Instant to);
}

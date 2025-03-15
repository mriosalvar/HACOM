package com.prueba.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.OffsetDateTime;

@Document(collection = "tracemsgs")
public class TraceMsg {

    @Id
    private ObjectId id;
    private String sessionId;
    private String payload;
    private Instant ts;

    @Override
    public String toString() {
        return "TraceMsg{" +
                "id=" + id +
                ", sessionId='" + sessionId + '\'' +
                ", payload='" + payload + '\'' +
                ", ts=" + ts +
                '}';
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Instant getTs() {
        return ts;
    }

    public void setTs(Instant ts) {
        this.ts = ts;
    }
}

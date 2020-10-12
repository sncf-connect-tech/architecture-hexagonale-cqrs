package com.vsct.hexagonalcqrs.tests.bdd.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class TestContext {

    private ResponseEntity<?> responseEntity;

    public void setResponseEntity(ResponseEntity<?> responseEntity) {
        this.responseEntity = responseEntity;
    }

    public <T> T getResponseBody(Class<T> responseType) {
        return responseType.cast(responseEntity.getBody());
    }

    public <T> T getResponseBody() {
        return (T) responseEntity.getBody();
    }

    public <T> T[] getResponseBodyAsArray() {
        return (T[]) responseEntity.getBody();
    }

    public <T> List<T> getResponseBodyAsList() {
        return Arrays.asList(getResponseBodyAsArray());
    }

    public int getResponseBodyArrayLength() {
        return getResponseBodyAsArray().length;
    }

    public <K, V> Map<K, V> getResponseBodyAsMap() {
        return (Map<K, V>) responseEntity.getBody();
    }

    public HttpStatus getResponseStatusCode() {
        return responseEntity.getStatusCode();
    }
}

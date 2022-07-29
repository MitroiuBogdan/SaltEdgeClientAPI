package com.ing.casyadapterpoc.vendor.saltedge.response;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class SaltEdgeListResponse<T> {

    private List<T> data;

    protected SaltEdgeListResponse(List<T> data) {
        safeSetData(data);
    }

    protected SaltEdgeListResponse() {
        data = new ArrayList<>();
    }

    public void setData(List<T> data) {
        safeSetData(data);
    }

    private void safeSetData(List<T> data) {
        this.data = data == null ? new ArrayList<>() : data;
    }
}

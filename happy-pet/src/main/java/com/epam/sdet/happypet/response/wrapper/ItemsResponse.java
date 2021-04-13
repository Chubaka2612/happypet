package com.epam.sdet.happypet.response.wrapper;

import com.epam.sdet.happypet.util.ResponseCode;

import java.util.List;
import java.util.Objects;

public class ItemsResponse<T> {

    private List<T> items;

    private ResponseCode responseCode;

    public ItemsResponse(ResponseCode code, List<T> items) {
        this.responseCode = code;
        this.items = items;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsResponse<?> that = (ItemsResponse<?>) o;
        return Objects.equals(items, that.items) && responseCode == that.responseCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, responseCode);
    }
}

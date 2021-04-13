package com.epam.sdet.happypet.response.wrapper;

import com.epam.sdet.happypet.util.ResponseCode;

import java.util.Objects;

public class ItemResponse <T> {

    private T item;

    private ResponseCode responseCode;

    public ItemResponse(ResponseCode responseCode, T item) {
        this.item = item;
        this.responseCode = responseCode;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
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
        ItemResponse<?> that = (ItemResponse<?>) o;
        return Objects.equals(item, that.item) && responseCode == that.responseCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, responseCode);
    }
}

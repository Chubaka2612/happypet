package com.epam.sdet.happypet.response.wrapper;

import java.util.Objects;

public class ItemResponse <T> {

    private T item;

    public ItemResponse(T item) {
        this.item = item;
    }

    public ItemResponse() {

    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemResponse<?> that = (ItemResponse<?>) o;
        return Objects.equals(item, that.item) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }
}

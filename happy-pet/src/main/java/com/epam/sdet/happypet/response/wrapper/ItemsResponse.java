package com.epam.sdet.happypet.response.wrapper;

import java.util.List;
import java.util.Objects;

public class ItemsResponse<T> {

    private List<T> items;

    public ItemsResponse(List<T> items) {
        this.items = items;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsResponse<?> that = (ItemsResponse<?>) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}

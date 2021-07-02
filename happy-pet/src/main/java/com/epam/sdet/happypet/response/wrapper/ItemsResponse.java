package com.epam.sdet.happypet.response.wrapper;

import java.util.List;
import java.util.Objects;

public class ItemsResponse<T> {

    private Long totalItems;

    private List<T> items;

    public ItemsResponse(List<T> items, Long totalItems) {
        this.items = items;
        this.totalItems = totalItems;
    }

    public ItemsResponse(List<T> items) {
        this.items = items;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
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

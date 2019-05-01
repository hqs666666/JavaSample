package example.pojo;

import java.io.Serializable;
import java.util.List;

public class PagedList<T> implements Serializable {

    private List<T> items;
    private int total;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

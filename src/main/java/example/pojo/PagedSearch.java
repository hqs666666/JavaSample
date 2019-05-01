package example.pojo;

import java.io.Serializable;

public abstract class PagedSearch  implements Serializable {
    private int page;
    private int pagesize;
    private int offset;

    public PagedSearch(int page, int pagesize) {
        this.page = page;
        this.pagesize = pagesize;
    }

    public PagedSearch(){
        this.page = 1;
        this.pagesize = 10;
    }

    public int getOffset() {
        return (page - 1) * pagesize;
    }

    public int getPagesize() {
        return pagesize;
    }
}

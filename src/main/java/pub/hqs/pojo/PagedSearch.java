package pub.hqs.pojo;

import java.io.Serializable;

public abstract class PagedSearch  implements Serializable {
    private int page;
    private int pagesize;

    public void setPage(int page) {
        this.page = page;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public PagedSearch(){
        this.page = 1;
        this.pagesize = 10;
    }

    public int getPagesize() {
        return pagesize;
    }

    public int getPage() {
        return page;
    }
}

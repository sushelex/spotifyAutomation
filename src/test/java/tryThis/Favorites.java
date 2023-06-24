package tryThis;

import java.util.ArrayList;
import java.util.List;

public class Favorites {
    private List<Boards> boards = new ArrayList<Boards>();
    private List<Categories> categories = new ArrayList<Categories>();
    private List<Author> authorList = new ArrayList<Author>();
    private List<Thread> threads  = new ArrayList<Thread>();
//    private List<AncestryThread> ancestryThreadList = new ArrayList<AncestryThread>();

    private TotalCount totalCount;

    public List<Thread> getThreads() {
        return threads;
    }

    public void setThreads(List<Thread> threads) {
        this.threads = threads;
    }

    public TotalCount getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(TotalCount totalCount) {
        this.totalCount = totalCount;
    }

    public List<Boards> getBoards() {
        return boards;
    }

    public void setBoards(List<Boards> boards) {
        this.boards = boards;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

/*    public List<AncestryThread> getAncestryTreadList() {
        return ancestryThreadList;
    }

    public void setAncestryTreadList(List<AncestryThread> ancestryThreadList) {
        this.ancestryThreadList = ancestryThreadList;
    }*/
}

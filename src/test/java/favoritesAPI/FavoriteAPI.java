package favoritesAPI;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class FavoriteAPI
{
    private List<Thread> threads = new ArrayList<Thread>();
    private List<Author> authors = new ArrayList<Author>();

    private List<Category> categories = new ArrayList<Category>();

    private TotalCount totalCount;

    private List<Board> boards = new ArrayList<Board>();

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }
    public TotalCount getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(TotalCount totalCount) {
        this.totalCount = totalCount;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public void setThreads(List<Thread> threads) {
        this.threads = threads;
    }
}

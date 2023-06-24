package ancestry;

import tryThis.AncestryThreads;
import tryThis.Authors;

import java.util.ArrayList;
import java.util.List;

public class Playlists {
    private List<AncestryTread> ancestryTreadList = new ArrayList<AncestryTread>();
    private List<Author> authorList = new ArrayList<Author>();

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public List<AncestryTread> getAncestryTreadList() {
        return ancestryTreadList;
    }

    public void setAncestryTreadList(List<AncestryTread> ancestryTreadList) {
        this.ancestryTreadList = ancestryTreadList;
    }
}

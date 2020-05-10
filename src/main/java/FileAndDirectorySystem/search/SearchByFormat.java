package FileAndDirectorySystem.search;

import FileAndDirectorySystem.Directory;
import FileAndDirectorySystem.Entry;
import FileAndDirectorySystem.File;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchByFormat implements SearchCriteria {

    @Override
    public SearchResponse search(SearchRequest searchRequest, List<Entry> entries) {
        SearchResponse searchResponse = new SearchResponse(new ArrayList<>());
        search(searchRequest.getPattern(), entries, searchResponse);
        return searchResponse;
    }

    public void search(String format, List<Entry> entries, SearchResponse searchResponse) {
        for (Entry e : entries) {

            if (e instanceof Directory) {
                // searching within directory
                search(format, Collections.singletonList(e), searchResponse);
            } else {
                File f = (File) e;
                if (f.getFormat().endsWith(format)) {
                    searchResponse.getResult().add(e);
                }
            }
        }
    }
}

package FileAndDirectorySystem.search;

import FileAndDirectorySystem.Directory;
import FileAndDirectorySystem.Entry;

import java.util.ArrayList;
import java.util.List;

public class ApplySearchFilter implements SearchCriteria {

    private SearchByFileName searchByFileName;
    private SearchByFormat searchByFormat;
    private SearchBySize searchBySize;

    public ApplySearchFilter() {
        searchByFileName = new SearchByFileName();
        searchByFormat = new SearchByFormat();
        searchBySize = new SearchBySize();
    }

    @Override
    public SearchResponse search(SearchRequest searchRequest, List<Entry> entries) {
        SearchResponse searchResponse = null;

        if(searchRequest.getPattern()!=null){
            searchResponse =searchByFileName.search(searchRequest, entries);
        }

        if(searchRequest.getMinSize()!=null){
            if(searchResponse!=null){
                searchResponse =searchBySize.search(searchRequest, searchResponse.getResult());
            }
            else{
                searchResponse =searchBySize.search(searchRequest, entries);
            }
        }

        return searchResponse;
    }
}

package FileAndDirectorySystem.search;

import FileAndDirectorySystem.Directory;
import FileAndDirectorySystem.Entry;

import java.util.Arrays;

public class SearchByFileName implements SearchCriteria {

    // Assuming top level provided data is directory (not file)
    private Directory directory;

    public SearchByFileName(Directory directory) {
        this.directory = directory;
    }

    @Override
    public SearchResponse search(String value) {
        return search(value, directory);
    }

    public SearchResponse search(String fileName, Directory path) {
        for (Entry e : path.getEntries()) {

            if (e instanceof Directory) {
                // searching within directory
                SearchResponse searchResult = search(fileName, (Directory) e);

                if (!searchResult.getStatusCode().equalsIgnoreCase( "404")) {
                    return searchResult;
                }
            }
            else{

                if(e.getName().equalsIgnoreCase(fileName)){
                    return new SearchResponse(Arrays.asList(e), "200");
                }
            }
        }
        return new SearchResponse(null, "404");
    }
}

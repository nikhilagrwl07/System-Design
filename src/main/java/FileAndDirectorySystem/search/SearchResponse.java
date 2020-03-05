package FileAndDirectorySystem.search;

import FileAndDirectorySystem.Entry;

import java.util.List;

public class SearchResponse {
    private List<Entry> result;
    private String statusCode;

    public SearchResponse(List<Entry> result, String statusCode) {
        this.result = result;
        this.statusCode = statusCode;
    }

    public List<Entry> getResult() {
        return result;
    }

    public String getStatusCode() {
        return statusCode;
    }
}

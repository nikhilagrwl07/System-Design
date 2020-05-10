package FileAndDirectorySystem;

import FileAndDirectorySystem.search.ApplySearchFilter;
import FileAndDirectorySystem.search.SearchRequest;
import FileAndDirectorySystem.search.SearchResponse;

import java.util.Collections;
import java.util.List;

public class MainDriver {
    public static void main(String[] args) {
        MainDriver ob = new MainDriver();

        List<Entry> entries = buildFileSystem();
        SearchRequest searchRequest = new SearchRequest(31d,"F");

        ApplySearchFilter applySearchFilter = new ApplySearchFilter();
        SearchResponse searchResponse = applySearchFilter.search(searchRequest, entries);
        System.out.println(searchResponse);
    }

    // D1 -->
    //      F1.csv 10
    //      F2.ppt 20
    //      F3.txt 30
    //      D2 -->
    //              F4.txt 40
    //              F5.xlsx 50
    private static List<Entry> buildFileSystem() {
        File F1 = new File("F1.csv", 10d);
        File F2 = new File("F2.ppt", 20d);
        File F3 = new File("F3.txt", 30d);
        File F4 = new File("F4.txt", 40d);
        File F5 = new File("F5.xlsx", 50d);

        Directory d2 = new Directory();
        d2.add(F4);
        d2.add(F5);


        Directory d1 = new Directory();
        d1.add(F1);
        d1.add(F2);
        d1.add(F3);
        d1.add(d2);

        return Collections.singletonList(d1);
    }
}

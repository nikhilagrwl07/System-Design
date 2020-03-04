package FileAndDirectorySystem;

public class File extends Entry {
    private String content;
    private String format;
    private Integer size;

    public String getContent() {
        return content;
    }

    public String getFormat() {
        return format;
    }

    public Integer getSize() {
        return size;
    }
}

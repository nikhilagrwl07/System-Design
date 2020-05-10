package FileAndDirectorySystem;

public class File extends Entry {
    private String content;
    private String format;

    public File(String name, Double size) {
        super.setName(name);
        super.setSize(size);
    }

    public String getContent() {
        return content;
    }

    public String getFormat() {
        return format;
    }

}

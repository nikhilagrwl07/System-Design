package FileAndDirectorySystem;

import java.util.Date;

public abstract class Entry {

    private String name;
    private Date updatedTs;
    private Date lastAccessTs;
    private Date createdTs;


    public String getName() {
        return name;
    }

    public Date getUpdatedTs() {
        return updatedTs;
    }

    public Date getLastAccessTs() {
        return lastAccessTs;
    }

    public Date getCreatedTs() {
        return createdTs;
    }
}

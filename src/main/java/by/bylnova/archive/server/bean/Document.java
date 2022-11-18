package by.bylnova.archive.server.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Document {
    private String name;
    private Date date;
    private long id;
}

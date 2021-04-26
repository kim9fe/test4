package com.kim9fe.test4.domain;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardDTO {
    private long id;
    private String title;
    private String content;

    public String toString(){
        return (new Gson()).toJson(this);
    }
}

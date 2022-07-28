package com.example.vaco.Model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PostRequestModel {
    private String title;
    private String contents;
    private int categoryid;
}

package com.bookcompany.builder.model;

import java.io.File;

public enum Directory {
    FILE_DIRECTORY(("C:\\Users\\user\\IdeaProject\\TheBookCompany\\src\\com\\bookcompany\\builder\\data\\input\\")
    private final String path;

    Directory(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

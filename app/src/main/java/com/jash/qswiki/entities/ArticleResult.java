package com.jash.qswiki.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jash
 * Date: 15-12-30
 * Time: 下午3:23
 */
public class ArticleResult {
    @SerializedName("items")
    private List<ArticleItem> list;

    public List<ArticleItem> getList() {
        return list;
    }

    public void setList(List<ArticleItem> list) {
        this.list = list;
    }
}

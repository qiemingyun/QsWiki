package com.jash.qswiki.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jash
 * Date: 15-12-30
 * Time: 下午3:35
 */
public class ArticleType {
    private String title;
    private String type;

    private ArticleType(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }
    private static List<ArticleType> list;
    static {
        list = new ArrayList<>();
        list.add(new ArticleType("专享", "suggest"));
        list.add(new ArticleType("纯文", "text"));
        list.add(new ArticleType("纯图", "image"));
        list.add(new ArticleType("视频", "video"));
        list.add(new ArticleType("最新", "latest"));
    }
    public static List<ArticleType> getList(){
        return list;
    }
}

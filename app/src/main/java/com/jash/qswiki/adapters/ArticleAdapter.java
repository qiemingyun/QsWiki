package com.jash.qswiki.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jash.qswiki.entities.ArticleType;
import com.jash.qswiki.fragments.ArticleFragment;

import java.util.List;

/**
 * Created by jash
 * Date: 15-12-30
 * Time: 下午3:53
 */
public class ArticleAdapter extends FragmentPagerAdapter {
    private List<ArticleType> list;

    public ArticleAdapter(FragmentManager fm, List<ArticleType> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return ArticleFragment.newInstance(list.get(position).getType());
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getTitle();
    }
}

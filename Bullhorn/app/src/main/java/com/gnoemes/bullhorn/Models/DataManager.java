package com.gnoemes.bullhorn.Models;

import android.util.Log;

import com.gnoemes.bullhorn.Models.Database.DatabaseHelper;
import com.gnoemes.bullhorn.Models.Networking.Model.Article.Article;
import com.gnoemes.bullhorn.Models.Networking.Model.Source.Source;
import com.gnoemes.bullhorn.Models.Networking.NewsNetworkHelper;
import com.gnoemes.bullhorn.Models.Preference.PreferenceHelper;
import com.gnoemes.bullhorn.Utils.TextUtilites;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DataManager implements DataManagerHelper {

    private NewsNetworkHelper newsNetworkHelper;
    private DatabaseHelper databaseHelper;
    private PreferenceHelper preferenceHelper;

    @Inject
    public DataManager(NewsNetworkHelper newsNetworkHelper, DatabaseHelper databaseHelper, PreferenceHelper preferenceHelper) {
        this.newsNetworkHelper = newsNetworkHelper;
        this.databaseHelper = databaseHelper;
        this.preferenceHelper = preferenceHelper;
    }


    @Override
    public void saveSourceData(Source source) {

    }

    @Override
    public void saveArticleData(Article article) {

    }

    @Override
    public Observable<List<Source>> getSources(String category) {

        return newsNetworkHelper.getSources(category);
    }

    @Override
    public Observable<List<Article>> getArticles(String source) {
        Log.i("DEVE", "getArticles: " + TextUtilites.parseNameToId(source));
        return newsNetworkHelper.getArticles(TextUtilites.parseNameToId(source));
    }
}

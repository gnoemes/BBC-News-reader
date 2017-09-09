package com.gnoemes.bullhorn.models.networking.data;

import com.gnoemes.bullhorn.models.networking.model.source.Source;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface SourceData {

    @GET("sources?")
    Observable<Source> getSourcesData(@Query("category") String category, @Query("language") String language);

}

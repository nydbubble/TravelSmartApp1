package com.example.nydia.travelsmartapp.network;

import com.example.nydia.travelsmartapp.models.DirectionsResults;
import com.example.nydia.travelsmartapp.models.GeocodingResults;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nydia on 3/29/18.
 */

public interface DirectionsService {
    @GET("directions/json?")
    Call<DirectionsResults> getDirections(@Query("origin") String origin,
                                          @Query("destination") String destination,
                                          @Query("key") String key);

    @GET("geocode/json?")
    Call<GeocodingResults> getReverseGeocoding(@Query("latlng") String latlng,
                                               @Query("key") String key);
}

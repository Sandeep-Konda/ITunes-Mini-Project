package sandeep.itunesminiproject.retrofitutils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import sandeep.itunesminiproject.DTO.OutputResponse;



public interface APIInterface {
    @GET("/search")
    Call<OutputResponse> getSearchResults(@Query("term") String term,
                                          @Query("entity") String entity);
}

package starace.com.staracetest.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import starace.com.staracetest.models.ResponseModel;

/**
 * Created by mstarace on 9/13/17.
 */

public interface PlaceHolderClient {

    @GET("photos")
    Call<List<ResponseModel>> getResponseModels();

}

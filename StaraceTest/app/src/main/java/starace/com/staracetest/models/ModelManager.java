package starace.com.staracetest.models;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import starace.com.staracetest.contract.Contract;
import starace.com.staracetest.retrofit.PlaceHolderClient;
import starace.com.staracetest.retrofit.RetrofitInterface;

/**
 * Created by mstarace on 9/13/17.
 */

public class ModelManager implements Contract.Model {

    private static String TAG = ModelManager.class.getSimpleName();

    private Contract.Presenter presenter;

    public static Contract.Model getInstanceModelManager(Contract.Presenter presenter) {
        return new ModelManager(presenter);
    }

    private ModelManager(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getPlaceHolderModelList() {
        PlaceHolderClient client = RetrofitInterface.getClient().create(PlaceHolderClient.class);
        Call<List<ResponseModel>> call = client.getResponseModels();
        call.enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                convertToPlaceHolderModels(response);
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {
                Log.e(TAG, "Failed to return list of ResponseModels");
            }
        });
    }

    private void convertToPlaceHolderModels(Response<List<ResponseModel>> response) {
        List<ResponseModel> responseModelList = response.body();
        List<PlaceHolderModel> placeHolderModelList = new ArrayList<>();
        if (responseModelList != null) {
            for (ResponseModel responseModel : responseModelList) {
                placeHolderModelList.add(new PlaceHolderModel(responseModel.getId().concat(" - ").concat(responseModel.getTitle()),
                        responseModel.getThumbnailUrl()));
            }
        }

        if (!placeHolderModelList.isEmpty()) {
            presenter.modelReturn(placeHolderModelList);
        }

    }

}

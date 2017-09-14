package starace.com.staracetest.contract;

import java.util.List;

import starace.com.staracetest.models.PlaceHolderModel;

/**
 * Created by mstarace on 9/13/17.
 */

public class Contract {

    public interface Model {
        void getPlaceHolderModelList();
    }

    public interface Presenter {
        void modelReturn(List<PlaceHolderModel> placeHolderModelList);

        void requestModelList();
    }

    public interface View {
        void updateRecyclerView(List<PlaceHolderModel> placeHolderModelList);
    }
}

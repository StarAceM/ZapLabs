package starace.com.staracetest;

import java.util.List;

import starace.com.staracetest.contract.Contract;
import starace.com.staracetest.models.ModelManager;
import starace.com.staracetest.models.PlaceHolderModel;

/**
 * Created by mstarace on 9/13/17.
 */

public class Presenter implements Contract.Presenter {

    private Contract.View view;

    public static Contract.Presenter getPresenterInstance(Contract.View view) {
        return new Presenter(view);
    }

    public Presenter(Contract.View view) {
        this.view = view;
    }

    @Override
    public void modelReturn(List<PlaceHolderModel> placeHolderModelList) {
        view.updateRecyclerView(placeHolderModelList);
    }

    @Override
    public void requestModelList() {
        Contract.Model model = ModelManager.getInstanceModelManager(this);
        model.getPlaceHolderModelList();
    }
}

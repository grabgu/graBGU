package Controller;

import Model.ISearchTagsModel;
import ViewControllers.IView;

public class Controller {
    ISearchTagsModel model;
    IView view;

    public void setModel(ISearchTagsModel model){
        this.model = model;
    }

    public void setView(IView view){
        this.view = view;
    }

    

}

package menu;

import utils.*;
import menu.*;
import model.*;

public class ActieLogin implements IActie {

    @Override
    public void voerActieUit() {
        Security.getInstance().login();
    }
}

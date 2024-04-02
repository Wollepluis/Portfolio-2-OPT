package menu;

import utils.*;
import menu.*;
import model.*;

public class ActieLogout implements IActie {

    @Override
    public void voerActieUit() {
        Security.getInstance().logout();
    }
}

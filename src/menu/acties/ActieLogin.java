package menu.acties;

import utils.*;

public class ActieLogin implements IActie {

    @Override
    public void voerActieUit() {
        Security.getInstance().login();
    }
}

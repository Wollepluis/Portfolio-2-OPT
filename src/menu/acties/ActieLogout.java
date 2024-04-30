package menu.acties;

import utils.*;

public class ActieLogout implements IActie {

    @Override
    public void voerActieUit() {
        Security.getInstance().logout();
    }
}

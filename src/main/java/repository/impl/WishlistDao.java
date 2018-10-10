package repository.impl;

import pojo.WishList;
import repository.background.DaoBackground;
import repository.iface.IWishlistDao;

import java.util.List;

public class WishlistDao implements IWishlistDao {
    private final static DaoBackground<WishList> background = new DaoBackground<>(WishList::new,
            WishList[]::new,
            WishList::init);

    @Override
    public boolean add(WishList wishList) {
        return background.execute("INSERT INTO wishlist VALUES (?, ?)",
                wishList.getClientId(), wishList.getTourId());
    }

    @Override
    public List<WishList> getAllByClientIdTourId(Integer clientId, Integer tourId) {
        return background.fetchRowsAsPojoList("SELECT * FROM wishlist " +
                "WHERE client_id=? and tour_id = ?", clientId, tourId);
    }
}

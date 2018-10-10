package service.impl;

import pojo.WishList;
import repository.iface.IWishlistDao;
import repository.impl.WishlistDao;
import service.iface.IWishlistSrv;

import java.util.List;

public class WishlistSrv implements IWishlistSrv {
    private IWishlistDao wishlistDao;

    public WishlistSrv() {
        this.wishlistDao = new WishlistDao();
    }

    public WishlistSrv(IWishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    @Override
    public boolean add(WishList wishList) {
        return wishlistDao.add(wishList);
    }

    @Override
    public List<WishList> getAllByClientIdTourId(Integer clientId,
                                                 Integer tourId) {
        return wishlistDao.getAllByClientIdTourId(clientId, tourId);
    }
}

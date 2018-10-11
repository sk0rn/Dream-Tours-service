package service.iface;

import pojo.WishList;

import java.util.List;

public interface IWishlistSrv {

    boolean add(WishList wishList);

    List<WishList> getAllByClientIdTourId(Integer clientId, Integer tourId);
}

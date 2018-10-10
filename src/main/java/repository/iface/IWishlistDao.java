package repository.iface;

import pojo.WishList;

import java.util.List;

public interface IWishlistDao {

    boolean add(WishList wishList);

    List<WishList> getAllByClientIdTourId(Integer clientId, Integer tourId);
}

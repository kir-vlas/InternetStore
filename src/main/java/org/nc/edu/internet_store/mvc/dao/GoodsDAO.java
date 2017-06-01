package org.nc.edu.internet_store.mvc.dao;

import org.nc.edu.internet_store.mvc.domain.Good;
import java.util.List;

public interface GoodsDAO {
    public void addGood(Good good);

    public List<Good> listGood();

    public List<Good> listGoodByCategory(Integer id);

    public Good listGoodById(Integer id);

    public void updateGood(Good good);

    public void deleteGood(Integer id);
}

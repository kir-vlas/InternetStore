package org.nc.edu.internet_store.mvc.service;

import org.nc.edu.internet_store.mvc.domain.Good;
import java.util.List;

public interface GoodService {
    public void addGood(Good good);

    public List<Good> listGood();

    public List<Good> listGoodByCategory(Integer Id);

    public Good listGoodById(Integer Id);

    public void updateGood(Good good);

    public void deleteGood(Integer id);
}

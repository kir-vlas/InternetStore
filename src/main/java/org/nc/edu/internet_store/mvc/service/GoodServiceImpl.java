package org.nc.edu.internet_store.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.nc.edu.internet_store.mvc.domain.Good;
import org.nc.edu.internet_store.mvc.dao.GoodsDAO;

@Service
@Transactional
public class GoodServiceImpl implements GoodService{
    @Autowired
    private GoodsDAO goodsDAO;

    @Transactional
    public void addGood(Good good) {
        goodsDAO.addGood(good);
    }

    @Transactional
    public List<Good> listGood() {
        return goodsDAO.listGood();
    }

    @Transactional
    public List<Good> listGoodByCategory(Integer id){return goodsDAO.listGoodByCategory(id);}

    @Transactional
    public Good listGoodById(Integer id){return  goodsDAO.listGoodById(id);}

    @Transactional
    public void updateGood(Good good){
        goodsDAO.updateGood(good);
    }

    @Transactional
    public void deleteGood(Integer id) {
        goodsDAO.deleteGood(id);
    }
}

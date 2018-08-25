package com.zthack.drip.service.impl;

import com.zthack.drip.dao.CategoryDao;
import com.zthack.drip.model.Category;
import com.zthack.drip.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hucker on 2018/8/25.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    /**
     * 获取全部分类
     *
     * @return
     */
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}

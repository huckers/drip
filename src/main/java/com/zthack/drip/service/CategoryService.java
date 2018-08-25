package com.zthack.drip.service;

import com.zthack.drip.dao.CategoryDao;
import com.zthack.drip.model.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by hucker on 2018/8/25.
 */
public interface CategoryService {

    /**
     * 获取全部分类
     *
     * @return
     */
    List<Category> findAll();

}

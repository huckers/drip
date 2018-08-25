package com.zthack.drip.dao;

import com.zthack.drip.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hucker on 2018/8/25.
 */
public interface CategoryDao extends JpaRepository<Category, Long>{
}

package com.java4all.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * description:
 *
 * @author wangzhongxiang
 * @date 2019/2/14 14:39
 */
@Repository
public interface CompanyDao {
    int increaseMoney(@Param("id") Integer id,@Param("money") BigDecimal money);
    int confirmIncreaseMoney(@Param("id") Integer id,@Param("money") BigDecimal money);
    int cancelIncreaseMoney(@Param("id") Integer id,@Param("money") BigDecimal money);
}


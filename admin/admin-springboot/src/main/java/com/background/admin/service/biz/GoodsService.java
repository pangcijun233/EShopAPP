package com.inc.admin.service.biz;

import com.github.pagehelper.PageInfo;
import com.inc.admin.domain.biz.Goods;
import java.util.List;

/**
 * 管理 service
 * @author xty
 * @date 2023-05-16 17:45:55
*/
public interface GoodsService {
    /**
     * 分页查询
     */
    PageInfo<Goods> listByPage(Goods req);

    /**
     * 查询列表
     */
    List<Goods> getList(Goods req);

    /**
     * 单个查询
     */
    Goods getOne(Goods req);

    /**
     * 新增
     */
    int insert(Goods req);

    /**
     * 根据主键修改
     */
    int update(Goods req);

    /**
     * 根据主键删除
     */
    int delete(Integer id);
}
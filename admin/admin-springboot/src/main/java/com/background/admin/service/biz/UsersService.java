package com.inc.admin.service.biz;

import com.github.pagehelper.PageInfo;
import com.inc.admin.domain.biz.Users;
import java.util.List;

/**
 * 管理 service
 * @author xty
 * @date 2023-05-16 16:16:06
*/
public interface UsersService {
    /**
     * 分页查询
     */
    PageInfo<Users> listByPage(Users req);

    /**
     * 查询列表
     */
    List<Users> getList(Users req);

    /**
     * 单个查询
     */
    Users getOne(Users req);

    /**
     * 新增
     */
    int insert(Users req);

    /**
     * 根据主键修改
     */
    int update(Users req);

    /**
     * 根据主键删除
     */
    int delete(Integer id);
}
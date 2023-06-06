package com.inc.admin.service.biz.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.inc.admin.dao.biz.UsersDao;
import com.inc.admin.domain.biz.Users;
import com.inc.admin.domain.biz.UsersCriteria;
import com.inc.admin.service.biz.UsersService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    /**
     * 分页查询
     */
    @Override
    public PageInfo<Users> listByPage(Users req) {
        PageHelper.startPage(req.getPageNo(), req.getPageSize());
        UsersCriteria condition = buildCondition(req);
        return new PageInfo<>(usersDao.selectByExample(condition));
    }

    /**
     * 查询list
     */
    @Override
    public List<Users> getList(Users req) {
        return usersDao.selectByExample(buildCondition(req));
    }

    /**
     * 单个查询
     */
    @Override
    public Users getOne(Users req) {
        List<Users> lst = getList(req);
        if (CollectionUtils.isEmpty(lst)) {
            return null;
        }
        return lst.get(0);
    }

    /**
     * 新增
     */
    @Override
    public int insert(Users req) {
        return usersDao.insertSelective(req);
    }

    /**
     * 根据主键更新不为空的值
     */
    @Override
    public int update(Users req) {
        return usersDao.updateByPrimaryKeySelective(req);
    }

    /**
     * 根据主键删除该记录
     */
    @Override
    public int delete(Integer id) {
        return usersDao.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     */
    private UsersCriteria buildCondition(Users req) {
        UsersCriteria usersCriteria= new UsersCriteria();
        UsersCriteria.Criteria criteria = usersCriteria.createCriteria();
        if (req != null) {
            if (req.getId() != null) {criteria.andIdEqualTo(req.getId());}
            if (StringUtils.isNotBlank(req.getName())) {criteria.andNameEqualTo(req.getName());}
            if (req.getAge() != null) {criteria.andAgeEqualTo(req.getAge());        }
            if (StringUtils.isNotBlank(req.getUpdatetime())) {criteria.andUpdatetimeEqualTo(req.getUpdatetime());}
            if (StringUtils.isNotBlank(req.getPhone())) {criteria.andPhoneEqualTo(req.getPhone());}
            if (StringUtils.isNotBlank(req.getPassword())) {criteria.andPasswordEqualTo(req.getPassword());}
            if (StringUtils.isNotBlank(req.getAddress())) {criteria.andAddressEqualTo(req.getAddress());}
        }
        return usersCriteria;
    }
}
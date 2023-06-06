package com.inc.admin.service.biz.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.inc.admin.dao.biz.GoodsDao;
import com.inc.admin.domain.biz.Goods;
import com.inc.admin.domain.biz.GoodsCriteria;
import com.inc.admin.service.biz.GoodsService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    /**
     * 分页查询
     */
    @Override
    public PageInfo<Goods> listByPage(Goods req) {
        PageHelper.startPage(req.getPageNo(), req.getPageSize());
        GoodsCriteria condition = buildCondition(req);
        return new PageInfo<>(goodsDao.selectByExample(condition));
    }

    /**
     * 查询list
     */
    @Override
    public List<Goods> getList(Goods req) {
        return goodsDao.selectByExample(buildCondition(req));
    }

    /**
     * 单个查询
     */
    @Override
    public Goods getOne(Goods req) {
        List<Goods> lst = getList(req);
        if (CollectionUtils.isEmpty(lst)) {
            return null;
        }
        return lst.get(0);
    }

    /**
     * 新增
     */
    @Override
    public int insert(Goods req) {
        return goodsDao.insertSelective(req);
    }

    /**
     * 根据主键更新不为空的值
     */
    @Override
    public int update(Goods req) {
        return goodsDao.updateByPrimaryKeySelective(req);
    }

    /**
     * 根据主键删除该记录
     */
    @Override
    public int delete(Integer id) {
        return goodsDao.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     */
    private GoodsCriteria buildCondition(Goods req) {
        GoodsCriteria goodsCriteria= new GoodsCriteria();
        GoodsCriteria.Criteria criteria = goodsCriteria.createCriteria();
        if (req != null) {
            if (req.getId() != null) {criteria.andIdEqualTo(req.getId());}
            if (StringUtils.isNotBlank(req.getName())) {criteria.andNameEqualTo(req.getName());}
            if (req.getPrice() != null) {criteria.andPriceEqualTo(req.getPrice());        }
            if (req.getPicid() != null) {criteria.andPicidEqualTo(req.getPicid());        }
            if (StringUtils.isNotBlank(req.getPicpath())) {criteria.andPicpathEqualTo(req.getPicpath());}
            if (StringUtils.isNotBlank(req.getCategory())) {criteria.andCategoryEqualTo(req.getCategory());}
        }
        return goodsCriteria;
    }
}
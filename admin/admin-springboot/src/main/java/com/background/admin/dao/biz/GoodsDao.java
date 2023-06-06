package com.inc.admin.dao.biz;

import com.inc.admin.domain.biz.Goods;
import com.inc.admin.domain.biz.GoodsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GoodsDao {
    /**
     * @param example
     * @return long
     */
    long countByExample(GoodsCriteria example);

    /**
     * @param example
     * @return int
     */
    int deleteByExample(GoodsCriteria example);

    /**
     * 根据主键删除 
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加 
     * @param record
     * @return int
     */
    int insert(Goods record);

    /**
     * 插入值不为空的列 
     * @param record
     * @return int
     */
    int insertSelective(Goods record);

    /**
     * @param example
     * @return java.util.List<com.inc.admin.domain.biz.Goods>
     */
    List<Goods> selectByExampleWithBLOBs(GoodsCriteria example);

    /**
     * @param example
     * @return java.util.List<com.inc.admin.domain.biz.Goods>
     */
    List<Goods> selectByExample(GoodsCriteria example);

    /**
     * 根据主键查询 
     * @param id
     * @return com.inc.admin.domain.biz.Goods
     */
    Goods selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @param example
     * @return int
     */
    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsCriteria example);

    /**
     * @param record
     * @param example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("record") Goods record, @Param("example") GoodsCriteria example);

    /**
     * @param record
     * @param example
     * @return int
     */
    int updateByExample(@Param("record") Goods record, @Param("example") GoodsCriteria example);

    /**
     * 根据主键更新值不为空的列 
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Goods record);

    /**
     * @param record
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(Goods record);

    /**
     * 根据主键更新 
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Goods record);
}
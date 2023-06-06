package com.inc.admin.dao.biz;

import com.inc.admin.domain.biz.Users;
import com.inc.admin.domain.biz.UsersCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UsersDao {
    /**
     * @param example
     * @return long
     */
    long countByExample(UsersCriteria example);

    /**
     * @param example
     * @return int
     */
    int deleteByExample(UsersCriteria example);

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
    int insert(Users record);

    /**
     * 插入值不为空的列 
     * @param record
     * @return int
     */
    int insertSelective(Users record);

    /**
     * @param example
     * @return java.util.List<com.inc.admin.domain.biz.Users>
     */
    List<Users> selectByExample(UsersCriteria example);

    /**
     * 根据主键查询 
     * @param id
     * @return com.inc.admin.domain.biz.Users
     */
    Users selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @param example
     * @return int
     */
    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersCriteria example);

    /**
     * @param record
     * @param example
     * @return int
     */
    int updateByExample(@Param("record") Users record, @Param("example") UsersCriteria example);

    /**
     * 根据主键更新值不为空的列 
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Users record);

    /**
     * 根据主键更新 
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Users record);
}
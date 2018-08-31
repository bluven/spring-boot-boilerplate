package com.github.bluven.demo.mapper;

import com.github.bluven.demo.entity.User;
import com.github.bluven.demo.util.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface UserMapper extends BaseMapper<User> {
    /**
     * 判断是否有用户存在
     */
    @Select("SELECT count(*) FROM auth_user")
    boolean isAnyExisting();

    List<User> selectByName(@Param("name") String name);
    
    /**
     * 删除用户
     */
    @Update("UPDATE user SET deleted = id WHERE id = #{id}")
    int deleteById(Integer id);
}

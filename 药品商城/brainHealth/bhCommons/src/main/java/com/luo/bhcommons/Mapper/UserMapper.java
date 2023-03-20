package com.luo.bhcommons.Mapper;

import com.luo.bhcommons.Entity.fUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper  {
    @Select("SELECT * FROM f_user WHERE id = #{id}")
    public fUser getUserById(@Param("id") Integer id);

    @Delete("DELETE FROM department WHERE id = #{id}")
    public int deleteUserById(@Param("id") Integer id);


    @Insert("INSERT INTO f_user VALUES(#{user})")
    public int insertUser(fUser fuser);

}

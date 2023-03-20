package com.luo.bhfront.mapper;

import com.luo.bhfront.Entity.fUser;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper  {
    @Select("SELECT * FROM f_user WHERE uid = #{id}")
    public fUser getUserById(@Param("id") Integer id);
    @Select("SELECT * FROM f_user WHERE account = #{account} AND password=#{pass}")
    public fUser getUserByacps(@Param("account") String account,@Param("pass") String pass);
    @Delete("DELETE FROM department WHERE id = #{id}")
    public int deleteUserById(@Param("id") Integer id);


    @Insert("INSERT INTO f_user (account,password)VALUES(#{account},#{pass})")
    public int insertUser(String account,String pass);

}

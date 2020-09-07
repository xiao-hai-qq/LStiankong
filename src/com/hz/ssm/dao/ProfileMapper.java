package com.hz.ssm.dao;

import com.hz.ssm.pojo.Profile;
import com.hz.ssm.pojo.ProfileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProfileMapper {
    int countByExample(ProfileExample example);

    int deleteByExample(ProfileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Profile record);

    int insertSelective(Profile record);

    List<Profile> selectByExample(ProfileExample example);

    Profile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Profile record, @Param("example") ProfileExample example);

    int updateByExample(@Param("record") Profile record, @Param("example") ProfileExample example);

    int updateByPrimaryKeySelective(Profile record);

    int updateByPrimaryKey(Profile record);
}
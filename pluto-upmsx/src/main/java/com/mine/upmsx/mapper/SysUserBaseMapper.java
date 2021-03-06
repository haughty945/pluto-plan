package com.mine.upmsx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mine.common.feign.entity.upmsx.SysUserBase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * 【登录信息表】映射器
 *
 * @author Generated by Jax-li
 * @version v1.0
 * @date 2020-08-12
 */
@Mapper
public interface SysUserBaseMapper extends BaseMapper<SysUserBase> {

    SysUserBase getLoginInfo(@Param("clientId") String clientId,
                               @Param("userName") String userName);

    void updateLastLoginTime(@Param("userId") Long userId, @Param("lastLoginTime") LocalDateTime lastLoginTime);
}

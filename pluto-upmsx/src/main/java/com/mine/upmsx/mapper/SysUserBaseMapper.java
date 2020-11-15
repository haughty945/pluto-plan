package com.mine.upmsx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mine.common.feign.entity.SysUserBaseVO;
import com.mine.upmsx.entity.SysUserBase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 【登录信息表】映射器
 * @author Generated by Jax-li
 * @date  2020-08-12
 * @version v1.0
 */
@Mapper
public interface SysUserBaseMapper extends BaseMapper<SysUserBase> {

    SysUserBaseVO getLoginInfo(@Param("clientId") String clientId,
                               @Param(value = "userName") String userName);
}

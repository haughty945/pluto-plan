package com.mine.upmsx.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mine.common.feign.entity.SysUserBaseVO;
import com.mine.upmsx.dto.SysUserBaseDTO;
import com.mine.upmsx.entity.SysUserBase;

import java.util.List;

/**
 * @description: 【登录信息表】代理层
 * @author: Generated by Jax-li
 * @create: 2020-08-12
 * @version: v1.0
 */
public interface ISysUserBaseService extends IService<SysUserBase> {

    List<SysUserBaseVO> list(SysUserBaseDTO dto);

    SysUserBaseVO detail(Long id);

    void insert(SysUserBaseDTO dto);

    void update(SysUserBaseDTO dto);

    void delete(Long id);

    SysUserBaseVO getLoginInfo(String clientId, String userName);
}

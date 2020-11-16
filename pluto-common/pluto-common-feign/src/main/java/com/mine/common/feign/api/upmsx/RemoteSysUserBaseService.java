package com.mine.common.feign.api.upmsx;

import com.mine.common.core.constant.ServiceNameConstants;
import com.mine.common.core.result.Result;
import com.mine.common.feign.entity.SysUserBaseVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jax-li
 */
@FeignClient(value = ServiceNameConstants.UPMS)
public interface RemoteSysUserBaseService {

    /**
     * 通过用户名查询用户基本信息
     *
     * @param clientId 客户端id
     * @param userName 用户名
     * @return SysUserBaseVO系统用户基础VO
     */
    @GetMapping("/feign/sysUserBase/{clientId}/{userName}")
    SysUserBaseVO getUserByUserName(
            @PathVariable("clientId") String clientId,
            @PathVariable("userName") String userName);


    @GetMapping("/feign/test")
    Result<String> test();
}

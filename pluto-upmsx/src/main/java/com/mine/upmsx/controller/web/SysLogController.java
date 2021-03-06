package com.mine.upmsx.controller.web;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mine.common.core.result.Result;
import com.mine.common.feign.entity.upmsx.SysLog;
import com.mine.upmsx.dto.SysLogDTO;
import com.mine.upmsx.service.ISysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 【日志表】控制层
 *
 * @author Generated by jax-li
 * @date 2020-08-20
 */
@Api(tags = {"【日志表】模块API"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/sysLog")
public class SysLogController {

    private final ISysLogService iSysLogService;

    @ApiOperation(value = "日志表列表查询")
    @GetMapping
    public Result<?> list(SysLog entity) {
        return Result.ok(iSysLogService.list(Wrappers.lambdaQuery(entity)));
    }

    @ApiOperation(value = "日志表详细查询")
    @GetMapping("/{id}")
    public Result<?> detail(@PathVariable("id") Long Id) {
        return Result.ok(iSysLogService.getById(Id));
    }

    @ApiOperation(value = "日志表添加")
    @PostMapping
    public Result<?> insert(@RequestBody SysLog entity) {
        iSysLogService.save(entity);
        return Result.ok();
    }

    @ApiOperation(value = "日志表更新")
    @PutMapping
    public Result<?> update(@RequestBody SysLogDTO dto) {
        return Result.ok();
    }

    @ApiOperation(value = "日志表删除")
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable("id") Long id) {
        iSysLogService.removeById(id);
        return Result.ok();
    }
}


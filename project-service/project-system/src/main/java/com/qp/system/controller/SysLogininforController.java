package com.qp.system.controller;

import com.qp.common.log.annotation.OperateLog;
import com.qp.common.log.enums.BusinessType;
import com.qp.common.model.ApiResponse;
import com.qp.system.model.SysLogininfor;
import com.qp.system.service.ISysLogininforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 系统访问记录 提供者
 *
 * @author Meixi
 * @date 2020/3/17 14:50
 */
@RestController
@RequestMapping("logininfor")
public class SysLogininforController {

    @Autowired
    private ISysLogininforService sysLogininforService;

    /**
     * 查询系统访问记录列表
     */
    @GetMapping("list")
    public ApiResponse<?> list(SysLogininfor sysLogininfor) {
        return new ApiResponse<>().success(sysLogininforService.selectLogininforList(sysLogininfor));
    }

    /**
     * 新增保存系统访问记录
     */
    @PostMapping("save")
    public void addSave(@RequestBody SysLogininfor sysLogininfor) {
        sysLogininforService.insertLogininfor(sysLogininfor);
    }

    /**
     * 删除系统访问记录
     */
    @OperateLog(title = "访问日志", businessType = BusinessType.DELETE)
    @PostMapping("remove")
    public ApiResponse<?> remove(String ids) {
        return new ApiResponse<>().success(sysLogininforService.deleteLogininforByIds(ids));
    }

    @OperateLog(title = "访问日志", businessType = BusinessType.CLEAN)
    @PostMapping("/clean")
    public ApiResponse<?> clean() {
        sysLogininforService.cleanLogininfor();
        return new ApiResponse<>().success();
    }
}

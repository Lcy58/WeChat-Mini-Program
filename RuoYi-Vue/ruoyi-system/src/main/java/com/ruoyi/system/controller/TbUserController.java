package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TbUser;
import com.ruoyi.system.service.ITbUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 个人信息 Controller
 */
@RestController
@RequestMapping("/work/user")
public class TbUserController extends BaseController
{
    @Autowired
    private ITbUserService tbUserService;

    /**
     * 查询个人信息 列表
     */
    @PreAuthorize("@ss.hasPermi('work:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbUser tbUser)
    {
        startPage();
        List<TbUser> list = tbUserService.selectTbUserList(tbUser);
        return getDataTable(list);
    }

    /**
     * 导出个人信息 列表
     */
    @PreAuthorize("@ss.hasPermi('work:user:export')")
    @Log(title = "个人信息 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbUser tbUser)
    {
        List<TbUser> list = tbUserService.selectTbUserList(tbUser);
        ExcelUtil<TbUser> util = new ExcelUtil<TbUser>(TbUser.class);
        util.exportExcel(response, list, "个人信息 数据");
    }

    /**
     * 获取个人信息 详细信息
     */
    @PreAuthorize("@ss.hasPermi('work:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbUserService.selectTbUserById(id));
    }

    /**
     * 新增个人信息 
     */
    @PreAuthorize("@ss.hasPermi('work:user:add')")
    @Log(title = "个人信息 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbUser tbUser)
    {
        return toAjax(tbUserService.insertTbUser(tbUser));
    }

    /**
     * 修改个人信息 
     */
    @PreAuthorize("@ss.hasPermi('work:user:edit')")
    @Log(title = "个人信息 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbUser tbUser)
    {
        return toAjax(tbUserService.updateTbUser(tbUser));
    }

    /**
     * 删除个人信息 
     */
    @PreAuthorize("@ss.hasPermi('work:user:remove')")
    @Log(title = "个人信息 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbUserService.deleteTbUserByIds(ids));
    }
}

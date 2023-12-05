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
import com.ruoyi.system.domain.TbWork;
import com.ruoyi.system.service.ITbWorkService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 工作信息Controller
 */
@RestController
@RequestMapping("/work/work")
public class TbWorkController extends BaseController
{
    @Autowired
    private ITbWorkService tbWorkService;

    /**
     * 查询工作信息列表
     */
    @PreAuthorize("@ss.hasPermi('work:work:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbWork tbWork)
    {
        startPage();
        List<TbWork> list = tbWorkService.selectTbWorkList(tbWork);
        return getDataTable(list);
    }

    /**
     * 导出工作信息列表
     */
    @PreAuthorize("@ss.hasPermi('work:work:export')")
    @Log(title = "工作信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbWork tbWork)
    {
        List<TbWork> list = tbWorkService.selectTbWorkList(tbWork);
        ExcelUtil<TbWork> util = new ExcelUtil<TbWork>(TbWork.class);
        util.exportExcel(response, list, "工作信息数据");
    }

    /**
     * 获取工作信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('work:work:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbWorkService.selectTbWorkById(id));
    }

    /**
     * 新增工作信息
     */
    @PreAuthorize("@ss.hasPermi('work:work:add')")
    @Log(title = "工作信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbWork tbWork)
    {
        return toAjax(tbWorkService.insertTbWork(tbWork));
    }

    /**
     * 修改工作信息
     */
    @PreAuthorize("@ss.hasPermi('work:work:edit')")
    @Log(title = "工作信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbWork tbWork)
    {
        return toAjax(tbWorkService.updateTbWork(tbWork));
    }

    /**
     * 删除工作信息
     */
    @PreAuthorize("@ss.hasPermi('work:work:remove')")
    @Log(title = "工作信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbWorkService.deleteTbWorkByIds(ids));
    }
}

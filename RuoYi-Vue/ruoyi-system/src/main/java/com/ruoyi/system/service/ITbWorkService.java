package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TbWork;

/**
 * 工作信息Service接口
 */
public interface ITbWorkService 
{
    /**
     * 查询工作信息
     * 
     * @param id 工作信息主键
     * @return 工作信息
     */
    public TbWork selectTbWorkById(Long id);

    /**
     * 查询工作信息列表
     * 
     * @param tbWork 工作信息
     * @return 工作信息集合
     */
    public List<TbWork> selectTbWorkList(TbWork tbWork);

    public List<TbWork> selectTbWorkListByApi(TbWork tbWork);

    /**
     * 新增工作信息
     * 
     * @param tbWork 工作信息
     * @return 结果
     */
    public int insertTbWork(TbWork tbWork);

    /**
     * 修改工作信息
     * 
     * @param tbWork 工作信息
     * @return 结果
     */
    public int updateTbWork(TbWork tbWork);

    /**
     * 批量删除工作信息
     * 
     * @param ids 需要删除的工作信息主键集合
     * @return 结果
     */
    public int deleteTbWorkByIds(Long[] ids);

    /**
     * 删除工作信息信息
     * 
     * @param id 工作信息主键
     * @return 结果
     */
    public int deleteTbWorkById(Long id);
}

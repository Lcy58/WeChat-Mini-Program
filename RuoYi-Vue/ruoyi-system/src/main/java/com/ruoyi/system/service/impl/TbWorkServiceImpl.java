package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbWorkMapper;
import com.ruoyi.system.domain.TbWork;
import com.ruoyi.system.service.ITbWorkService;

/**
 * 工作信息Service业务层处理
 */
@Service
public class TbWorkServiceImpl implements ITbWorkService 
{
    @Autowired
    private TbWorkMapper tbWorkMapper;

    /**
     * 查询工作信息
     *
     * @param id 工作信息主键
     * @return 工作信息
     */
    @Override
    public TbWork selectTbWorkById(Long id)
    {
        return tbWorkMapper.selectTbWorkById(id);
    }

    /**
     * 查询工作信息列表
     * 
     * @param tbWork 工作信息
     * @return 工作信息
     */
    @Override
    public List<TbWork> selectTbWorkList(TbWork tbWork)
    {
        return tbWorkMapper.selectTbWorkList(tbWork);
    }

    @Override
    public List<TbWork> selectTbWorkListByApi(TbWork tbWork) {

        return tbWorkMapper.selectTbWorkListByApi(tbWork);
    }

    /**
     * 新增工作信息
     * 
     * @param tbWork 工作信息
     * @return 结果
     */
    @Override
    public int insertTbWork(TbWork tbWork)
    {
        return tbWorkMapper.insertTbWork(tbWork);
    }

    /**
     * 修改工作信息
     * 
     * @param tbWork 工作信息
     * @return 结果
     */
    @Override
    public int updateTbWork(TbWork tbWork)
    {
        return tbWorkMapper.updateTbWork(tbWork);
    }

    /**
     * 批量删除工作信息
     * 
     * @param ids 需要删除的工作信息主键
     * @return 结果
     */
    @Override
    public int deleteTbWorkByIds(Long[] ids)
    {
        return tbWorkMapper.deleteTbWorkByIds(ids);
    }

    /**
     * 删除工作信息信息
     * 
     * @param id 工作信息主键
     * @return 结果
     */
    @Override
    public int deleteTbWorkById(Long id)
    {
        return tbWorkMapper.deleteTbWorkById(id);
    }
}

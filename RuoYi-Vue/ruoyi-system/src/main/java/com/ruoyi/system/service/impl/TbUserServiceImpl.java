package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbUserMapper;
import com.ruoyi.system.domain.TbUser;
import com.ruoyi.system.service.ITbUserService;

/**
 * 个人信息 Service业务层处理
 */
@Service
public class TbUserServiceImpl implements ITbUserService 
{
    @Autowired
    private TbUserMapper tbUserMapper;

    /**
     * 查询个人信息 
     * 
     * @param id 个人信息 主键
     * @return 个人信息 
     */
    @Override
    public TbUser selectTbUserById(Long id)
    {
        return tbUserMapper.selectTbUserById(id);
    }

    /**
     * 查询个人信息 列表
     * 
     * @param tbUser 个人信息 
     * @return 个人信息 
     */
    @Override
    public List<TbUser> selectTbUserList(TbUser tbUser)
    {
        return tbUserMapper.selectTbUserList(tbUser);
    }

    /**
     * 新增个人信息 
     * 
     * @param tbUser 个人信息 
     * @return 结果
     */
    @Override
    public int insertTbUser(TbUser tbUser)
    {
        return tbUserMapper.insertTbUser(tbUser);
    }

    /**
     * 修改个人信息 
     * 
     * @param tbUser 个人信息 
     * @return 结果
     */
    @Override
    public int updateTbUser(TbUser tbUser)
    {
        return tbUserMapper.updateTbUser(tbUser);
    }

    /**
     * 批量删除个人信息 
     * 
     * @param ids 需要删除的个人信息 主键
     * @return 结果
     */
    @Override
    public int deleteTbUserByIds(Long[] ids)
    {
        return tbUserMapper.deleteTbUserByIds(ids);
    }

    /**
     * 删除个人信息 信息
     * 
     * @param id 个人信息 主键
     * @return 结果
     */
    @Override
    public int deleteTbUserById(Long id)
    {
        return tbUserMapper.deleteTbUserById(id);
    }
}

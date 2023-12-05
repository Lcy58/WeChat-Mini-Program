package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TbUser;

/**
 * 个人信息 Service接口
 */
public interface ITbUserService 
{
    /**
     * 查询个人信息 
     * 
     * @param id 个人信息 主键
     * @return 个人信息 
     */
    public TbUser selectTbUserById(Long id);

    /**
     * 查询个人信息 列表
     * 
     * @param tbUser 个人信息 
     * @return 个人信息 集合
     */
    public List<TbUser> selectTbUserList(TbUser tbUser);

    /**
     * 新增个人信息 
     * 
     * @param tbUser 个人信息 
     * @return 结果
     */
    public int insertTbUser(TbUser tbUser);

    /**
     * 修改个人信息 
     * 
     * @param tbUser 个人信息 
     * @return 结果
     */
    public int updateTbUser(TbUser tbUser);

    /**
     * 批量删除个人信息 
     * 
     * @param ids 需要删除的个人信息 主键集合
     * @return 结果
     */
    public int deleteTbUserByIds(Long[] ids);

    /**
     * 删除个人信息 信息
     * 
     * @param id 个人信息 主键
     * @return 结果
     */
    public int deleteTbUserById(Long id);
}

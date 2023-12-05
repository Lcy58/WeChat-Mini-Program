package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 个人信息 对象 tb_user
 */
public class TbUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** openid */
    @Excel(name = "openid")
    private String openId;

    /** userName */
    @Excel(name = "userName")
    private String userName;

    /** 学历-wj */
    @Excel(name = "学历-wj")
    private Long education;

    /** 期望最低薪资 */
    @Excel(name = "期望最低薪资")
    private Long wagesStart;

    /** 期望最高薪资 */
    @Excel(name = "期望最高薪资")
    private Long wagesEnd;

    /** 期望工作地点 */
    @Excel(name = "期望工作地点")
    private String workPlace;

    /** 工作经验时间 */
    @Excel(name = "工作经验时间")
    private Long workTime;

    /** 毕业院校 */
    @Excel(name = "毕业院校")
    private String gradSchool;

    /** 学习专业-wj */
    @Excel(name = "学习专业-wj")
    private Long studyMajor;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String callPhone;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOpenId(String openId) 
    {
        this.openId = openId;
    }

    public String getOpenId() 
    {
        return openId;
    }
    public void setEducation(Long education) 
    {
        this.education = education;
    }

    public Long getEducation() 
    {
        return education;
    }
    public void setWagesStart(Long wagesStart) 
    {
        this.wagesStart = wagesStart;
    }

    public Long getWagesStart() 
    {
        return wagesStart;
    }
    public void setWagesEnd(Long wagesEnd) 
    {
        this.wagesEnd = wagesEnd;
    }

    public Long getWagesEnd() 
    {
        return wagesEnd;
    }
    public void setWorkPlace(String workPlace) 
    {
        this.workPlace = workPlace;
    }

    public String getWorkPlace() 
    {
        return workPlace;
    }
    public void setWorkTime(Long workTime) 
    {
        this.workTime = workTime;
    }

    public Long getWorkTime() 
    {
        return workTime;
    }
    public void setGradSchool(String gradSchool) 
    {
        this.gradSchool = gradSchool;
    }

    public String getGradSchool() 
    {
        return gradSchool;
    }
    public void setStudyMajor(Long studyMajor) 
    {
        this.studyMajor = studyMajor;
    }

    public Long getStudyMajor() 
    {
        return studyMajor;
    }
    public void setCallPhone(String callPhone) 
    {
        this.callPhone = callPhone;
    }

    public String getCallPhone() 
    {
        return callPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("openId", getOpenId())
            .append("education", getEducation())
            .append("wagesStart", getWagesStart())
            .append("wagesEnd", getWagesEnd())
            .append("workPlace", getWorkPlace())
            .append("workTime", getWorkTime())
            .append("gradSchool", getGradSchool())
            .append("studyMajor", getStudyMajor())
            .append("callPhone", getCallPhone())
            .append("userName", getUserName())
            .toString();
    }
}

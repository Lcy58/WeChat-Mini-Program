package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 工作信息对象 tb_work
 */
public class TbWork extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 职位名称 */
    @Excel(name = "职位名称")
    private String jobTitle;

    /** 学历要求-wj */
    @Excel(name = "学历要求-wj")
    private Long education;

    /** 专业要求-wj */
    @Excel(name = "专业要求-wj")
    private Long studyMajor;

    /** 工作经验起始 */
    @Excel(name = "工作经验起始")
    private Long workTimeStart;

    /** 工作经验结束 */
    @Excel(name = "工作经验结束")
    private Long workTimeEnd;

    /** 工作地点 */
    @Excel(name = "工作地点")
    private String workPlace;

    /** 最低薪资 */
    @Excel(name = "最低薪资")
    private Long wagesStart;

    /** 最高薪资 */
    @Excel(name = "最高薪资")
    private Long wagesEnd;

    /** HR头像 */
    @Excel(name = "HR头像")
    private String hrImg;

    /** 来源网站-wj */
    @Excel(name = "来源网站-wj")
    private Long sourceWebsite;

    private Integer pageSizeApi;

    private Integer pageNumApi;


    /** 任职要求 */
    @Excel(name = "任职要求")
    private String useRequire;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setJobTitle(String jobTitle) 
    {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() 
    {
        return jobTitle;
    }
    public void setEducation(Long education) 
    {
        this.education = education;
    }

    public Long getEducation() 
    {
        return education;
    }
    public void setStudyMajor(Long studyMajor) 
    {
        this.studyMajor = studyMajor;
    }

    public Long getStudyMajor() 
    {
        return studyMajor;
    }
    public void setWorkTimeStart(Long workTimeStart) 
    {
        this.workTimeStart = workTimeStart;
    }

    public Long getWorkTimeStart() 
    {
        return workTimeStart;
    }
    public void setWorkTimeEnd(Long workTimeEnd) 
    {
        this.workTimeEnd = workTimeEnd;
    }

    public Long getWorkTimeEnd() 
    {
        return workTimeEnd;
    }
    public void setWorkPlace(String workPlace) 
    {
        this.workPlace = workPlace;
    }

    public String getWorkPlace() 
    {
        return workPlace;
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
    public void setHrImg(String hrImg) 
    {
        this.hrImg = hrImg;
    }

    public String getHrImg() 
    {
        return hrImg;
    }
    public void setSourceWebsite(Long sourceWebsite) 
    {
        this.sourceWebsite = sourceWebsite;
    }

    public Long getSourceWebsite() 
    {
        return sourceWebsite;
    }
    public void setUseRequire(String useRequire) 
    {
        this.useRequire = useRequire;
    }

    public String getUseRequire() 
    {
        return useRequire;
    }

    public Integer getPageSizeApi() {
        return pageSizeApi;
    }

    public void setPageSizeApi(Integer pageSizeApi) {
        this.pageSizeApi = pageSizeApi;
    }

    public Integer getPageNumApi() {
        return pageNumApi;
    }

    public void setPageNumApi(Integer pageNumApi) {
        this.pageNumApi = pageNumApi;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("companyName", getCompanyName())
            .append("jobTitle", getJobTitle())
            .append("education", getEducation())
            .append("studyMajor", getStudyMajor())
            .append("workTimeStart", getWorkTimeStart())
            .append("workTimeEnd", getWorkTimeEnd())
            .append("workPlace", getWorkPlace())
            .append("wagesStart", getWagesStart())
            .append("wagesEnd", getWagesEnd())
            .append("hrImg", getHrImg())
            .append("sourceWebsite", getSourceWebsite())
            .append("useRequire", getUseRequire())
            .append("pageSizeApi", getPageSizeApi())
            .append("pageNumApi", getPageNumApi())
            .toString();
    }
}

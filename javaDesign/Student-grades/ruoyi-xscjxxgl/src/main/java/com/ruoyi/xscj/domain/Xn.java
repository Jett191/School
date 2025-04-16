package com.ruoyi.xscj.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学年对象 xscj_xn
 *
 * @author huacai
 * @date 2025-03-05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Xn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学年ID */
    private String xnId;

    /** 开始年份 */
    @JsonFormat(pattern = "yyyy")
    @Excel(name = "开始年份", width = 30, dateFormat = "yyyy")
    private Date ksNf;

    /** 结束年份 */
    @JsonFormat(pattern = "yyyy")
    @Excel(name = "结束年份", width = 30, dateFormat = "yyyy")
    private Date jsNf;

    @Excel(name = "学期")
    private String xq;

    /** 课程信息 */
    private List<XnKc> xnKcList;
}

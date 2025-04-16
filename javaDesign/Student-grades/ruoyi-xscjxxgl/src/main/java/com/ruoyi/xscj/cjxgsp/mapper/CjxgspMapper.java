package com.ruoyi.xscj.cjxgsp.mapper;

import java.util.List;
import com.ruoyi.xscj.cjxgsp.domain.Cjxgsp;

/**
 * 成绩修改审批Mapper接口
 *
 * @author huacai
 * @date 2025-03-05
 */
public interface CjxgspMapper
{
    /**
     * 查询成绩修改审批
     *
     * @param cjxgspId 成绩修改审批主键
     * @return 成绩修改审批
     */
    public Cjxgsp selectCjxgspByCjxgspId(Integer cjxgspId);

    /**
     * 查询成绩修改审批列表
     *
     * @param cjxgsp 成绩修改审批
     * @return 成绩修改审批集合
     */
    public List<Cjxgsp> selectCjxgspList(Cjxgsp cjxgsp);

    /**
     * 新增成绩修改审批
     *
     * @param cjxgsp 成绩修改审批
     * @return 结果
     */
    public int insertCjxgsp(Cjxgsp cjxgsp);

    /**
     * 修改成绩修改审批
     *
     * @param cjxgsp 成绩修改审批
     * @return 结果
     */
    public int updateCjxgsp(Cjxgsp cjxgsp);

    /**
     * 删除成绩修改审批
     *
     * @param cjxgspId 成绩修改审批主键
     * @return 结果
     */
    public int deleteCjxgspByCjxgspId(Integer cjxgspId);

    /**
     * 批量删除成绩修改审批
     *
     * @param cjxgspIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCjxgspByCjxgspIds(Integer[] cjxgspIds);
}

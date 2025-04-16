package com.ruoyi.xscj.jbxx.mapper;

import java.util.List;
import com.ruoyi.xscj.jbxx.domain.Xsjbxx;

/**
 * 学生基本信息Mapper接口
 *
 * @author huacai
 * @date 2025-02-28
 */
public interface XsjbxxMapper
{
    /**
     * 查询学生基本信息
     *
     * @param xsjbxxId 学生基本信息主键
     * @return 学生基本信息
     */
    public Xsjbxx selectXsjbxxByXsjbxxId(String xsjbxxId);

    /**
     * 查询学生基本信息列表
     *
     * @param xsjbxx 学生基本信息
     * @return 学生基本信息集合
     */
    public List<Xsjbxx> selectXsjbxxList(Xsjbxx xsjbxx);

    /**
     * 新增学生基本信息
     *
     * @param xsjbxx 学生基本信息
     * @return 结果
     */
    public int insertXsjbxx(Xsjbxx xsjbxx);

    /**
     * 修改学生基本信息
     *
     * @param xsjbxx 学生基本信息
     * @return 结果
     */
    public int updateXsjbxx(Xsjbxx xsjbxx);

    /**
     * 删除学生基本信息
     *
     * @param xsjbxxId 学生基本信息主键
     * @return 结果
     */
    public int deleteXsjbxxByXsjbxxId(String xsjbxxId);

    /**
     * 批量删除学生基本信息
     *
     * @param xsjbxxIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXsjbxxByXsjbxxIds(String[] xsjbxxIds);
}

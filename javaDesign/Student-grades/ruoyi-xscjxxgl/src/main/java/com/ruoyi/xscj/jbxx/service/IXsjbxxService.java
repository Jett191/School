package com.ruoyi.xscj.jbxx.service;

import java.util.List;
import com.ruoyi.xscj.jbxx.domain.Xsjbxx;

/**
 * 学生基本信息Service接口
 *
 * @author huacai
 * @date 2025-02-28
 */
public interface IXsjbxxService
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
     * 批量新增学生基本信息
     *
     * @param xsjbxxs 学生基本信息List
     * @return 结果
     */
    public int batchInsertXsjbxx(List<Xsjbxx> xsjbxxs);

    /**
     * 修改学生基本信息
     *
     * @param xsjbxx 学生基本信息
     * @return 结果
     */
    public int updateXsjbxx(Xsjbxx xsjbxx);

    /**
     * 批量删除学生基本信息
     *
     * @param xsjbxxIds 需要删除的学生基本信息主键集合
     * @return 结果
     */
    public int deleteXsjbxxByXsjbxxIds(String[] xsjbxxIds);

    /**
     * 删除学生基本信息信息
     *
     * @param xsjbxxId 学生基本信息主键
     * @return 结果
     */
    public int deleteXsjbxxByXsjbxxId(String xsjbxxId);
}

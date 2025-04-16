package com.ruoyi.xscj.mapper;

import java.util.List;
import com.ruoyi.xscj.domain.Xn;
import com.ruoyi.xscj.domain.XnKc;

/**
 * 学年Mapper接口
 * 
 * @author huacai
 * @date 2025-03-05
 */
public interface XnMapper 
{
    /**
     * 查询学年
     * 
     * @param xnId 学年主键
     * @return 学年
     */
    public Xn selectXnByXnId(String xnId);

    /**
     * 查询学年列表
     * 
     * @param xn 学年
     * @return 学年集合
     */
    public List<Xn> selectXnList(Xn xn);

    /**
     * 新增学年
     * 
     * @param xn 学年
     * @return 结果
     */
    public int insertXn(Xn xn);

    /**
     * 修改学年
     * 
     * @param xn 学年
     * @return 结果
     */
    public int updateXn(Xn xn);

    /**
     * 删除学年
     * 
     * @param xnId 学年主键
     * @return 结果
     */
    public int deleteXnByXnId(String xnId);

    /**
     * 批量删除学年
     * 
     * @param xnIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXnByXnIds(String[] xnIds);

    /**
     * 批量删除课程
     * 
     * @param xnIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXnKcByXnIds(String[] xnIds);
    
    /**
     * 批量新增课程
     * 
     * @param xnKcList 课程列表
     * @return 结果
     */
    public int batchXnKc(List<XnKc> xnKcList);
    

    /**
     * 通过学年主键删除课程信息
     * 
     * @param xnId 学年ID
     * @return 结果
     */
    public int deleteXnKcByXnId(String xnId);
}

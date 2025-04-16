package com.ruoyi.xscj.kcpj.mapper;

import java.util.List;
import com.ruoyi.xscj.kcpj.domain.Kcpj;

/**
 * 课程评价Mapper接口
 *
 * @author huacai
 * @date 2025-03-04
 */
public interface KcpjMapper
{
    /**
     * 查询课程评价
     *
     * @param kcpjId 课程评价主键
     * @return 课程评价
     */
    public Kcpj selectKcpjByKcpjId(String kcpjId);

    /**
     * 查询课程评价列表
     *
     * @param kcpj 课程评价
     * @return 课程评价集合
     */
    public List<Kcpj> selectKcpjList(Kcpj kcpj);

    /**
     * 新增课程评价
     *
     * @param kcpj 课程评价
     * @return 结果
     */
    public int insertKcpj(Kcpj kcpj);

    /**
     * 修改课程评价
     *
     * @param kcpj 课程评价
     * @return 结果
     */
    public int updateKcpj(Kcpj kcpj);

    /**
     * 删除课程评价
     *
     * @param kcpjId 课程评价主键
     * @return 结果
     */
    public int deleteKcpjByKcpjId(String kcpjId);

    /**
     * 批量删除课程评价
     *
     * @param kcpjIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKcpjByKcpjIds(String[] kcpjIds);
}

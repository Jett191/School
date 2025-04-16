package com.ruoyi.xscj.kcap.mapper;

import java.util.List;
import com.ruoyi.xscj.kcap.domain.Kcap;

/**
 * 课程安排Mapper接口
 *
 * @author huacai
 * @date 2025-03-04
 */
public interface KcapMapper
{
    /**
     * 查询课程安排
     *
     * @param kcapId 课程安排主键
     * @return 课程安排
     */
    public Kcap selectKcapByKcapId(String kcapId);

    /**
     * 查询课程安排列表
     *
     * @param kcap 课程安排
     * @return 课程安排集合
     */
    public List<Kcap> selectKcapList(Kcap kcap);

    /**
     * 新增课程安排
     *
     * @param kcap 课程安排
     * @return 结果
     */
    public int insertKcap(Kcap kcap);

    /**
     * 修改课程安排
     *
     * @param kcap 课程安排
     * @return 结果
     */
    public int updateKcap(Kcap kcap);

    /**
     * 删除课程安排
     *
     * @param kcapId 课程安排主键
     * @return 结果
     */
    public int deleteKcapByKcapId(String kcapId);

    /**
     * 批量删除课程安排
     *
     * @param kcapIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKcapByKcapIds(String[] kcapIds);

    /**
     * 不分页查询课程安排
     */
    List<Kcap> selectKcApList();
}

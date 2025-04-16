package com.ruoyi.xscj.kcxx.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.xscj.kcxx.domain.Js;
import com.ruoyi.xscj.kcxx.domain.Kcxx;
import com.ruoyi.xscj.kcxx.domain.KcxxFj;
import com.ruoyi.xscj.kcxx.mapper.KcxxMapper;
import com.ruoyi.xscj.kcxx.service.IKcxxService;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.ruoyi.common.utils.SecurityUtils.*;

/**
 * 课程信息Service业务层处理
 *
 * @author huacai
 * @date 2025-02-28
 */
@Service
public class KcxxServiceImpl implements IKcxxService {
    @Resource
    private KcxxMapper kcxxMapper;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 查询课程信息
     *
     * @param kcxxId 课程信息主键
     * @return 课程信息
     */
    @Override
    public Kcxx selectKcxxByKcxxId(String kcxxId) {
        return kcxxMapper.selectKcxxByKcxxId(kcxxId);
    }

    /**
     * 查询课程信息列表
     *
     * @param kcxx 课程信息
     * @return 课程信息
     */
    @Override
    public List<Kcxx> selectKcxxList(Kcxx kcxx) {
        return kcxxMapper.selectKcxxList(kcxx);
    }

    /**
     * 新增课程信息
     *
     * @param kcxx 课程信息
     * @return 结果
     */
    @Transactional
    @Override
    public int insertKcxx(Kcxx kcxx) {
        kcxx.setCreateTime(DateUtils.getNowDate());
        kcxx.setUserId(Math.toIntExact(getUserId())); //用户ID
        kcxx.setDeptId(Math.toIntExact(getDeptId())); //部门ID
        kcxx.setCreateBy(getUsername()); //创建人
//        kcxx.setKcxxId(IdUtils.fastSimpleUUID()); //课程信息ID
        int rows = kcxxMapper.insertKcxx(kcxx);
        insertKcxxFj(kcxx);
        return rows;
    }

    /**
     * 批量新增课程信息
     *
     * @param kcxxs 课程信息List
     * @return 结果
     */
    @Override
    public int batchInsertKcxx(List<Kcxx> kcxxs) {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        int count = 0;
        if (!CollectionUtils.isEmpty(kcxxs)) {
            try {
                for (int i = 0; i < kcxxs.size(); i++) {
                    int row = kcxxMapper.insertKcxx(kcxxs.get(i));
                    // 防止内存溢出，每100次提交一次,并清除缓存
                    boolean bool = (i > 0 && i % 100 == 0) || i == kcxxs.size() - 1;
                    if (bool) {
                        sqlSession.commit();
                        sqlSession.clearCache();
                    }
                    count = i + 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
                // 没有提交的数据可以回滚
                sqlSession.rollback();
            } finally {
                sqlSession.close();
                return count;
            }
        }
        return count;
    }

    /**
     * 修改课程信息
     *
     * @param kcxx 课程信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updateKcxx(Kcxx kcxx) {
        kcxx.setUpdateTime(DateUtils.getNowDate());
//        kcxxMapper.deleteKcxxFjByKcxxId(kcxx.getKcxxId());
        insertKcxxFj(kcxx);
        return kcxxMapper.updateKcxx(kcxx);
    }

    /**
     * 批量删除课程信息
     *
     * @param kcxxIds 需要删除的课程信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteKcxxByKcxxIds(String[] kcxxIds) {
        kcxxMapper.deleteKcxxFjByKcxxIds(kcxxIds);
        return kcxxMapper.deleteKcxxByKcxxIds(kcxxIds);
    }

    /**
     * 删除课程信息信息
     *
     * @param kcxxId 课程信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteKcxxByKcxxId(String kcxxId) {
        kcxxMapper.deleteKcxxFjByKcxxId(kcxxId);
        return kcxxMapper.deleteKcxxByKcxxId(kcxxId);
    }

    /**
     * 新增附件
     * @param kcxxFj
     * @return
     */
    @Override
    public int insertKcxxFjByKcxxId(KcxxFj kcxxFj) {
        return kcxxMapper.insertKcxxFjByKcxxId(kcxxFj);
    }

    /**
     * 根据ID查询附件列表
     * @param kcxxFj
     * @return
     */
    @Override
    public List<KcxxFj> selectKcxxFjList(KcxxFj kcxxFj) {
        System.out.println(kcxxFj);
        return kcxxMapper.selectKcxxFjList(kcxxFj);
    }

    /**
     * 删除课程附件
     * @param fjs
     * @return
     */
    @Override
    public int deleteKcxxFjByFjs(Integer[] fjs) {
        return kcxxMapper.deleteKcxxFjByFjs(fjs);
    }

    /**
     * 不分页查询课程列表
     * @return
     */
    @Override
    public List<Kcxx> selectKcList() {
        return kcxxMapper.selectKcList();
    }

    /**
     * 不分页查询教师列表
     * @return
     */
    @Override
    public List<Js> selectJsList() {
        return kcxxMapper.selectJsList();
    }

    /**
     * 不分页查询学生列表
     * @return
     */
    @Override
    public List<Js> selectXsList() {
        return kcxxMapper.selectXsList();
    }

    /**
     * 新增课程附件信息
     *
     * @param kcxx 课程信息对象
     */
    public void insertKcxxFj(Kcxx kcxx) {
        List<KcxxFj> kcxxFjList = kcxx.getKcxxFjList();
        String kcxxId = kcxx.getKcxxId();
        if (StringUtils.isNotNull(kcxxFjList)) {
            List<KcxxFj> list = new ArrayList<KcxxFj>();
            for (KcxxFj kcxxFj : kcxxFjList) {
                kcxxFj.setKcxxId(kcxxId);
                list.add(kcxxFj);
            }
//            if (list.size() > 0) {
//                kcxxMapper.batchKcxxFj(list);
//            }
        }
    }
}

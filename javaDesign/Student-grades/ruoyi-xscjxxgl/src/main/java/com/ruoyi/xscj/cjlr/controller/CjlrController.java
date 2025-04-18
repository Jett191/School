package com.ruoyi.xscj.cjlr.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.xscj.cjlr.domain.BjCj;
import com.ruoyi.xscj.cjlr.domain.CjTj;
import com.ruoyi.xscj.cjlr.domain.Cjlr;
import com.ruoyi.xscj.cjlr.domain.Gpa;
import com.ruoyi.xscj.cjlr.service.ICjlrService;
import com.ruoyi.xscj.cjxgsp.domain.Cjxgsp;
import com.ruoyi.xscj.cjxgsp.service.ICjxgspService;
import com.ruoyi.xscj.kcxx.domain.Js;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

/**
 * 成绩录入Controller
 *
 * @author huacai
 * @date 2025-03-05
 */
@Api("成绩录入")
@RestController
@RequestMapping("/xscj/cjlr")
public class CjlrController extends BaseController {
    @Autowired
    private ICjlrService cjlrService;

    @Autowired
    private ICjxgspService cjxgspService;

    /**
     * 查询成绩录入列表
     */
    @ApiOperation("查询成绩录入列表")
    @PreAuthorize("@ss.hasPermi('xscj:cjlr:list')")
    @GetMapping("/list")
    public TableDataInfo list(Cjlr cjlr) {
        startPage();
        List<Cjlr> list = cjlrService.selectCjlrList(cjlr);
        return getDataTable(list);
    }

    /**
     * 导出成绩录入列表
     */
    @ApiOperation("导出成绩录入列表")
    @PreAuthorize("@ss.hasPermi('xscj:cjlr:export')")
    @Log(title = "成绩录入", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Cjlr cjlr) {
        List<Cjlr> list = cjlrService.selectCjlrList(cjlr);
        ExcelUtil<Cjlr> util = new ExcelUtil<Cjlr>(Cjlr.class);
        util.exportExcel(response, list, "成绩录入数据");
    }

    /**
     * 下载模板
     */
    @ApiOperation("下载模板")
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) {
        ExcelUtil<Cjlr> util = new ExcelUtil<Cjlr>(Cjlr.class);
        util.importTemplateExcel(response, "成绩录入数据");
    }

    /**
     * 导入数据
     */
    @ApiOperation("导入数据")
    @Log(title = "成绩录入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('xscj:cjlr:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file) throws Exception {
        ExcelUtil<Cjlr> util = new ExcelUtil<Cjlr>(Cjlr.class);
        InputStream inputStream = file.getInputStream();
        List<Cjlr> list = util.importExcel(inputStream);
        inputStream.close();
        int count = cjlrService.batchInsertCjlr(list);
        return AjaxResult.success("导入成功" + count + "条信息！");
    }

    /**
     * 获取成绩录入详细信息
     */
    @ApiOperation("获取成绩录入详细信息")
    @PreAuthorize("@ss.hasPermi('xscj:cjlr:query')")
    @GetMapping(value = "/{cjlrId}")
    public AjaxResult getInfo(@PathVariable("cjlrId") String cjlrId) {
        return success(cjlrService.selectCjlrByCjlrId(cjlrId));
    }

    /**
     * 新增成绩录入
     */
    @ApiOperation("新增成绩录入")
    @PreAuthorize("@ss.hasPermi('xscj:cjlr:add')")
    @Log(title = "成绩录入", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Cjlr cjlr) {
        cjlr.setUserId(Math.toIntExact(getUserId())); //用户ID
        cjlr.setDeptId(Math.toIntExact(getDeptId())); //部门ID
        cjlr.setCreateBy(getUsername()); //创建人
        cjlr.setCjlrId(IdUtils.fastSimpleUUID());
        return toAjax(cjlrService.insertCjlr(cjlr));
    }

    /**
     * 修改成绩录入
     */
    @ApiOperation("修改成绩录入")
    @PreAuthorize("@ss.hasPermi('xscj:cjlr:edit')")
    @Log(title = "成绩录入", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Cjlr cjlr) {
        return toAjax(cjlrService.updateCjlr(cjlr));
    }

    /**
     * 修改成绩
     */
    @ApiOperation("修改成绩")
    @Log(title = "修改成绩", businessType = BusinessType.UPDATE)
    @PutMapping("/updateXgCj")
    public AjaxResult updateXgCj(@RequestBody Cjlr cjlr) {
        Cjxgsp cjxgsp = new Cjxgsp();
        cjxgsp.setXsName(cjlr.getXsName());
        cjxgsp.setKcName(cjlr.getKcName());
        cjxgsp.setXgqCj(cjlr.getKcCj());
        cjxgsp.setXghCj(cjlr.getXghCj());
        cjxgsp.setCjlrId(cjlr.getCjlrId());
        System.out.println(cjxgsp);
        return toAjax(cjxgspService.insertCjxgsp(cjxgsp));
    }

    /**
     * 删除成绩录入
     */
    @ApiOperation("删除成绩录入")
    @PreAuthorize("@ss.hasPermi('xscj:cjlr:remove')")
    @Log(title = "成绩录入", businessType = BusinessType.DELETE)
    @DeleteMapping("/{cjlrIds}")
    public AjaxResult remove(@PathVariable String[] cjlrIds) {
        return toAjax(cjlrService.deleteCjlrByCjlrIds(cjlrIds));
    }

    /**
     * 不分页查询成绩统计列表
     * @return
     */
    @ApiOperation("不分页查询成绩统计列表")
    @GetMapping("/selectCjTjList")
    public AjaxResult selectCjTjList() {
        List<CjTj> list = cjlrService.selectCjTjList();
        return AjaxResult.success(list);
    }

    /**
     * 学生成绩分析
     */
    @ApiOperation("学生成绩分析")
    @GetMapping(value = "/selectXscjfx/{xsName}")
    public AjaxResult selectXscjfx(@PathVariable("xsName") String xsName) {
        System.out.println(xsName);
        return success(cjlrService.selectXscjfx(xsName));
    }

    /**
     * 查询gpa
     */
    @ApiOperation("查询gpa")
    @GetMapping("/selectGpaList")
    public AjaxResult selectGpaList() {
        List<Gpa> list = cjlrService.selectGpaList();
        return AjaxResult.success(list);
    }

    /**
     * 查询班级成绩排名
     */
    @ApiOperation("查询班级成绩排名")
    @GetMapping("/selectBjCjList")
    public AjaxResult selectBjCjList() {
        List<BjCj> list = cjlrService.selectBjCjList();
        return AjaxResult.success(list);
    }

}

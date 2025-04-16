package com.ruoyi.activiti.exception;

import lombok.Data;
import org.activiti.bpmn.model.BpmnModel;

/**
 * @projectName: haucai-activiti-kjglxt
 * @package: com.ruoyi.activiti.exception
 * @className: CustomException
 * @author: 陈达勇
 * @description: TODO
 * @date: 2024/6/23 20:49
 * @version: 1.0
 */
@Data
public class CustomException extends Throwable {

    String errMsg;
    BpmnModel model;

    public CustomException(String errMsg) {
        this.errMsg = errMsg;
    }
}

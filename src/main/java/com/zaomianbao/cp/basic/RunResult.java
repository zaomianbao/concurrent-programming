package com.zaomianbao.cp.basic;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description RunResult
 * @Author zaomianbao
 * @Date 2020/3/18
 **/
@Data
@NoArgsConstructor
public class RunResult {
    // 输入参数
    private Integer param;
    // 是否运算成功
    private Boolean success;
    // 运算结果
    private Integer result;

}

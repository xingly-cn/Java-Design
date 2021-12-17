package cn.xingly;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 功能描述: 统一返回类
 *
 * @author XiaoNianXin
 * @date 2021/12/17 22:55
 */
@Data
@AllArgsConstructor
public class AwardRes {
    private String code;    // 编码
    private String info;    // 描述
}

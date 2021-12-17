package cn.xingly;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * 功能描述: 统一请求类
 *
 * @author XiaoNianXin
 * @date 2021/12/17 22:55
 */
@Data
@AllArgsConstructor
public class AwardReq {
    private String uId;                 // 用户唯一ID
    private Integer awardType;          // 商品类型；1优惠券、2实物、3兑换卡
    private String awardId;             // 奖品ID
    private String bizId;               // 业务ID，防重复
    private Map<String,String> exMap;   // 其他信息
}

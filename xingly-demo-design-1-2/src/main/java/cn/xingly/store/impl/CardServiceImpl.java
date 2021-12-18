package cn.xingly.store.impl;

import cn.xingly.service.card.IQiYiCardService;
import cn.xingly.store.ICommodity;

import java.util.Map;

/**
 * 功能描述: 兑换卡发放实现类
 *
 * @author XiaoNianXin
 * @date 2021/12/18 23:57
 */
public class CardServiceImpl implements ICommodity {

    // 模拟注入
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendGoods(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        String mobile = queryUserMobile(uId);
        iQiYiCardService.grantToken(mobile,bizId);
        System.out.println("兑换卡兑换成功");
    }

    private String queryUserMobile(String uId) {
        return "15200101232";
    }
}

package cn.xingly.store.impl;

import cn.xingly.service.goods.DeliverReq;
import cn.xingly.service.goods.GoodsService;
import cn.xingly.store.ICommodity;

import java.util.Map;

/**
 * 功能描述: 商品发放实现类
 *
 * @author XiaoNianXin
 * @date 2021/12/19 0:07
 */
public class GoodsServiceImpl implements ICommodity {

    // 模拟注入
    private GoodsService goodsService = new GoodsService();

    @Override
    public void sendGoods(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(uId));
        deliverReq.setUserPhone(queryUserPhoneNumber(uId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));

        Boolean isSuccess = goodsService.deliverGoods(deliverReq);
        if (!isSuccess) {
            throw new RuntimeException("实物发放失败");
        }
        System.out.println("实物发放成功");
    }


    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }
}

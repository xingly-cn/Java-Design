package cn.xingly.store.impl;

import cn.xingly.service.coupon.CouponResult;
import cn.xingly.service.coupon.CouponService;
import cn.xingly.store.ICommodity;

import java.util.Map;

/**
 * 功能描述: 实物发放实现类
 *
 * @author XiaoNianXin
 * @date 2021/12/19 0:03
 */
public class CouponServiceImpl implements ICommodity {

    // 模拟注入
    private CouponService couponService = new CouponService();

    @Override
    public void sendGoods(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        if (!"0000".equals(couponResult.getCode())) {
            throw  new RuntimeException(couponResult.getInfo());
        }
        System.out.println("实物兑换成功" + couponResult);
    }
}

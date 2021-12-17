package cn.xingly;

import cn.xingly.card.IQiYiCardService;
import cn.xingly.coupon.CouponResult;
import cn.xingly.coupon.CouponService;
import cn.xingly.goods.DeliverReq;
import cn.xingly.goods.GoodsService;
import com.alibaba.fastjson.JSON;

/**
 * 功能描述: 奖品分发控制
 *
 * @author XiaoNianXin
 * @date 2021/12/17 22:55
 */
public class PrizeController {

    public AwardRes awardToUser(AwardReq req) {
        String reqJson = JSON.toJSONString(req);
        AwardRes result = null;
        // 按照不同类型,发送不同产品
        if (req.getAwardType() == 1) {
            CouponService couponService = new CouponService();
            CouponResult couponResult = couponService.sendCoupon(req.getUId(), req.getAwardId(), req.getBizId());
            if ("0000".equals(couponResult.getCode())) {
                result = new AwardRes("0000","发放成功");
            }else {
                result = new AwardRes("0001",couponResult.getInfo());
            }
        }else if (req.getAwardType() == 2) {
            GoodsService goodsService = new GoodsService();
            DeliverReq deliverReq = new DeliverReq();
            deliverReq.setUserName(queryUserName(req.getUId()));
            deliverReq.setUserPhone(queryUserPhoneNumber(req.getUId()));
            deliverReq.setSku(req.getAwardId());
            deliverReq.setOrderId(req.getBizId());
            deliverReq.setConsigneeUserName(req.getExMap().get("consigneeUserName"));
            deliverReq.setConsigneeUserPhone(req.getExMap().get("consigneeUserPhone"));
            deliverReq.setConsigneeUserAddress(req.getExMap().get("consigneeUserAddress"));
            Boolean isSuccess = goodsService.deliverGoods(deliverReq);
            if (isSuccess) {
                result = new AwardRes("0000","发放成功");
            }else {
                result = new AwardRes("0000","发放失败");
            }
        }else if (req.getAwardType() == 3) {
            String mobilePhone = queryUserPhoneNumber(req.getUId());
            IQiYiCardService iQiYiCardService = new IQiYiCardService();
            iQiYiCardService.grantToken(mobilePhone,req.getAwardId());
            result = new AwardRes("0000","发放成功");
        }
        result = new AwardRes("0001",null);
        return result;
    }

    private String queryUserName(String uId) {
        return "XingLy";
    }

    private String queryUserPhoneNumber(String uId) {
        return "18855550000";
    }
}

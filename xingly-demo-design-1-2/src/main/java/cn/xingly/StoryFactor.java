package cn.xingly;

import cn.xingly.store.ICommodity;
import cn.xingly.store.impl.CardServiceImpl;
import cn.xingly.store.impl.CouponServiceImpl;
import cn.xingly.store.impl.GoodsServiceImpl;

/**
 * 功能描述: 抽象工程
 *
 * @author XiaoNianXin
 * @date 2021/12/19 0:10
 */
public class StoryFactor {

    public ICommodity sendGoods(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) {
            return new CouponServiceImpl();
        }
        if (2 == commodityType) {
            return new GoodsServiceImpl();
        }
        if (3 == commodityType) {
            return new CardServiceImpl();
        }
        throw new RuntimeException("不存在的商品类型");
    }

}

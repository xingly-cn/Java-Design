package cn.xingly.store;

import java.util.Map;

/**
 * 功能描述: 具体工厂 - 发放商品接口
 *
 * @author XiaoNianXin
 * @date 2021/12/18 23:55
 */
public interface ICommodity {
    void sendGoods(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}

import cn.xingly.AwardReq;
import cn.xingly.AwardRes;
import cn.xingly.PrizeController;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;

/**
 * 功能描述: 测试类
 *
 * @author XiaoNianXin
 * @date 2021/12/17 23:21
 */
public class ApiTest {

    @Test
    public void test() {
        PrizeController prizeController = new PrizeController();

        System.out.println("======模拟发放优惠券测试======");
        // 优惠券
        AwardReq req01 = new AwardReq("1001",1,"XINGLY12580","1",null);
        AwardRes awardRes01 = prizeController.awardToUser(req01);
        System.out.println("优惠券测试结果 = " + JSON.toJSON(awardRes01));
        System.out.println("============================");

        // 实物
        AwardReq req02 = new AwardReq("1002",2,"XINGLY10086","2",new HashMap<String,String>(){{
            put("consigneeUserName", "XINGLY");
            put("consigneeUserPhone", "15566669999");
            put("consigneeUserAddress", "上海市黄浦区xxx号");
        }});
        AwardRes awardRes02 = prizeController.awardToUser(req02);
        System.out.println("实物测试结果 = " + JSON.toJSON(awardRes02));
        System.out.println("============================");

        // 兑换卡
        AwardReq req03 = new AwardReq("1003",3,"AQY1xjkUodl8LO975GdfrYUio","3",null);
        AwardRes awardRes03 = prizeController.awardToUser(req03);
        System.out.println("兑换卡测试结果 = " + JSON.toJSON(awardRes03));
        System.out.println("============================");


    }
}

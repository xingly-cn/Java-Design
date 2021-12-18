import cn.xingly.StoryFactor;
import cn.xingly.store.ICommodity;
import org.junit.Test;

import java.util.HashMap;

/**
 * 功能描述: 测试类
 *
 * @author XiaoNianXin
 * @date 2021/12/19 0:14
 */
public class ApiTest {


    @Test
    public void test() throws Exception {
        // 抽象工厂
        StoryFactor storyFactor = new StoryFactor();

        // 1、优惠券
        ICommodity commodity1 = storyFactor.sendGoods(1);
        commodity1.sendGoods("001","XINGLY01","01",null);

        // 2、实物
        ICommodity commodity2 = storyFactor.sendGoods(2);
        commodity2.sendGoods("002","XINGLY02","02",new HashMap<String,String>(){{
            put("consigneeUserName", "XINGLY");
            put("consigneeUserPhone", "15566669999");
            put("consigneeUserAddress", "上海市黄浦区00号");
        }});

        // 3、兑换卡
        ICommodity commodity3 = storyFactor.sendGoods(3);
        commodity3.sendGoods("003","XINGLY03","03",null);
    }
}

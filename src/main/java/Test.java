import cn.hutool.Hutool;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.ClassLoaderUtil;
import cn.hutool.core.util.EnumUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.checkerframework.checker.units.qual.A;
import struct.AVLTree;
import struct.ListNode;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Zeng-WD
 * @date 23:42 2020/12/15
 */
public class Test {

    @Getter
    @AllArgsConstructor
    enum Pay {
        ALI_PAY(1, "支付宝"),
        WX_PAY(2, "微信支付"),
        TX_PAY(3, "腾讯支付");

        public final int payVal;

        public final String dec;
    }

    public static void main(String[] args) throws InterruptedException {

        Pay pay = EnumUtil.getBy(Pay.class, p -> (p.getPayVal() == 1));
        Pay by = EnumUtil.getBy(Pay::getPayVal, 2);
        System.out.println(by.getDec());
    }

}

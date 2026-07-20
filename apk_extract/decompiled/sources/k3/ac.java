package k3;

import com.transsion.iotcardsdk.bean.DeviceType;

/* JADX INFO: loaded from: classes.dex */
public abstract class ac {
    public static void a(int i8) {
        switch (i8) {
            case 100:
                we.h.h("BleScanTool", "GATT已经连接成功!");
                break;
            case 101:
                we.h.h("BleScanTool", "GATT已经断开连接!");
                break;
            case 102:
                we.h.h("BleScanTool", "服务发现成功!");
                break;
            case DeviceType.INFRARED_TV_BOX /* 103 */:
                we.h.h("BleScanTool", "描述符写(设置通知)成功!");
                break;
            default:
                switch (i8) {
                    case 300:
                        we.h.h("BleScanTool", "对端询问我们当前wifi信息");
                        break;
                    case 301:
                        we.h.h("BleScanTool", "对端询问我们后续连接方式是什么");
                        break;
                    case 302:
                        we.h.h("BleScanTool", "对端询问我们mac地址是多少");
                        break;
                    case 303:
                        we.h.h("BleScanTool", "对端询问我们ip地址是多少");
                        break;
                    case 304:
                        we.h.h("BleScanTool", "对端询问我们是否支持5G");
                        break;
                    case 305:
                        we.h.h("BleScanTool", "对端询问我们频率");
                        break;
                    case 306:
                        we.h.h("BleScanTool", "对端询问我们ssidInfo");
                        break;
                    case 307:
                        we.h.h("BleScanTool", "对端询问我们AP-STA信息，即询问我们是否支持5G和我们的静态IP是多少");
                        break;
                    case 308:
                        we.h.h("BleScanTool", "对端询问我们P2P信息");
                        break;
                    case 309:
                        we.h.h("BleScanTool", "对端询问我们wifi信息和ap-sta信息");
                        break;
                }
                break;
        }
    }
}

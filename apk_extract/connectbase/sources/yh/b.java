package yh;

import ai.c;
import ai.e;
import android.content.Context;
import android.text.TextUtils;
import com.transsion.infra.gateway.core.bean.GatewayResponse;
import com.transsion.infra.gateway.core.bean.GatewaySignKey;
import com.transsion.infra.gateway.core.bean.RequestBean;
import com.transsion.infra.gateway.core.bean.TimeBean;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static String a(RequestBean requestBean) {
        c.f217a.k("requestBean" + requestBean.toString());
        return zh.c.b(requestBean);
    }

    public static void b(Context context) {
        ai.a.b(context);
    }

    public static boolean c(int code, String response, GatewaySignKey key) {
        if (code != 200 && !TextUtils.isEmpty(response)) {
            try {
                c.f217a.k("response" + response);
                GatewayResponse gatewayResponse = (GatewayResponse) bi.b.a(response, GatewayResponse.class);
                if ("GW.4410".equals(gatewayResponse.errorCode)) {
                    c.f217a.k("verify sign failed, retrying update time");
                    TimeBean timeBean = (TimeBean) bi.b.a(zh.b.a(gatewayResponse.errorMsg, key.getKey()), TimeBean.class);
                    if (timeBean.time > 0) {
                        e.a(ai.a.a()).g("time_offset", timeBean.time - System.currentTimeMillis());
                        return true;
                    }
                }
            } catch (Exception e10) {
                c.f217a.m(e10);
            }
        }
        return false;
    }
}

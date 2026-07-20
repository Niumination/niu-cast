package k3;

import com.transsion.atomiccore.support.host.AtomicAction;
import com.transsion.atomiccore.support.host.AtomicDefaultSizeData;
import com.transsion.iotservice.multiscreen.pc.notification.atomic.AtomicActionService;
import com.transsion.message.bank.MessageBank;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class f2 {
    public static final JSONObject a(boolean z2) {
        int i8 = (z2 ? 0 | 2 : 0) | 4;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("flags", i8);
            jSONObject.put(MessageBank.KEY_TYPE, 0);
            jSONObject.put("notificationKey", (Object) null);
            jSONObject.put("groupKey", (Object) null);
            jSONObject.put("updateTime", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toJSONObject(...)");
        return jSONObject;
    }

    public static final void b(y6.g gVar, String title, String subTitle, gb.e button) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        Intrinsics.checkNotNullParameter("app_logo", "iconName");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(button, "button");
        k7.e eVar = new k7.e();
        eVar.f6788a = title;
        eVar.f6789b = subTitle;
        f5.a aVar = new f5.a();
        aVar.f4984a = "app_logo";
        eVar.f6791d = new k7.d(aVar);
        f5.a aVar2 = new f5.a();
        aVar2.f4984a = button.f5131a;
        String action = button.f5132b;
        if (action.length() > 0) {
            Intrinsics.checkNotNullParameter(action, "action");
            k7.a aVar3 = new k7.a();
            aVar3.f6780a = "service";
            aVar3.f6781b = "com.transsion.pcconnect";
            aVar3.f6782c = AtomicActionService.class.getName();
            aVar3.f6783d = "com.transsion.iotservice.multiscreen.pc.notification.atomic.AtomicActionService";
            if (aVar3.e == null) {
                aVar3.e = new JSONObject();
            }
            try {
                aVar3.e.put("clickAction", action);
            } catch (Exception e) {
                k1.b("Error adding string param", e.toString());
            }
            aVar2.f4985b = new AtomicAction(aVar3, 0);
        }
        Unit unit = Unit.INSTANCE;
        eVar.f6790c = new k7.d(aVar2);
        gVar.f11096b = new AtomicDefaultSizeData(eVar, 0);
        Intrinsics.checkNotNullExpressionValue(gVar, "setLargeSize(...)");
    }

    public static final void c(y6.g gVar, String title, String str) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        Intrinsics.checkNotNullParameter("app_logo", "iconName");
        Intrinsics.checkNotNullParameter(title, "title");
        k7.e eVar = new k7.e();
        eVar.f6788a = title;
        f5.a aVar = new f5.a();
        aVar.f4984a = "app_logo";
        eVar.f6791d = new k7.d(aVar);
        if (title.length() == 0) {
            f5.a aVar2 = new f5.a();
            aVar2.f4984a = str;
            eVar.e = new k7.d(aVar2);
        } else {
            eVar.e = null;
        }
        gVar.f11095a = new AtomicDefaultSizeData(eVar, 0);
        Intrinsics.checkNotNullExpressionValue(gVar, "setSmallSize(...)");
    }

    public static final JSONObject d() {
        int i8 = 0 | 2 | 4;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("flags", i8);
            jSONObject.put(MessageBank.KEY_TYPE, 1);
            jSONObject.put("notificationKey", (Object) null);
            jSONObject.put("groupKey", (Object) null);
            jSONObject.put("updateTime", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toJSONObject(...)");
        return jSONObject;
    }
}

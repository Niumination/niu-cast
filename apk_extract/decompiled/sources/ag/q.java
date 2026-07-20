package ag;

import android.database.Cursor;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.config.TccpConfig;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpScreenLockRequestBean;
import com.transsion.message.cast.MessageCastService;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearNetworkElement;
import com.welink.protocol.nfbd.NetworkParamsInformation;
import eb.l2;
import k3.gc;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CombinedContext;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import li.j2;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class q implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f781a;

    public /* synthetic */ q(int i8) {
        this.f781a = i8;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String str;
        d0 d0Var;
        d0 d0Var2;
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer;
        switch (this.f781a) {
            case 0:
                Pair t3 = (Pair) obj;
                int iIntValue = ((Integer) obj2).intValue();
                Intrinsics.checkNotNullParameter(t3, "t");
                return Character.valueOf(((String) t3.getFirst()).charAt(iIntValue));
            case 1:
                ((Character) obj).getClass();
                ((Integer) obj2).getClass();
                return Boolean.FALSE;
            case 2:
                char cCharValue = ((Character) obj).charValue();
                ((Integer) obj2).intValue();
                return Boolean.valueOf(cCharValue == ' ');
            case 3:
                char cCharValue2 = ((Character) obj).charValue();
                ((Integer) obj2).intValue();
                return Boolean.valueOf(cCharValue2 == ' ');
            case 4:
                CharSequence s2 = (CharSequence) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                Intrinsics.checkNotNullParameter(s2, "s");
                return Character.valueOf(s2.charAt(iIntValue2));
            case 5:
                zf.x m7 = (zf.x) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                Intrinsics.checkNotNullParameter(m7, "m");
                return Character.valueOf(m7.f11559a.charAt(iIntValue3));
            case 6:
                return CombinedContext.toString$lambda$2((String) obj, (CoroutineContext.Element) obj2);
            case 7:
                return CoroutineContext.DefaultImpls.plus$lambda$0((CoroutineContext) obj, (CoroutineContext.Element) obj2);
            case 8:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 9:
                return ((CoroutineContext) obj).plus((CoroutineContext.Element) obj2);
            case 10:
                return ((CoroutineContext) obj).plus((CoroutineContext.Element) obj2);
            case 11:
                NearNetworkElement nearNetworkElement = (NearNetworkElement) obj2;
                Intrinsics.checkNotNullParameter((NearDevice) obj, "<unused var>");
                gc.c("BleConnectFromPeer", "connectCallback:" + nearNetworkElement);
                if (nearNetworkElement instanceof NearNetworkElement.Wifi) {
                    NetworkParamsInformation networkParamsInformation = ((NearNetworkElement.Wifi) nearNetworkElement).f3949l;
                    if (networkParamsInformation == null || (str = networkParamsInformation.f3952a) == null) {
                        str = "";
                    }
                    String str2 = str;
                    if (!StringsKt__StringsKt.contains$default(str2, ".", false, 2, (Object) null)) {
                        gc.d("BleConnectFromPeer", "connect wrong ip:".concat(str2));
                        return Unit.INSTANCE;
                    }
                    hc.c cVar = ma.a.f7952a;
                    if (cVar != null && (d0Var = ma.a.f7953b) != null) {
                        d0Var.invoke(new hc.b(true, null, cVar.f5288c, str2, cVar.f5289d, cVar.f5287b, 0, 0, cVar.f5286a, 194));
                    }
                }
                return Unit.INSTANCE;
            case 12:
                ((Integer) obj2).getClass();
                Intrinsics.checkNotNullParameter((NearDevice) obj, "<unused var>");
                Lazy lazy = mc.b.f7958a;
                mc.b.b();
                hc.c cVar2 = ma.a.f7952a;
                if (cVar2 != null && (d0Var2 = ma.a.f7953b) != null) {
                    d0Var2.invoke(new hc.b(false, null, cVar2.f5288c, "", cVar2.f5289d, cVar2.f5287b, 0, 0, cVar2.f5286a, 194));
                }
                return Unit.INSTANCE;
            case 13:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
            case 14:
                CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                if (!(element instanceof j2)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue4 = num != null ? num.intValue() : 1;
                return iIntValue4 == 0 ? element : Integer.valueOf(iIntValue4 + 1);
            case 15:
                j2 j2Var = (j2) obj;
                CoroutineContext.Element element2 = (CoroutineContext.Element) obj2;
                if (j2Var != null) {
                    return j2Var;
                }
                return element2 instanceof j2 ? (j2) element2 : null;
            case 16:
                qi.b0 b0Var = (qi.b0) obj;
                CoroutineContext.Element element3 = (CoroutineContext.Element) obj2;
                if (element3 instanceof j2) {
                    bf.p pVar = (bf.p) ((j2) element3);
                    Object objC = pVar.c(b0Var.f9133a);
                    int i8 = b0Var.f9136d;
                    b0Var.f9134b[i8] = objC;
                    b0Var.f9136d = 1 + i8;
                    Intrinsics.checkNotNull(pVar, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
                    b0Var.f9135c[i8] = pVar;
                }
                return b0Var;
            case 17:
                zf.j0 url = (zf.j0) obj;
                zf.j0 it = (zf.j0) obj2;
                Intrinsics.checkNotNullParameter(url, "$this$url");
                Intrinsics.checkNotNullParameter(it, "it");
                zf.n0 value = zf.n0.f11525d;
                url.getClass();
                Intrinsics.checkNotNullParameter(value, "value");
                url.f11512d = value;
                return Unit.INSTANCE;
            case 18:
                ((Integer) obj).getClass();
                boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                w7.d.a();
                if (zBooleanValue) {
                    pa.a aVar = pa.a.f8703a;
                    if (pa.a.j("ro.tr_project.foldable_screen.support")) {
                        Intrinsics.checkNotNullParameter("ScreenControlUtils", "tag");
                        Intrinsics.checkNotNullParameter("isFoldNormal", "log");
                        if (gc.f6462a <= 3) {
                            Log.d(gc.f6463b.concat("ScreenControlUtils"), "isFoldNormal");
                        }
                    } else if (pa.a.j("ro.tr_project.flip_screen.support")) {
                        Intrinsics.checkNotNullParameter("ScreenControlUtils", "tag");
                        Intrinsics.checkNotNullParameter("isFoldPocket", "log");
                        if (gc.f6462a <= 3) {
                            Log.d(gc.f6463b.concat("ScreenControlUtils"), "isFoldPocket");
                        }
                        if (w7.d.f10682d != null && (tCCPHandshakeSocketServer = l2.f4772a) != null) {
                            tCCPHandshakeSocketServer.sendRequest(TccpConfig.INSTANCE.getLOCKSCREEN_TCCP(), new TccpScreenLockRequestBean(true));
                        }
                    }
                } else {
                    Intrinsics.checkNotNullParameter("ScreenControlUtils", "tag");
                    Intrinsics.checkNotNullParameter("NOT FOLD status", "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("ScreenControlUtils"), "NOT FOLD status");
                    }
                    if (w7.d.f10679a == 0) {
                        pa.a aVar2 = pa.a.f8703a;
                        if (pa.a.j("ro.tr_project.flip_screen.support") && w7.d.f10682d != null) {
                            j3.z.c();
                        }
                    }
                }
                return Unit.INSTANCE;
            case 19:
                return MessageCastService.setupSmsReplyDispatcher$lambda$1((String) obj, (String) obj2);
            default:
                Cursor cursor = (Cursor) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                if (xa.i.e.isEmpty() && xa.i.f10895g.isEmpty()) {
                    li.l0.p(xa.i.f10893c, null, null, new xa.e(cursor, iIntValue5, null), 3);
                }
                return Unit.INSTANCE;
        }
    }
}

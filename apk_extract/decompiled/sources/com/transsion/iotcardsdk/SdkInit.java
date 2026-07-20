package com.transsion.iotcardsdk;

import af.w5;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.atomiccore.support.host.AtomicIntentType;
import com.transsion.iotcardsdk.bean.EmptyTemplateBean;
import com.transsion.iotcardsdk.bean.IotCardTemplateBean;
import com.transsion.iotcardsdk.constant.IotCardConstance;
import com.transsion.iotcardsdk.event.EventBean;
import com.transsion.iotcardsdk.exception.InvalidParameterException;
import com.transsion.iotcardsdk.util.IotcardConverter;
import com.transsion.iotservice.iotcard.proto.Empty;
import com.transsion.iotservice.iotcard.proto.IIotcardProviderGrpc;
import com.transsion.iotservice.iotcard.proto.IotcardBean;
import com.transsion.iotservice.iotcard.proto.IotcardListMap;
import com.transsion.iotservice.iotcard.proto.PackageName;
import com.transsion.iotservice.iotcard.proto.Port;
import com.transsion.iotservice.iotcard.proto.SwitchClickAction;
import com.transsion.widgetsliquid.utils.Utils;
import hf.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import k3.db;
import k3.v8;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import le.a;
import li.g0;
import li.h0;
import li.v0;
import o.d;
import si.e;
import y1.b;
import ze.e1;
import ze.f0;
import ze.g1;
import ze.h1;
import ze.i1;
import ze.j1;
import ze.p2;
import ze.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\rJ#\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0004\b\u0017\u0010\u0011J\u001d\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\rJ#\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0004\b\u0019\u0010\u0011J?\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u001e\u0010\u001c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u001b0\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J@\u0010&\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00042!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0!¢\u0006\u0004\b&\u0010'J\u0015\u0010*\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u0015\u0010.\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u000bH\u0002¢\u0006\u0004\b0\u0010\u0003J\u0017\u00101\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b1\u00102J\u001f\u00103\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u001dH\u0002¢\u0006\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u0010<R\u0014\u0010>\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u0010<R$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010:\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u00102R$\u0010A\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010:\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u00102R\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010G\u001a\u0004\b\u001e\u00108\"\u0004\bH\u0010IR$\u0010J\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\"\u0010S\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010G\u001a\u0004\bS\u00108\"\u0004\bT\u0010IR\"\u0010V\u001a\u00020U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R*\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\bb\u0010:\u001a\u0004\bc\u0010\u0006R\"\u0010d\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010G\u001a\u0004\bd\u00108\"\u0004\be\u0010I¨\u0006f"}, d2 = {"Lcom/transsion/iotcardsdk/SdkInit;", "", "<init>", "()V", "", "getVersion", "()Ljava/lang/String;", "Landroid/app/Application;", "application", "Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;", "iotCardTemplateBean", "", "registerDevice", "(Landroid/app/Application;Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;)V", "", "cardList", "registerDeviceList", "(Landroid/app/Application;Ljava/util/List;)V", "controlId", "packageName", "unregisterDevice", "(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;)V", "iotCardTemplateBeans", "unregisterDeviceList", "updateDevice", "updateDeviceList", "Lkotlin/Function0;", "", "callback", "", "isInitPort", "initAppDevices", "(Landroid/app/Application;Lkotlin/jvm/functions/Function0;Z)V", "Lkotlin/Function1;", "Lcom/transsion/iotservice/iotcard/proto/SwitchClickAction;", "Lkotlin/ParameterName;", "name", "switchAction", "clickCardSwitch", "(Landroid/app/Application;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "", "deviceTypeId", "isSupportDevice", "(I)Z", "Landroid/content/Context;", "context", "initSupportDevices", "(Landroid/content/Context;)V", "checkChannelEnable", "initPort", "(Ljava/lang/String;)V", "checkParametersLegal", "(Ljava/lang/String;Ljava/lang/String;)V", "isIotCardEnable", "(Landroid/app/Application;)Z", "isTargetVersion", "()Z", "TAG", "Ljava/lang/String;", "REGISTER", "I", "UNREGISTER", "UPDATE", "getPackageName", "setPackageName", "className", "getClassName", "setClassName", "Lze/e1;", "channel", "Lze/e1;", "Z", "setInitPort", "(Z)V", "appPort", "Ljava/lang/Integer;", "getAppPort", "()Ljava/lang/Integer;", "setAppPort", "(Ljava/lang/Integer;)V", "Lli/g0;", "mCoroutineScope", "Lli/g0;", "isTCircle", "setTCircle", "Lcom/transsion/iotcardsdk/TCHelper;", "tcHelper", "Lcom/transsion/iotcardsdk/TCHelper;", "getTcHelper", "()Lcom/transsion/iotcardsdk/TCHelper;", "setTcHelper", "(Lcom/transsion/iotcardsdk/TCHelper;)V", "currentSupportDevices", "Ljava/util/List;", "getCurrentSupportDevices", "()Ljava/util/List;", "setCurrentSupportDevices", "(Ljava/util/List;)V", "KEY_IOT_CARD_SUPPORT_DEVICES", "getKEY_IOT_CARD_SUPPORT_DEVICES", "isNeedReadSettings", "setNeedReadSettings", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nSdkInit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SdkInit.kt\ncom/transsion/iotcardsdk/SdkInit\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,500:1\n766#2:501\n857#2,2:502\n766#2:504\n857#2,2:505\n1549#2:507\n1620#2,3:508\n*S KotlinDebug\n*F\n+ 1 SdkInit.kt\ncom/transsion/iotcardsdk/SdkInit\n*L\n117#1:501\n117#1:502,2\n291#1:504\n291#1:505,2\n496#1:507\n496#1:508,3\n*E\n"})
public final class SdkInit {
    private static final String KEY_IOT_CARD_SUPPORT_DEVICES;
    public static final int REGISTER = 0;
    public static final String TAG = "SdkInit";
    public static final int UNREGISTER = 1;
    public static final int UPDATE = 2;
    private static e1 channel;
    private static String className;
    private static List<Integer> currentSupportDevices;
    private static boolean isInitPort;
    private static boolean isNeedReadSettings;
    private static boolean isTCircle;
    private static final g0 mCoroutineScope;
    private static String packageName;
    private static TCHelper tcHelper;
    public static final SdkInit INSTANCE = new SdkInit();
    private static Integer appPort = 0;

    static {
        v0 v0Var = v0.f7498a;
        mCoroutineScope = h0.a(e.f10118a);
        tcHelper = new TCHelper();
        currentSupportDevices = CollectionsKt.emptyList();
        KEY_IOT_CARD_SUPPORT_DEVICES = "key_iot_card_support_devices";
    }

    private SdkInit() {
    }

    private final void checkChannelEnable() {
        j1 j1Var;
        List list;
        int i8 = 0;
        e1 e1Var = channel;
        q qVarH = e1Var != null ? e1Var.h() : null;
        Log.d(DeviceProviderService.TAG, "checkChannelEnable channel state:" + qVarH);
        if (qVarH == q.READY || qVarH == q.IDLE) {
            return;
        }
        e1 e1Var2 = channel;
        if (e1Var2 != null) {
            e1Var2.i();
        }
        IotCardConstance iotCardConstance = IotCardConstance.INSTANCE;
        String ip = iotCardConstance.getIP();
        int port = iotCardConstance.getPORT();
        Logger logger = j1.f11365c;
        synchronized (j1.class) {
            try {
                if (j1.f11366d == null) {
                    List<h1> listE = f0.e(h1.class, j1.a(), h1.class.getClassLoader(), new p2(4));
                    j1.f11366d = new j1();
                    for (h1 h1Var : listE) {
                        j1.f11365c.fine("Service loader found " + h1Var);
                        j1 j1Var2 = j1.f11366d;
                        synchronized (j1Var2) {
                            v8.c("isAvailable() returned false", h1Var.b());
                            j1Var2.f11367a.add(h1Var);
                        }
                    }
                    j1 j1Var3 = j1.f11366d;
                    synchronized (j1Var3) {
                        ArrayList arrayList = new ArrayList(j1Var3.f11367a);
                        Collections.sort(arrayList, Collections.reverseOrder(new i1(i8)));
                        j1Var3.f11368b = Collections.unmodifiableList(arrayList);
                    }
                }
                j1Var = j1.f11366d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        synchronized (j1Var) {
            list = j1Var.f11368b;
        }
        h1 h1Var2 = list.isEmpty() ? null : (h1) list.get(0);
        if (h1Var2 == null) {
            throw new g1("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
        }
        e1 e1VarA = h1Var2.a(ip, port).b().a();
        channel = e1VarA;
        Log.d(DeviceProviderService.TAG, "build channel state:" + (e1VarA != null ? e1VarA.h() : null));
    }

    private final void checkParametersLegal(String controlId, String packageName2) {
        if (packageName2 == null || packageName2.length() == 0) {
            throw new InvalidParameterException("packageName cannot be empty ");
        }
        if (controlId == null || controlId.length() == 0) {
            throw new InvalidParameterException("controlId cannot be empty ");
        }
    }

    public static /* synthetic */ void initAppDevices$default(SdkInit sdkInit, Application application, Function0 function0, boolean z2, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            z2 = true;
        }
        sdkInit.initAppDevices(application, function0, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initPort(String packageName2) {
        try {
            Log.d(DeviceProviderService.TAG, "initPort, isInitPort = " + isInitPort);
            checkChannelEnable();
            IIotcardProviderGrpc.IIotcardProviderStub iIotcardProviderStubNewStub = IIotcardProviderGrpc.newStub(channel);
            if (!isInitPort) {
                a aVarA = db.a();
                if (aVarA.f7420a) {
                    w5 w5Var = aVarA.f7421b;
                    appPort = w5Var != null ? Integer.valueOf(w5Var.e()) : null;
                } else {
                    Log.d(DeviceProviderService.TAG, "initPort, createServer fail = " + aVarA.f7422c);
                }
                Log.d(DeviceProviderService.TAG, "initPort appPort2222 " + appPort);
                isInitPort = true;
            }
            Log.d(DeviceProviderService.TAG, "stub.initPort");
            Port.Builder builderNewBuilder = Port.newBuilder();
            Integer num = appPort;
            builderNewBuilder.setPort(num != null ? num.intValue() : 0);
            builderNewBuilder.setPackageName(packageName2);
            iIotcardProviderStubNewStub.initPort(builderNewBuilder.build(), new v() { // from class: com.transsion.iotcardsdk.SdkInit.initPort.1
                @Override // hf.v
                public void onCompleted() {
                }

                @Override // hf.v
                public void onError(Throwable t3) {
                }

                @Override // hf.v
                public void onNext(Empty value) {
                }
            });
        } catch (Exception e) {
            h0.a.w("initPort ", e.getMessage(), DeviceProviderService.TAG);
        }
    }

    private final boolean isIotCardEnable(Application application) {
        Object systemService = application.getSystemService(AtomicIntentType.ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
        Log.d(DeviceProviderService.TAG, "runningAppProcesses size is " + runningAppProcesses.size());
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            d.B("processName is ", runningAppProcessInfo.processName, DeviceProviderService.TAG);
            if (Intrinsics.areEqual(runningAppProcessInfo.processName, IotCardConstance.INSTANCE.getIOTCARD_PACKAGENAME())) {
                return true;
            }
        }
        return false;
    }

    private final boolean isTargetVersion() {
        IotcardConverter iotcardConverter = IotcardConverter.INSTANCE;
        String property = iotcardConverter.getProperty(Utils.OS_TRANS_VERSION, "");
        if (property == null) {
            property = "";
        }
        String property2 = iotcardConverter.getProperty("ro.tranos.type", "");
        if (property2 == null) {
            property2 = "";
        }
        return iotcardConverter.isSupportVersion(StringsKt__StringsJVMKt.replace$default(property, property2, "", false, 4, (Object) null), IotCardConstance.INSTANCE.getTARGET_VERSION());
    }

    public final void clickCardSwitch(Application application, String packageName2, final Function1<? super SwitchClickAction, Unit> callback) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(packageName2, "packageName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            Log.d(DeviceProviderService.TAG, "clickCardSwitch:" + callback);
            checkChannelEnable();
            IIotcardProviderGrpc.IIotcardProviderStub iIotcardProviderStubNewStub = IIotcardProviderGrpc.newStub(channel);
            PackageName.Builder builderNewBuilder = PackageName.newBuilder();
            builderNewBuilder.setPackageName(packageName2);
            iIotcardProviderStubNewStub.switchClick(builderNewBuilder.build(), new v() { // from class: com.transsion.iotcardsdk.SdkInit.clickCardSwitch.1
                @Override // hf.v
                public void onCompleted() {
                    Log.d(DeviceProviderService.TAG, "clickCardSwitch onCompleted");
                }

                @Override // hf.v
                public void onError(Throwable t3) {
                    d.B("clickCardSwitch onError ", t3 != null ? t3.getMessage() : null, DeviceProviderService.TAG);
                }

                @Override // hf.v
                public void onNext(SwitchClickAction switchAction) {
                    if (switchAction != null) {
                        Function1<SwitchClickAction, Unit> function1 = callback;
                        Log.d(DeviceProviderService.TAG, "switchClick onNext " + switchAction);
                        function1.invoke(switchAction);
                    }
                }
            });
        } catch (Exception e) {
            h0.a.w("clickCardSwitch ", e.getMessage(), DeviceProviderService.TAG);
        }
    }

    public final Integer getAppPort() {
        return appPort;
    }

    public final String getClassName() {
        return className;
    }

    public final List<Integer> getCurrentSupportDevices() {
        return currentSupportDevices;
    }

    public final String getKEY_IOT_CARD_SUPPORT_DEVICES() {
        return KEY_IOT_CARD_SUPPORT_DEVICES;
    }

    public final String getPackageName() {
        return packageName;
    }

    public final TCHelper getTcHelper() {
        return tcHelper;
    }

    public final String getVersion() {
        return "1.0.39";
    }

    public final synchronized void initAppDevices(final Application application, Function0<? extends Map<String, ? extends List<? extends IotCardTemplateBean>>> callback, final boolean isInitPort2) {
        try {
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(callback, "callback");
            try {
                initSupportDevices(application);
                tcHelper.bindWriteService(application, callback);
                checkChannelEnable();
                Map<String, ? extends List<? extends IotCardTemplateBean>> mapInvoke = callback.invoke();
                Log.d(DeviceProviderService.TAG, "initAppDevices map:" + mapInvoke + " ");
                IIotcardProviderGrpc.IIotcardProviderStub iIotcardProviderStubNewStub = IIotcardProviderGrpc.newStub(channel);
                IotcardListMap iotcardListMapConvertToIotcardListMap = IotcardConverter.INSTANCE.convertToIotcardListMap(mapInvoke);
                e1 e1Var = channel;
                Log.d(DeviceProviderService.TAG, "channel status: " + (e1Var != null ? e1Var.h() : null) + " ");
                iIotcardProviderStubNewStub.initAppDevices(new v() { // from class: com.transsion.iotcardsdk.SdkInit.initAppDevices.1
                    @Override // hf.v
                    public void onCompleted() {
                        Log.d(DeviceProviderService.TAG, "initAppDevices onCompleted");
                    }

                    @Override // hf.v
                    public void onError(Throwable t3) {
                        h0.a.w("initAppDevices onError ", t3 != null ? t3.getMessage() : null, DeviceProviderService.TAG);
                    }

                    @Override // hf.v
                    public void onNext(Empty value) {
                        Log.d(DeviceProviderService.TAG, "initAppDevices onNext ");
                        if (isInitPort2) {
                            SdkInit sdkInit = SdkInit.INSTANCE;
                            String packageName2 = application.getPackageName();
                            Intrinsics.checkNotNullExpressionValue(packageName2, "application.packageName");
                            sdkInit.initPort(packageName2);
                        }
                    }
                }).onNext(iotcardListMapConvertToIotcardListMap);
            } catch (Exception e) {
                Log.e(DeviceProviderService.TAG, "initAppDevices " + e.getMessage());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void initSupportDevices(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean zIsTargetVersion = isTargetVersion();
        isNeedReadSettings = zIsTargetVersion;
        Log.d(TAG, "isNeedReadSettings: " + zIsTargetVersion);
        if (isNeedReadSettings) {
            String string = Settings.Global.getString(context.getContentResolver(), KEY_IOT_CARD_SUPPORT_DEVICES);
            if (string == null) {
                string = "";
            }
            List listSplit$default = StringsKt__StringsKt.split$default(string, new String[]{"$"}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.i(listSplit$default));
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.toIntOrNull((String) it.next()));
            }
            currentSupportDevices = arrayList;
        }
    }

    public final boolean isInitPort() {
        return isInitPort;
    }

    public final boolean isNeedReadSettings() {
        return isNeedReadSettings;
    }

    public final boolean isSupportDevice(int deviceTypeId) {
        return isNeedReadSettings ? currentSupportDevices.contains(Integer.valueOf(deviceTypeId)) : IotCardConstance.INSTANCE.getLOW_VERSION_SUPPORT_DEVICES().contains(Integer.valueOf(deviceTypeId));
    }

    public final boolean isTCircle() {
        return isTCircle;
    }

    public final void registerDevice(Application application, IotCardTemplateBean iotCardTemplateBean) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(iotCardTemplateBean, "iotCardTemplateBean");
        try {
            Log.d(DeviceProviderService.TAG, "registerDevice " + iotCardTemplateBean + " ");
            if (isSupportDevice(iotCardTemplateBean.getDeviceTypeId())) {
                tcHelper.registerDevice(iotCardTemplateBean);
                if (isTCircle) {
                    return;
                }
                checkParametersLegal(iotCardTemplateBean.getControlId(), iotCardTemplateBean.getPackageName());
                b bVar = b.e;
                EventBean eventBean = new EventBean(0, iotCardTemplateBean);
                bVar.getClass();
                b.f11024c.onNext(eventBean);
                IotcardBean iotcardBeanConvertToIotCardBean = IotcardConverter.INSTANCE.convertToIotCardBean(iotCardTemplateBean);
                checkChannelEnable();
                IIotcardProviderGrpc.newStub(channel).registerDevice(iotcardBeanConvertToIotCardBean, new v() { // from class: com.transsion.iotcardsdk.SdkInit.registerDevice.1
                    @Override // hf.v
                    public void onCompleted() {
                    }

                    @Override // hf.v
                    public void onError(Throwable t3) {
                    }

                    @Override // hf.v
                    public void onNext(Empty value) {
                    }
                });
            }
        } catch (Exception e) {
            h0.a.w("registerDevice ", e.getMessage(), DeviceProviderService.TAG);
        }
    }

    public final void registerDeviceList(Application application, List<? extends IotCardTemplateBean> cardList) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(cardList, "cardList");
        try {
            Log.d(DeviceProviderService.TAG, "registerDeviceList " + cardList + " ");
            ArrayList arrayList = new ArrayList();
            for (Object obj : cardList) {
                if (INSTANCE.isSupportDevice(((IotCardTemplateBean) obj).getDeviceTypeId())) {
                    arrayList.add(obj);
                }
            }
            tcHelper.registerDeviceList(arrayList);
            if (isTCircle) {
                return;
            }
            checkChannelEnable();
            IIotcardProviderGrpc.newStub(channel).registerDeviceList(IotcardConverter.INSTANCE.convertToIotCardBeanList(arrayList), new v() { // from class: com.transsion.iotcardsdk.SdkInit.registerDeviceList.1
                @Override // hf.v
                public void onCompleted() {
                }

                @Override // hf.v
                public void onError(Throwable t3) {
                }

                @Override // hf.v
                public void onNext(Empty value) {
                }
            });
        } catch (Exception e) {
            h0.a.w("registerDeviceList ", e.getMessage(), DeviceProviderService.TAG);
        }
    }

    public final void setAppPort(Integer num) {
        appPort = num;
    }

    public final void setClassName(String str) {
        className = str;
    }

    public final void setCurrentSupportDevices(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        currentSupportDevices = list;
    }

    public final void setInitPort(boolean z2) {
        isInitPort = z2;
    }

    public final void setNeedReadSettings(boolean z2) {
        isNeedReadSettings = z2;
    }

    public final void setPackageName(String str) {
        packageName = str;
    }

    public final void setTCircle(boolean z2) {
        isTCircle = z2;
    }

    public final void setTcHelper(TCHelper tCHelper) {
        Intrinsics.checkNotNullParameter(tCHelper, "<set-?>");
        tcHelper = tCHelper;
    }

    public final void unregisterDevice(Application application, String controlId, String packageName2) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(controlId, "controlId");
        Intrinsics.checkNotNullParameter(packageName2, "packageName");
        try {
            Log.d(DeviceProviderService.TAG, "unregisterDevice " + controlId + " ");
            tcHelper.unregisterDevice(controlId);
            if (isTCircle) {
                return;
            }
            checkParametersLegal(controlId, packageName2);
            b bVar = b.e;
            EventBean eventBean = new EventBean(1, new EmptyTemplateBean(controlId, packageName2));
            bVar.getClass();
            b.f11024c.onNext(eventBean);
            IotcardBean iotcardBeanConvertToIotCardBean = IotcardConverter.INSTANCE.convertToIotCardBean(controlId, packageName2);
            checkChannelEnable();
            IIotcardProviderGrpc.newStub(channel).unregisterDevice(iotcardBeanConvertToIotCardBean, new v() { // from class: com.transsion.iotcardsdk.SdkInit.unregisterDevice.1
                @Override // hf.v
                public void onCompleted() {
                }

                @Override // hf.v
                public void onError(Throwable t3) {
                }

                @Override // hf.v
                public void onNext(Empty value) {
                }
            });
        } catch (Exception e) {
            h0.a.w("unregisterDevice ", e.getMessage(), DeviceProviderService.TAG);
        }
    }

    public final void unregisterDeviceList(Application application, List<? extends IotCardTemplateBean> iotCardTemplateBeans) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(iotCardTemplateBeans, "iotCardTemplateBeans");
        try {
            Log.d(DeviceProviderService.TAG, "unregisterDeviceList " + iotCardTemplateBeans + " ");
            tcHelper.unregisterDeviceList(iotCardTemplateBeans);
            if (isTCircle) {
                return;
            }
            checkChannelEnable();
            IIotcardProviderGrpc.newStub(channel).unRegisterDeviceList(IotcardConverter.INSTANCE.convertToIotCardBeanList(iotCardTemplateBeans), new v() { // from class: com.transsion.iotcardsdk.SdkInit.unregisterDeviceList.1
                @Override // hf.v
                public void onCompleted() {
                }

                @Override // hf.v
                public void onError(Throwable t3) {
                }

                @Override // hf.v
                public void onNext(Empty value) {
                }
            });
        } catch (Exception e) {
            h0.a.w("unregisterDeviceList ", e.getMessage(), DeviceProviderService.TAG);
        }
    }

    public final void updateDevice(Application application, IotCardTemplateBean iotCardTemplateBean) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(iotCardTemplateBean, "iotCardTemplateBean");
        try {
            Log.d(DeviceProviderService.TAG, "updateDevice " + iotCardTemplateBean + " ");
            if (isSupportDevice(iotCardTemplateBean.getDeviceTypeId())) {
                tcHelper.updateDevice(iotCardTemplateBean);
                if (isTCircle) {
                    return;
                }
                checkParametersLegal(iotCardTemplateBean.getControlId(), iotCardTemplateBean.getPackageName());
                b bVar = b.e;
                EventBean eventBean = new EventBean(2, iotCardTemplateBean);
                bVar.getClass();
                b.f11024c.onNext(eventBean);
                IotcardBean iotcardBeanConvertToIotCardBean = IotcardConverter.INSTANCE.convertToIotCardBean(iotCardTemplateBean);
                checkChannelEnable();
                IIotcardProviderGrpc.newStub(channel).updateDevice(iotcardBeanConvertToIotCardBean, new v() { // from class: com.transsion.iotcardsdk.SdkInit.updateDevice.1
                    @Override // hf.v
                    public void onCompleted() {
                    }

                    @Override // hf.v
                    public void onError(Throwable t3) {
                    }

                    @Override // hf.v
                    public void onNext(Empty value) {
                    }
                });
            }
        } catch (Exception e) {
            h0.a.w("updateDevice ", e.getMessage(), DeviceProviderService.TAG);
        }
    }

    public final void updateDeviceList(Application application, List<? extends IotCardTemplateBean> iotCardTemplateBeans) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(iotCardTemplateBeans, "iotCardTemplateBeans");
        try {
            Log.d(DeviceProviderService.TAG, "updateDeviceList " + iotCardTemplateBeans + " ");
            ArrayList arrayList = new ArrayList();
            for (Object obj : iotCardTemplateBeans) {
                if (!INSTANCE.isSupportDevice(((IotCardTemplateBean) obj).getDeviceTypeId())) {
                    arrayList.add(obj);
                }
            }
            tcHelper.updateDeviceList(arrayList);
            if (isTCircle) {
                return;
            }
            checkChannelEnable();
            IIotcardProviderGrpc.newStub(channel).updateDeviceList(IotcardConverter.INSTANCE.convertToIotCardBeanList(arrayList), new v() { // from class: com.transsion.iotcardsdk.SdkInit.updateDeviceList.1
                @Override // hf.v
                public void onCompleted() {
                }

                @Override // hf.v
                public void onError(Throwable t3) {
                }

                @Override // hf.v
                public void onNext(Empty value) {
                }
            });
        } catch (Exception e) {
            h0.a.w("updateDeviceList ", e.getMessage(), DeviceProviderService.TAG);
        }
    }

    public final void unregisterDevice(Application application, IotCardTemplateBean iotCardTemplateBean) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(iotCardTemplateBean, "iotCardTemplateBean");
        try {
            Log.d(DeviceProviderService.TAG, "unregisterDevice " + iotCardTemplateBean + " ");
            tcHelper.unregisterDevice(iotCardTemplateBean.getControlId());
            if (isTCircle) {
                return;
            }
            checkParametersLegal(iotCardTemplateBean.getControlId(), iotCardTemplateBean.getPackageName());
            b bVar = b.e;
            EventBean eventBean = new EventBean(1, iotCardTemplateBean);
            bVar.getClass();
            b.f11024c.onNext(eventBean);
            IotcardBean iotcardBeanConvertToIotCardBean = IotcardConverter.INSTANCE.convertToIotCardBean(iotCardTemplateBean);
            checkChannelEnable();
            IIotcardProviderGrpc.newStub(channel).unregisterDevice(iotcardBeanConvertToIotCardBean, new v() { // from class: com.transsion.iotcardsdk.SdkInit.unregisterDevice.2
                @Override // hf.v
                public void onCompleted() {
                }

                @Override // hf.v
                public void onError(Throwable t3) {
                }

                @Override // hf.v
                public void onNext(Empty value) {
                }
            });
        } catch (Exception e) {
            h0.a.w("unregisterDevice ", e.getMessage(), DeviceProviderService.TAG);
        }
    }
}

package com.transsion.iotservice.multiscreen.pc.ui.search.viewModel;

import android.content.Intent;
import android.location.LocationManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import bb.r;
import com.transsion.capability.bean.FileInfo;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.state.BaseState;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalConnecting;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalDisconnecting;
import com.transsion.iotservice.pc.bean.ThumbBean;
import com.transsion.iotservice.scan.bean.ScannedDevice;
import eb.k1;
import eb.l2;
import eb.o1;
import eb.t;
import eb.v;
import eb.y;
import eb.y0;
import java.util.ArrayList;
import k3.gc;
import k3.pb;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import li.g2;
import li.l0;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/search/viewModel/DeviceViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nDeviceViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceViewModel.kt\ncom/transsion/iotservice/multiscreen/pc/ui/search/viewModel/DeviceViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,424:1\n1557#2:425\n1628#2,3:426\n*S KotlinDebug\n*F\n+ 1 DeviceViewModel.kt\ncom/transsion/iotservice/multiscreen/pc/ui/search/viewModel/DeviceViewModel\n*L\n280#1:425\n280#1:426,3\n*E\n"})
public final class DeviceViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2838c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2839d;
    public r e;
    public final MutableLiveData f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData f2840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData f2841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData f2842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData f2843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableLiveData f2844k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableLiveData f2845l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutableLiveData f2846m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g2 f2847n;

    public DeviceViewModel() {
        MutableLiveData mutableLiveData = new MutableLiveData(0);
        this.f = mutableLiveData;
        this.f2840g = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this.f2841h = mutableLiveData2;
        this.f2842i = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData(Integer.valueOf(R$string.module_pc_connect));
        this.f2843j = mutableLiveData3;
        this.f2844k = mutableLiveData3;
        MutableLiveData mutableLiveData4 = new MutableLiveData();
        this.f2845l = mutableLiveData4;
        this.f2846m = mutableLiveData4;
        y yVar = y.f4799a;
        y.o(true);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    public static final Object a(DeviceViewModel deviceViewModel, hc.b connectState, ScannedDevice connectingDevice, ContinuationImpl continuationImpl) {
        a aVar;
        r rVar;
        DeviceViewModel deviceViewModel2 = deviceViewModel;
        deviceViewModel.getClass();
        if (continuationImpl instanceof a) {
            aVar = (a) continuationImpl;
            int i8 = aVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                aVar.label = i8 - Integer.MIN_VALUE;
            } else {
                aVar = new a(deviceViewModel2, continuationImpl);
            }
        } else {
            aVar = new a(deviceViewModel2, continuationImpl);
        }
        Object obj = aVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = aVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            gc.c("DeviceViewModel", "dealConnectResult:" + connectState);
            r rVar2 = deviceViewModel2.e;
            if (rVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBleScanDataFilterHelper");
                rVar2 = null;
            }
            rVar2.getClass();
            Intrinsics.checkNotNullParameter(connectState, "connectState");
            boolean z2 = !connectState.f5279a;
            rVar2.f1245g = z2;
            String strO = d.o("onP2pConnected deleteTimeoutDevice:", z2, "BleScanDataFilterHelper", "tag", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("BleScanDataFilterHelper"), strO);
            }
            if (connectState.f5279a) {
                r rVar3 = deviceViewModel2.e;
                if (rVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBleScanDataFilterHelper");
                    rVar = null;
                } else {
                    rVar = rVar3;
                }
                rVar.getClass();
                Intrinsics.checkNotNullParameter(connectingDevice, "connectingDevice");
                rVar.e.remove(connectingDevice.getDeviceMac());
                h();
                return Unit.INSTANCE;
            }
            String str = connectState.f5280b;
            int iHashCode = str.hashCode();
            if (iHashCode != -1313911455) {
                if (iHashCode != -1281977283) {
                    if (iHashCode == -934710369 && str.equals("reject")) {
                        aVar.label = 1;
                        if (deviceViewModel2.d("bleReject", aVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else if (str.equals("failed")) {
                    gc.a("DeviceViewModel", "dealConnectResult STATE_DISCONNECT");
                    if (deviceViewModel2.f2836a) {
                        gc.c("DeviceViewModel", "STATE_DISCONNECT: no deal, reason click research");
                        return Unit.INSTANCE;
                    }
                    y yVar = y.f4799a;
                    aVar.L$0 = deviceViewModel2;
                    aVar.label = 3;
                    if (y.f4799a.j("DeviceViewModel disconnect", true, aVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    deviceViewModel2.f.postValue(Boxing.boxInt(4));
                    deviceViewModel2.f2841h.postValue(Boxing.boxBoolean(false));
                    deviceViewModel2.f2843j.postValue(Boxing.boxInt(R$string.module_pc_connect_time_out));
                    ob.b bVar = ob.b.f8417b;
                    bVar.getClass();
                    String triggerScene = ob.b.f8418c;
                    Intrinsics.checkNotNullParameter("others_failed", "requestConnectStatus");
                    Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
                    bVar.f8437a.q("others_failed", triggerScene);
                }
            } else if (str.equals("timeout")) {
                gc.a("DeviceViewModel", "STATE_TIME_OUT");
                y yVar2 = y.f4799a;
                aVar.L$0 = deviceViewModel2;
                aVar.label = 2;
                if (y.f4799a.j("DeviceViewModel timeout", true, aVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                deviceViewModel2.f();
                ob.b bVar2 = ob.b.f8417b;
                bVar2.getClass();
                String triggerScene2 = ob.b.f8418c;
                Intrinsics.checkNotNullParameter("others_failed", "requestConnectStatus");
                Intrinsics.checkNotNullParameter(triggerScene2, "triggerScene");
                bVar2.f8437a.q("others_failed", triggerScene2);
            }
        } else if (i9 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i9 == 2) {
            deviceViewModel2 = (DeviceViewModel) aVar.L$0;
            ResultKt.throwOnFailure(obj);
            deviceViewModel2.f();
            ob.b bVar3 = ob.b.f8417b;
            bVar3.getClass();
            String triggerScene3 = ob.b.f8418c;
            Intrinsics.checkNotNullParameter("others_failed", "requestConnectStatus");
            Intrinsics.checkNotNullParameter(triggerScene3, "triggerScene");
            bVar3.f8437a.q("others_failed", triggerScene3);
        } else {
            if (i9 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            deviceViewModel2 = (DeviceViewModel) aVar.L$0;
            ResultKt.throwOnFailure(obj);
            deviceViewModel2.f.postValue(Boxing.boxInt(4));
            deviceViewModel2.f2841h.postValue(Boxing.boxBoolean(false));
            deviceViewModel2.f2843j.postValue(Boxing.boxInt(R$string.module_pc_connect_time_out));
            ob.b bVar4 = ob.b.f8417b;
            bVar4.getClass();
            String triggerScene4 = ob.b.f8418c;
            Intrinsics.checkNotNullParameter("others_failed", "requestConnectStatus");
            Intrinsics.checkNotNullParameter(triggerScene4, "triggerScene");
            bVar4.f8437a.q("others_failed", triggerScene4);
        }
        return Unit.INSTANCE;
    }

    public static final Object b(DeviceViewModel deviceViewModel, SuspendLambda suspendLambda) {
        deviceViewModel.getClass();
        Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
        Intrinsics.checkNotNullParameter("startScanDevice", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("DeviceViewModel"), "startScanDevice");
        }
        ob.b.f8417b.getClass();
        ob.b.f8424k.clear();
        ob.b.f8420g = SystemClock.elapsedRealtime();
        Object systemService = pb.a().getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        if (!((LocationManager) systemService).isLocationEnabled()) {
            if (pb.a().checkSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL") == 0) {
                Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
                Intrinsics.checkNotNullParameter("setLocationEnable with across_user_full", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("DeviceViewModel"), "setLocationEnable with across_user_full");
                }
                pa.a.f8703a.a();
            } else {
                Settings.Secure.putInt(pb.a().getContentResolver(), "location_mode", 1);
                Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
                Intrinsics.checkNotNullParameter("setLocationEnable with setting provider", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("DeviceViewModel"), "setLocationEnable with setting provider");
                }
            }
        }
        Object objP = y.f4799a.p(new zb.b(deviceViewModel, 0), suspendLambda);
        return objP == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objP : Unit.INSTANCE;
    }

    public static void c(int i8, ArrayList fileList) {
        if (fileList == null || fileList.isEmpty()) {
            Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
            Intrinsics.checkNotNullParameter("dealFileTransfer: file info is empty", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("DeviceViewModel"), "dealFileTransfer: file info is empty");
                return;
            }
            return;
        }
        Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
        Intrinsics.checkNotNullParameter("dealFileTransfer", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("DeviceViewModel"), "dealFileTransfer");
        }
        y yVar = y.f4799a;
        Intrinsics.checkNotNullParameter(fileList, "fileList");
        l0.p(y.f4800b, null, null, new v(fileList, i8, null), 3);
    }

    public static ArrayList e(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        ArrayList<ThumbBean> arrayList = (ArrayList) intent.getSerializableExtra("fileList", new ArrayList().getClass());
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.i(arrayList));
        for (ThumbBean thumbBean : arrayList) {
            arrayList2.add(new FileInfo(thumbBean.getUri(), thumbBean.getThumbnail(), thumbBean.getName(), thumbBean.getFormat(), thumbBean.getType(), thumbBean.getFileSize()));
        }
        return arrayList2;
    }

    public static void g() {
        Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
        Intrinsics.checkNotNullParameter("stopAdvertisement", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("DeviceViewModel"), "stopAdvertisement");
        }
        o1 o1Var = o1.f4782a;
        Intrinsics.checkNotNullParameter("ScanManager", "tag");
        Intrinsics.checkNotNullParameter("stopAdvertisement", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("ScanManager"), "stopAdvertisement");
        }
        kc.b bVar = o1.f4783b;
        if (!bVar.f6820c) {
            Intrinsics.checkNotNullParameter("ScanApi", "tag");
            Intrinsics.checkNotNullParameter("stopAdvertisement already stop", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("ScanApi"), "stopAdvertisement already stop");
                return;
            }
            return;
        }
        Lazy lazy = mc.b.f7958a;
        Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
        Intrinsics.checkNotNullParameter("stopAdv", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("TranConnectManager"), "stopAdv");
        }
        mc.b.e().f9655c.U();
        bVar.f6820c = false;
    }

    public static void h() {
        Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
        Intrinsics.checkNotNullParameter("stopScan", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("DeviceViewModel"), "stopScan");
        }
        y yVar = y.f4799a;
        l0.p(y.f4800b, null, null, new t(null), 3);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d(String str, ContinuationImpl continuationImpl) {
        b bVar;
        if (continuationImpl instanceof b) {
            bVar = (b) continuationImpl;
            int i8 = bVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                bVar.label = i8 - Integer.MIN_VALUE;
            } else {
                bVar = new b(this, continuationImpl);
            }
        } else {
            bVar = new b(this, continuationImpl);
        }
        Object obj = bVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = bVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            String log = "dealPcReject " + str;
            Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("DeviceViewModel"), log);
            }
            if (TextUtils.equals(str, "bleReject")) {
                y yVar = y.f4799a;
                String strI = h0.a.i("DeviceViewModel ", str);
                bVar.L$0 = this;
                bVar.label = 1;
                if (y.f4799a.j(strI, true, bVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (DeviceViewModel) bVar.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.f2841h.postValue(Boxing.boxBoolean(true));
        this.f.postValue(Boxing.boxInt(3));
        this.f2843j.postValue(Boxing.boxInt(R$string.pc_module_application_rejected));
        ob.b bVar2 = ob.b.f8417b;
        bVar2.getClass();
        Intrinsics.checkNotNullParameter("decline", "conStatus");
        String triggerScene = ob.b.f8418c;
        Intrinsics.checkNotNullParameter("decline", "requestConnectStatus");
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        bVar2.f8437a.q("decline", triggerScene);
        return Unit.INSTANCE;
    }

    public final void f() {
        Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
        Intrinsics.checkNotNullParameter("setTimeoutState", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("DeviceViewModel"), "setTimeoutState");
        }
        this.f2841h.postValue(Boolean.FALSE);
        this.f.postValue(5);
        this.f2843j.postValue(Integer.valueOf(R$string.module_pc_connect_time_out));
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        super.onCleared();
        gc.c("DeviceViewModel", "onCleared");
        y yVar = y.f4799a;
        y.o(false);
        h();
        g();
        k1 k1Var = k1.f4765a;
        Intrinsics.checkNotNullParameter("BleConnectFromPeer", "tag");
        Intrinsics.checkNotNullParameter("unregisterBleConnectFromPeer", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BleConnectFromPeer"), "unregisterBleConnectFromPeer");
        }
        ma.a.f7953b = null;
        ma.a.f7954c = null;
        Lazy lazy = mc.b.f7958a;
        mc.b.f();
        Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
        Intrinsics.checkNotNullParameter("releasePcConnCallback", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("TranConnectManager"), "releasePcConnCallback");
        }
        mc.b.f7965j.clear();
        mc.b.f7962g = null;
        mc.b.f7964i = null;
        mc.b.f7963h = null;
        BaseState baseState = y.f4804h;
        gc.c("DeviceViewModel", "onCleared when " + baseState);
        if (baseState.compareTo((BaseState) new PhysicalConnecting()) <= 0 || Intrinsics.areEqual(baseState, new PhysicalDisconnecting())) {
            if (!this.f2839d) {
                l2.d();
            }
            y.f = 0;
            y0.b("DeviceViewModel onCleared");
        }
    }
}

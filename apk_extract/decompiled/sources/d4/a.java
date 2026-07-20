package d4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import bb.r;
import bb.t;
import com.google.android.material.snackbar.Snackbar;
import com.transsion.iotservice.multiscreen.pc.adapter.BaseBindingViewHolder;
import com.transsion.iotservice.multiscreen.pc.adapter.BaseDataBindingAdapter;
import com.transsion.iotservice.multiscreen.pc.adapter.SearchPcItemAdapter;
import com.transsion.iotservice.multiscreen.pc.bean.PcBleScanedDeviceBean;
import com.transsion.iotservice.multiscreen.pc.bean.Permission;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityFunctionGuideBinding;
import com.transsion.iotservice.multiscreen.pc.ui.BlankActivity;
import com.transsion.iotservice.multiscreen.pc.ui.guide.FunctionGuideActivity;
import com.transsion.iotservice.multiscreen.pc.ui.guide.FunctionGuideViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import com.transsion.iotservice.scan.bean.ScannedDevice;
import eb.k1;
import eb.o1;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import jb.h;
import k3.gc;
import k3.pb;
import k3.sb;
import k3.vb;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import li.v0;
import ob.b;
import tj.w;
import zb.c;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4292c;

    public /* synthetic */ a(int i8, Object obj, Object obj2) {
        this.f4290a = i8;
        this.f4291b = obj;
        this.f4292c = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseDataBindingAdapter baseDataBindingAdapter;
        a8.a aVar;
        int i8;
        SharedPreferences sharedPreferences = null;
        Object obj = this.f4292c;
        Object obj2 = this.f4291b;
        switch (this.f4290a) {
            case 0:
                ((Snackbar) obj2).lambda$setAction$0((View.OnClickListener) obj, view);
                break;
            case 1:
                BaseBindingViewHolder baseBindingViewHolder = (BaseBindingViewHolder) obj2;
                if (baseBindingViewHolder.getAdapterPosition() >= 0 && (aVar = (baseDataBindingAdapter = (BaseDataBindingAdapter) obj).f2389a) != null) {
                    M item = baseDataBindingAdapter.getItem(baseBindingViewHolder.getAdapterPosition());
                    baseBindingViewHolder.getAdapterPosition();
                    View view2 = baseBindingViewHolder.itemView;
                    Intrinsics.checkNotNullExpressionValue(view2, "itemView");
                    PcBleScanedDeviceBean pcDevice = (PcBleScanedDeviceBean) item;
                    Intrinsics.checkNotNullParameter(pcDevice, "item");
                    Intrinsics.checkNotNullParameter(view2, "itemView");
                    gc.c("SearchPcItemAdapter", "user click connect mac: " + pcDevice.getMDeviceMac());
                    DeviceViewModel deviceViewModel = ((SearchPcItemAdapter) aVar.f44b).f2392b;
                    Intrinsics.checkNotNullParameter(view2, "view");
                    int[] iArr = new int[2];
                    view2.getLocationOnScreen(iArr);
                    int width = (view2.getWidth() / 2) + iArr[0];
                    deviceViewModel.getClass();
                    Intrinsics.checkNotNullParameter(pcDevice, "pcDevice");
                    b bVar = b.f8417b;
                    String deviceMac = pcDevice.getMDeviceMac();
                    bVar.getClass();
                    Intrinsics.checkNotNullParameter(deviceMac, "deviceMac");
                    long j8 = b.f8420g;
                    Long l4 = (Long) b.f8424k.get(deviceMac);
                    long jLongValue = l4 != null ? l4.longValue() - j8 : -1L;
                    w wVar = bVar.f8437a;
                    if (jLongValue >= 0) {
                        wVar.T(jLongValue);
                    }
                    b.f8421h = SystemClock.elapsedRealtime();
                    Intrinsics.checkNotNullParameter("phone_pick_pc_connect", "conType");
                    b.f8423j = "phone_pick_pc_connect";
                    wVar.V();
                    gc.c("DeviceViewModel", "connectDevice");
                    pcDevice.setMConnectState(1);
                    r rVar = deviceViewModel.e;
                    if (rVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBleScanDataFilterHelper");
                        rVar = null;
                    }
                    ScannedDevice connectingDevice = (ScannedDevice) rVar.f1243c.get(pcDevice.getMDeviceMac());
                    gc.c("DeviceViewModel", "connect:" + connectingDevice);
                    MutableLiveData mutableLiveData = deviceViewModel.f;
                    if (connectingDevice == null) {
                        gc.b("DeviceViewModel", "connect:device is null, " + pcDevice);
                        mutableLiveData.setValue(4);
                    } else {
                        r rVar2 = deviceViewModel.e;
                        if (rVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBleScanDataFilterHelper");
                            rVar2 = null;
                        }
                        rVar2.getClass();
                        Intrinsics.checkNotNullParameter(connectingDevice, "connectingDevice");
                        rVar2.f1248j = connectingDevice;
                        rVar2.e.put(connectingDevice.getDeviceMac(), connectingDevice);
                        k1 k1Var = k1.f4765a;
                        k1.j("ble");
                        deviceViewModel.f2847n = l0.p(ViewModelKt.getViewModelScope(deviceViewModel), v0.f7499b, null, new c(deviceViewModel, connectingDevice, null), 2);
                    }
                    DeviceViewModel.g();
                    o1 o1Var = o1.f4782a;
                    o1.b();
                    int i9 = pb.a().getResources().getDisplayMetrics().widthPixels;
                    double d7 = i9 / 2;
                    double d10 = ((double) i9) * 0.14d;
                    double d11 = d7 - d10;
                    double d12 = d7 + d10;
                    double d13 = width;
                    if (d13 < d11) {
                        Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
                        Intrinsics.checkNotNullParameter("left pc item", "log");
                        if (gc.f6462a <= 3) {
                            Log.d(gc.f6463b.concat("DeviceViewModel"), "left pc item");
                        }
                        i8 = 0;
                    } else if (d13 < d12) {
                        Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
                        Intrinsics.checkNotNullParameter("center pc item", "log");
                        if (gc.f6462a <= 3) {
                            Log.d(gc.f6463b.concat("DeviceViewModel"), "center pc item");
                        }
                        i8 = 2;
                    } else {
                        Intrinsics.checkNotNullParameter("DeviceViewModel", "tag");
                        Intrinsics.checkNotNullParameter("right pc item", "log");
                        if (gc.f6462a <= 3) {
                            Log.d(gc.f6463b.concat("DeviceViewModel"), "right pc item");
                        }
                        i8 = 1;
                    }
                    deviceViewModel.f2837b = i8;
                    deviceViewModel.f2845l.setValue(CollectionsKt.emptyList());
                    String mDeviceMac = pcDevice.getMDeviceMac();
                    Locale locale = Locale.ROOT;
                    String mac = mDeviceMac.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(mac, "toUpperCase(...)");
                    Intrinsics.checkNotNullParameter(mac, "mac");
                    String deviceKey = mac + "from PC";
                    Intrinsics.checkNotNullParameter(deviceKey, "deviceKey");
                    String key = deviceKey.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(key, "toUpperCase(...)");
                    Intrinsics.checkNotNullParameter(key, "key");
                    SharedPreferences sharedPreferences2 = vb.f6684a;
                    if (sharedPreferences2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    } else {
                        sharedPreferences = sharedPreferences2;
                    }
                    if (!sharedPreferences.getBoolean(key, false)) {
                        mutableLiveData.setValue(1);
                    } else {
                        mutableLiveData.setValue(2);
                    }
                    break;
                }
                break;
            default:
                int i10 = FunctionGuideActivity.f2774o;
                ub.b bVar2 = ((ActivityFunctionGuideBinding) obj2).f2434i;
                if (bVar2 != null) {
                    FunctionGuideViewModel functionGuideViewModel = ((FunctionGuideActivity) obj).f2776l;
                    if (functionGuideViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                        functionGuideViewModel = null;
                    }
                    FunctionGuideActivity context = bVar2.f10419a;
                    FunctionGuideViewModel functionGuideViewModel2 = context.f2776l;
                    if (functionGuideViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                        functionGuideViewModel2 = null;
                    }
                    functionGuideViewModel2.getClass();
                    if (sb.b() || !Intrinsics.areEqual(functionGuideViewModel2.f.getValue(), Boolean.TRUE)) {
                        FunctionGuideViewModel functionGuideViewModel3 = context.f2776l;
                        if (functionGuideViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                            functionGuideViewModel3 = null;
                        }
                        functionGuideViewModel3.getClass();
                        Object[] objArr = sb.b() && Intrinsics.areEqual(functionGuideViewModel3.f.getValue(), Boolean.TRUE);
                        if (objArr != false) {
                            b.f8417b.f8437a.getClass();
                            w.X(sb.b() ? "iot_multi_con_pc_newtipspage_startnow_cl" : "iot_multi_con_pad_newtipspage_startnow_cl", w.D());
                        }
                        if (objArr == false) {
                            FunctionGuideViewModel functionGuideViewModel4 = context.f2776l;
                            if (functionGuideViewModel4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                                functionGuideViewModel4 = null;
                            }
                            MutableLiveData mutableLiveData2 = functionGuideViewModel4.f2783d;
                            Integer num = (Integer) mutableLiveData2.getValue();
                            mutableLiveData2.setValue(num != null ? Integer.valueOf(num.intValue() + 1) : null);
                            MutableLiveData mutableLiveData3 = functionGuideViewModel4.f;
                            T value = mutableLiveData2.getValue();
                            List list = (List) functionGuideViewModel4.f2781b.getValue();
                            mutableLiveData3.setValue(Boolean.valueOf(Intrinsics.areEqual(value, list != null ? Integer.valueOf(list.size() - 1) : null)));
                            functionGuideViewModel4.b();
                            String log = "isLast=" + mutableLiveData3.getValue() + ", currentGuideIndex=" + mutableLiveData2.getValue();
                            Intrinsics.checkNotNullParameter("FunctionGuideViewModel", "tag");
                            Intrinsics.checkNotNullParameter(log, "log");
                            if (gc.f6462a <= 3) {
                                Log.d(gc.f6463b.concat("FunctionGuideViewModel"), log);
                            }
                            b.f8417b.i("next_page");
                        }
                    }
                    b bVar3 = b.f8417b;
                    bVar3.getClass();
                    String triggerScene = b.f8419d;
                    Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
                    bVar3.f8437a.I(triggerScene);
                    ArrayList notGrantPermissions = k3.o1.a(context, CollectionsKt.listOf((Object[]) new Permission[]{h.f6141d, h.f6138a, h.f6139b}));
                    t whenGranted = new t(10);
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(notGrantPermissions, "notGrantPermissions");
                    Intrinsics.checkNotNullParameter(whenGranted, "whenGranted");
                    BlankActivity.f2697c = notGrantPermissions;
                    BlankActivity.f2696b = whenGranted;
                    BlankActivity.f2698d = 0;
                    Intent intent = new Intent(pb.a(), (Class<?>) BlankActivity.class);
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    context.finish();
                }
                break;
        }
    }
}

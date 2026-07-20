package tj;

import af.n2;
import af.o2;
import af.q1;
import af.r1;
import af.s2;
import af.s5;
import af.w5;
import af.z4;
import android.bluetooth.BluetoothAdapter;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import cf.h0;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvj;
import com.transsion.athena.data.TrackData;
import com.transsion.flamboyant.FoldableDeviceManager;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import com.transsion.message.cast.analytics.p000const.EAnalyticsParams;
import com.transsion.pcconnect.invoke.bridge.Device;
import com.transsion.widgetslib.view.damping.DampingLayout;
import com.transsion.widgetslib.widget.tablayout.TabLayout;
import dj.m0;
import eb.g0;
import eb.k1;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import k3.dd;
import k3.gc;
import k3.pb;
import k3.sb;
import k3.ub;
import k3.v8;
import k3.vb;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ze.n0;
import ze.o0;
import ze.q2;
import ze.r2;

/* JADX INFO: loaded from: classes3.dex */
public class w implements s2, o2, c8.b, f2.b, ck.b, ie.h, b8.f, tk.a, u5.a, r2.h, zj.e, zj.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile w f10259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ByteBuffer f10260d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f10262b;

    public w(int i8) {
        this.f10261a = i8;
        switch (i8) {
            case 1:
                this.f10262b = new AtomicLong();
                break;
            case 9:
                g5.b bVar = new g5.b();
                bVar.f5113b = 100;
                bVar.f5112a = new g5.a(bVar, 134, 0.75f, true);
                this.f10262b = bVar;
                break;
            case 13:
                this.f10262b = new bc.f(this, new Handler(Looper.getMainLooper()), 1);
                break;
            case 14:
                this.f10262b = new o5.c(13);
                break;
        }
    }

    public static Bundle A() {
        k1 k1Var = k1.f4765a;
        hc.c cVar = k1.e;
        String str = cVar != null ? cVar.f5288c : null;
        hc.c cVar2 = k1.e;
        String str2 = cVar2 != null ? cVar2.f5286a : null;
        ob.b.f8417b.getClass();
        String strE = ob.b.e(str, str2);
        String log = h0.a.k("getDeviceDidPidBundle mac:", str, " pid:", str2);
        Intrinsics.checkNotNullParameter("Athena", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("Athena"), log);
        }
        Bundle bundle = new Bundle();
        bundle.putString("did", strE);
        bundle.putString("pid", str2);
        return bundle;
    }

    public static String B() {
        return sb.b() ? "phone" : EAnalyticsParams.DEVICE_TYPE_PAD;
    }

    public static Bundle D() {
        Bundle bundle = new Bundle();
        bundle.putString("my_device_type", B());
        return bundle;
    }

    public static String F() {
        String str;
        String str2;
        Device device = g0.f;
        String str3 = "";
        if (device == null || (str = device.f2949c) == null) {
            str = "";
        }
        String log = "getMultiConnectDeviceType:".concat(str);
        Intrinsics.checkNotNullParameter("MultiConnectManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("MultiConnectManager"), log);
        }
        Device device2 = g0.f;
        if (device2 != null && (str2 = device2.f2949c) != null) {
            str3 = str2;
        }
        switch (str3.hashCode()) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                return !str3.equals("1") ? "pc" : "phone";
            case 50:
                return !str3.equals(ExifInterface.GPS_MEASUREMENT_2D) ? "pc" : EAnalyticsParams.DEVICE_TYPE_PAD;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                str3.equals(ExifInterface.GPS_MEASUREMENT_3D);
                return "pc";
            default:
                return "pc";
        }
    }

    public static void M(String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", x());
        bundle.putString("trigger_scene", triggerScene);
        X("pad_pc_con_copy_download_link", bundle);
    }

    public static void N(String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", x());
        bundle.putString("trigger_scene", triggerScene);
        X("pad_pc_con_finddevicepage_ex", bundle);
    }

    public static void X(String str, Bundle bundle) {
        a7.a aVar = new a7.a();
        long j8 = t6.d.f10184a;
        aVar.f41b = j8;
        if (j8 == 0) {
            z6.a.c("FAILED! You should init Athena first before track the event ".concat(str));
        }
        aVar.f40a = str;
        aVar.f42c = new TrackData();
        ((TrackData) aVar.f42c).d(0, "eparam", bundle);
        aVar.a();
    }

    public static String x() {
        Intrinsics.checkNotNullParameter("connected_count", "key");
        SharedPreferences sharedPreferences = vb.f6684a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        return sharedPreferences.getInt("connected_count", 0) == 0 ? "first_connect" : "not_first_connect";
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0037 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x003a A[ORIG_RETURN, RETURN] */
    public static String y() {
        SharedPreferences sharedPreferences = null;
        if (DeviceConnectState.INSTANCE.isConnected()) {
            Intrinsics.checkNotNullParameter("connected_count", "key");
            SharedPreferences sharedPreferences2 = vb.f6684a;
            if (sharedPreferences2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            } else {
                sharedPreferences = sharedPreferences2;
            }
            if (sharedPreferences.getInt("connected_count", 0) < 2) {
                return "first_connect";
            }
            return "not_first_connect";
        }
        Intrinsics.checkNotNullParameter("connected_count", "key");
        SharedPreferences sharedPreferences3 = vb.f6684a;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        } else {
            sharedPreferences = sharedPreferences3;
        }
        if (sharedPreferences.getInt("connected_count", 0) < 1) {
            return "first_connect";
        }
        return "not_first_connect";
    }

    public static String z() {
        dc.h hVar = dc.h.f4409a;
        hVar.a(pb.a());
        FoldableDeviceManager foldableDeviceManager = dc.h.f4410b;
        if (!(foldableDeviceManager != null ? foldableDeviceManager.isFoldableDevice() : false)) {
            return "unfold";
        }
        hVar.a(pb.a());
        FoldableDeviceManager foldableDeviceManager2 = dc.h.f4410b;
        return (foldableDeviceManager2 != null ? foldableDeviceManager2.getCurrentFoldState() : 0) == 2 ? "unfold" : "fold";
    }

    public String C(Object obj) {
        String string = obj.toString();
        if (string != null && string.length() != 0) {
            int length = string.length();
            int iCharCount = 0;
            while (iCharCount < length) {
                int iCodePointAt = string.codePointAt(iCharCount);
                if (Character.isLetterOrDigit(iCodePointAt)) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
            }
            return ((String) this.f10262b) + obj;
        }
        throw new IllegalArgumentException(h0.a.i("Invalid key: ", string));
    }

    public Pattern E(String str) {
        Object obj;
        g5.b bVar = (g5.b) this.f10262b;
        synchronized (bVar) {
            obj = bVar.f5112a.get(str);
        }
        Pattern patternCompile = (Pattern) obj;
        if (patternCompile == null) {
            patternCompile = Pattern.compile(str);
            g5.b bVar2 = (g5.b) this.f10262b;
            synchronized (bVar2) {
                bVar2.f5112a.put(str, patternCompile);
            }
        }
        return patternCompile;
    }

    public void G(String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Bundle bundle = new Bundle();
        bundle.putString("trigger_scene", triggerScene);
        X("iot_pc_con_newtipspage_ex", bundle);
    }

    public void H(String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Bundle bundle = new Bundle();
        bundle.putString("trigger_scene", triggerScene);
        X("iot_pc_con_newtipspage_exit", bundle);
    }

    public void I(String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Bundle bundle = new Bundle();
        bundle.putString("trigger_scene", triggerScene);
        X("iot_pc_con_newtipspage_startnow_cl", bundle);
    }

    public void J(String handleResult) {
        Intrinsics.checkNotNullParameter(handleResult, "handleResult");
        Bundle bundle = new Bundle();
        bundle.putString("handleResult", handleResult);
        bundle.putString("device_type", B());
        X("pad_connection_connect_conflict_handle", bundle);
    }

    public void K() {
        Bundle bundle = new Bundle();
        bundle.putString("device_type", B());
        X("pad_connection_connect_conflict_show", bundle);
    }

    public void L(int i8, String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Bundle bundle = new Bundle();
        bundle.putInt("scan_pc_quantity", i8);
        bundle.putString("is_first_connect", x());
        bundle.putString("trigger_scene", triggerScene);
        X("iot_pc_con_open_pc_scan_find", bundle);
    }

    public void O(String conFailureType, String did, String pid, String triggerScene, String startByPcOrPhone) {
        Intrinsics.checkNotNullParameter(conFailureType, "conFailureType");
        Intrinsics.checkNotNullParameter(did, "did");
        Intrinsics.checkNotNullParameter(pid, "pid");
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Intrinsics.checkNotNullParameter(startByPcOrPhone, "startByPcOrPhone");
        Bundle bundle = new Bundle();
        bundle.putString("connect_failure_type", conFailureType);
        bundle.putString("pc_pid", pid);
        X("iot_pc_con_failure", bundle);
    }

    public void P(String startByPcOrPhone, String pid, String conType, String triggerScene, String did) {
        Intrinsics.checkNotNullParameter(startByPcOrPhone, "startByPcOrPhone");
        Intrinsics.checkNotNullParameter(pid, "pid");
        Intrinsics.checkNotNullParameter(conType, "conType");
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Intrinsics.checkNotNullParameter(did, "did");
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", x());
        bundle.putString("pc_pid", pid);
        bundle.putString("connect_type", conType);
        bundle.putString("fold_states", z());
        X("iot_pc_con_success", bundle);
    }

    public void Q(long j8) {
        Intrinsics.checkNotNullParameter("shortcut_center", "entry");
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", y());
        bundle.putString("entry", "shortcut_center");
        bundle.putLong("enable_time", j8);
        X("iot_pc_con_turn_off", bundle);
    }

    public void R(String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Bundle bundle = new Bundle();
        bundle.putString("trigger_scene", triggerScene);
        X("iot_pc_con_permissionpage_ex", bundle);
    }

    public void S(String pid, long j8) {
        Intrinsics.checkNotNullParameter(pid, "pid");
        Bundle bundle = new Bundle();
        bundle.putLong(TypedValues.TransitionType.S_DURATION, j8);
        bundle.putString("pc_pid", pid);
        X("iot_pc_con_phone_connect_pc_duration", bundle);
    }

    public void T(long j8) {
        Bundle bundle = new Bundle();
        bundle.putLong(TypedValues.TransitionType.S_DURATION, j8);
        X("iot_pc_con_scan_pc_duration", bundle);
    }

    public void U(String conStatus, String entry) {
        Intrinsics.checkNotNullParameter(conStatus, "conStatus");
        Intrinsics.checkNotNullParameter("pc_connection", "workMode");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Bundle bundle = new Bundle();
        bundle.putString("scanqr_connect_status", conStatus);
        bundle.putString("is_first_connect", x());
        bundle.putString("work_mode", "pc_connection");
        bundle.putString("entry", entry);
        X("iot_pc_con_scanqr_result", bundle);
    }

    public void V() {
    }

    public void W(String entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Bundle bundle = new Bundle();
        bundle.putString("entry", entry);
        bundle.putString("is_first_connect", x());
        X("iot_settings_pc_con_enter", bundle);
    }

    public void Y() {
        String str;
        Bundle bundle = new Bundle();
        boolean zA = ub.a(pb.a());
        boolean zIsEnabled = BluetoothAdapter.getDefaultAdapter().isEnabled();
        if (zA && zIsEnabled) {
            str = "wlan_on_and_bluetooth_on";
        } else if (!zA || zIsEnabled) {
            str = (zA || !zIsEnabled) ? "wlan_off_and_bluetooth_off" : "wlan_off_and_bluetooth_on";
        } else {
            str = "wlan_on_and_bluetooth_off";
        }
        bundle.putString("wlan_blutooth_status", str);
        bundle.putString("fold_states", z());
        bundle.putString("is_first_connect", x());
        X("iot_systemui_pc_con_on", bundle);
    }

    public qf.c Z(h0 h0Var) {
        synchronized (((w5) this.f10262b).f672m) {
            ((w5) this.f10262b).f673n.add(h0Var);
        }
        w5 w5Var = (w5) this.f10262b;
        qf.c cVar = new qf.c(w5Var, h0Var);
        long j8 = w5Var.f668i;
        if (j8 != Long.MAX_VALUE) {
            cVar.f9048c = h0Var.f1540h.schedule(new af.f(cVar, 11), j8, TimeUnit.MILLISECONDS);
        } else {
            cVar.f9048c = new FutureTask(new s5(), null);
        }
        o0.a((n0) w5Var.q.e.get(Long.valueOf(w5Var.f663b.f11421c)), h0Var);
        return cVar;
    }

    @Override // c8.b, tk.a
    public boolean a() {
        switch (this.f10261a) {
            case 4:
                return !((c8.c) this.f10262b).f1454a.canScrollVertically(1);
            default:
                return !((TabLayout) this.f10262b).canScrollHorizontally(1);
        }
    }

    @Override // r2.h
    public void accept(Object obj, Object obj2) {
        y2.e eVar = new y2.e((q3.g) obj2, 0);
        y2.d dVar = (y2.d) ((y2.g) obj).o();
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(dVar.f5236d);
        h3.c.d(parcelObtain, eVar);
        h3.c.c(parcelObtain, (ApiFeatureRequest) this.f10262b);
        dVar.e(parcelObtain, 1);
    }

    @Override // c8.b, tk.a
    public boolean b() {
        switch (this.f10261a) {
            case 4:
                return !((c8.c) this.f10262b).f1454a.canScrollVertically(-1);
            default:
                return !((TabLayout) this.f10262b).canScrollHorizontally(-1);
        }
    }

    @Override // zj.e
    public Type c() {
        return (Type) this.f10262b;
    }

    @Override // ek.g
    public Object call(Object obj) {
        ck.i iVar = (ck.i) obj;
        gk.a aVar = new gk.a(iVar);
        fk.f fVar = new fk.f(this, aVar, iVar);
        iVar.f1736a.a(fVar);
        iVar.b(aVar);
        return fVar;
    }

    @Override // zj.j
    public Object convert(Object obj) {
        return Optional.ofNullable(((zj.j) this.f10262b).convert((m0) obj));
    }

    @Override // b8.f
    public void d(float f) {
        ((DampingLayout) this.f10262b).handleOverScrollDistance(f);
    }

    @Override // af.s2
    public void e() {
        ((AtomicLong) this.f10262b).getAndAdd(1L);
    }

    @Override // af.o2
    public void f() {
        long jNextLong;
        boolean z2 = true;
        n2 n2Var = new n2(this);
        m4.k kVar = m4.k.INSTANCE;
        cf.q qVar = (cf.q) this.f10262b;
        synchronized (qVar.f1619k) {
            try {
                v8.m(qVar.f1617i != null);
                if (qVar.f1630y) {
                    r2 r2VarM = qVar.m();
                    Logger logger = r1.f544g;
                    try {
                        kVar.execute(new q1(n2Var, r2VarM));
                    } catch (Throwable th2) {
                        r1.f544g.log(Level.SEVERE, "Failed to execute PingCallback", th2);
                    }
                    return;
                }
                r1 r1Var = qVar.f1629x;
                if (r1Var != null) {
                    jNextLong = 0;
                    z2 = false;
                } else {
                    jNextLong = qVar.f1614d.nextLong();
                    qVar.e.getClass();
                    z4 z4Var = new z4(1);
                    z4Var.b();
                    r1 r1Var2 = new r1(jNextLong, z4Var);
                    qVar.f1629x = r1Var2;
                    qVar.L.getClass();
                    r1Var = r1Var2;
                }
                if (z2) {
                    qVar.f1617i.j(false, (int) (jNextLong >>> 32), (int) jNextLong);
                }
                synchronized (r1Var) {
                    try {
                        if (!r1Var.f548d) {
                            r1Var.f547c.put(n2Var, kVar);
                            return;
                        }
                        r2 r2Var = r1Var.e;
                        q1 q1Var = r2Var != null ? new q1(n2Var, r2Var) : new q1(n2Var, r1Var.f);
                        try {
                            kVar.execute(q1Var);
                        } catch (Throwable th3) {
                            r1.f544g.log(Level.SEVERE, "Failed to execute PingCallback", th3);
                        }
                    } catch (Throwable th4) {
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    @Override // u5.a
    public Rect g() {
        Point[] pointArr = ((zzvj) this.f10262b).e;
        if (pointArr == null) {
            return null;
        }
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        for (Point point : pointArr) {
            iMin = Math.min(iMin, point.x);
            iMax = Math.max(iMax, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax2 = Math.max(iMax2, point.y);
        }
        return new Rect(iMin, iMin2, iMax, iMax2);
    }

    @Override // yh.a
    public Object get() {
        return this.f10262b;
    }

    @Override // u5.a
    public int getFormat() {
        return ((zzvj) this.f10262b).f2114a;
    }

    @Override // tk.a
    public View getView() {
        return (TabLayout) this.f10262b;
    }

    @Override // u5.a
    public String h() {
        return ((zzvj) this.f10262b).f2116c;
    }

    @Override // u5.a
    public int i() {
        return ((zzvj) this.f10262b).f2118h;
    }

    @Override // af.o2
    public void j() {
        ((cf.q) this.f10262b).a(q2.f11411n.h("Keepalive failed. The connection is likely gone"));
    }

    @Override // zj.e
    public Object k(zj.w wVar) {
        zj.g gVar = new zj.g(wVar);
        wVar.g(new se.e(gVar, 23));
        return gVar;
    }

    @Override // u5.a
    public Point[] l() {
        return ((zzvj) this.f10262b).e;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x011d A[Catch: IOException -> 0x0119, TRY_LEAVE, TryCatch #0 {IOException -> 0x0119, blocks: (B:64:0x0115, B:68:0x011d), top: B:92:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x012a A[Catch: IOException -> 0x00eb, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x00eb, blocks: (B:44:0x00e7, B:72:0x012a), top: B:101:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0145 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x0147 A[Catch: IOException -> 0x0143, TRY_LEAVE, TryCatch #10 {IOException -> 0x0143, blocks: (B:79:0x013f, B:83:0x0147), top: B:107:0x013f }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0154 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public String m() throws Throwable {
        FileChannel fileChannel;
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        FileLock fileLock2;
        byte[] bArr;
        File file = (File) this.f10262b;
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = ((s6.e) ((i1.b) m6.a.f().f7948a.f8123c).f5527a).f9568l;
        if (dd.g(arrayList)) {
            z6.a.a("readBuffer passwords is empty");
            return "";
        }
        RandomAccessFile randomAccessFile2 = null;
        fileLockLock = null;
        FileLock fileLockLock = null;
        fileChannel = null;
        FileChannel fileChannel2 = null;
        FileChannel fileChannel3 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    channel = randomAccessFile.getChannel();
                    try {
                        try {
                            fileLockLock = channel.lock();
                            randomAccessFile.seek(0L);
                            randomAccessFile.read(f10260d.array(), 0, 32808);
                            byte[] bArr2 = (byte[]) arrayList.get(f10260d.getInt(4));
                            if (bArr2 != null) {
                                y6.g gVar = new y6.g(bArr2);
                                boolean z2 = true;
                                for (int i8 = 0; i8 < f10260d.getInt(0); i8++) {
                                    if (i8 == 0) {
                                        int i9 = f10260d.getInt((i8 + 10) * 4);
                                        bArr = new byte[i9];
                                        randomAccessFile.read(bArr, 0, i9);
                                    } else {
                                        int i10 = f10260d.getInt((i8 + 10) * 4) - f10260d.getInt((i8 + 9) * 4);
                                        bArr = new byte[i10];
                                        randomAccessFile.read(bArr, 0, i10);
                                    }
                                    String str = new String(gVar.d(bArr));
                                    try {
                                        try {
                                            JSONObject jSONObject = new JSONObject(str);
                                            if (jSONObject.has("tid") && jSONObject.has(NotificationCompat.CATEGORY_EVENT)) {
                                                if (!z2) {
                                                    sb2.append("\n");
                                                }
                                                sb2.append(str);
                                                z2 = false;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (fileLockLock != null) {
                                                try {
                                                    fileLockLock.release();
                                                    if (channel != null) {
                                                        channel.close();
                                                    }
                                                } catch (IOException e) {
                                                    z6.a.c(Log.getStackTraceString(e));
                                                    if (randomAccessFile == null) {
                                                        throw th;
                                                    }
                                                    try {
                                                        randomAccessFile.close();
                                                        throw th;
                                                    } catch (IOException e4) {
                                                        z6.a.c(Log.getStackTraceString(e4));
                                                        throw th;
                                                    }
                                                }
                                            } else if (channel != null) {
                                                channel.close();
                                            }
                                            if (randomAccessFile == null) {
                                                throw th;
                                            }
                                            randomAccessFile.close();
                                            throw th;
                                        }
                                    } catch (Exception e10) {
                                        z6.a.c(Log.getStackTraceString(e10));
                                    }
                                }
                            }
                            if (fileLockLock != null) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e11) {
                                    z6.a.c(Log.getStackTraceString(e11));
                                }
                            }
                            channel.close();
                            randomAccessFile.close();
                        } catch (Exception e12) {
                            e = e12;
                            fileLock = fileLockLock;
                            fileChannel3 = channel;
                            try {
                                z6.a.c(Log.getStackTraceString(e));
                                if (file.delete()) {
                                    z6.a.e("file deleted");
                                }
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                        if (fileChannel3 != null) {
                                            fileChannel3.close();
                                        }
                                    } catch (IOException e13) {
                                        z6.a.c(Log.getStackTraceString(e13));
                                        if (randomAccessFile != null) {
                                            randomAccessFile.close();
                                        }
                                        return sb2.toString();
                                    }
                                } else if (fileChannel3 != null) {
                                    fileChannel3.close();
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                return sb2.toString();
                            } catch (Throwable th3) {
                                th = th3;
                                fileChannel = fileChannel3;
                                randomAccessFile2 = randomAccessFile;
                                randomAccessFile = randomAccessFile2;
                                fileLockLock = fileLock;
                                channel = fileChannel;
                                if (fileLockLock != null) {
                                    fileLockLock.release();
                                    if (channel != null) {
                                        channel.close();
                                    }
                                } else if (channel != null) {
                                    channel.close();
                                }
                                if (randomAccessFile == null) {
                                    throw th;
                                }
                                randomAccessFile.close();
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileLock2 = fileLockLock;
                        fileChannel2 = channel;
                        channel = fileChannel2;
                        fileLockLock = fileLock2;
                        if (fileLockLock != null) {
                            fileLockLock.release();
                            if (channel != null) {
                                channel.close();
                            }
                        } else if (channel != null) {
                            channel.close();
                        }
                        if (randomAccessFile == null) {
                            throw th;
                        }
                        randomAccessFile.close();
                        throw th;
                    }
                } catch (Exception e14) {
                    e = e14;
                    fileLock = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileLock2 = null;
                }
            } catch (IOException e15) {
                z6.a.c(Log.getStackTraceString(e15));
            }
        } catch (Exception e16) {
            e = e16;
            randomAccessFile = null;
            fileLock = null;
        } catch (Throwable th6) {
            th = th6;
            fileChannel = null;
            fileLock = null;
            randomAccessFile = randomAccessFile2;
            fileLockLock = fileLock;
            channel = fileChannel;
            if (fileLockLock != null) {
                fileLockLock.release();
                if (channel != null) {
                    channel.close();
                }
            } else if (channel != null) {
                channel.close();
            }
            if (randomAccessFile == null) {
                throw th;
            }
            randomAccessFile.close();
            throw th;
        }
        return sb2.toString();
    }

    public void n() {
    }

    public void o() {
        ((q3.k) ((o5.c) this.f10262b).f8405a).i(null);
    }

    public void p(String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", x());
        bundle.putString("trigger_scene", triggerScene);
        X("iot_pc_con_cancel_scan_pc_window", bundle);
    }

    public void q(String requestConnectStatus, String triggerScene) {
        Intrinsics.checkNotNullParameter(requestConnectStatus, "requestConnectStatus");
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", x());
        bundle.putString("request_connect_status", requestConnectStatus);
        bundle.putString("trigger_scene", triggerScene);
        X("iot_pc_con_confirm_connect_dialog_by_pc", bundle);
    }

    public void r(String requestConStatus, String isRememberDevice) {
        Intrinsics.checkNotNullParameter(requestConStatus, "requestConStatus");
        Intrinsics.checkNotNullParameter(isRememberDevice, "isRememberDevice");
        Bundle bundle = new Bundle();
        bundle.putString("request_connect_status", requestConStatus);
        bundle.putString("is_remember_device", isRememberDevice);
        bundle.putString("is_first_connect", x());
        X("iot_pc_con_confirm_connect_dialog_by_phone", bundle);
    }

    public void s(String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", x());
        bundle.putString("trigger_scene", triggerScene);
        X("iot_pc_con_copy_download_link", bundle);
    }

    public void t(String did, String reason) {
        Intrinsics.checkNotNullParameter(did, "did");
        Intrinsics.checkNotNullParameter("pc_connection", "workMode");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Bundle bundle = new Bundle();
        bundle.putString("connected_pc_id", did);
        bundle.putString("work_mode", "pc_connection");
        bundle.putString("disconnect_reason", reason);
        X("iot_pc_con_disconnect_by_system", bundle);
    }

    public void u(String entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", x());
        bundle.putString("work_mode", "pc_connection");
        bundle.putString("entry", entry);
        X("iot_pc_con_enter_scan_page", bundle);
    }

    public void v(int i8) {
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", x());
        bundle.putInt("scan_pc_quantity", i8);
        X("iot_pc_finddevicepage_devicenum_change", bundle);
    }

    public void w(String triggerScene) {
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Bundle bundle = new Bundle();
        bundle.putString("is_first_connect", x());
        bundle.putString("trigger_scene", triggerScene);
        X("iot_pc_con_finddevicepage_ex", bundle);
    }

    public /* synthetic */ w(Object obj, int i8) {
        this.f10261a = i8;
        this.f10262b = obj;
    }

    public /* synthetic */ w(y2.f fVar, ApiFeatureRequest apiFeatureRequest) {
        this.f10261a = 20;
        this.f10262b = apiFeatureRequest;
    }

    /* JADX WARN: Code duplicated, block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x00c3 A[Catch: IOException -> 0x00bf, TRY_LEAVE, TryCatch #9 {IOException -> 0x00bf, blocks: (B:43:0x00bb, B:47:0x00c3), top: B:98:0x00bb }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00ec A[Catch: IOException -> 0x00e8, TRY_LEAVE, TryCatch #2 {IOException -> 0x00e8, blocks: (B:59:0x00e4, B:63:0x00ec), top: B:87:0x00e4 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00f9 A[Catch: IOException -> 0x00d4, TRY_ENTER, TRY_LEAVE, TryCatch #6 {IOException -> 0x00d4, blocks: (B:51:0x00d0, B:67:0x00f9), top: B:94:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0111 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x0113 A[Catch: IOException -> 0x010f, TRY_LEAVE, TryCatch #8 {IOException -> 0x010f, blocks: (B:73:0x010b, B:77:0x0113), top: B:96:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r7v6 */
    public w(String str, int i8) throws Throwable {
        ?? r7;
        ?? r10;
        Exception e;
        ?? r11;
        RandomAccessFile randomAccessFile;
        Object obj;
        FileChannel channel;
        RandomAccessFile randomAccessFile2;
        FileLock fileLock;
        this.f10261a = i8;
        switch (i8) {
            case 15:
                File file = new File(str);
                this.f10262b = file;
                if (!file.exists()) {
                    try {
                        if (file.createNewFile()) {
                            z6.a.e("EncryptFile created");
                        }
                    } catch (Exception e4) {
                        z6.a.c(Log.getStackTraceString(e4));
                    }
                }
                if (f10260d == null) {
                    f10260d = ByteBuffer.allocate(32808);
                }
                FileLock fileLockLock = null;
                try {
                    try {
                        try {
                            if (((File) this.f10262b).length() < 8192) {
                                RandomAccessFile randomAccessFile3 = new RandomAccessFile((File) this.f10262b, "rw");
                                try {
                                    channel = randomAccessFile3.getChannel();
                                    try {
                                        fileLockLock = channel.lock();
                                        f10260d.putInt(0, 0);
                                        f10260d.putInt(4, ((Integer) m6.a.f().f7948a.i().first).intValue());
                                        for (int i9 = 0; i9 < 8192; i9 += 4) {
                                            f10260d.putInt((i9 + 10) * 4, i9);
                                        }
                                        randomAccessFile3.seek(0L);
                                        randomAccessFile3.write(f10260d.array());
                                        randomAccessFile2 = randomAccessFile3;
                                    } catch (Exception e10) {
                                        e = e10;
                                        FileLock fileLock2 = fileLockLock;
                                        fileLockLock = channel;
                                        fileLock = fileLock2;
                                        FileLock fileLock3 = fileLockLock;
                                        fileLockLock = fileLock;
                                        r11 = fileLock3;
                                        randomAccessFile = randomAccessFile3;
                                        z6.a.c(Log.getStackTraceString(e));
                                        if (fileLockLock != null) {
                                            try {
                                                fileLockLock.release();
                                                if (r11 != 0) {
                                                    r11.close();
                                                }
                                            } catch (IOException e11) {
                                                z6.a.c(Log.getStackTraceString(e11));
                                                if (randomAccessFile == null) {
                                                    randomAccessFile.close();
                                                    return;
                                                }
                                                return;
                                            }
                                        } else if (r11 != 0) {
                                            r11.close();
                                        }
                                        if (randomAccessFile == null) {
                                            return;
                                        } else {
                                            randomAccessFile.close();
                                        }
                                    }
                                } catch (Exception e12) {
                                    e = e12;
                                    fileLock = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    this = null;
                                    obj = randomAccessFile3;
                                    Object obj2 = obj;
                                    r7 = this;
                                    th = th;
                                    r10 = obj2;
                                    if (0 != 0) {
                                        if (r7 != 0) {
                                            r7.close();
                                        }
                                        break;
                                    } else {
                                        try {
                                            fileLockLock.release();
                                            if (r7 != 0) {
                                                r7.close();
                                            }
                                        } catch (IOException e13) {
                                            z6.a.c(Log.getStackTraceString(e13));
                                            if (r10 != 0) {
                                                try {
                                                    r10.close();
                                                    throw th;
                                                } catch (IOException e14) {
                                                    z6.a.c(Log.getStackTraceString(e14));
                                                    throw th;
                                                }
                                            }
                                            throw th;
                                        }
                                        break;
                                    }
                                    if (r10 != 0) {
                                        r10.close();
                                        throw th;
                                    }
                                    throw th;
                                }
                                break;
                            } else {
                                channel = null;
                                randomAccessFile2 = null;
                            }
                            if (fileLockLock == null) {
                                if (channel != null) {
                                    channel.close();
                                }
                                break;
                            } else {
                                try {
                                    fileLockLock.release();
                                    if (channel != null) {
                                        channel.close();
                                    }
                                } catch (IOException e15) {
                                    z6.a.c(Log.getStackTraceString(e15));
                                }
                                break;
                            }
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                                return;
                            }
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            obj = file;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        r11 = 0;
                        randomAccessFile = null;
                    } catch (Throwable th4) {
                        th = th4;
                        r7 = 0;
                        r10 = 0;
                        if (0 != 0) {
                            if (r7 != 0) {
                                r7.close();
                            }
                            break;
                        } else {
                            fileLockLock.release();
                            if (r7 != 0) {
                                r7.close();
                            }
                            break;
                        }
                        if (r10 != 0) {
                            r10.close();
                            throw th;
                        }
                        throw th;
                    }
                } catch (IOException e17) {
                    z6.a.c(Log.getStackTraceString(e17));
                    return;
                }
                break;
            default:
                this.f10262b = str.concat("_");
                return;
        }
    }

    public w(int i8, long j8, TimeUnit timeUnit) {
        this.f10261a = 6;
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        hj.n delegate = new hj.n(gj.d.f5219h, i8, j8, timeUnit);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f10262b = delegate;
    }

    public w(Field field) {
        this.f10261a = 11;
        this.f10262b = field;
        field.setAccessible(true);
    }
}

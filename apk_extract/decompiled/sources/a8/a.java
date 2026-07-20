package a8;

import af.f6;
import af.g6;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Parcel;
import androidx.core.content.ContextCompat;
import androidx.core.view.PointerIconCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import ck.i;
import com.google.android.gms.common.internal.TelemetryData;
import com.transsion.widgetslib.widget.shadow.SpringFloatingOvalButton;
import com.welink.protocol.nfbd.NearDevice;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k3.vb;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import mg.a0;
import r2.h;
import tj.w;
import tj.x;
import ze.s;
import ze.t;
import ze.y;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements t, f2.b, jd.f, ck.b, j2.f, ek.b, q3.d, q3.c, h, zj.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f44b;

    public /* synthetic */ a(int i8, boolean z2) {
        this.f43a = i8;
    }

    @Override // jd.f
    public void a(boolean z2, DynamicAnimation dynamicAnimation, boolean z3, boolean z5, float f, float f4) {
        jd.f fVar = ((SpringFloatingOvalButton) this.f44b).f3658c;
        if (fVar != null) {
            fVar.a(z2, dynamicAnimation, z3, z5, f, f4);
        }
    }

    @Override // r2.h
    public void accept(Object obj, Object obj2) {
        q3.g gVar = (q3.g) obj2;
        w2.a aVar = (w2.a) ((w2.c) obj).o();
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(aVar.f5236d);
        h3.c.c(parcelObtain, (TelemetryData) this.f44b);
        try {
            aVar.f5235c.transact(1, parcelObtain, null, 1);
            parcelObtain.recycle();
            gVar.f8950a.g(null);
        } catch (Throwable th2) {
            parcelObtain.recycle();
            throw th2;
        }
    }

    @Override // j2.f
    public Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        a2.b bVar = j2.h.e;
        while (cursor.moveToNext()) {
            long j8 = cursor.getLong(0);
            Long lValueOf = Long.valueOf(j8);
            HashMap map = (HashMap) this.f44b;
            Set hashSet = (Set) map.get(lValueOf);
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j8), hashSet);
            }
            hashSet.add(new j2.g(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    @Override // q3.c
    public void b(Exception exc) {
        ((CountDownLatch) this.f44b).countDown();
    }

    @Override // zj.e
    public Type c() {
        return (Type) this.f44b;
    }

    @Override // ek.g
    public Object call(Object obj) {
        i iVar = (i) obj;
        fk.g gVar = new fk.g(iVar, (ek.g) this.f44b, 1);
        iVar.f1736a.a(gVar);
        return gVar;
    }

    public void d(int i8, boolean z2) {
        x6.c cVar = (x6.c) this.f44b;
        try {
            if (i8 > 0) {
                x6.c.s(cVar, i8, z2);
            } else {
                cVar.getClass();
                cVar.e = ((s6.e) ((i1.b) m6.a.f().f7948a.f8123c).f5527a).p * 1000;
                cVar.A();
            }
        } catch (Exception e) {
            z6.a.d("onConfigChanged exception : %s", e.getMessage());
        }
    }

    public String e() {
        BluetoothAdapter adapter;
        String address;
        Intrinsics.checkNotNullParameter("deviceMac", "key");
        String str = "";
        Intrinsics.checkNotNullParameter("", "defaultVal");
        SharedPreferences sharedPreferences = vb.f6684a;
        SharedPreferences sharedPreferences2 = null;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        String string = sharedPreferences.getString("deviceMac", "");
        if (string == null) {
            string = "";
        }
        if (string.length() != 0) {
            return string;
        }
        Application context = (Application) this.f44b;
        Intrinsics.checkNotNullParameter(context, "context");
        BluetoothManager bluetoothManager = (BluetoothManager) ContextCompat.getSystemService(context, BluetoothManager.class);
        if (bluetoothManager != null && (adapter = bluetoothManager.getAdapter()) != null && (address = adapter.getAddress()) != null) {
            str = address;
        }
        if (!Intrinsics.areEqual(str, "02:00:00:00:00:00") && StringsKt__StringsKt.trim((CharSequence) str).toString().length() != 0) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int iE = 0; iE < 6; iE = h0.a.e(new Object[]{Integer.valueOf(RangesKt___RangesKt.random(new IntRange(0, 255), Random.INSTANCE))}, 1, "%02X:", "format(...)", sb2, iE, 1)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        }
        sb2.deleteCharAt(sb2.length() - 1);
        String value = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(value, "toString(...)");
        Intrinsics.checkNotNullParameter("deviceMac", "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences sharedPreferences3 = vb.f6684a;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        } else {
            sharedPreferences2 = sharedPreferences3;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
        editorEdit.putString("deviceMac", value);
        editorEdit.apply();
        return value;
    }

    public InputStream f() {
        InputStream inputStream = (InputStream) this.f44b;
        this.f44b = null;
        return inputStream;
    }

    public void g(boolean z2) {
        NearDevice nearDevice = (NearDevice) this.f44b;
        if (z2) {
            nearDevice.f3899w = PointerIconCompat.TYPE_TEXT;
            return;
        }
        nearDevice.f3899w = PointerIconCompat.TYPE_ALIAS;
        if (nearDevice.f3900x == 1014) {
            nearDevice.A(PointerIconCompat.TYPE_CELL);
            se.g newState = new se.g(0);
            Intrinsics.checkNotNullParameter(newState, "newState");
            nearDevice.I = newState;
        }
    }

    @Override // yh.a
    public Object get() {
        return new e2.e((Context) ((w) this.f44b).f10262b, new n5.a(), new a0());
    }

    public void h() {
        ((NearDevice) this.f44b).f3900x = PointerIconCompat.TYPE_COPY;
    }

    public void i() {
        NearDevice nearDevice = (NearDevice) this.f44b;
        nearDevice.f3900x = PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW;
        if (nearDevice.f3899w == 1010) {
            nearDevice.A(PointerIconCompat.TYPE_CELL);
            se.g newState = new se.g(0);
            Intrinsics.checkNotNullParameter(newState, "newState");
            nearDevice.I = newState;
        }
    }

    public void j(boolean z2) {
        NearDevice nearDevice = (NearDevice) this.f44b;
        if (z2) {
            nearDevice.f3900x = PointerIconCompat.TYPE_NO_DROP;
            return;
        }
        nearDevice.f3900x = PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW;
        if (nearDevice.f3899w == 1010) {
            nearDevice.A(PointerIconCompat.TYPE_CELL);
            se.g newState = new se.g(0);
            Intrinsics.checkNotNullParameter(newState, "newState");
            nearDevice.I = newState;
        }
    }

    @Override // zj.e
    public Object k(zj.w wVar) {
        zj.g gVar = new zj.g(wVar);
        wVar.g(new x(gVar));
        return gVar;
    }

    public void l(boolean z2) {
        NearDevice device = (NearDevice) this.f44b;
        if (!z2) {
            device.A(PointerIconCompat.TYPE_CELL);
            se.g newState = new se.g(0);
            Intrinsics.checkNotNullParameter(newState, "newState");
            device.I = newState;
            return;
        }
        device.A(PointerIconCompat.TYPE_WAIT);
        Intrinsics.checkNotNullParameter(device, "device");
        se.d newState2 = new se.d();
        Intrinsics.checkNotNullParameter(newState2, "newState");
        device.I = newState2;
    }

    @Override // ze.t
    public void m(y yVar) {
        switch (this.f43a) {
            case 1:
                ((af.a0) this.f44b).f131j.h(ze.i.s(yVar));
                break;
            default:
                ((s) this.f44b).t(yVar.g());
                break;
        }
    }

    public void n(Object obj) {
        g6.b((f6) this.f44b, obj);
    }

    @Override // q3.d
    public void onSuccess(Object obj) {
        ((CountDownLatch) this.f44b).countDown();
    }

    public String toString() {
        switch (this.f43a) {
            case 15:
                return a1.a.s(new StringBuilder("<"), (String) this.f44b, Typography.greater);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ a(Object obj, int i8) {
        this.f43a = i8;
        this.f44b = obj;
    }

    public a(Application context) {
        this.f43a = 12;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f44b = context;
    }

    public a(int i8) {
        this.f43a = i8;
        switch (i8) {
            case 14:
                this.f44b = new CountDownLatch(1);
                break;
            default:
                this.f44b = new LinkedHashSet();
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x006d  */
    /* JADX WARN: Code duplicated, block: B:60:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // ek.b
    /* JADX INFO: renamed from: call, reason: collision with other method in class */
    public void mo0call(Object obj) throws Throwable {
        pk.e eVar = (pk.e) obj;
        Object latest = ((pk.f) this.f44b).getLatest();
        fk.d dVar = ((pk.f) this.f44b).nl;
        synchronized (eVar) {
            if (eVar.f8925b && !eVar.f8926c) {
                eVar.f8925b = false;
                boolean z2 = true;
                eVar.f8926c = latest != null;
                if (latest != null) {
                    boolean z3 = true;
                    ArrayList arrayList = null;
                    while (true) {
                        if (arrayList != null) {
                            try {
                                for (Object obj2 : arrayList) {
                                    if (obj2 != null) {
                                        dVar.getClass();
                                        fk.d.a(eVar.f8924a, obj2);
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                z2 = false;
                                if (!z2) {
                                    synchronized (eVar) {
                                        eVar.f8926c = false;
                                    }
                                }
                                throw th;
                            }
                        }
                        if (z3) {
                            dVar.getClass();
                            fk.d.a(eVar.f8924a, latest);
                            z3 = false;
                        }
                        try {
                            synchronized (eVar) {
                                try {
                                    arrayList = eVar.f8927d;
                                    eVar.f8927d = null;
                                    if (arrayList == null) {
                                        eVar.f8926c = false;
                                        return;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    z2 = false;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            th = th5;
                            if (!z2) {
                                synchronized (eVar) {
                                    eVar.f8926c = false;
                                }
                            }
                            throw th;
                        }
                    }
                }
            }
        }
    }

    public a(NearDevice device) {
        this.f43a = 17;
        Intrinsics.checkNotNullParameter(device, "device");
        this.f44b = device;
    }

    public a(ej.a threadFactory) {
        this.f43a = 8;
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
        this.f44b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
    }
}

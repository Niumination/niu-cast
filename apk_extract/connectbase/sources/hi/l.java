package hi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.transsion.padconnect.bridge.CastEntryClickReceiver;
import com.transsion.padconnect.bridge.CastEntryStateReceiver;
import in.n;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import jn.p;
import jq.e0;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.l2;
import nq.w0;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nPadConnectBridge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PadConnectBridge.kt\ncom/transsion/padconnect/bridge/PadConnectBridge\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,440:1\n1#2:441\n*E\n"})
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f7142b = "PCBridge";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final String f7143c = "connectx.cast.status.service.enabled";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7144d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7145e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.m
    public static WeakReference<Context> f7146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.m
    public static ii.a f7147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.m
    public static hi.a f7148h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.m
    public static String f7149i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.m
    public static CastEntryStateReceiver f7150j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.m
    public static CastEntryClickReceiver f7151k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.m
    public static h f7152l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final l f7141a = new l();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @os.l
    public static final CopyOnWriteArrayList<i> f7153m = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public static final CopyOnWriteArrayList<k> f7154n = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @os.l
    public static final CopyOnWriteArrayList<j> f7155o = new CopyOnWriteArrayList<>();

    public static final class a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.l<Boolean, l2> f7156a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(jn.l<? super Boolean, l2> lVar) {
            this.f7156a = lVar;
        }

        @Override // hi.i
        public void a(boolean z10) {
            this.f7156a.invoke(Boolean.valueOf(z10));
        }
    }

    public static final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.a<l2> f7157a;

        public b(jn.a<l2> aVar) {
            this.f7157a = aVar;
        }

        @Override // hi.j
        public void a() {
            this.f7157a.invoke();
        }
    }

    public static final class c implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.l<g, l2> f7158a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(jn.l<? super g, l2> lVar) {
            this.f7158a = lVar;
        }

        @Override // hi.k
        public void a(@os.l g gVar) {
            l0.p(gVar, "state");
            this.f7158a.invoke(gVar);
        }
    }

    @r1({"SMAP\nPadConnectBridge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PadConnectBridge.kt\ncom/transsion/padconnect/bridge/PadConnectBridge$registerCastEntryClickReceiver$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,440:1\n1855#2,2:441\n*S KotlinDebug\n*F\n+ 1 PadConnectBridge.kt\ncom/transsion/padconnect/bridge/PadConnectBridge$registerCastEntryClickReceiver$1\n*L\n336#1:441,2\n*E\n"})
    public static final class d extends n0 implements jn.l<String, l2> {
        public static final d INSTANCE = new d();

        public d() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(String str) {
            invoke2(str);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.m String str) {
            l.f7141a.y(str);
            Iterator<T> it = l.f7155o.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a();
            }
        }
    }

    @r1({"SMAP\nPadConnectBridge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PadConnectBridge.kt\ncom/transsion/padconnect/bridge/PadConnectBridge$registerCastEntryStateReceiver$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,440:1\n1855#2,2:441\n*S KotlinDebug\n*F\n+ 1 PadConnectBridge.kt\ncom/transsion/padconnect/bridge/PadConnectBridge$registerCastEntryStateReceiver$1\n*L\n304#1:441,2\n*E\n"})
    public static final class e extends n0 implements p<Boolean, String, l2> {
        public static final e INSTANCE = new e();

        public e() {
            super(2);
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ l2 invoke(Boolean bool, String str) {
            invoke(bool.booleanValue(), str);
            return l2.f10208a;
        }

        public final void invoke(boolean z10, @os.m String str) {
            l.f7141a.y(str);
            Iterator<T> it = l.f7153m.iterator();
            while (it.hasNext()) {
                ((i) it.next()).a(z10);
            }
        }
    }

    @r1({"SMAP\nPadConnectBridge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PadConnectBridge.kt\ncom/transsion/padconnect/bridge/PadConnectBridge$registerCastStateObserver$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,440:1\n1855#2,2:441\n*S KotlinDebug\n*F\n+ 1 PadConnectBridge.kt\ncom/transsion/padconnect/bridge/PadConnectBridge$registerCastStateObserver$1\n*L\n367#1:441,2\n*E\n"})
    public static final class f extends n0 implements jn.l<g, l2> {
        public static final f INSTANCE = new f();

        public f() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(g gVar) {
            invoke2(gVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l g gVar) {
            l0.p(gVar, "state");
            Iterator it = l.f7154n.iterator();
            while (it.hasNext()) {
                ((k) it.next()).a(gVar);
            }
        }
    }

    @n
    public static final void A(@os.l j jVar) {
        l0.p(jVar, "listener");
        CopyOnWriteArrayList<j> copyOnWriteArrayList = f7155o;
        copyOnWriteArrayList.remove(jVar);
        if (!copyOnWriteArrayList.isEmpty() || f7151k == null) {
            return;
        }
        f7141a.H();
    }

    @n
    public static final void B(@os.l k kVar) {
        l0.p(kVar, "listener");
        CopyOnWriteArrayList<k> copyOnWriteArrayList = f7154n;
        copyOnWriteArrayList.remove(kVar);
        if (!copyOnWriteArrayList.isEmpty() || f7152l == null) {
            return;
        }
        f7141a.J();
    }

    @n
    public static final void D(@os.l i iVar) {
        l0.p(iVar, "listener");
        f7153m.add(iVar);
        if (f7150j == null) {
            f7141a.v();
        }
    }

    @n
    public static final void E(@os.l j jVar) {
        l0.p(jVar, "listener");
        f7155o.add(jVar);
        if (f7151k == null) {
            f7141a.u();
        }
    }

    @n
    public static final void F(boolean z10) {
        l lVar = f7141a;
        Context contextF = lVar.f();
        ii.a aVarG = lVar.g();
        String strC = lVar.C();
        Intent intent = new Intent(hi.b.f7113b);
        if (strC != null) {
            intent.setPackage(strC);
        }
        intent.putExtra(hi.b.f7122k, z10);
        intent.putExtra(hi.b.f7123l, System.currentTimeMillis());
        intent.putExtra(hi.b.f7124m, contextF.getPackageName());
        aVarG.a(intent, hi.b.f7115d);
        if (strC == null) {
            strC = "implicit";
        }
        Log.d(f7142b, "Sent cast entry state: " + z10 + " -> " + strC);
    }

    @n
    public static final void G(@os.l k kVar) {
        l0.p(kVar, "listener");
        f7154n.add(kVar);
        if (f7152l == null) {
            f7141a.w();
        }
    }

    @in.j
    @n
    public static final void h(@os.l Context context) {
        l0.p(context, "context");
        l(context, null, 2, null);
    }

    @in.j
    @n
    public static final void i(@os.l Context context, @os.l hi.a aVar) {
        l0.p(context, "context");
        l0.p(aVar, "config");
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        f7141a.t(context, aVar, new ii.b(context));
    }

    @in.j
    @n
    public static final void j(@os.l Context context, @os.l hi.a aVar, @os.l ii.a aVar2) {
        l0.p(context, "context");
        l0.p(aVar, "config");
        l0.p(aVar2, NotificationCompat.CATEGORY_TRANSPORT);
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        f7141a.t(context, aVar, aVar2);
    }

    @in.j
    @n
    public static final void k(@os.l Context context, @os.l ii.a aVar) {
        l0.p(context, "context");
        l0.p(aVar, NotificationCompat.CATEGORY_TRANSPORT);
        m(context, null, aVar, 2, null);
    }

    public static /* synthetic */ void l(Context context, hi.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = hi.a.f7109d;
        }
        i(context, aVar);
    }

    public static /* synthetic */ void m(Context context, hi.a aVar, ii.a aVar2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = hi.a.f7109d;
        }
        j(context, aVar, aVar2);
    }

    @n
    public static final boolean n(@os.l Context context) {
        l0.p(context, "context");
        return Settings.Global.getInt(context.getContentResolver(), "connectx.cast.status.service.enabled", 0) == 1;
    }

    @n
    public static final boolean o(@os.l Context context) {
        l0.p(context, "context");
        return l0.g(Settings.Global.getString(context.getContentResolver(), hi.b.f7117f), "1");
    }

    @n
    public static final void p() {
        l lVar = f7141a;
        Context contextF = lVar.f();
        ii.a aVarG = lVar.g();
        String strC = lVar.C();
        Intent intent = new Intent(hi.b.f7114c);
        if (strC != null) {
            intent.setPackage(strC);
        }
        intent.putExtra(hi.b.f7123l, System.currentTimeMillis());
        intent.putExtra(hi.b.f7124m, contextF.getPackageName());
        aVarG.a(intent, hi.b.f7116e);
        if (strC == null) {
            strC = "implicit";
        }
        Log.d(f7142b, "Sent cast entry click event -> ".concat(strC));
    }

    @n
    public static final void x() {
        Context context;
        l lVar = f7141a;
        lVar.I();
        lVar.H();
        lVar.J();
        WeakReference<Context> weakReference = f7146f;
        if (weakReference != null && (context = weakReference.get()) != null) {
            hi.e.f7125a.a(context);
        }
        WeakReference<Context> weakReference2 = f7146f;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        f7146f = null;
        f7147g = null;
        f7148h = null;
        f7149i = null;
        f7153m.clear();
        f7154n.clear();
        f7155o.clear();
        Log.d(f7142b, "PadConnectBridge released");
    }

    @n
    public static final void z(@os.l i iVar) {
        l0.p(iVar, "listener");
        CopyOnWriteArrayList<i> copyOnWriteArrayList = f7153m;
        copyOnWriteArrayList.remove(iVar);
        if (!copyOnWriteArrayList.isEmpty() || f7150j == null) {
            return;
        }
        f7141a.I();
    }

    public final String C() {
        Context context;
        hi.a aVar;
        String str = f7149i;
        if (str != null) {
            WeakReference<Context> weakReference = f7146f;
            Context context2 = weakReference != null ? weakReference.get() : null;
            if (context2 != null && hi.e.f7125a.c(context2, str)) {
                return str;
            }
            Log.w(f7142b, "Memory cached package invalid, re-resolving: ".concat(str));
            f7149i = null;
            if (context2 != null) {
                hi.e.f7125a.a(context2);
            }
        }
        WeakReference<Context> weakReference2 = f7146f;
        if (weakReference2 == null || (context = weakReference2.get()) == null || (aVar = f7148h) == null) {
            return null;
        }
        String strG = hi.e.f7125a.g(context, aVar);
        f7149i = strG;
        return strG;
    }

    public final void H() {
        CastEntryClickReceiver castEntryClickReceiver = f7151k;
        if (castEntryClickReceiver != null) {
            ii.a aVar = f7147g;
            if (aVar != null) {
                if (aVar != null) {
                    try {
                        aVar.c(castEntryClickReceiver);
                    } catch (Exception e10) {
                        Log.w(f7142b, "Failed to unregister cast entry click receiver", e10);
                    }
                }
                Log.d(f7142b, "Cast entry click receiver unregistered");
            }
            f7151k = null;
        }
    }

    public final void I() {
        CastEntryStateReceiver castEntryStateReceiver = f7150j;
        if (castEntryStateReceiver != null) {
            ii.a aVar = f7147g;
            if (aVar != null) {
                if (aVar != null) {
                    try {
                        aVar.c(castEntryStateReceiver);
                    } catch (Exception e10) {
                        Log.w(f7142b, "Failed to unregister cast entry state receiver", e10);
                    }
                }
                Log.d(f7142b, "Cast entry state receiver unregistered");
            }
            f7150j = null;
        }
    }

    public final void J() {
        Context context;
        ContentResolver contentResolver;
        h hVar = f7152l;
        if (hVar != null) {
            try {
                WeakReference<Context> weakReference = f7146f;
                if (weakReference != null && (context = weakReference.get()) != null && (contentResolver = context.getContentResolver()) != null) {
                    contentResolver.unregisterContentObserver(hVar);
                }
                Log.d(f7142b, "Cast state observer unregistered");
            } catch (Exception e10) {
                Log.w(f7142b, "Failed to unregister cast state observer", e10);
            }
            f7152l = null;
        }
    }

    public final hi.a e() {
        hi.a aVar = f7148h;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("PadConnectBridge not configured. Call config() first.");
    }

    public final Context f() {
        WeakReference<Context> weakReference = f7146f;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            return context;
        }
        f7146f = null;
        throw new IllegalStateException("PadConnectBridge not configured. Call config() first.");
    }

    public final ii.a g() {
        ii.a aVar = f7147g;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("PadConnectBridge not configured. Call config() first.");
    }

    public final /* synthetic */ void q(jn.l lVar) {
        l0.p(lVar, "listener");
        D(new a(lVar));
    }

    public final /* synthetic */ void r(jn.a aVar) {
        l0.p(aVar, "listener");
        E(new b(aVar));
    }

    public final /* synthetic */ void s(jn.l lVar) {
        l0.p(lVar, "listener");
        G(new c(lVar));
    }

    public final void t(Context context, hi.a aVar, ii.a aVar2) {
        f7146f = new WeakReference<>(context);
        f7147g = aVar2;
        f7148h = aVar;
        String str = aVar.f7110a;
        if (str == null || e0.S1(str)) {
            str = null;
        }
        f7149i = str;
        if (str != null) {
            hi.e.f7125a.e(context, str);
        }
        String str2 = f7149i;
        if (str2 == null) {
            str2 = w0.f11975c;
        }
        Log.d(f7142b, "PadConnectBridge configured with target: ".concat(str2));
    }

    public final void u() {
        ii.a aVarG = g();
        f7151k = new CastEntryClickReceiver(d.INSTANCE);
        IntentFilter intentFilter = new IntentFilter(hi.b.f7114c);
        CastEntryClickReceiver castEntryClickReceiver = f7151k;
        if (castEntryClickReceiver == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        aVarG.b(castEntryClickReceiver, intentFilter, hi.b.f7116e, null, 2);
        Log.d(f7142b, "Cast entry click receiver registered");
    }

    public final void v() {
        ii.a aVarG = g();
        f7150j = new CastEntryStateReceiver(e.INSTANCE);
        IntentFilter intentFilter = new IntentFilter(hi.b.f7113b);
        CastEntryStateReceiver castEntryStateReceiver = f7150j;
        if (castEntryStateReceiver == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        aVarG.b(castEntryStateReceiver, intentFilter, hi.b.f7115d, null, 2);
        Log.d(f7142b, "Cast entry state receiver registered");
    }

    public final void w() {
        Context contextF = f();
        f7152l = new h(contextF, f.INSTANCE);
        ContentResolver contentResolver = contextF.getContentResolver();
        Uri uriFor = Settings.Global.getUriFor(hi.b.f7117f);
        h hVar = f7152l;
        if (hVar == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        contentResolver.registerContentObserver(uriFor, false, hVar);
        Log.d(f7142b, "Cast state observer registered");
    }

    public final void y(String str) {
        Context context;
        if (str == null || e0.S1(str)) {
            return;
        }
        f7149i = str;
        WeakReference<Context> weakReference = f7146f;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        hi.e.f7125a.e(context, str);
    }
}

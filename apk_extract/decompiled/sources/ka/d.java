package ka;

import android.content.Context;
import android.net.wifi.WifiManager;
import cf.r;
import cf.s;
import ck.i;
import e5.j;
import fk.m;
import fk.o;
import fk.p;
import fk.q;
import j3.z;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.v8;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import ng.a0;
import qj.f;
import se.h4;
import se.q6;
import we.h;
import zf.p0;
import zf.v;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ck.a, j5.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static d f6815c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f6816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f6817b;

    public d(Level level, Class cls) {
        Logger logger = Logger.getLogger(cls.getName());
        v8.i(level, "level");
        this.f6817b = level;
        v8.i(logger, "logger");
        this.f6816a = logger;
    }

    public static synchronized d d(Context context) {
        try {
            if (f6815c == null) {
                d dVar = new d();
                dVar.f6817b = context.getApplicationContext();
                f6815c = dVar;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f6815c;
    }

    public static String r(f fVar) {
        long j8 = fVar.f9195b;
        if (j8 <= 64) {
            return fVar.B().hex();
        }
        return fVar.E((int) Math.min(j8, 64L)).hex() + "...";
    }

    public void a(j jVar) {
        ((ConcurrentHashMap) this.f6816a).put(((j5.b) this.f6817b).a(jVar), jVar);
    }

    public void b(String name, String value, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        if (((Set) this.f6816a).contains(name)) {
            return;
        }
        if (z2) {
            String[] strArr = v.f11551a;
            Intrinsics.checkNotNullParameter(name, "header");
            String[] strArr2 = v.f11551a;
            for (int i8 = 0; i8 < 2; i8++) {
                if (StringsKt__StringsJVMKt.equals(strArr2[i8], name, true)) {
                    throw new p0(name);
                }
            }
        }
        v.a(name);
        v.b(value);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        ((a0) this.f6817b).f8242n.d(name, value);
    }

    public String c(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(name, "name");
        List listB = ((a0) this.f6817b).f8242n.b(name);
        if (listB == null) {
            listB = CollectionsKt.emptyList();
        }
        return (String) CollectionsKt.firstOrNull(listB);
    }

    @Override // ek.b
    /* JADX INFO: renamed from: call */
    public void mo0call(Object obj) {
        q qVar;
        AtomicReference atomicReference;
        m[] mVarArr;
        m[] mVarArr2;
        i iVar = (i) obj;
        while (true) {
            AtomicReference atomicReference2 = (AtomicReference) this.f6816a;
            qVar = (q) atomicReference2.get();
            if (qVar != null) {
                break;
            }
            q qVar2 = new q((o) ((ek.f) this.f6817b).call());
            qVar2.f1736a.a(new qk.a(new p(qVar2)));
            if (atomicReference2.compareAndSet(qVar, qVar2)) {
                qVar = qVar2;
                break;
            }
        }
        m mVar = new m(qVar, iVar);
        do {
            atomicReference = qVar.f5085i;
            mVarArr = (m[]) atomicReference.get();
            if (mVarArr == q.p) {
                break;
            }
            int length = mVarArr.length;
            mVarArr2 = new m[length + 1];
            System.arraycopy(mVarArr, 0, mVarArr2, 0, length);
            mVarArr2[length] = mVar;
        } while (!atomicReference.compareAndSet(mVarArr, mVarArr2));
        iVar.f1736a.a(mVar);
        qVar.e.replay(mVar);
        iVar.b(mVar);
    }

    public int e() {
        m8.a aVar;
        ca.a aVar2;
        r9.a aVar3;
        if (l9.b.a(l9.a.f7343b)) {
            j9.a.a("d", "TranThubWifiManager start");
            aVar3 = (r9.a) this.f6816a;
            if (aVar3 == null) {
                aVar2 = aVar3;
                r9.a aVar4 = new r9.a();
                this.f6816a = aVar4;
                aVar2 = aVar4;
            }
        } else {
            j9.a.a("d", "TranAospWifiManager start");
            aVar = (m8.a) this.f6817b;
            if (aVar == null) {
                aVar2 = aVar;
                m8.a aVar5 = new m8.a();
                Context context = z.f6093b;
                aVar5.f7950a = (WifiManager) context.getSystemService("wifi");
                this.f6817b = aVar5;
                aVar2 = aVar5;
            }
        }
        aVar2 = aVar;
        aVar2 = aVar3;
        return aVar2.a();
    }

    public boolean f() {
        return ((Logger) this.f6816a).isLoggable((Level) this.f6817b);
    }

    public void g(r rVar, int i8, f fVar, int i9, boolean z2) {
        if (f()) {
            ((Logger) this.f6816a).log((Level) this.f6817b, rVar + " DATA: streamId=" + i8 + " endStream=" + z2 + " length=" + i9 + " bytes=" + r(fVar));
        }
    }

    public void h(r rVar, int i8, ef.a aVar, qj.j jVar) {
        if (f()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(rVar);
            sb2.append(" GO_AWAY: lastStreamId=");
            sb2.append(i8);
            sb2.append(" errorCode=");
            sb2.append(aVar);
            sb2.append(" length=");
            sb2.append(jVar.size());
            sb2.append(" bytes=");
            f fVar = new f();
            fVar.I(jVar);
            sb2.append(r(fVar));
            ((Logger) this.f6816a).log((Level) this.f6817b, sb2.toString());
        }
    }

    public void i(r rVar, int i8, ArrayList arrayList, boolean z2) {
        if (f()) {
            ((Logger) this.f6816a).log((Level) this.f6817b, rVar + " HEADERS: streamId=" + i8 + " headers=" + arrayList + " endStream=" + z2);
        }
    }

    public void j(r rVar, long j8) {
        if (f()) {
            ((Logger) this.f6816a).log((Level) this.f6817b, rVar + " PING: ack=false bytes=" + j8);
        }
    }

    public void k(r rVar, long j8) {
        if (f()) {
            ((Logger) this.f6816a).log((Level) this.f6817b, rVar + " PING: ack=true bytes=" + j8);
        }
    }

    public void l(r rVar, int i8, int i9, ArrayList arrayList) {
        if (f()) {
            ((Logger) this.f6816a).log((Level) this.f6817b, rVar + " PUSH_PROMISE: streamId=" + i8 + " promisedStreamId=" + i9 + " headers=" + arrayList);
        }
    }

    public void m(r rVar, int i8, ef.a aVar) {
        if (f()) {
            ((Logger) this.f6816a).log((Level) this.f6817b, rVar + " RST_STREAM: streamId=" + i8 + " errorCode=" + aVar);
        }
    }

    public void n(r rVar, ef.o oVar) {
        if (f()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(rVar);
            sb2.append(" SETTINGS: ack=false settings=");
            EnumMap enumMap = new EnumMap(s.class);
            for (s sVar : s.values()) {
                if (oVar.b(sVar.getBit())) {
                    enumMap.put(sVar, Integer.valueOf(((int[]) oVar.f4952b)[sVar.getBit()]));
                }
            }
            sb2.append(enumMap.toString());
            ((Logger) this.f6816a).log((Level) this.f6817b, sb2.toString());
        }
    }

    public void o(r rVar, int i8, long j8) {
        if (f()) {
            ((Logger) this.f6816a).log((Level) this.f6817b, rVar + " WINDOW_UPDATE: streamId=" + i8 + " windowSizeIncrement=" + j8);
        }
    }

    public void p(int i8) {
        h.b((String) this.f6817b, a1.a.o(i8, "GroupClientConnectFailedResult reason="));
        h4 h4Var = (h4) this.f6816a;
        if (h4Var != null) {
            q6 newState = new q6();
            Intrinsics.checkNotNullParameter(newState, "newState");
            h4Var.f9764g = newState;
        }
    }

    public void q(int i8) {
        h.b((String) this.f6817b, a1.a.o(i8, "GroupOwnerConnectFailedResult reason="));
        h4 h4Var = (h4) this.f6816a;
        if (h4Var != null) {
            q6 newState = new q6();
            Intrinsics.checkNotNullParameter(newState, "newState");
            h4Var.f9765h = newState;
        }
    }

    public d(j5.b bVar) {
        this.f6816a = new ConcurrentHashMap();
        this.f6817b = bVar;
    }

    public d(h4 h4Var) {
        this.f6816a = h4Var;
        this.f6817b = "NearP2pManager";
    }
}

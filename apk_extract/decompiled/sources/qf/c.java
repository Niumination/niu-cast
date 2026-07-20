package qf;

import af.c0;
import af.d0;
import af.h6;
import af.k2;
import af.l1;
import af.l5;
import af.o5;
import af.r5;
import af.t1;
import af.t5;
import af.u5;
import af.w5;
import af.x;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import cf.b0;
import cf.h0;
import d2.l;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import k3.ma;
import k3.t8;
import k3.v8;
import k3.y0;
import k3.z0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import m3.n7;
import m4.m;
import pf.e0;
import r2.w;
import ze.a0;
import ze.f0;
import ze.f2;
import ze.g2;
import ze.k1;
import ze.n;
import ze.o;
import ze.o2;
import ze.p1;
import ze.q2;
import ze.s;
import ze.u0;
import ze.w1;
import ze.y;
import ze.y1;
import ze.z;
import zf.i0;
import zf.r;

/* JADX INFO: loaded from: classes3.dex */
public class c implements e0, d0, k2.b, j2.f, mg.f, sk.a, vg.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f9047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f9048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f9049d;

    public /* synthetic */ c() {
        this.f9046a = 7;
    }

    public static g2 t(c cVar, b0 b0Var, g2 g2Var, h6 h6Var) {
        cVar.getClass();
        n[] nVarArr = h6Var.f312a;
        if (nVarArr.length > 0) {
            nVarArr[0].getClass();
            throw new ClassCastException();
        }
        f2[] f2VarArr = ((w5) cVar.f9049d).f667h;
        if (f2VarArr.length <= 0) {
            return new g2(g2Var.f11353a, g2Var.f11354b);
        }
        f2 f2Var = f2VarArr[0];
        v8.i(null, "interceptor");
        throw null;
    }

    public static Method w(Class cls, String str, Class[] clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            if ((cls.getModifiers() & 1) == 0) {
                return w(cls.getSuperclass(), str, clsArr);
            }
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    public Object A(SSLSocket sSLSocket, Object... objArr) {
        try {
            return y(sSLSocket, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void B(b0 b0Var, String str, p1 p1Var) {
        Executor l5Var;
        Object[] objArr;
        s sVar;
        boolean z2 = true;
        w5 w5Var = (w5) this.f9049d;
        Logger logger = w5.f662t;
        w5Var.getClass();
        if (((w5) this.f9049d).f665d != m4.k.INSTANCE) {
            l5Var = new o5(((w5) this.f9049d).f665d);
        } else {
            l5Var = new l5();
            b0Var.g();
        }
        Executor executor = l5Var;
        k1 k1Var = l1.e;
        for (int i8 = 0; i8 < p1Var.f11400b; i8++) {
            if (Arrays.equals(k1Var.f11381b, p1Var.e(i8))) {
                String str2 = (String) p1Var.c(l1.e);
                a0 a0Var = (a0) ((w5) this.f9049d).p.f11325a.get(str2);
                o oVar = a0Var != null ? a0Var.f11319a : null;
                if (oVar != null) {
                    b0Var.f1488g.f301a.k(oVar);
                    break;
                }
                k2 k2Var = w5.u;
                cf.a0 a0Var2 = b0Var.f1488g;
                v8.n(a0Var2.f1468i == null, "setListener should be called only once");
                v8.i(k2Var, "listener");
                a0Var2.f1468i = k2Var;
                b0Var.x(q2.f11409l.h("Can't find decompressor for " + str2), new p1());
                return;
            }
        }
        h6 h6Var = b0Var.f1487d;
        v8.i(h6Var, "statsTraceCtx not present from stream");
        Long l4 = (Long) p1Var.c(l1.f413d);
        y yVar = ((w5) this.f9049d).f674o;
        v8.i(yVar, "context");
        n[] nVarArr = h6Var.f312a;
        if (nVarArr.length > 0) {
            nVarArr[0].getClass();
            throw new ClassCastException();
        }
        sj.a aVar = u0.f11444a;
        w5 w5Var2 = (w5) this.f9049d;
        y1 y1Var = yVar.f11475b;
        y yVar2 = new y(yVar, y1Var == null ? new w1(z2 ? 1 : 0, aVar, w5Var2) : y1Var.b(aVar, w5Var2, aVar.hashCode(), 0));
        if (l4 == null) {
            sVar = new s(yVar2);
        } else {
            long jLongValue = l4.longValue();
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            z zVarA = z.a(jLongValue, timeUnit, ((w5) this.f9049d).f676s);
            ScheduledExecutorService scheduledExecutorService = ((h0) this.f9047b).f1540h;
            y.h(scheduledExecutorService, "scheduler");
            z zVarL = yVar2.l();
            if (zVarL == null || zVarL.compareTo(zVarA) > 0) {
                objArr = true;
            } else {
                zVarA = zVarL;
                objArr = false;
            }
            s sVar2 = new s(yVar2, zVarA);
            if (objArr != false) {
                if (zVarA.e()) {
                    sVar2.t(new TimeoutException("context timed out"));
                } else {
                    synchronized (sVar2) {
                        w wVar = new w(sVar2, 7);
                        zVarA.f11483a.getClass();
                        sVar2.f11431m = scheduledExecutorService.schedule(wVar, zVarA.f11484b - System.nanoTime(), timeUnit);
                    }
                }
            }
            sVar = sVar2;
        }
        ph.b.c();
        r5 r5Var = new r5(executor, ((w5) this.f9049d).f665d, b0Var, sVar);
        cf.a0 a0Var3 = b0Var.f1488g;
        v8.n(a0Var3.f1468i == null, "setListener should be called only once");
        a0Var3.f1468i = r5Var;
        m mVar = new m();
        s sVar3 = sVar;
        executor.execute(new u5(this, sVar3, str, b0Var, r5Var, mVar, h6Var, p1Var, executor));
        executor.execute(new t5(this, sVar3, mVar, str, p1Var, b0Var, r5Var));
    }

    public byte[] C(ma maVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            HashMap map = (HashMap) this.f9047b;
            z0 z0Var = new z0(byteArrayOutputStream, map, (HashMap) this.f9048c, (y0) this.f9049d);
            q4.d dVar = (q4.d) map.get(ma.class);
            if (dVar == null) {
                throw new q4.b("No encoder for ".concat(String.valueOf(ma.class)));
            }
            dVar.a(maVar, z0Var);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
        }
    }

    public byte[] D(n7 n7Var) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            HashMap map = (HashMap) this.f9047b;
            m3.h hVar = new m3.h(byteArrayOutputStream, map, (HashMap) this.f9048c, (m3.g) this.f9049d);
            q4.d dVar = (q4.d) map.get(n7.class);
            if (dVar == null) {
                throw new q4.b("No encoder for ".concat(String.valueOf(n7.class)));
            }
            dVar.a(n7Var, hVar);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
        }
    }

    @Override // vg.c
    public r a() {
        return ((vg.e) this.f9049d).a();
    }

    @Override // j2.f
    public Object apply(Object obj) {
        long jInsert;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        a2.b bVar = j2.h.e;
        j2.h hVar = (j2.h) this.f9047b;
        long jSimpleQueryForLong = hVar.a().compileStatement("PRAGMA page_size").simpleQueryForLong() * hVar.a().compileStatement("PRAGMA page_count").simpleQueryForLong();
        j2.a aVar = hVar.f6051d;
        if (jSimpleQueryForLong >= aVar.f6035a) {
            return -1L;
        }
        d2.d dVar = (d2.d) this.f9048c;
        Long lC = j2.h.c(sQLiteDatabase, dVar);
        if (lC != null) {
            jInsert = lC.longValue();
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("backend_name", dVar.f4269a);
            contentValues.put("priority", Integer.valueOf(m2.a.a(dVar.f4271c)));
            contentValues.put("next_request_ms", (Integer) 0);
            byte[] bArr = dVar.f4270b;
            if (bArr != null) {
                contentValues.put("extras", Base64.encodeToString(bArr, 0));
            }
            jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        d2.b bVar2 = (d2.b) this.f9049d;
        d2.f fVar = bVar2.f4264c;
        byte[] bArr2 = fVar.f4277b;
        int length = bArr2.length;
        int i8 = aVar.e;
        boolean z2 = length <= i8;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("context_id", Long.valueOf(jInsert));
        contentValues2.put("transport_name", bVar2.f4262a);
        contentValues2.put("timestamp_ms", Long.valueOf(bVar2.f4265d));
        contentValues2.put("uptime_ms", Long.valueOf(bVar2.e));
        contentValues2.put("payload_encoding", fVar.f4276a.f28a);
        contentValues2.put("code", bVar2.f4263b);
        contentValues2.put("num_attempts", (Integer) 0);
        contentValues2.put("inline", Boolean.valueOf(z2));
        contentValues2.put("payload", z2 ? bArr2 : new byte[0]);
        long jInsert2 = sQLiteDatabase.insert("events", null, contentValues2);
        if (!z2) {
            int iCeil = (int) Math.ceil(((double) bArr2.length) / ((double) i8));
            for (int i9 = 1; i9 <= iCeil; i9++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, (i9 - 1) * i8, Math.min(i9 * i8, bArr2.length));
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("event_id", Long.valueOf(jInsert2));
                contentValues3.put("sequence_num", Integer.valueOf(i9));
                contentValues3.put("bytes", bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues3);
            }
        }
        for (Map.Entry entry : Collections.unmodifiableMap(bVar2.f).entrySet()) {
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("event_id", Long.valueOf(jInsert2));
            contentValues4.put("name", (String) entry.getKey());
            contentValues4.put("value", (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues4);
        }
        return Long.valueOf(jInsert2);
    }

    @Override // sk.a
    public void b() {
        Class cls = (Class) this.f9048c;
        try {
            Log.d("BounceEffect", "cancelTranBounceAnimation called " + cls.toString());
            cls.getMethod("cancelTranBounceAnimation", null).invoke((View) this.f9047b, null);
        } catch (Throwable unused) {
            Log.e("BounceEffect", "cancelTranBounceAnimation not found." + cls.toString());
        }
    }

    @Override // vg.c
    public mg.b c() {
        return (xg.y) this.f9047b;
    }

    @Override // sk.a
    public boolean d(b8.d dVar) {
        Class cls = (Class) this.f9048c;
        try {
            Log.d("BounceEffect", "isBounceEdgeAnimRunning called " + cls.toString());
            Method method = (Method) this.f9049d;
            if (method != null) {
                return ((Boolean) method.invoke((View) this.f9047b, dVar)).booleanValue();
            }
        } catch (Throwable unused) {
            Log.e("BounceEffect", "isBounceEdgeAnimRunning not found." + cls.toString());
        }
        return false;
    }

    @Override // vg.e
    public vg.b e() {
        return (vg.b) this.f9048c;
    }

    @Override // k2.b
    public Object execute() {
        h2.a aVar = (h2.a) this.f9047b;
        j2.h hVar = (j2.h) aVar.f5233d;
        hVar.getClass();
        d2.d dVar = (d2.d) this.f9048c;
        d2.b bVar = (d2.b) this.f9049d;
        Log.d("TransportRuntime.".concat("SQLiteEventStore"), "Storing event with priority=" + dVar.f4271c + ", name=" + bVar.f4262a + " for destination " + dVar.f4269a);
        ((Long) hVar.g(new c(hVar, 8, dVar, bVar))).longValue();
        aVar.f5230a.a(dVar, 1, false);
        return null;
    }

    @Override // vg.c
    public vg.f f() {
        return ((vg.e) this.f9049d).f();
    }

    @Override // vg.c
    public i0 g() {
        return ((vg.e) this.f9049d).g();
    }

    @Override // pf.e0
    public zg.a getKey() {
        switch (this.f9046a) {
            case 0:
                break;
        }
        return (zg.a) this.f9049d;
    }

    @Override // vg.c
    public zf.d0 h() {
        return ((vg.e) this.f9049d).h();
    }

    @Override // af.d0
    public void i(p1 p1Var) {
        af.a0 a0Var = (af.a0) this.f9049d;
        ph.b.d();
        try {
            ph.c cVar = a0Var.f125b;
            ph.b.a();
            ph.b.c();
            a0Var.f126c.execute(new af.w(this, p1Var));
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // af.j6
    public void j(a8.a aVar) {
        af.a0 a0Var = (af.a0) this.f9049d;
        ph.b.d();
        try {
            ph.c cVar = a0Var.f125b;
            ph.b.a();
            ph.b.c();
            a0Var.f126c.execute(new af.w(this, aVar));
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // vg.c
    public jh.o k() {
        return ((vg.e) this.f9049d).k();
    }

    @Override // af.d0
    public void l(q2 q2Var, c0 c0Var, p1 p1Var) {
        ph.b.d();
        try {
            ph.c cVar = ((af.a0) this.f9049d).f125b;
            ph.b.a();
            u(q2Var, p1Var);
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // mg.f
    public Object m(hh.e eVar, Function1 configure) {
        mg.a aVar;
        mg.a pipeline = (mg.a) eVar;
        Intrinsics.checkNotNullParameter(pipeline, "pipeline");
        Intrinsics.checkNotNullParameter(configure, "configure");
        Object objInvoke = ((bh.a) this.f9047b).invoke(pipeline);
        configure.invoke(objInvoke);
        mg.k builder = new mg.k(pipeline, objInvoke, (zg.a) this.f9049d);
        ((Function1) this.f9048c).invoke(builder);
        Iterator it = builder.f8082b.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            aVar = builder.f8069g;
            if (!zHasNext) {
                break;
            }
            ((mg.o) it.next()).f8075a.invoke(aVar);
        }
        Iterator it2 = builder.f8083c.iterator();
        while (it2.hasNext()) {
            ((mg.o) it2.next()).f8075a.invoke(aVar.f8056j);
        }
        Iterator it3 = builder.f8084d.iterator();
        while (it3.hasNext()) {
            ((mg.o) it3.next()).f8075a.invoke(aVar.f8057k);
        }
        Iterator it4 = builder.e.iterator();
        while (it4.hasNext()) {
            ((mg.o) it4.next()).f8075a.invoke(aVar.f8057k);
        }
        Iterator it5 = builder.f.iterator();
        if (it5.hasNext()) {
            it5.next().getClass();
            throw new ClassCastException();
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        return new mg.a0();
    }

    @Override // pf.e0
    public void o(Object obj, jf.d client) {
        d plugin = (d) obj;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(client, "scope");
        plugin.getClass();
        Intrinsics.checkNotNullParameter(client, "scope");
        b bVar = new b(plugin.f9050a, client, plugin.f9051b);
        plugin.f9052c.invoke(bVar);
        plugin.f9053d = bVar.f9045d;
        for (e eVar : bVar.f9044c) {
            eVar.getClass();
            Intrinsics.checkNotNullParameter(client, "client");
            eVar.f9054a.a(client, eVar.f9055b);
        }
    }

    @Override // af.j6
    public void q() {
        af.a0 a0Var = (af.a0) this.f9049d;
        if (a0Var.f124a.f11422a.clientSendsOneMessage()) {
            return;
        }
        ph.b.d();
        try {
            ph.b.a();
            ph.b.c();
            a0Var.f126c.execute(new af.y(this));
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // pf.e0
    public Object r(Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Object objInvoke = ((Function0) this.f9047b).invoke();
        block.invoke(objInvoke);
        return new d((zg.a) this.f9049d, objInvoke, (Function1) this.f9048c);
    }

    @Override // vg.c
    public zf.d0 s() {
        return ((vg.e) this.f9049d).s();
    }

    public String toString() {
        switch (this.f9046a) {
            case 15:
                o6.a aVarA = t8.a(this);
                aVarA.d((List) this.f9047b, "addrs");
                aVarA.d((ze.b) this.f9048c, "attrs");
                aVarA.d(Arrays.deepToString((Object[][]) this.f9049d), "customOptions");
                return aVarA.toString();
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0010  */
    public void u(q2 q2Var, p1 p1Var) {
        af.a0 a0Var = (af.a0) this.f9049d;
        z zVar = a0Var.f130i.f11347a;
        z zVarL = a0Var.f.l();
        if (zVar == null) {
            zVar = zVarL;
        } else if (zVarL != null) {
            zVar.b(zVarL);
            if (!zVar.d(zVarL)) {
                zVar = zVarL;
            }
        }
        if (q2Var.f11413a == o2.CANCELLED && zVar != null && zVar.e()) {
            t1 t1Var = new t1(0);
            a0Var.f131j.j(t1Var);
            q2Var = q2.f11405h.a("ClientCall was cancelled at or after deadline. " + t1Var);
            p1Var = new p1();
        }
        ph.b.c();
        a0Var.f126c.execute(new x(this, q2Var, p1Var));
    }

    public Method v(Class cls) {
        Class cls2;
        Method methodW = w(cls, (String) this.f9048c, (Class[]) this.f9049d);
        if (methodW == null || (cls2 = (Class) this.f9047b) == null || cls2.isAssignableFrom(methodW.getReturnType())) {
            return methodW;
        }
        return null;
    }

    public d2.k x(a2.b bVar, a2.d dVar) {
        Set set = (Set) this.f9047b;
        if (set.contains(bVar)) {
            return new d2.k((d2.d) this.f9048c, bVar, dVar, (l) this.f9049d);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar, set));
    }

    public Object y(SSLSocket sSLSocket, Object... objArr) {
        Method methodV = v(sSLSocket.getClass());
        if (methodV == null) {
            throw new AssertionError("Method " + ((String) this.f9048c) + " not supported for object " + sSLSocket);
        }
        try {
            return methodV.invoke(sSLSocket, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodV);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public void z(SSLSocket sSLSocket, Object... objArr) {
        try {
            Method methodV = v(sSLSocket.getClass());
            if (methodV == null) {
                return;
            }
            try {
                methodV.invoke(sSLSocket, objArr);
            } catch (IllegalAccessException unused) {
            }
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public c(Class cls, FrameLayout frameLayout) {
        this.f9046a = 13;
        this.f9047b = frameLayout;
        this.f9048c = cls;
        try {
            this.f9049d = cls.getMethod("isBounceEdgeAnimRunning", b8.d.class);
        } catch (Exception unused) {
            Log.e("NativeBounceEdgeEffect", "isBounceEdgeAnimRunning not found." + ((Class) this.f9048c).toString());
        }
    }

    public /* synthetic */ c(Object obj, int i8, Object obj2, Object obj3) {
        this.f9046a = i8;
        this.f9047b = obj;
        this.f9048c = obj2;
        this.f9049d = obj3;
    }

    public c(List list) {
        this.f9046a = 10;
        this.f9049d = list;
        this.f9047b = new ArrayList(list.size());
        this.f9048c = new ArrayList(list.size());
        for (int i8 = 0; i8 < list.size(); i8++) {
            ((ArrayList) this.f9047b).add(new m1.n((List) ((r1.j) list.get(i8)).f9269b.f574b));
            ((ArrayList) this.f9048c).add(((r1.j) list.get(i8)).f9270c.g());
        }
    }

    public c(xg.y call, vg.b pipeline, vg.e engineRequest) {
        this.f9046a = 14;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(pipeline, "pipeline");
        Intrinsics.checkNotNullParameter(engineRequest, "engineRequest");
        this.f9047b = call;
        this.f9048c = pipeline;
        this.f9049d = engineRequest;
    }

    public c(String name, Function0 createConfiguration, Function1 body) {
        KType kTypeTypeOf;
        this.f9046a = 0;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(createConfiguration, "createConfiguration");
        Intrinsics.checkNotNullParameter(body, "body");
        this.f9047b = createConfiguration;
        this.f9048c = body;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(d.class);
        try {
            KTypeProjection.Companion companion = KTypeProjection.INSTANCE;
            KTypeParameter kTypeParameterTypeParameter = Reflection.typeParameter(Reflection.getOrCreateKotlinClass(c.class), "PluginConfigT", KVariance.INVARIANT, false);
            Reflection.setUpperBounds(kTypeParameterTypeParameter, Reflection.typeOf(Object.class));
            kTypeTypeOf = Reflection.typeOf(d.class, companion.invariant(Reflection.typeOf(kTypeParameterTypeParameter)));
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        this.f9049d = new zg.a(name, new ih.a(orCreateKotlinClass, kTypeTypeOf));
    }

    public c(String name, bh.a createConfiguration, Function1 body) {
        KType kTypeTypeOf;
        this.f9046a = 12;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(createConfiguration, "createConfiguration");
        Intrinsics.checkNotNullParameter(body, "body");
        this.f9047b = createConfiguration;
        this.f9048c = body;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(mg.a0.class);
        try {
            kTypeTypeOf = Reflection.typeOf(mg.a0.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        this.f9049d = new zg.a(name, new ih.a(orCreateKotlinClass, kTypeTypeOf));
    }

    public c(w5 w5Var, h0 h0Var) {
        this.f9046a = 3;
        this.f9049d = w5Var;
        this.f9047b = h0Var;
    }

    public c(af.a0 a0Var, f0 f0Var) {
        this.f9046a = 1;
        this.f9049d = a0Var;
        v8.i(f0Var, "observer");
        this.f9047b = f0Var;
    }

    public c(List list, ze.b bVar, Object[][] objArr) {
        this.f9046a = 15;
        v8.i(list, "addresses are not set");
        this.f9047b = list;
        v8.i(bVar, "attrs");
        this.f9048c = bVar;
        v8.i(objArr, "customOptions");
        this.f9049d = objArr;
    }
}

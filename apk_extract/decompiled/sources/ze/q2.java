package ze;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import k3.t8;
import k3.u8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class q2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List f11403d;
    public static final q2 e;
    public static final q2 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q2 f11404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q2 f11405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final q2 f11406i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final q2 f11407j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final q2 f11408k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final q2 f11409l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final q2 f11410m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final q2 f11411n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final n1 f11412o;
    public static final n1 p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o2 f11413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f11415c;

    static {
        Boolean.parseBoolean(System.getProperty("io.grpc.Status.failOnEqualsForTest", "false"));
        TreeMap treeMap = new TreeMap();
        for (o2 o2Var : o2.values()) {
            q2 q2Var = (q2) treeMap.put(Integer.valueOf(o2Var.value()), new q2(o2Var, null, null));
            if (q2Var != null) {
                throw new IllegalStateException("Code value duplication between " + q2Var.f11413a.name() + " & " + o2Var.name());
            }
        }
        f11403d = Collections.unmodifiableList(new ArrayList(treeMap.values()));
        e = o2.OK.toStatus();
        f = o2.CANCELLED.toStatus();
        f11404g = o2.UNKNOWN.toStatus();
        o2.INVALID_ARGUMENT.toStatus();
        f11405h = o2.DEADLINE_EXCEEDED.toStatus();
        o2.NOT_FOUND.toStatus();
        o2.ALREADY_EXISTS.toStatus();
        f11406i = o2.PERMISSION_DENIED.toStatus();
        f11407j = o2.UNAUTHENTICATED.toStatus();
        f11408k = o2.RESOURCE_EXHAUSTED.toStatus();
        o2.FAILED_PRECONDITION.toStatus();
        o2.ABORTED.toStatus();
        o2.OUT_OF_RANGE.toStatus();
        f11409l = o2.UNIMPLEMENTED.toStatus();
        f11410m = o2.INTERNAL.toStatus();
        f11411n = o2.UNAVAILABLE.toStatus();
        o2.DATA_LOSS.toStatus();
        f11412o = new n1("grpc-status", false, new p2(8));
        p = new n1("grpc-message", false, new p2(0));
    }

    public q2(o2 o2Var, String str, Throwable th2) {
        v8.i(o2Var, "code");
        this.f11413a = o2Var;
        this.f11414b = str;
        this.f11415c = th2;
    }

    public static String b(q2 q2Var) {
        String str = q2Var.f11414b;
        o2 o2Var = q2Var.f11413a;
        if (str == null) {
            return o2Var.toString();
        }
        return o2Var + ": " + q2Var.f11414b;
    }

    public static q2 c(int i8) {
        if (i8 >= 0) {
            List list = f11403d;
            if (i8 < list.size()) {
                return (q2) list.get(i8);
            }
        }
        return f11404g.h("Unknown code " + i8);
    }

    public static q2 d(Throwable th2) {
        v8.i(th2, "t");
        for (Throwable cause = th2; cause != null; cause = cause.getCause()) {
            if (cause instanceof r2) {
                return ((r2) cause).getStatus();
            }
            if (cause instanceof s2) {
                return ((s2) cause).getStatus();
            }
        }
        return f11404g.g(th2);
    }

    public static p1 f(Throwable th2) {
        while (th2 != null) {
            if (th2 instanceof r2) {
                return ((r2) th2).getTrailers();
            }
            if (th2 instanceof s2) {
                return ((s2) th2).getTrailers();
            }
            th2 = th2.getCause();
        }
        return null;
    }

    public final q2 a(String str) {
        if (str == null) {
            return this;
        }
        Throwable th2 = this.f11415c;
        o2 o2Var = this.f11413a;
        String str2 = this.f11414b;
        if (str2 == null) {
            return new q2(o2Var, str, th2);
        }
        return new q2(o2Var, str2 + "\n" + str, th2);
    }

    public final boolean e() {
        return o2.OK == this.f11413a;
    }

    public final q2 g(Throwable th2) {
        return u8.a(this.f11415c, th2) ? this : new q2(this.f11413a, this.f11414b, th2);
    }

    public final q2 h(String str) {
        return u8.a(this.f11414b, str) ? this : new q2(this.f11413a, str, this.f11415c);
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f11413a.name(), "code");
        aVarA.d(this.f11414b, "description");
        Throwable th2 = this.f11415c;
        Object string = th2;
        if (th2 != null) {
            Object obj = h4.v.f5259a;
            StringWriter stringWriter = new StringWriter();
            th2.printStackTrace(new PrintWriter(stringWriter));
            string = stringWriter.toString();
        }
        aVarA.d(string, "cause");
        return aVarA.toString();
    }
}

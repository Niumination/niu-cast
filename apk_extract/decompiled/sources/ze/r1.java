package ze;

import com.transsion.message.bank.MessageBank;
import java.util.concurrent.atomic.AtomicReferenceArray;
import k3.t8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f11422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final gf.b f11425d;
    public final gf.b e;
    public final boolean f;

    public r1(q1 q1Var, String str, gf.b bVar, gf.b bVar2, boolean z2) {
        new AtomicReferenceArray(2);
        v8.i(q1Var, MessageBank.KEY_TYPE);
        this.f11422a = q1Var;
        v8.i(str, "fullMethodName");
        this.f11423b = str;
        int iLastIndexOf = str.lastIndexOf(47);
        this.f11424c = iLastIndexOf == -1 ? null : str.substring(0, iLastIndexOf);
        v8.i(bVar, "requestMarshaller");
        this.f11425d = bVar;
        v8.i(bVar2, "responseMarshaller");
        this.e = bVar2;
        this.f = z2;
    }

    public static String a(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        v8.i(str, "fullServiceName");
        sb2.append(str);
        sb2.append("/");
        v8.i(str2, "methodName");
        sb2.append(str2);
        return sb2.toString();
    }

    public static e8.b b() {
        e8.b bVar = new e8.b();
        bVar.f4715b = null;
        bVar.f4716c = null;
        return bVar;
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f11423b, "fullMethodName");
        aVarA.d(this.f11422a, MessageBank.KEY_TYPE);
        aVarA.f("idempotent", false);
        aVarA.f("safe", false);
        aVarA.f("sampledToLocalTracing", this.f);
        aVarA.d(this.f11425d, "requestMarshaller");
        aVarA.d(this.e, "responseMarshaller");
        aVarA.d(null, "schemaDescriptor");
        aVarA.f8408c = true;
        return aVarA.toString();
    }
}

package ak;

import af.y3;
import d5.d;
import dj.f0;
import dj.x;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import k3.w1;
import kotlin.jvm.internal.Intrinsics;
import qj.f;
import v4.p0;
import v4.q;
import zj.j;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f802d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p0 f804b;

    static {
        Pattern pattern = x.f4641d;
        f801c = w1.a("application/json; charset=UTF-8");
        f802d = Charset.forName("UTF-8");
    }

    public b(q qVar, p0 p0Var) {
        this.f803a = qVar;
        this.f804b = p0Var;
    }

    @Override // zj.j
    public final Object convert(Object obj) throws IOException {
        f fVar = new f();
        d dVarNewJsonWriter = this.f803a.newJsonWriter(new OutputStreamWriter(new y3(fVar, 1), f802d));
        this.f804b.write(dVarNewJsonWriter, obj);
        dVarNewJsonWriter.close();
        qj.j toRequestBody = fVar.o(fVar.f9195b);
        Intrinsics.checkNotNullParameter(toRequestBody, "content");
        Intrinsics.checkNotNullParameter(toRequestBody, "$this$toRequestBody");
        return new f0(toRequestBody, f801c, 0);
    }
}

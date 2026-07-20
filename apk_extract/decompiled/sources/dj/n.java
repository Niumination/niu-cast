package dj;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import k3.w1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f4614c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f4615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f4616b;

    static {
        Pattern pattern = x.f4641d;
        f4614c = w1.a("application/x-www-form-urlencoded");
    }

    public n(ArrayList encodedNames, ArrayList encodedValues) {
        Intrinsics.checkNotNullParameter(encodedNames, "encodedNames");
        Intrinsics.checkNotNullParameter(encodedValues, "encodedValues");
        this.f4615a = ej.b.w(encodedNames);
        this.f4616b = ej.b.w(encodedValues);
    }

    @Override // dj.h0
    public final long a() {
        return d(null, true);
    }

    @Override // dj.h0
    public final x b() {
        return f4614c;
    }

    @Override // dj.h0
    public final void c(qj.g sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        d(sink, false);
    }

    public final long d(qj.g gVar, boolean z2) throws EOFException {
        qj.f buffer;
        if (z2) {
            buffer = new qj.f();
        } else {
            Intrinsics.checkNotNull(gVar);
            buffer = gVar.getBuffer();
        }
        List list = this.f4615a;
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (i8 > 0) {
                buffer.S(38);
            }
            buffer.m0((String) list.get(i8));
            buffer.S(61);
            buffer.m0((String) this.f4616b.get(i8));
        }
        if (!z2) {
            return 0L;
        }
        long j8 = buffer.f9195b;
        buffer.a();
        return j8;
    }
}

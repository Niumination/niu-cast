package ij;

import dj.e0;
import dj.j0;
import dj.m;
import dj.v;
import dj.w;
import hj.i;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f5878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f5879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5880d;
    public final m e;
    public final e0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f5881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f5882h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f5883i;

    public f(i call, ArrayList interceptors, int i8, m mVar, e0 request, int i9, int i10, int i11) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(request, "request");
        this.f5878b = call;
        this.f5879c = interceptors;
        this.f5880d = i8;
        this.e = mVar;
        this.f = request;
        this.f5881g = i9;
        this.f5882h = i10;
        this.f5883i = i11;
    }

    public static f a(f fVar, int i8, m mVar, e0 e0Var, int i9) {
        if ((i9 & 1) != 0) {
            i8 = fVar.f5880d;
        }
        int i10 = i8;
        if ((i9 & 2) != 0) {
            mVar = fVar.e;
        }
        m mVar2 = mVar;
        if ((i9 & 4) != 0) {
            e0Var = fVar.f;
        }
        e0 request = e0Var;
        int i11 = fVar.f5881g;
        int i12 = fVar.f5882h;
        int i13 = fVar.f5883i;
        fVar.getClass();
        Intrinsics.checkNotNullParameter(request, "request");
        return new f(fVar.f5878b, fVar.f5879c, i10, mVar2, request, i11, i12, i13);
    }

    public final j0 b(e0 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ArrayList arrayList = this.f5879c;
        int size = arrayList.size();
        int i8 = this.f5880d;
        if (i8 >= size) {
            throw new IllegalStateException("Check failed.");
        }
        this.f5877a++;
        m mVar = this.e;
        if (mVar != null) {
            if (!((hj.e) mVar.f4611c).b(request.f4528b)) {
                throw new IllegalStateException(("network interceptor " + ((w) arrayList.get(i8 - 1)) + " must retain the same host and port").toString());
            }
            if (this.f5877a != 1) {
                throw new IllegalStateException(("network interceptor " + ((w) arrayList.get(i8 - 1)) + " must call proceed() exactly once").toString());
            }
        }
        int i9 = i8 + 1;
        f fVarA = a(this, i9, null, request, 58);
        w wVar = (w) arrayList.get(i8);
        j0 j0VarIntercept = wVar.intercept(fVarA);
        if (j0VarIntercept == null) {
            throw new NullPointerException("interceptor " + wVar + " returned null");
        }
        if (mVar != null && i9 < arrayList.size() && fVarA.f5877a != 1) {
            throw new IllegalStateException(("network interceptor " + wVar + " must call proceed() exactly once").toString());
        }
        if (j0VarIntercept.f4581i != null) {
            return j0VarIntercept;
        }
        throw new IllegalStateException(("interceptor " + wVar + " returned a response with no body").toString());
    }
}

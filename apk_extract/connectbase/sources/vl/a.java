package vl;

import io.netty.handler.codec.rtsp.RtspHeaders;
import kn.l0;
import lm.j0;
import lm.k;
import lm.m;
import lm.z0;
import os.l;
import tl.e;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    @k(level = m.ERROR, message = "Not implemented.")
    @l
    public static final Void a() {
        throw new j0(l0.C("An operation is not implemented: ", "Not implemented."));
    }

    @k(level = m.ERROR, message = "Not implemented.")
    @l
    public static final <R> Void b(R r10) {
        throw new j0(l0.C("An operation is not implemented: ", l0.C("Not implemented. Value is ", r10)));
    }

    public static final void c(@l e eVar, int i10, int i11, int i12) {
        l0.p(eVar, RtspHeaders.Values.DESTINATION);
        if (i10 < 0) {
            throw new IllegalArgumentException(("offset shouldn't be negative: " + i10 + n1.e.f11183c).toString());
        }
        if (i11 < 0) {
            throw new IllegalArgumentException(("min shouldn't be negative: " + i11 + n1.e.f11183c).toString());
        }
        if (i12 < i11) {
            throw new IllegalArgumentException(("max should't be less than min: max = " + i12 + ", min = " + i11 + n1.e.f11183c).toString());
        }
        tl.m mVar = eVar.f15821b;
        if (i11 <= mVar.f15872a - mVar.f15874c) {
            return;
        }
        StringBuilder sbA = h.b.a("Not enough free space in the destination buffer to write the specified minimum number of bytes: min = ", i11, ", free = ");
        tl.m mVar2 = eVar.f15821b;
        sbA.append(mVar2.f15872a - mVar2.f15874c);
        sbA.append(n1.e.f11183c);
        throw new IllegalArgumentException(sbA.toString().toString());
    }

    @z0
    @l
    public static final Void d() {
        throw new Error("This API is no longer supported. Please downgrade kotlinx-io or recompile your project/dependencies with new kotlinx-io.");
    }
}

package tl;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends u {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15881e;

    public static final class a extends ul.h {
        public a() {
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("shouldn't be negative: headerSizeHint = ", Integer.valueOf(s.this.f15881e)));
        }
    }

    public /* synthetic */ s(int i10, bm.h hVar, int i11, kn.w wVar) {
        this((i11 & 1) != 0 ? 0 : i10, hVar);
    }

    @lm.z0
    public static /* synthetic */ void C2() {
    }

    public final int A2() {
        return P0();
    }

    @os.l
    public final bm.h<ul.b> B2() {
        return this.f15806b;
    }

    public final boolean D2() {
        return P0() == 0;
    }

    public final boolean E2() {
        return P0() > 0;
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ Object F2(jn.l lVar) {
        kn.l0.p(lVar, "block");
        v vVarB = y0.b(this);
        try {
            return lVar.invoke(vVarB);
        } finally {
            vVarB.z2();
        }
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    @lm.z0
    public final /* synthetic */ v G2() {
        return y0.b(this);
    }

    @Override // tl.c
    public final void O() {
    }

    @Override // tl.c, java.lang.Appendable
    public Appendable append(char c10) {
        return (s) super.append(c10);
    }

    @Override // tl.c
    public final void b0(@os.l ByteBuffer byteBuffer, int i10, int i11) {
        kn.l0.p(byteBuffer, "source");
    }

    @Override // tl.c
    /* JADX INFO: renamed from: h */
    public c append(char c10) {
        return (s) super.append(c10);
    }

    @Override // tl.c
    /* JADX INFO: renamed from: k */
    public c append(CharSequence charSequence) {
        return (s) super.append(charSequence);
    }

    @Override // tl.c
    /* JADX INFO: renamed from: n */
    public c append(CharSequence charSequence, int i10, int i11) {
        return (s) super.append(charSequence, i10, i11);
    }

    @Override // tl.c
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final void reset() {
        close();
    }

    @os.l
    public s t2(char c10) {
        return (s) super.append(c10);
    }

    @os.l
    public String toString() {
        return "BytePacketBuilder(" + P0() + " bytes written)";
    }

    @os.l
    public s u2(@os.m CharSequence charSequence) {
        return (s) super.append(charSequence);
    }

    @os.l
    public s v2(@os.m CharSequence charSequence, int i10, int i11) {
        return (s) super.append(charSequence, i10, i11);
    }

    @in.i(name = RtspHeaders.Values.APPEND)
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final t w2(char c10) {
        return (s) super.append(c10);
    }

    @in.i(name = RtspHeaders.Values.APPEND)
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final t x2(CharSequence charSequence) {
        return (s) super.append(charSequence);
    }

    @in.i(name = RtspHeaders.Values.APPEND)
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public final t y2(CharSequence charSequence, int i10, int i11) {
        return (s) super.append(charSequence, i10, i11);
    }

    @os.l
    public final v z2() {
        int iP0 = P0();
        ul.b bVarH2 = h2();
        if (bVarH2 != null) {
            return new v(bVarH2, iP0, this.f15806b);
        }
        v.f15884f.getClass();
        return v.f15885g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(int i10, @os.l bm.h<ul.b> hVar) {
        super(hVar);
        kn.l0.p(hVar, "pool");
        this.f15881e = i10;
        if (i10 >= 0) {
            return;
        }
        new a().a();
        throw new lm.y();
    }

    @Override // tl.c, java.lang.Appendable
    public Appendable append(CharSequence charSequence) {
        return (s) super.append(charSequence);
    }

    @Override // tl.c, java.lang.Appendable
    public Appendable append(CharSequence charSequence, int i10, int i11) {
        return (s) super.append(charSequence, i10, i11);
    }
}

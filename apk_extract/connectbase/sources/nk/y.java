package nk;

import ik.r0;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import jq.j0;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends s.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f11559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final ik.i f11560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public final r0 f11561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final byte[] f11562e;

    public /* synthetic */ y(String str, ik.i iVar, r0 r0Var, int i10, kn.w wVar) {
        this(str, iVar, (i10 & 4) != 0 ? null : r0Var);
    }

    @Override // nk.s
    @os.l
    public Long b() {
        return Long.valueOf(this.f11562e.length);
    }

    @Override // nk.s
    @os.l
    public ik.i c() {
        return this.f11560c;
    }

    @Override // nk.s
    @os.m
    public r0 g() {
        return this.f11561d;
    }

    @Override // nk.s.a
    @os.l
    public byte[] j() {
        return this.f11562e;
    }

    @os.l
    public final String k() {
        return this.f11559b;
    }

    @os.l
    public String toString() {
        return "TextContent[" + this.f11560c + "] \"" + j0.V8(this.f11559b, 30) + '\"';
    }

    public y(@os.l String str, @os.l ik.i iVar, @os.m r0 r0Var) {
        l0.p(str, "text");
        l0.p(iVar, "contentType");
        this.f11559b = str;
        this.f11560c = iVar;
        this.f11561d = r0Var;
        Charset charsetA = ik.k.a(iVar);
        CharsetEncoder charsetEncoderNewEncoder = (charsetA == null ? jq.f.f8800b : charsetA).newEncoder();
        l0.o(charsetEncoderNewEncoder, "charset.newEncoder()");
        this.f11562e = rl.a.j(charsetEncoderNewEncoder, str, 0, str.length());
    }
}

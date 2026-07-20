package tl;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import lm.a2;
import lm.g2;
import lm.l2;
import lm.s1;
import lm.w1;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    public static final class a extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15835a;

        public a(int i10) {
            this.f15835a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("offset shouldn't be negative: ", Integer.valueOf(this.f15835a)));
        }
    }

    public static final class b extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15836a;

        public b(int i10) {
            this.f15836a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("length shouldn't be negative: ", Integer.valueOf(this.f15836a)));
        }
    }

    public static final class c extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long[] f15839c;

        public c(int i10, int i11, long[] jArr) {
            this.f15837a = i10;
            this.f15838b = i11;
            this.f15839c = jArr;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException("offset + length should be less than the destination size: " + this.f15837a + " + " + this.f15838b + " > " + this.f15839c.length);
        }
    }

    public static final class d extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15840a;

        public d(int i10) {
            this.f15840a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("offset shouldn't be negative: ", Integer.valueOf(this.f15840a)));
        }
    }

    public static final class e extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15841a;

        public e(int i10) {
            this.f15841a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("length shouldn't be negative: ", Integer.valueOf(this.f15841a)));
        }
    }

    public static final class f extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15843b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float[] f15844c;

        public f(int i10, int i11, float[] fArr) {
            this.f15842a = i10;
            this.f15843b = i11;
            this.f15844c = fArr;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException("offset + length should be less than the destination size: " + this.f15842a + " + " + this.f15843b + " > " + this.f15844c.length);
        }
    }

    public static final class g extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15845a;

        public g(int i10) {
            this.f15845a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("offset shouldn't be negative: ", Integer.valueOf(this.f15845a)));
        }
    }

    public static final class h extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15846a;

        public h(int i10) {
            this.f15846a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("length shouldn't be negative: ", Integer.valueOf(this.f15846a)));
        }
    }

    public static final class i extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ double[] f15849c;

        public i(int i10, int i11, double[] dArr) {
            this.f15847a = i10;
            this.f15848b = i11;
            this.f15849c = dArr;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException("offset + length should be less than the destination size: " + this.f15847a + " + " + this.f15848b + " > " + this.f15849c.length);
        }
    }

    public static final class j extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15850a;

        public j(int i10) {
            this.f15850a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("offset shouldn't be negative: ", Integer.valueOf(this.f15850a)));
        }
    }

    public static final class k extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15851a;

        public k(int i10) {
            this.f15851a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("length shouldn't be negative: ", Integer.valueOf(this.f15851a)));
        }
    }

    /* JADX INFO: renamed from: tl.l$l, reason: collision with other inner class name */
    public static final class C0408l extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f15854c;

        public C0408l(int i10, int i11, byte[] bArr) {
            this.f15852a = i10;
            this.f15853b = i11;
            this.f15854c = bArr;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException("offset + length should be less than the destination size: " + this.f15852a + " + " + this.f15853b + " > " + this.f15854c.length);
        }
    }

    public static final class m extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15855a;

        public m(int i10) {
            this.f15855a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("offset shouldn't be negative: ", Integer.valueOf(this.f15855a)));
        }
    }

    public static final class n extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15856a;

        public n(int i10) {
            this.f15856a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("length shouldn't be negative: ", Integer.valueOf(this.f15856a)));
        }
    }

    public static final class o extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ short[] f15859c;

        public o(int i10, int i11, short[] sArr) {
            this.f15857a = i10;
            this.f15858b = i11;
            this.f15859c = sArr;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException("offset + length should be less than the destination size: " + this.f15857a + " + " + this.f15858b + " > " + this.f15859c.length);
        }
    }

    public static final class p extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15860a;

        public p(int i10) {
            this.f15860a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("offset shouldn't be negative: ", Integer.valueOf(this.f15860a)));
        }
    }

    public static final class q extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15861a;

        public q(int i10) {
            this.f15861a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("length shouldn't be negative: ", Integer.valueOf(this.f15861a)));
        }
    }

    public static final class r extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int[] f15864c;

        public r(int i10, int i11, int[] iArr) {
            this.f15862a = i10;
            this.f15863b = i11;
            this.f15864c = iArr;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException("offset + length should be less than the destination size: " + this.f15862a + " + " + this.f15863b + " > " + this.f15864c.length);
        }
    }

    public static final class s extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15866b;

        public s(String str, int i10) {
            this.f15865a = str;
            this.f15866b = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() throws EOFException {
            StringBuilder sb2 = new StringBuilder("Not enough bytes to read a ");
            sb2.append(this.f15865a);
            sb2.append(" of size ");
            throw new EOFException(u.a.a(sb2, this.f15866b, n1.e.f11183c));
        }
    }

    public static final class t extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15867a;

        public t(int i10) {
            this.f15867a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("length shouldn't be negative: ", Integer.valueOf(this.f15867a)));
        }
    }

    public static final class u extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ tl.e f15869b;

        public u(int i10, tl.e eVar) {
            this.f15868a = i10;
            this.f15869b = eVar;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            StringBuilder sb2 = new StringBuilder("length shouldn't be greater than the source read remaining: ");
            sb2.append(this.f15868a);
            sb2.append(" > ");
            tl.m mVar = this.f15869b.f15821b;
            sb2.append(mVar.f15874c - mVar.f15873b);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public static final class v extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ tl.e f15871b;

        public v(int i10, tl.e eVar) {
            this.f15870a = i10;
            this.f15871b = eVar;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            StringBuilder sb2 = new StringBuilder("length shouldn't be greater than the destination write remaining space: ");
            sb2.append(this.f15870a);
            sb2.append(" > ");
            tl.m mVar = this.f15871b.f15821b;
            sb2.append(mVar.f15872a - mVar.f15874c);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final double A(@os.l o0 o0Var) {
        kn.l0.p(o0Var, "<this>");
        return z(o0Var);
    }

    public static final void A0(@os.l tl.e eVar, @os.l int[] iArr, int i10, int i11) throws n0 {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(iArr, "source");
        int i12 = i11 * 4;
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i13 = mVar.f15874c;
        int i14 = mVar.f15872a - i13;
        if (i14 < i12) {
            throw new n0("integers array", i12, i14);
        }
        ql.n.C(byteBuffer, i13, iArr, i10, i11);
        eVar.b(i12);
    }

    @lm.z0
    public static final <R> R B(@os.l tl.e eVar, int i10, @os.l String str, @os.l jn.p<? super ql.f, ? super Integer, ? extends R> pVar) throws EOFException {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(str, "name");
        kn.l0.p(pVar, "block");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i11 = mVar.f15873b;
        if (!(mVar.f15874c - i11 >= i10)) {
            new s(str, i10).a();
            throw new lm.y();
        }
        R rInvoke = pVar.invoke(ql.f.b(byteBuffer), Integer.valueOf(i11));
        eVar.h(i10);
        return rInvoke;
    }

    public static final void B0(@os.l tl.e eVar, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(jArr, "source");
        int i12 = i11 * 8;
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i13 = mVar.f15874c;
        int i14 = mVar.f15872a - i13;
        if (i14 < i12) {
            throw new n0("long integers array", i12, i14);
        }
        ql.n.I(byteBuffer, i13, jArr, i10, i11);
        eVar.b(i12);
    }

    public static final float C(@os.l tl.e eVar) {
        kn.l0.p(eVar, "<this>");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        if (!(mVar.f15874c - i10 >= 4)) {
            new s("floating point number", 4).a();
            throw new lm.y();
        }
        Float fValueOf = Float.valueOf(byteBuffer.getFloat(i10));
        eVar.h(4);
        return fValueOf.floatValue();
    }

    public static final void C0(@os.l tl.e eVar, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(sArr, "source");
        int i12 = i11 * 2;
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i13 = mVar.f15874c;
        int i14 = mVar.f15872a - i13;
        if (i14 < i12) {
            throw new n0("short integers array", i12, i14);
        }
        ql.n.K(byteBuffer, i13, sArr, i10, i11);
        eVar.b(i12);
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final float D(@os.l o0 o0Var) {
        kn.l0.p(o0Var, "<this>");
        return C(o0Var);
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    public static final void D0(@os.l o0 o0Var, @os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(bArr, "source");
        x0(o0Var, bArr, i10, i11);
    }

    public static final int E(@os.l tl.e eVar, @os.l tl.e eVar2, int i10) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(eVar2, "dst");
        if (i10 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        tl.m mVar = eVar2.f15821b;
        int i11 = mVar.f15872a;
        int i12 = mVar.f15874c;
        if (i10 > i11 - i12) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar2 = eVar.f15821b;
        int i13 = mVar2.f15873b;
        if (!(mVar2.f15874c - i13 >= i10)) {
            new s("buffer content", i10).a();
            throw new lm.y();
        }
        ql.f.d(byteBuffer, eVar2.f15820a, i13, i10, i12);
        eVar2.b(i10);
        l2 l2Var = l2.f10208a;
        eVar.h(i10);
        return i10;
    }

    public static /* synthetic */ void E0(tl.e eVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        x0(eVar, bArr, i10, i11);
    }

    public static final void F(@os.l tl.e eVar, @os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(bArr, RtspHeaders.Values.DESTINATION);
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i12 = mVar.f15873b;
        if (!(mVar.f15874c - i12 >= i11)) {
            new s("byte array", i11).a();
            throw new lm.y();
        }
        ql.i.a(byteBuffer, bArr, i12, i11, i10);
        l2 l2Var = l2.f10208a;
        eVar.h(i11);
    }

    public static /* synthetic */ void F0(tl.e eVar, double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length - i10;
        }
        y0(eVar, dArr, i10, i11);
    }

    public static final void G(@os.l tl.e eVar, @os.l double[] dArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(dArr, RtspHeaders.Values.DESTINATION);
        int i12 = i11 * 8;
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i13 = mVar.f15873b;
        if (!(mVar.f15874c - i13 >= i12)) {
            new s("floating point numbers array", i12).a();
            throw new lm.y();
        }
        ql.n.a(byteBuffer, i13, dArr, i10, i11);
        l2 l2Var = l2.f10208a;
        eVar.h(i12);
    }

    public static /* synthetic */ void G0(tl.e eVar, float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length - i10;
        }
        z0(eVar, fArr, i10, i11);
    }

    public static final void H(@os.l tl.e eVar, @os.l float[] fArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(fArr, RtspHeaders.Values.DESTINATION);
        int i12 = i11 * 4;
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i13 = mVar.f15873b;
        if (!(mVar.f15874c - i13 >= i12)) {
            new s("floating point numbers array", i12).a();
            throw new lm.y();
        }
        ql.n.e(byteBuffer, i13, fArr, i10, i11);
        l2 l2Var = l2.f10208a;
        eVar.h(i12);
    }

    public static /* synthetic */ void H0(tl.e eVar, int[] iArr, int i10, int i11, int i12, Object obj) throws n0 {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        A0(eVar, iArr, i10, i11);
    }

    public static final void I(@os.l tl.e eVar, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(iArr, RtspHeaders.Values.DESTINATION);
        int i12 = i11 * 4;
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i13 = mVar.f15873b;
        if (!(mVar.f15874c - i13 >= i12)) {
            new s("integers array", i12).a();
            throw new lm.y();
        }
        ql.n.i(byteBuffer, i13, iArr, i10, i11);
        l2 l2Var = l2.f10208a;
        eVar.h(i12);
    }

    public static /* synthetic */ void I0(tl.e eVar, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        B0(eVar, jArr, i10, i11);
    }

    public static final void J(@os.l tl.e eVar, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(jArr, RtspHeaders.Values.DESTINATION);
        int i12 = i11 * 8;
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i13 = mVar.f15873b;
        if (!(mVar.f15874c - i13 >= i12)) {
            new s("long integers array", i12).a();
            throw new lm.y();
        }
        ql.n.o(byteBuffer, i13, jArr, i10, i11);
        l2 l2Var = l2.f10208a;
        eVar.h(i12);
    }

    public static /* synthetic */ void J0(tl.e eVar, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        C0(eVar, sArr, i10, i11);
    }

    public static final void K(@os.l tl.e eVar, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(sArr, RtspHeaders.Values.DESTINATION);
        int i12 = i11 * 2;
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i13 = mVar.f15873b;
        if (!(mVar.f15874c - i13 >= i12)) {
            new s("short integers array", i12).a();
            throw new lm.y();
        }
        ql.n.q(byteBuffer, i13, sArr, i10, i11);
        l2 l2Var = l2.f10208a;
        eVar.h(i12);
    }

    public static /* synthetic */ void K0(o0 o0Var, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(bArr, "source");
        x0(o0Var, bArr, i10, i11);
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final void L(@os.l o0 o0Var, @os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(bArr, RtspHeaders.Values.DESTINATION);
        F(o0Var, bArr, i10, i11);
    }

    public static final void L0(@os.l tl.e eVar, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$writeFully");
        kn.l0.p(sArr, "source");
        C0(eVar, sArr, i10, i11);
    }

    public static int M(tl.e eVar, tl.e eVar2, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            tl.m mVar = eVar2.f15821b;
            i10 = mVar.f15872a - mVar.f15874c;
        }
        return E(eVar, eVar2, i10);
    }

    public static void M0(tl.e eVar, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        L0(eVar, sArr, i10, i11);
    }

    public static /* synthetic */ void N(tl.e eVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        F(eVar, bArr, i10, i11);
    }

    public static final void N0(@os.l tl.e eVar, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$writeFully");
        kn.l0.p(jArr, "source");
        B0(eVar, jArr, i10, i11);
    }

    public static /* synthetic */ void O(tl.e eVar, double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length - i10;
        }
        G(eVar, dArr, i10, i11);
    }

    public static void O0(tl.e eVar, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        N0(eVar, jArr, i10, i11);
    }

    public static /* synthetic */ void P(tl.e eVar, float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length - i10;
        }
        H(eVar, fArr, i10, i11);
    }

    public static final void P0(@os.l tl.e eVar, @os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$writeFully");
        kn.l0.p(bArr, "source");
        x0(eVar, bArr, i10, i11);
    }

    public static /* synthetic */ void Q(tl.e eVar, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        I(eVar, iArr, i10, i11);
    }

    public static void Q0(tl.e eVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        P0(eVar, bArr, i10, i11);
    }

    public static /* synthetic */ void R(tl.e eVar, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        J(eVar, jArr, i10, i11);
    }

    public static final void R0(@os.l tl.e eVar, @os.l int[] iArr, int i10, int i11) throws n0 {
        kn.l0.p(eVar, "$this$writeFully");
        kn.l0.p(iArr, "source");
        A0(eVar, iArr, i10, i11);
    }

    public static /* synthetic */ void S(tl.e eVar, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        K(eVar, sArr, i10, i11);
    }

    public static void S0(tl.e eVar, int[] iArr, int i10, int i11, int i12, Object obj) throws n0 {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        R0(eVar, iArr, i10, i11);
    }

    public static /* synthetic */ void T(o0 o0Var, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(bArr, RtspHeaders.Values.DESTINATION);
        F(o0Var, bArr, i10, i11);
    }

    public static final void T0(@os.l tl.e eVar, int i10) {
        kn.l0.p(eVar, "<this>");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i11 = mVar.f15874c;
        int i12 = mVar.f15872a - i11;
        if (i12 < 4) {
            throw new n0("regular integer", 4, i12);
        }
        byteBuffer.putInt(i11, i10);
        eVar.b(4);
    }

    public static final void U(@os.l tl.e eVar, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$readFully");
        kn.l0.p(sArr, RtspHeaders.Values.DESTINATION);
        K(eVar, sArr, i10, i11);
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    public static final void U0(@os.l o0 o0Var, int i10) {
        kn.l0.p(o0Var, "<this>");
        T0(o0Var, i10);
    }

    public static void V(tl.e eVar, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        U(eVar, sArr, i10, i11);
    }

    public static final void V0(@os.l tl.e eVar, long j10) {
        kn.l0.p(eVar, "<this>");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15874c;
        int i11 = mVar.f15872a - i10;
        if (i11 < 8) {
            throw new n0("long integer", 8, i11);
        }
        byteBuffer.putLong(i10, j10);
        eVar.b(8);
    }

    public static final void W(@os.l tl.e eVar, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$readFully");
        kn.l0.p(jArr, RtspHeaders.Values.DESTINATION);
        J(eVar, jArr, i10, i11);
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    public static final void W0(@os.l o0 o0Var, long j10) {
        kn.l0.p(o0Var, "<this>");
        V0(o0Var, j10);
    }

    public static void X(tl.e eVar, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        W(eVar, jArr, i10, i11);
    }

    public static final void X0(@os.l tl.e eVar, short s10) {
        kn.l0.p(eVar, "<this>");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15874c;
        int i11 = mVar.f15872a - i10;
        if (i11 < 2) {
            throw new n0("short integer", 2, i11);
        }
        byteBuffer.putShort(i10, s10);
        eVar.b(2);
    }

    public static final void Y(@os.l tl.e eVar, @os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$readFully");
        kn.l0.p(bArr, RtspHeaders.Values.DESTINATION);
        F(eVar, bArr, i10, i11);
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    public static final void Y0(@os.l o0 o0Var, short s10) {
        kn.l0.p(o0Var, "<this>");
        X0(o0Var, s10);
    }

    public static void Z(tl.e eVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        Y(eVar, bArr, i10, i11);
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    public static final void Z0(@os.l o0 o0Var, byte b10) throws n0 {
        kn.l0.p(o0Var, "$this$writeUByte");
        a1(o0Var, b10);
    }

    @f0
    public static final void a(@os.l tl.e eVar, @os.l jn.l<? super Byte, l2> lVar) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(lVar, "block");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        int i11 = mVar.f15874c;
        for (int i12 = i10; i12 < i11; i12++) {
            lVar.invoke(Byte.valueOf(byteBuffer.get(i12)));
        }
        eVar.h(i11 - i10);
    }

    public static final void a0(@os.l tl.e eVar, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$readFully");
        kn.l0.p(iArr, RtspHeaders.Values.DESTINATION);
        I(eVar, iArr, i10, i11);
    }

    public static final void a1(@os.l tl.e eVar, byte b10) throws n0 {
        kn.l0.p(eVar, "$this$writeUByte");
        eVar.d1(b10);
    }

    public static final int b(@os.l tl.e eVar, @os.l tl.e eVar2, int i10) throws EOFException {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(eVar2, "dst");
        tl.m mVar = eVar.f15821b;
        int i11 = mVar.f15874c;
        int i12 = mVar.f15873b;
        if (i11 <= i12) {
            return -1;
        }
        tl.m mVar2 = eVar2.f15821b;
        int iMin = Math.min(mVar2.f15872a - mVar2.f15874c, Math.min(i11 - i12, i10));
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar3 = eVar.f15821b;
        int i13 = mVar3.f15873b;
        if (!(mVar3.f15874c - i13 >= iMin)) {
            new s("buffer content", iMin).a();
            throw new lm.y();
        }
        ql.f.d(byteBuffer, eVar2.f15820a, i13, iMin, eVar2.f15821b.f15874c);
        eVar2.b(iMin);
        l2 l2Var = l2.f10208a;
        eVar.h(iMin);
        return iMin;
    }

    public static void b0(tl.e eVar, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        a0(eVar, iArr, i10, i11);
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    public static final void b1(@os.l o0 o0Var, int i10) throws n0 {
        kn.l0.p(o0Var, "$this$writeUInt");
        c1(o0Var, i10);
    }

    public static final int c(@os.l tl.e eVar, @os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(bArr, RtspHeaders.Values.DESTINATION);
        if (!(i10 >= 0)) {
            new j(i10).a();
            throw new lm.y();
        }
        if (!(i11 >= 0)) {
            new k(i11).a();
            throw new lm.y();
        }
        if (!(i10 + i11 <= bArr.length)) {
            new C0408l(i10, i11, bArr).a();
            throw new lm.y();
        }
        tl.m mVar = eVar.f15821b;
        int i12 = mVar.f15874c;
        int i13 = mVar.f15873b;
        if (i12 <= i13) {
            return -1;
        }
        int iMin = Math.min(i11, i12 - i13);
        F(eVar, bArr, i10, iMin);
        return iMin;
    }

    public static final int c0(@os.l tl.e eVar) {
        kn.l0.p(eVar, "<this>");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        if (!(mVar.f15874c - i10 >= 4)) {
            new s("regular integer", 4).a();
            throw new lm.y();
        }
        Integer numValueOf = Integer.valueOf(byteBuffer.getInt(i10));
        eVar.h(4);
        return numValueOf.intValue();
    }

    public static final void c1(@os.l tl.e eVar, int i10) throws n0 {
        kn.l0.p(eVar, "$this$writeUInt");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i11 = mVar.f15874c;
        int i12 = mVar.f15872a - i11;
        if (i12 < 4) {
            throw new n0("regular unsigned integer", 4, i12);
        }
        byteBuffer.putInt(i11, i10);
        eVar.b(4);
    }

    public static final int d(@os.l tl.e eVar, @os.l double[] dArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(dArr, RtspHeaders.Values.DESTINATION);
        if (!(i10 >= 0)) {
            new g(i10).a();
            throw new lm.y();
        }
        if (!(i11 >= 0)) {
            new h(i11).a();
            throw new lm.y();
        }
        if (!(i10 + i11 <= dArr.length)) {
            new i(i10, i11, dArr).a();
            throw new lm.y();
        }
        tl.m mVar = eVar.f15821b;
        int i12 = mVar.f15874c;
        int i13 = mVar.f15873b;
        if (i12 <= i13) {
            return -1;
        }
        int iMin = Math.min(i11 / 8, i12 - i13);
        G(eVar, dArr, i10, iMin);
        return iMin;
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final int d0(@os.l o0 o0Var) {
        kn.l0.p(o0Var, "<this>");
        return c0(o0Var);
    }

    public static final void d1(@os.l tl.e eVar, long j10) throws n0 {
        kn.l0.p(eVar, "$this$writeULong");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15874c;
        int i11 = mVar.f15872a - i10;
        if (i11 < 8) {
            throw new n0("long unsigned integer", 8, i11);
        }
        byteBuffer.putLong(i10, j10);
        eVar.b(8);
    }

    public static final int e(@os.l tl.e eVar, @os.l float[] fArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(fArr, RtspHeaders.Values.DESTINATION);
        if (!(i10 >= 0)) {
            new d(i10).a();
            throw new lm.y();
        }
        if (!(i11 >= 0)) {
            new e(i11).a();
            throw new lm.y();
        }
        if (!(i10 + i11 <= fArr.length)) {
            new f(i10, i11, fArr).a();
            throw new lm.y();
        }
        tl.m mVar = eVar.f15821b;
        int i12 = mVar.f15874c;
        int i13 = mVar.f15873b;
        if (i12 <= i13) {
            return -1;
        }
        int iMin = Math.min(i11 / 4, i12 - i13);
        H(eVar, fArr, i10, iMin);
        return iMin;
    }

    public static final long e0(@os.l tl.e eVar) {
        kn.l0.p(eVar, "<this>");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        if (!(mVar.f15874c - i10 >= 8)) {
            new s("long integer", 8).a();
            throw new lm.y();
        }
        Long lValueOf = Long.valueOf(byteBuffer.getLong(i10));
        eVar.h(8);
        return lValueOf.longValue();
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    public static final void e1(@os.l o0 o0Var, long j10) throws n0 {
        kn.l0.p(o0Var, "$this$writeULong");
        d1(o0Var, j10);
    }

    public static final int f(@os.l tl.e eVar, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(iArr, RtspHeaders.Values.DESTINATION);
        if (!(i10 >= 0)) {
            new p(i10).a();
            throw new lm.y();
        }
        if (!(i11 >= 0)) {
            new q(i11).a();
            throw new lm.y();
        }
        if (!(i10 + i11 <= iArr.length)) {
            new r(i10, i11, iArr).a();
            throw new lm.y();
        }
        tl.m mVar = eVar.f15821b;
        int i12 = mVar.f15874c;
        int i13 = mVar.f15873b;
        if (i12 <= i13) {
            return -1;
        }
        int iMin = Math.min(i11 / 4, i12 - i13);
        I(eVar, iArr, i10, iMin);
        return iMin;
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final long f0(@os.l o0 o0Var) {
        kn.l0.p(o0Var, "<this>");
        return e0(o0Var);
    }

    public static final void f1(@os.l tl.e eVar, short s10) throws n0 {
        kn.l0.p(eVar, "$this$writeUShort");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15874c;
        int i11 = mVar.f15872a - i10;
        if (i11 < 2) {
            throw new n0("short unsigned integer", 2, i11);
        }
        byteBuffer.putShort(i10, s10);
        eVar.b(2);
    }

    public static final int g(@os.l tl.e eVar, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(jArr, RtspHeaders.Values.DESTINATION);
        if (!(i10 >= 0)) {
            new a(i10).a();
            throw new lm.y();
        }
        if (!(i11 >= 0)) {
            new b(i11).a();
            throw new lm.y();
        }
        if (!(i10 + i11 <= jArr.length)) {
            new c(i10, i11, jArr).a();
            throw new lm.y();
        }
        tl.m mVar = eVar.f15821b;
        int i12 = mVar.f15874c;
        int i13 = mVar.f15873b;
        if (i12 <= i13) {
            return -1;
        }
        int iMin = Math.min(i11 / 8, i12 - i13);
        J(eVar, jArr, i10, iMin);
        return iMin;
    }

    public static final short g0(@os.l tl.e eVar) {
        kn.l0.p(eVar, "<this>");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        if (!(mVar.f15874c - i10 >= 2)) {
            new s("short integer", 2).a();
            throw new lm.y();
        }
        Short shValueOf = Short.valueOf(byteBuffer.getShort(i10));
        eVar.h(2);
        return shValueOf.shortValue();
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    public static final void g1(@os.l o0 o0Var, short s10) throws n0 {
        kn.l0.p(o0Var, "$this$writeUShort");
        f1(o0Var, s10);
    }

    public static final int h(@os.l tl.e eVar, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(sArr, RtspHeaders.Values.DESTINATION);
        if (!(i10 >= 0)) {
            new m(i10).a();
            throw new lm.y();
        }
        if (!(i11 >= 0)) {
            new n(i11).a();
            throw new lm.y();
        }
        if (!(i10 + i11 <= sArr.length)) {
            new o(i10, i11, sArr).a();
            throw new lm.y();
        }
        tl.m mVar = eVar.f15821b;
        int i12 = mVar.f15874c;
        int i13 = mVar.f15873b;
        if (i12 <= i13) {
            return -1;
        }
        int iMin = Math.min(i11 / 2, i12 - i13);
        K(eVar, sArr, i10, iMin);
        return iMin;
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final short h0(@os.l o0 o0Var) {
        kn.l0.p(o0Var, "<this>");
        return g0(o0Var);
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final int i(@os.l o0 o0Var, @os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(bArr, RtspHeaders.Values.DESTINATION);
        return c(o0Var, bArr, i10, i11);
    }

    public static final byte i0(@os.l tl.e eVar) {
        kn.l0.p(eVar, "<this>");
        return s1.m(eVar.readByte());
    }

    public static int j(tl.e eVar, tl.e eVar2, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            tl.m mVar = eVar2.f15821b;
            i10 = mVar.f15872a - mVar.f15874c;
        }
        return b(eVar, eVar2, i10);
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final byte j0(@os.l o0 o0Var) {
        kn.l0.p(o0Var, "<this>");
        return i0(o0Var);
    }

    public static /* synthetic */ int k(tl.e eVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        return c(eVar, bArr, i10, i11);
    }

    public static final int k0(@os.l tl.e eVar) throws EOFException {
        kn.l0.p(eVar, "<this>");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        if (!(mVar.f15874c - i10 >= 4)) {
            new s("regular unsigned integer", 4).a();
            throw new lm.y();
        }
        w1 w1Var = new w1(w1.m(byteBuffer.getInt(i10)));
        eVar.h(4);
        return w1Var.f10227a;
    }

    public static /* synthetic */ int l(tl.e eVar, double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length - i10;
        }
        return d(eVar, dArr, i10, i11);
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final int l0(@os.l o0 o0Var) {
        kn.l0.p(o0Var, "<this>");
        return k0(o0Var);
    }

    public static /* synthetic */ int m(tl.e eVar, float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length - i10;
        }
        return e(eVar, fArr, i10, i11);
    }

    public static final long m0(@os.l tl.e eVar) throws EOFException {
        kn.l0.p(eVar, "<this>");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        if (!(mVar.f15874c - i10 >= 8)) {
            new s("long unsigned integer", 8).a();
            throw new lm.y();
        }
        a2 a2Var = new a2(a2.m(byteBuffer.getLong(i10)));
        eVar.h(8);
        return a2Var.f10177a;
    }

    public static /* synthetic */ int n(tl.e eVar, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        return f(eVar, iArr, i10, i11);
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final long n0(@os.l o0 o0Var) {
        kn.l0.p(o0Var, "<this>");
        return m0(o0Var);
    }

    public static /* synthetic */ int o(tl.e eVar, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        return g(eVar, jArr, i10, i11);
    }

    public static final short o0(@os.l tl.e eVar) throws EOFException {
        kn.l0.p(eVar, "<this>");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        if (!(mVar.f15874c - i10 >= 2)) {
            new s("short unsigned integer", 2).a();
            throw new lm.y();
        }
        g2 g2Var = new g2(g2.m(byteBuffer.getShort(i10)));
        eVar.h(2);
        return g2Var.f10193a;
    }

    public static /* synthetic */ int p(tl.e eVar, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        return h(eVar, sArr, i10, i11);
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Input instead.")
    public static final short p0(@os.l o0 o0Var) {
        kn.l0.p(o0Var, "<this>");
        return o0(o0Var);
    }

    public static /* synthetic */ int q(o0 o0Var, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        kn.l0.p(o0Var, "<this>");
        kn.l0.p(bArr, RtspHeaders.Values.DESTINATION);
        return c(o0Var, bArr, i10, i11);
    }

    public static final void q0(@os.l tl.e eVar, double d10) {
        kn.l0.p(eVar, "<this>");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15874c;
        int i11 = mVar.f15872a - i10;
        if (i11 < 8) {
            throw new n0("long floating point number", 8, i11);
        }
        byteBuffer.putDouble(i10, d10);
        eVar.b(8);
    }

    public static final int r(@os.l tl.e eVar, @os.l short[] sArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$readAvailable");
        kn.l0.p(sArr, RtspHeaders.Values.DESTINATION);
        return h(eVar, sArr, i10, i11);
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    public static final void r0(@os.l o0 o0Var, double d10) {
        kn.l0.p(o0Var, "<this>");
        q0(o0Var, d10);
    }

    public static int s(tl.e eVar, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        return r(eVar, sArr, i10, i11);
    }

    @lm.z0
    public static final void s0(@os.l tl.e eVar, int i10, @os.l String str, @os.l jn.p<? super ql.f, ? super Integer, l2> pVar) throws n0 {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(str, "name");
        kn.l0.p(pVar, "block");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i11 = mVar.f15874c;
        int i12 = mVar.f15872a - i11;
        if (i12 < i10) {
            throw new n0(str, i10, i12);
        }
        pVar.invoke(ql.f.b(byteBuffer), Integer.valueOf(i11));
        eVar.b(i10);
    }

    public static final int t(@os.l tl.e eVar, @os.l long[] jArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$readAvailable");
        kn.l0.p(jArr, RtspHeaders.Values.DESTINATION);
        return g(eVar, jArr, i10, i11);
    }

    public static final void t0(@os.l tl.e eVar, float f10) {
        kn.l0.p(eVar, "<this>");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15874c;
        int i11 = mVar.f15872a - i10;
        if (i11 < 4) {
            throw new n0("floating point number", 4, i11);
        }
        byteBuffer.putFloat(i10, f10);
        eVar.b(4);
    }

    public static int u(tl.e eVar, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        return t(eVar, jArr, i10, i11);
    }

    @lm.k(message = "IoBuffer is deprecated. Use Memory or Output instead.")
    public static final void u0(@os.l o0 o0Var, float f10) {
        kn.l0.p(o0Var, "<this>");
        t0(o0Var, f10);
    }

    public static final int v(@os.l tl.e eVar, @os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$readAvailable");
        kn.l0.p(bArr, RtspHeaders.Values.DESTINATION);
        return c(eVar, bArr, i10, i11);
    }

    public static final void v0(@os.l tl.e eVar, @os.l tl.e eVar2) throws n0 {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(eVar2, "src");
        tl.m mVar = eVar2.f15821b;
        int i10 = mVar.f15874c;
        int i11 = mVar.f15873b;
        int i12 = i10 - i11;
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar2 = eVar.f15821b;
        int i13 = mVar2.f15874c;
        int i14 = mVar2.f15872a - i13;
        if (i14 < i12) {
            throw new n0("buffer readable content", i12, i14);
        }
        ql.f.d(eVar2.f15820a, byteBuffer, i11, i12, i13);
        eVar2.h(i12);
        eVar.b(i12);
    }

    public static int w(tl.e eVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        return v(eVar, bArr, i10, i11);
    }

    public static final void w0(@os.l tl.e eVar, @os.l tl.e eVar2, int i10) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(eVar2, "src");
        if (!(i10 >= 0)) {
            new t(i10).a();
            throw new lm.y();
        }
        tl.m mVar = eVar2.f15821b;
        int i11 = mVar.f15874c;
        int i12 = mVar.f15873b;
        if (!(i10 <= i11 - i12)) {
            new u(i10, eVar2).a();
            throw new lm.y();
        }
        tl.m mVar2 = eVar.f15821b;
        int i13 = mVar2.f15872a;
        int i14 = mVar2.f15874c;
        if (!(i10 <= i13 - i14)) {
            new v(i10, eVar).a();
            throw new lm.y();
        }
        ByteBuffer byteBuffer = eVar.f15820a;
        int i15 = i13 - i14;
        if (i15 < i10) {
            throw new n0("buffer readable content", i10, i15);
        }
        ql.f.d(eVar2.f15820a, byteBuffer, i12, i10, i14);
        eVar2.h(i10);
        eVar.b(i10);
    }

    public static final int x(@os.l tl.e eVar, @os.l int[] iArr, int i10, int i11) {
        kn.l0.p(eVar, "$this$readAvailable");
        kn.l0.p(iArr, RtspHeaders.Values.DESTINATION);
        return f(eVar, iArr, i10, i11);
    }

    public static final void x0(@os.l tl.e eVar, @os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(bArr, "source");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i12 = mVar.f15874c;
        int i13 = mVar.f15872a - i12;
        if (i13 < i11) {
            throw new n0("byte array", i11, i13);
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, i10, i11).slice().order(ByteOrder.BIG_ENDIAN);
        kn.l0.o(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        ql.f.d(ql.f.c(byteBufferOrder), byteBuffer, 0, i11, i12);
        eVar.b(i11);
    }

    public static int y(tl.e eVar, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        return x(eVar, iArr, i10, i11);
    }

    public static final void y0(@os.l tl.e eVar, @os.l double[] dArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(dArr, "source");
        int i12 = i11 * 8;
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i13 = mVar.f15874c;
        int i14 = mVar.f15872a - i13;
        if (i14 < i12) {
            throw new n0("floating point numbers array", i12, i14);
        }
        ql.n.u(byteBuffer, i13, dArr, i10, i11);
        eVar.b(i12);
    }

    public static final double z(@os.l tl.e eVar) {
        kn.l0.p(eVar, "<this>");
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        if (!(mVar.f15874c - i10 >= 8)) {
            new s("long floating point number", 8).a();
            throw new lm.y();
        }
        Double dValueOf = Double.valueOf(byteBuffer.getDouble(i10));
        eVar.h(8);
        return dValueOf.doubleValue();
    }

    public static final void z0(@os.l tl.e eVar, @os.l float[] fArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(fArr, "source");
        int i12 = i11 * 4;
        ByteBuffer byteBuffer = eVar.f15820a;
        tl.m mVar = eVar.f15821b;
        int i13 = mVar.f15874c;
        int i14 = mVar.f15872a - i13;
        if (i14 < i12) {
            throw new n0("floating point numbers array", i12, i14);
        }
        ql.n.y(byteBuffer, i13, fArr, i10, i11);
        eVar.b(i12);
    }
}

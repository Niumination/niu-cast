package mk;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicReference;
import kn.l0;
import lm.i0;

/* JADX INFO: loaded from: classes2.dex */
@c0
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final AtomicReference<a> f10785a = new AtomicReference<>(a.HEADER0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10791g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10792h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f10793i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f10794j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.m
    public Integer f10795k;

    public enum a {
        HEADER0,
        LENGTH,
        MASK_KEY,
        BODY
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10797a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.HEADER0.ordinal()] = 1;
            iArr[a.LENGTH.ordinal()] = 2;
            iArr[a.MASK_KEY.ordinal()] = 3;
            iArr[a.BODY.ordinal()] = 4;
            f10797a = iArr;
        }
    }

    public final void a() {
        if (!g0.e.a(this.f10785a, a.BODY, a.HEADER0)) {
            throw new IllegalStateException(l0.C("It should be state BODY but it is ", this.f10785a.get()));
        }
        this.f10791g = 0;
        this.f10794j = 0L;
        this.f10793i = 0;
        this.f10795k = null;
    }

    public final void b(@os.l ByteBuffer byteBuffer) {
        l0.p(byteBuffer, "bb");
        if (!l0.g(byteBuffer.order(), ByteOrder.BIG_ENDIAN)) {
            throw new IllegalArgumentException(l0.C("Buffer order should be BIG_ENDIAN but it is ", byteBuffer.order()).toString());
        }
        while (l(byteBuffer)) {
        }
    }

    public final boolean c() {
        return this.f10785a.get() == a.BODY;
    }

    public final boolean d() {
        return this.f10786b;
    }

    @os.l
    public final k e() {
        k kVarA = k.Companion.a(this.f10791g);
        if (kVarA != null) {
            return kVarA;
        }
        throw new IllegalStateException(l0.C("Unsupported opcode ", Integer.toHexString(this.f10791g)));
    }

    public final long f() {
        return this.f10794j;
    }

    public final boolean g() {
        return this.f10790f;
    }

    @os.m
    public final Integer h() {
        return this.f10795k;
    }

    public final boolean i() {
        return this.f10787c;
    }

    public final boolean j() {
        return this.f10788d;
    }

    public final boolean k() {
        return this.f10789e;
    }

    public final boolean l(ByteBuffer byteBuffer) {
        a aVar = this.f10785a.get();
        l0.m(aVar);
        int i10 = b.f10797a[aVar.ordinal()];
        if (i10 == 1) {
            return m(byteBuffer);
        }
        if (i10 == 2) {
            return n(byteBuffer);
        }
        if (i10 == 3) {
            return o(byteBuffer);
        }
        if (i10 == 4) {
            return false;
        }
        throw new i0();
    }

    public final boolean m(ByteBuffer byteBuffer) {
        int i10 = 0;
        if (byteBuffer.remaining() < 2) {
            return false;
        }
        byte b10 = byteBuffer.get();
        byte b11 = byteBuffer.get();
        this.f10786b = (b10 & 128) != 0;
        this.f10787c = (b10 & o1.t.f12049a) != 0;
        this.f10788d = (b10 & 32) != 0;
        this.f10789e = (b10 & c1.c.f1124r) != 0;
        int i11 = b10 & c1.c.f1123q;
        if (i11 == 0) {
            i11 = this.f10792h;
        }
        this.f10791g = i11;
        if (!e().getControlFrame()) {
            this.f10792h = this.f10791g;
        }
        boolean z10 = (b11 & 128) != 0;
        this.f10790f = z10;
        int i12 = b11 & 127;
        if (i12 == 126) {
            i10 = 2;
        } else if (i12 == 127) {
            i10 = 8;
        }
        this.f10793i = i10;
        this.f10794j = i10 == 0 ? i12 : 0L;
        if (i10 > 0) {
            this.f10785a.set(a.LENGTH);
        } else if (z10) {
            this.f10785a.set(a.MASK_KEY);
        } else {
            this.f10785a.set(a.BODY);
        }
        return true;
    }

    public final boolean n(ByteBuffer byteBuffer) {
        long j10;
        int iRemaining = byteBuffer.remaining();
        int i10 = this.f10793i;
        if (iRemaining < i10) {
            return false;
        }
        if (i10 == 2) {
            j10 = ((long) byteBuffer.getShort()) & 65535;
        } else {
            if (i10 != 8) {
                throw new IllegalStateException();
            }
            j10 = byteBuffer.getLong();
        }
        this.f10794j = j10;
        this.f10785a.set(this.f10790f ? a.MASK_KEY : a.BODY);
        return true;
    }

    public final boolean o(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < 4) {
            return false;
        }
        this.f10795k = Integer.valueOf(byteBuffer.getInt());
        this.f10785a.set(a.BODY);
        return true;
    }
}

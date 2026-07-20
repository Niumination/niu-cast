package f2;

import android.os.SystemClock;
import java.nio.charset.Charset;
import kn.l0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final C0137b f5670d = new C0137b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final String f5671e = "AnimPlayer.AnimConfigManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final g f5672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public f2.a f5673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5674c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f5675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.m
        public String f5677c;

        public final int a() {
            return this.f5676b;
        }

        public final long b() {
            return this.f5675a;
        }

        @os.m
        public final String c() {
            return this.f5677c;
        }

        public final void d(int i10) {
            this.f5676b = i10;
        }

        public final void e(long j10) {
            this.f5675a = j10;
        }

        public final void f(@os.m String str) {
            this.f5677c = str;
        }
    }

    /* JADX INFO: renamed from: f2.b$b, reason: collision with other inner class name */
    public static final class C0137b {
        public C0137b() {
        }

        public C0137b(kn.w wVar) {
        }
    }

    public b(@os.l g gVar) {
        l0.p(gVar, "player");
        this.f5672a = gVar;
    }

    public final void a(int i10, int i11) {
        f2.a aVar = this.f5673b;
        if (!(aVar == null || aVar.f5662l) || aVar == null) {
            return;
        }
        aVar.f5655e = i10;
        aVar.f5656f = i11;
        int i12 = aVar.f5663m;
        if (i12 == 1) {
            int i13 = i10 / 2;
            aVar.f5653c = i13;
            aVar.f5654d = i11;
            aVar.q(new a0(0, 0, i13, i11));
            int i14 = aVar.f5653c;
            aVar.z(new a0(i14, 0, i14, aVar.f5654d));
            return;
        }
        if (i12 == 2) {
            aVar.f5653c = i10;
            int i15 = i11 / 2;
            aVar.f5654d = i15;
            aVar.q(new a0(0, 0, i10, i15));
            int i16 = aVar.f5654d;
            aVar.z(new a0(0, i16, aVar.f5653c, i16));
            return;
        }
        if (i12 == 3) {
            int i17 = i10 / 2;
            aVar.f5653c = i17;
            aVar.f5654d = i11;
            aVar.z(new a0(0, 0, i17, i11));
            int i18 = aVar.f5653c;
            aVar.q(new a0(i18, 0, i18, aVar.f5654d));
            return;
        }
        if (i12 != 4) {
            int i19 = i10 / 2;
            aVar.f5653c = i19;
            aVar.f5654d = i11;
            aVar.q(new a0(0, 0, i19, i11));
            int i20 = aVar.f5653c;
            aVar.z(new a0(i20, 0, i20, aVar.f5654d));
            return;
        }
        aVar.f5653c = i10;
        int i21 = i11 / 2;
        aVar.f5654d = i21;
        aVar.z(new a0(0, 0, i10, i21));
        int i22 = aVar.f5654d;
        aVar.q(new a0(0, i22, aVar.f5653c, i22));
    }

    @os.m
    public final f2.a b() {
        return this.f5673b;
    }

    @os.l
    public final g c() {
        return this.f5672a;
    }

    public final boolean d() {
        return this.f5674c;
    }

    public final boolean e(g2.c cVar, int i10, int i11) {
        a aVarF;
        f2.a aVar = new f2.a();
        this.f5673b = aVar;
        cVar.a();
        byte[] bArr = new byte[8];
        long j10 = 0;
        while (true) {
            if (cVar.read(bArr, 0, 8) != 8 || (aVarF = f(bArr)) == null) {
                aVarF = null;
                break;
            }
            if (l0.g("vapc", aVarF.f5677c)) {
                aVarF.f5675a = j10;
                break;
            }
            int i12 = aVarF.f5676b;
            j10 += (long) i12;
            cVar.skip(((long) i12) - 8);
        }
        if (aVarF == null) {
            l2.a.f9640a.b(f5671e, "vapc box head not found");
            aVar.f5662l = true;
            aVar.f5663m = i10;
            aVar.f5658h = i11;
            this.f5672a.N(i11);
            return true;
        }
        int i13 = aVarF.f5676b - 8;
        byte[] bArr2 = new byte[i13];
        cVar.read(bArr2, 0, i13);
        cVar.b();
        Charset charsetForName = Charset.forName("UTF-8");
        l0.o(charsetForName, "forName(\"UTF-8\")");
        JSONObject jSONObject = new JSONObject(new String(bArr2, 0, i13, charsetForName));
        aVar.f5665o = jSONObject;
        boolean zP = aVar.p(jSONObject);
        if (i11 > 0) {
            aVar.f5658h = i11;
        }
        this.f5672a.N(aVar.f5658h);
        return zP;
    }

    public final a f(byte[] bArr) {
        if (bArr.length != 8) {
            return null;
        }
        a aVar = new a();
        aVar.f5676b = ((bArr[2] & 255) << 8) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | (bArr[3] & 255);
        Charset charsetForName = Charset.forName("US-ASCII");
        l0.o(charsetForName, "forName(\"US-ASCII\")");
        aVar.f5677c = new String(bArr, 4, 4, charsetForName);
        return aVar;
    }

    public final int g(@os.l g2.c cVar, boolean z10, int i10, int i11) {
        l0.p(cVar, "fileContainer");
        try {
            this.f5674c = true;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            boolean zE = e(cVar, i10, i11);
            l2.a.f9640a.e(f5671e, "parseConfig cost=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms enableVersion1=" + z10 + " result=" + zE);
            if (!zE) {
                this.f5674c = false;
                return o.f5790o;
            }
            f2.a aVar = this.f5673b;
            if (aVar != null && aVar.f5662l && !z10) {
                this.f5674c = false;
                return o.f5790o;
            }
            int iD = aVar == null ? 0 : this.f5672a.f5755s.d(aVar);
            this.f5674c = false;
            return iD;
        } catch (Throwable th2) {
            l2.a.f9640a.c(f5671e, l0.C("parseConfig error ", th2), th2);
            this.f5674c = false;
            return o.f5790o;
        }
    }

    public final void h(@os.m f2.a aVar) {
        this.f5673b = aVar;
    }

    public final void i(boolean z10) {
        this.f5674c = z10;
    }
}

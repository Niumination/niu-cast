package ms;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import ks.h;

/* JADX INFO: loaded from: classes3.dex */
public class a extends FilterOutputStream {
    public static final byte[] H = "\u001b[0m".getBytes();
    public static final int I = 0;
    public static final int J = 1;
    public static final int K = 2;
    public static final int L = 3;
    public static final int M = 4;
    public static final int N = 5;
    public static final int O = 6;
    public static final int P = 7;
    public static final int Q = 8;
    public static final int R = 9;
    public static final int S = 27;
    public static final int T = 91;
    public static final int U = 93;
    public static final int V = 7;
    public static final int W = 92;
    public static final int X = 40;
    public static final int Y = 41;
    public static final int Z = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ms.b f10872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f10873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<Object> f10876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Charset f10878g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f10879i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ms.b f10880n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final h f10881p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ks.b f10882v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final InterfaceC0286a f10883w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final InterfaceC0286a f10884x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ks.e f10885y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f10886z;

    /* JADX INFO: renamed from: ms.a$a, reason: collision with other inner class name */
    public interface InterfaceC0286a {
        void run() throws IOException;
    }

    public interface b {
        int a();
    }

    public static class c implements b {
        @Override // ms.a.b
        public int a() {
            return 0;
        }
    }

    public a(OutputStream outputStream, b bVar, ks.e eVar, ms.b bVar2, h hVar, ks.b bVar3, Charset charset, InterfaceC0286a interfaceC0286a, InterfaceC0286a interfaceC0286a2, boolean z10) {
        super(outputStream);
        this.f10873b = new byte[100];
        this.f10874c = 0;
        this.f10876e = new ArrayList<>();
        this.f10877f = 0;
        this.f10879i = bVar;
        this.f10880n = bVar2;
        this.f10881p = hVar;
        this.f10882v = bVar3;
        this.f10883w = interfaceC0286a;
        this.f10884x = interfaceC0286a2;
        this.f10886z = z10;
        this.f10878g = charset;
        y(eVar);
    }

    public void A(boolean z10) {
        this.f10886z = z10;
    }

    public void E() throws IOException {
        h hVar;
        if (this.f10886z && (hVar = this.f10881p) != h.Redirected && hVar != h.Unsupported) {
            y(ks.e.Default);
            write(H);
            flush();
        }
        InterfaceC0286a interfaceC0286a = this.f10884x;
        if (interfaceC0286a != null) {
            interfaceC0286a.run();
        }
    }

    public ks.b b() {
        return this.f10882v;
    }

    public ks.e c() {
        return this.f10885y;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        E();
        super.close();
    }

    public int d() {
        return this.f10879i.a();
    }

    public h h() {
        return this.f10881p;
    }

    public void k() throws IOException {
        InterfaceC0286a interfaceC0286a = this.f10883w;
        if (interfaceC0286a != null) {
            interfaceC0286a.run();
        }
    }

    public boolean n() {
        return this.f10886z;
    }

    public final void o() throws IOException {
        try {
            ms.b bVar = this.f10872a;
            t(bVar != null && bVar.i(this.f10876e));
        } catch (RuntimeException e10) {
            t(true);
            throw e10;
        }
    }

    public final void p(int i10) throws IOException {
        try {
            ms.b bVar = this.f10872a;
            t(bVar != null && bVar.w(this.f10876e, i10));
        } catch (RuntimeException e10) {
            t(true);
            throw e10;
        }
    }

    public final void q() throws IOException {
        try {
            ms.b bVar = this.f10872a;
            t(bVar != null && bVar.y(this.f10876e));
        } catch (RuntimeException e10) {
            t(true);
            throw e10;
        }
    }

    public final void t(boolean z10) throws IOException {
        if (!z10) {
            ((FilterOutputStream) this).out.write(this.f10873b, 0, this.f10874c);
        }
        this.f10874c = 0;
        this.f10875d = 0;
        this.f10876e.clear();
        this.f10877f = 0;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i10) throws IOException {
        switch (this.f10877f) {
            case 0:
                if (i10 != 27) {
                    ((FilterOutputStream) this).out.write(i10);
                } else {
                    byte[] bArr = this.f10873b;
                    int i11 = this.f10874c;
                    this.f10874c = i11 + 1;
                    bArr[i11] = (byte) i10;
                    this.f10877f = 1;
                }
                break;
            case 1:
                byte[] bArr2 = this.f10873b;
                int i12 = this.f10874c;
                this.f10874c = i12 + 1;
                bArr2[i12] = (byte) i10;
                if (i10 == 91) {
                    this.f10877f = 2;
                } else if (i10 == 93) {
                    this.f10877f = 5;
                } else if (i10 == 40) {
                    this.f10876e.add(0);
                    this.f10877f = 9;
                } else if (i10 != 41) {
                    t(false);
                } else {
                    this.f10876e.add(1);
                    this.f10877f = 9;
                }
                break;
            case 2:
                byte[] bArr3 = this.f10873b;
                int i13 = this.f10874c;
                this.f10874c = i13 + 1;
                bArr3[i13] = (byte) i10;
                if (34 == i10) {
                    this.f10875d = i13;
                    this.f10877f = 3;
                } else if (48 <= i10 && i10 <= 57) {
                    this.f10875d = i13;
                    this.f10877f = 4;
                } else if (59 == i10) {
                    this.f10876e.add(null);
                } else if (63 == i10) {
                    this.f10876e.add('?');
                } else if (61 != i10) {
                    p(i10);
                } else {
                    this.f10876e.add(Character.valueOf(fl.h.f6043c));
                }
                break;
            case 3:
                byte[] bArr4 = this.f10873b;
                int i14 = this.f10874c;
                this.f10874c = i14 + 1;
                bArr4[i14] = (byte) i10;
                if (34 != i10) {
                    int i15 = this.f10875d;
                    this.f10876e.add(new String(bArr4, i15, i14 - i15, this.f10878g));
                    if (i10 != 59) {
                        p(i10);
                    } else {
                        this.f10877f = 2;
                    }
                }
                break;
            case 4:
                byte[] bArr5 = this.f10873b;
                int i16 = this.f10874c;
                this.f10874c = i16 + 1;
                bArr5[i16] = (byte) i10;
                if (48 > i10 || i10 > 57) {
                    int i17 = this.f10875d;
                    this.f10876e.add(Integer.valueOf(new String(bArr5, i17, i16 - i17)));
                    if (i10 != 59) {
                        p(i10);
                    } else {
                        this.f10877f = 2;
                    }
                }
                break;
            case 5:
                byte[] bArr6 = this.f10873b;
                int i18 = this.f10874c;
                this.f10874c = i18 + 1;
                bArr6[i18] = (byte) i10;
                if (48 <= i10 && i10 <= 57) {
                    this.f10875d = i18;
                    this.f10877f = 6;
                } else {
                    t(false);
                }
                break;
            case 6:
                byte[] bArr7 = this.f10873b;
                int i19 = this.f10874c;
                this.f10874c = i19 + 1;
                bArr7[i19] = (byte) i10;
                if (59 == i10) {
                    int i20 = this.f10875d;
                    this.f10876e.add(Integer.valueOf(new String(bArr7, i20, i19 - i20)));
                    this.f10875d = this.f10874c;
                    this.f10877f = 7;
                } else if (48 > i10 || i10 > 57) {
                    t(false);
                }
                break;
            case 7:
                byte[] bArr8 = this.f10873b;
                int i21 = this.f10874c;
                this.f10874c = i21 + 1;
                bArr8[i21] = (byte) i10;
                if (7 == i10) {
                    int i22 = this.f10875d;
                    this.f10876e.add(new String(bArr8, i22, i21 - i22, this.f10878g));
                    q();
                } else if (27 == i10) {
                    this.f10877f = 8;
                }
                break;
            case 8:
                byte[] bArr9 = this.f10873b;
                int i23 = this.f10874c;
                this.f10874c = i23 + 1;
                bArr9[i23] = (byte) i10;
                if (92 != i10) {
                    this.f10877f = 7;
                } else {
                    int i24 = this.f10875d;
                    this.f10876e.add(new String(bArr9, i24, (i23 - 1) - i24, this.f10878g));
                    q();
                }
                break;
            case 9:
                this.f10876e.add(Character.valueOf((char) i10));
                o();
                break;
        }
        if (this.f10874c >= this.f10873b.length) {
            t(false);
        }
    }

    public void y(ks.e eVar) {
        ms.b dVar;
        if (eVar == ks.e.Strip) {
            dVar = new ms.b(((FilterOutputStream) this).out);
        } else if (eVar == ks.e.Force || (dVar = this.f10880n) == null) {
            dVar = new d(((FilterOutputStream) this).out, this.f10882v);
        }
        this.f10872a = dVar;
        this.f10885y = eVar;
    }
}

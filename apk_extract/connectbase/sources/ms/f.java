package ms;

import java.io.IOException;
import java.io.OutputStream;
import ks.i;
import org.fusesource.jansi.internal.Kernel32;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends b {
    public static final short J = 0;
    public static final short K;
    public static final short L;
    public static final short M;
    public static final short N;
    public static final short O = 0;
    public static final short P;
    public static final short Q;
    public static final short R;
    public static final short S;
    public static final short[] T;
    public static final short[] U;
    public final long D;
    public final Kernel32.CONSOLE_SCREEN_BUFFER_INFO E;
    public final short F;
    public boolean G;
    public short H;
    public short I;

    static {
        short s10 = (short) (Kernel32.f12458c | Kernel32.f12457b);
        K = s10;
        short s11 = (short) (Kernel32.f12456a | Kernel32.f12458c);
        L = s11;
        short s12 = (short) (Kernel32.f12456a | Kernel32.f12457b);
        M = s12;
        short s13 = (short) (Kernel32.f12458c | Kernel32.f12457b | Kernel32.f12456a);
        N = s13;
        short s14 = (short) (Kernel32.f12462g | Kernel32.f12461f);
        P = s14;
        short s15 = (short) (Kernel32.f12460e | Kernel32.f12462g);
        Q = s15;
        short s16 = (short) (Kernel32.f12460e | Kernel32.f12461f);
        R = s16;
        short s17 = (short) (Kernel32.f12462g | Kernel32.f12461f | Kernel32.f12460e);
        S = s17;
        T = new short[]{0, Kernel32.f12458c, Kernel32.f12457b, s10, Kernel32.f12456a, s11, s12, s13};
        U = new short[]{0, Kernel32.f12462g, Kernel32.f12461f, s14, Kernel32.f12460e, s15, s16, s17};
    }

    public f(OutputStream outputStream, long j10) throws IOException {
        super(outputStream);
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = new Kernel32.CONSOLE_SCREEN_BUFFER_INFO();
        this.E = console_screen_buffer_info;
        this.H = (short) -1;
        this.I = (short) -1;
        this.D = j10;
        Q();
        this.F = console_screen_buffer_info.f12482c;
    }

    @Override // ms.b
    public void A() throws IOException {
        Q();
        Kernel32.COORD coord = this.E.f12481b;
        this.H = coord.f12486a;
        this.I = coord.f12487b;
    }

    @Override // ms.b
    public void D(int i10) throws IOException {
        if (i10 == 1) {
            Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = this.E;
            console_screen_buffer_info.f12482c = (short) (console_screen_buffer_info.f12482c | Kernel32.f12459d);
            O();
            return;
        }
        if (i10 == 4) {
            Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info2 = this.E;
            console_screen_buffer_info2.f12482c = (short) (console_screen_buffer_info2.f12482c | Kernel32.f12463h);
            O();
            return;
        }
        if (i10 == 7) {
            this.G = true;
            O();
            return;
        }
        if (i10 == 22) {
            Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info3 = this.E;
            console_screen_buffer_info3.f12482c = (short) (console_screen_buffer_info3.f12482c & (~Kernel32.f12459d));
            O();
        } else if (i10 == 24) {
            Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info4 = this.E;
            console_screen_buffer_info4.f12482c = (short) (console_screen_buffer_info4.f12482c & (~Kernel32.f12463h));
            O();
        } else {
            if (i10 != 27) {
                return;
            }
            this.G = false;
            O();
        }
    }

    @Override // ms.b
    public void F(int i10, boolean z10) throws IOException {
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = this.E;
        short s10 = (short) (U[i10] | (console_screen_buffer_info.f12482c & (-113)));
        console_screen_buffer_info.f12482c = s10;
        if (z10) {
            console_screen_buffer_info.f12482c = (short) (s10 | Kernel32.f12463h);
        }
        O();
    }

    @Override // ms.b
    public void G(int i10) throws IOException {
        int iH = c.h(i10, 16);
        F(iH >= 8 ? iH - 8 : iH, iH >= 8);
    }

    @Override // ms.b
    public void H(int i10, int i11, int i12) throws IOException {
        int iJ = c.j(i10, i11, i12, 16);
        F(iJ >= 8 ? iJ - 8 : iJ, iJ >= 8);
    }

    @Override // ms.b
    public void J(int i10, boolean z10) throws IOException {
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = this.E;
        short s10 = (short) (T[i10] | (console_screen_buffer_info.f12482c & (-8)));
        console_screen_buffer_info.f12482c = s10;
        if (z10) {
            console_screen_buffer_info.f12482c = (short) (s10 | Kernel32.f12459d);
        }
        O();
    }

    @Override // ms.b
    public void K(int i10) throws IOException {
        int iH = c.h(i10, 16);
        J(iH >= 8 ? iH - 8 : iH, iH >= 8);
    }

    @Override // ms.b
    public void L(int i10, int i11, int i12) throws IOException {
        int iJ = c.j(i10, i11, i12, 16);
        J(iJ >= 8 ? iJ - 8 : iJ, iJ >= 8);
    }

    public final void O() throws IOException {
        this.f10912a.flush();
        short sR = this.E.f12482c;
        if (this.G) {
            sR = R(sR);
        }
        if (Kernel32.SetConsoleTextAttribute(this.D, sR) == 0) {
            throw new IOException(i.b());
        }
    }

    public final void P() throws IOException {
        if (Kernel32.SetConsoleCursorPosition(this.D, this.E.f12481b.a()) == 0) {
            throw new IOException(i.b());
        }
    }

    public final void Q() throws IOException {
        this.f10912a.flush();
        if (Kernel32.GetConsoleScreenBufferInfo(this.D, this.E) == 0) {
            throw new IOException("Could not get the screen info: " + i.b());
        }
        if (this.G) {
            Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = this.E;
            console_screen_buffer_info.f12482c = R(console_screen_buffer_info.f12482c);
        }
    }

    public final short R(short s10) {
        return (short) (((s10 & 15) << 4) | (s10 & 65280) | ((s10 & 240) >> 4));
    }

    @Override // ms.b
    public void d() throws IOException {
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = this.E;
        console_screen_buffer_info.f12482c = (short) ((console_screen_buffer_info.f12482c & (-256)) | this.F);
        this.G = false;
        O();
    }

    @Override // ms.b
    public void g(String str) {
        Kernel32.SetConsoleTitle(str);
    }

    @Override // ms.b
    public void j(int i10) throws IOException {
        Q();
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = this.E;
        console_screen_buffer_info.f12481b.f12487b = (short) Math.min(Math.max(0, console_screen_buffer_info.f12480a.f12487b - 1), this.E.f12481b.f12487b + i10);
        P();
    }

    @Override // ms.b
    public void k(int i10) throws IOException {
        Q();
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = this.E;
        Kernel32.COORD coord = console_screen_buffer_info.f12481b;
        coord.f12486a = (short) 0;
        coord.f12487b = (short) Math.max((int) console_screen_buffer_info.f12483d.f12545b, coord.f12487b + i10);
        P();
    }

    @Override // ms.b
    public void l(int i10) throws IOException {
        Q();
        Kernel32.COORD coord = this.E.f12481b;
        coord.f12486a = (short) Math.max(0, coord.f12486a - i10);
        P();
    }

    @Override // ms.b
    public void m(int i10) throws IOException {
        Q();
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = this.E;
        console_screen_buffer_info.f12481b.f12486a = (short) Math.min((int) console_screen_buffer_info.f12483d.c(), this.E.f12481b.f12486a + i10);
        P();
    }

    @Override // ms.b
    public void n(int i10, int i11) throws IOException {
        Q();
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = this.E;
        Kernel32.COORD coord = console_screen_buffer_info.f12481b;
        short s10 = console_screen_buffer_info.f12483d.f12545b;
        coord.f12487b = (short) Math.max((int) s10, Math.min((int) console_screen_buffer_info.f12480a.f12487b, (i10 + s10) - 1));
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info2 = this.E;
        console_screen_buffer_info2.f12481b.f12486a = (short) Math.max(0, Math.min((int) console_screen_buffer_info2.f12483d.c(), i11 - 1));
        P();
    }

    @Override // ms.b
    public void o(int i10) throws IOException {
        Q();
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = this.E;
        console_screen_buffer_info.f12481b.f12486a = (short) Math.max(0, Math.min((int) console_screen_buffer_info.f12483d.c(), i10 - 1));
        P();
    }

    @Override // ms.b
    public void p(int i10) throws IOException {
        Q();
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = this.E;
        Kernel32.COORD coord = console_screen_buffer_info.f12481b;
        coord.f12487b = (short) Math.max((int) console_screen_buffer_info.f12483d.f12545b, coord.f12487b - i10);
        P();
    }

    @Override // ms.b
    public void q(int i10) throws IOException {
        Q();
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = this.E;
        Kernel32.COORD coord = console_screen_buffer_info.f12481b;
        coord.f12486a = (short) 0;
        coord.f12487b = (short) Math.max((int) console_screen_buffer_info.f12483d.f12545b, coord.f12487b - i10);
        P();
    }

    @Override // ms.b
    public void r() throws IOException {
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = this.E;
        short s10 = (short) ((console_screen_buffer_info.f12482c & (-241)) | (this.F & 240));
        console_screen_buffer_info.f12482c = s10;
        console_screen_buffer_info.f12482c = (short) (s10 & (~Kernel32.f12463h));
        O();
    }

    @Override // ms.b
    public void s() throws IOException {
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = this.E;
        short s10 = (short) ((console_screen_buffer_info.f12482c & (-16)) | (this.F & 15));
        console_screen_buffer_info.f12482c = s10;
        console_screen_buffer_info.f12482c = (short) (s10 & (~Kernel32.f12459d));
        O();
    }

    @Override // ms.b
    public void t(int i10) throws IOException {
        Q();
        Kernel32.SMALL_RECT small_rectA = this.E.f12483d.a();
        small_rectA.f12545b = this.E.f12481b.f12487b;
        Kernel32.COORD coord = new Kernel32.COORD();
        coord.f12486a = (short) 0;
        coord.f12487b = (short) (this.E.f12481b.f12487b - i10);
        Kernel32.CHAR_INFO char_info = new Kernel32.CHAR_INFO();
        char_info.f12477a = this.F;
        char_info.f12478b = ' ';
        if (Kernel32.ScrollConsoleScreenBuffer(this.D, small_rectA, small_rectA, coord, char_info) == 0) {
            throw new IOException(i.b());
        }
    }

    @Override // ms.b
    public void u(int i10) throws IOException {
        Q();
        int[] iArr = new int[1];
        if (i10 == 0) {
            Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = this.E;
            short s10 = console_screen_buffer_info.f12480a.f12486a;
            Kernel32.COORD coord = console_screen_buffer_info.f12481b;
            int i11 = s10 - coord.f12486a;
            Kernel32.FillConsoleOutputAttribute(this.D, console_screen_buffer_info.f12482c, i11, coord.a(), iArr);
            Kernel32.FillConsoleOutputCharacterW(this.D, ' ', i11, this.E.f12481b.a(), iArr);
            return;
        }
        if (i10 == 1) {
            Kernel32.COORD coordA = this.E.f12481b.a();
            coordA.f12486a = (short) 0;
            long j10 = this.D;
            Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info2 = this.E;
            Kernel32.FillConsoleOutputAttribute(j10, console_screen_buffer_info2.f12482c, console_screen_buffer_info2.f12481b.f12486a, coordA, iArr);
            Kernel32.FillConsoleOutputCharacterW(this.D, ' ', this.E.f12481b.f12486a, coordA, iArr);
            return;
        }
        if (i10 != 2) {
            return;
        }
        Kernel32.COORD coordA2 = this.E.f12481b.a();
        coordA2.f12486a = (short) 0;
        long j11 = this.D;
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info3 = this.E;
        Kernel32.FillConsoleOutputAttribute(j11, console_screen_buffer_info3.f12482c, console_screen_buffer_info3.f12480a.f12486a, coordA2, iArr);
        Kernel32.FillConsoleOutputCharacterW(this.D, ' ', this.E.f12480a.f12486a, coordA2, iArr);
    }

    @Override // ms.b
    public void v(int i10) throws IOException {
        Q();
        int[] iArr = new int[1];
        if (i10 == 0) {
            Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = this.E;
            short s10 = console_screen_buffer_info.f12483d.f12547d;
            Kernel32.COORD coord = console_screen_buffer_info.f12481b;
            int i11 = s10 - coord.f12487b;
            short s11 = console_screen_buffer_info.f12480a.f12486a;
            int i12 = (i11 * s11) + (s11 - coord.f12486a);
            Kernel32.FillConsoleOutputAttribute(this.D, console_screen_buffer_info.f12482c, i12, coord.a(), iArr);
            Kernel32.FillConsoleOutputCharacterW(this.D, ' ', i12, this.E.f12481b.a(), iArr);
            return;
        }
        if (i10 == 1) {
            Kernel32.COORD coord2 = new Kernel32.COORD();
            coord2.f12486a = (short) 0;
            Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info2 = this.E;
            short s12 = console_screen_buffer_info2.f12483d.f12545b;
            coord2.f12487b = s12;
            Kernel32.COORD coord3 = console_screen_buffer_info2.f12481b;
            int i13 = ((coord3.f12487b - s12) * console_screen_buffer_info2.f12480a.f12486a) + coord3.f12486a;
            Kernel32.FillConsoleOutputAttribute(this.D, console_screen_buffer_info2.f12482c, i13, coord2, iArr);
            Kernel32.FillConsoleOutputCharacterW(this.D, ' ', i13, coord2, iArr);
            return;
        }
        if (i10 != 2) {
            return;
        }
        Kernel32.COORD coord4 = new Kernel32.COORD();
        coord4.f12486a = (short) 0;
        Kernel32.SMALL_RECT small_rect = this.E.f12483d;
        coord4.f12487b = small_rect.f12545b;
        short sB = small_rect.b();
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info3 = this.E;
        int i14 = sB * console_screen_buffer_info3.f12480a.f12486a;
        Kernel32.FillConsoleOutputAttribute(this.D, console_screen_buffer_info3.f12482c, i14, coord4, iArr);
        Kernel32.FillConsoleOutputCharacterW(this.D, ' ', i14, coord4, iArr);
    }

    @Override // ms.b
    public void x(int i10) throws IOException {
        Q();
        Kernel32.SMALL_RECT small_rectA = this.E.f12483d.a();
        small_rectA.f12545b = this.E.f12481b.f12487b;
        Kernel32.COORD coord = new Kernel32.COORD();
        coord.f12486a = (short) 0;
        coord.f12487b = (short) (this.E.f12481b.f12487b + i10);
        Kernel32.CHAR_INFO char_info = new Kernel32.CHAR_INFO();
        char_info.f12477a = this.F;
        char_info.f12478b = ' ';
        if (Kernel32.ScrollConsoleScreenBuffer(this.D, small_rectA, small_rectA, coord, char_info) == 0) {
            throw new IOException(i.b());
        }
    }

    @Override // ms.b
    public void z() throws IOException {
        if (this.H == -1 || this.I == -1) {
            return;
        }
        this.f10912a.flush();
        Kernel32.COORD coord = this.E.f12481b;
        coord.f12486a = this.H;
        coord.f12487b = this.I;
        P();
    }

    public f(OutputStream outputStream, boolean z10) throws IOException {
        this(outputStream, Kernel32.GetStdHandle(z10 ? Kernel32.f12473r : Kernel32.f12474s));
    }

    public f(OutputStream outputStream) throws IOException {
        this(outputStream, true);
    }
}

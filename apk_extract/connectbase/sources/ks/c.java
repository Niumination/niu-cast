package ks;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Locale;
import org.fusesource.jansi.internal.CLibrary;
import org.fusesource.jansi.internal.Kernel32;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static final int A = 4;
    public static int B = 0;
    public static int C = 0;
    public static boolean D = false;
    public static int E = 0;
    public static int F = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9455a = "jansi.mode";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9456b = "jansi.out.mode";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9457c = "jansi.err.mode";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9458d = "strip";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9459e = "force";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9460f = "default";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9461g = "jansi.colors";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9462h = "jansi.out.colors";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f9463i = "jansi.err.colors";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9464j = "16";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9465k = "256";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9466l = "truecolor";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Deprecated
    public static final String f9467m = "jansi.passthrough";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Deprecated
    public static final String f9468n = "jansi.strip";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Deprecated
    public static final String f9469o = "jansi.force";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Deprecated
    public static final String f9470p = "jansi.eager";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f9471q = "jansi.noreset";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f9472r = "jansi.graceful";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Deprecated
    public static PrintStream f9474t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Deprecated
    public static PrintStream f9476v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f9477w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final boolean f9478x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final boolean f9479y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final boolean f9480z;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Deprecated
    public static PrintStream f9473s = System.out;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Deprecated
    public static PrintStream f9475u = System.err;

    public class a implements ms.a.InterfaceC0286a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f9481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f9482b;

        public a(long j10, int[] iArr) {
            this.f9481a = j10;
            this.f9482b = iArr;
        }

        @Override // ms.a.InterfaceC0286a
        public void run() throws IOException {
            c.b();
            Kernel32.SetConsoleMode(this.f9481a, this.f9482b[0] | 4);
        }
    }

    public class b implements ms.a.InterfaceC0286a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f9483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f9484b;

        public b(long j10, int[] iArr) {
            this.f9483a = j10;
            this.f9484b = iArr;
        }

        @Override // ms.a.InterfaceC0286a
        public void run() throws IOException {
            if (c.a() == 0) {
                Kernel32.SetConsoleMode(this.f9483a, this.f9484b[0]);
            }
        }
    }

    /* JADX INFO: renamed from: ks.c$c, reason: collision with other inner class name */
    public class C0250c implements ms.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f9485a;

        public C0250c(long j10) {
            this.f9485a = j10;
        }

        @Override // ms.a.b
        public int a() {
            Kernel32.CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info = new Kernel32.CONSOLE_SCREEN_BUFFER_INFO();
            Kernel32.GetConsoleScreenBufferInfo(this.f9485a, console_screen_buffer_info);
            return console_screen_buffer_info.b();
        }
    }

    public class d implements ms.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9486a;

        public d(int i10) {
            this.f9486a = i10;
        }

        @Override // ms.a.b
        public int a() {
            CLibrary.WinSize winSize = new CLibrary.WinSize();
            CLibrary.ioctl(this.f9486a, CLibrary.f12441m, winSize);
            return winSize.f12453b;
        }
    }

    static {
        boolean zContains = System.getProperty("os.name").toLowerCase(Locale.ENGLISH).contains("win");
        f9477w = zContains;
        boolean z10 = false;
        f9478x = zContains && System.getenv("PWD") != null && System.getenv("PWD").startsWith("/");
        f9479y = zContains && System.getenv("MSYSTEM") != null && (System.getenv("MSYSTEM").startsWith("MINGW") || System.getenv("MSYSTEM").equals("MSYS"));
        if (zContains && System.getenv("ConEmuPID") != null) {
            z10 = true;
        }
        f9480z = z10;
        B = 1;
        C = 2;
        if (e(f9470p)) {
            g();
        }
    }

    public static /* synthetic */ int a() {
        int i10 = F - 1;
        F = i10;
        return i10;
    }

    public static /* synthetic */ int b() {
        int i10 = F;
        F = i10 + 1;
        return i10;
    }

    public static f c(boolean z10) {
        boolean z11;
        boolean z12;
        a aVar;
        b bVar;
        h hVar;
        ms.a.b dVar;
        h hVar2;
        a aVar2;
        b bVar2;
        ms.b bVar3;
        e eVar;
        ks.b bVar4;
        ms.e eVar2 = new ms.e(new FileOutputStream(z10 ? FileDescriptor.out : FileDescriptor.err));
        String property = System.getProperty(z10 ? "sun.stdout.encoding" : "sun.stderr.encoding");
        int i10 = z10 ? B : C;
        try {
            z12 = CLibrary.isatty(i10) != 0;
            String str = System.getenv("TERM");
            String str2 = System.getenv("INSIDE_EMACS");
            if (z12 && "dumb".equals(str) && str2 != null && !str2.contains("comint")) {
                z12 = false;
            }
            z11 = false;
        } catch (Throwable unused) {
            z11 = true;
            z12 = false;
        }
        ms.b bVar5 = null;
        if (!z12) {
            h hVar3 = z11 ? h.Unsupported : h.Redirected;
            dVar = new ms.a.c();
            hVar = hVar3;
            aVar = null;
            bVar = null;
        } else if (f9477w) {
            long jGetStdHandle = Kernel32.GetStdHandle(z10 ? Kernel32.f12473r : Kernel32.f12474s);
            int[] iArr = new int[1];
            boolean z13 = Kernel32.GetConsoleMode(jGetStdHandle, iArr) != 0;
            if (z13 && Kernel32.SetConsoleMode(jGetStdHandle, iArr[0] | 4) != 0) {
                Kernel32.SetConsoleMode(jGetStdHandle, iArr[0]);
                hVar2 = h.VirtualTerminal;
                aVar2 = new a(jGetStdHandle, iArr);
                bVar2 = new b(jGetStdHandle, iArr);
            } else if ((f9480z || f9478x || f9479y) && !z13) {
                hVar2 = h.Native;
                aVar2 = null;
                bVar2 = null;
            } else {
                try {
                    bVar3 = new ms.f(eVar2, jGetStdHandle);
                    hVar2 = h.Emulation;
                } catch (Throwable unused2) {
                    bVar3 = new ms.b(eVar2);
                    hVar2 = h.Unsupported;
                }
                aVar2 = null;
                bVar2 = null;
                bVar5 = bVar3;
            }
            C0250c c0250c = new C0250c(jGetStdHandle);
            hVar = hVar2;
            aVar = aVar2;
            bVar = bVar2;
            dVar = c0250c;
        } else {
            aVar = null;
            bVar = null;
            hVar = h.Native;
            dVar = new d(i10);
        }
        String property2 = System.getProperty(z10 ? f9456b : f9457c, System.getProperty(f9455a));
        if (f9459e.equals(property2)) {
            eVar = e.Force;
        } else if (f9458d.equals(property2)) {
            eVar = e.Strip;
        } else if (property2 != null) {
            eVar = z12 ? e.Default : e.Strip;
        } else if (e(f9467m)) {
            eVar = e.Force;
        } else if (e(f9468n)) {
            eVar = e.Strip;
        } else if (e(f9469o)) {
            eVar = e.Force;
        } else {
            eVar = z12 ? e.Default : e.Strip;
        }
        e eVar3 = eVar;
        String property3 = System.getProperty(z10 ? f9462h : f9463i, System.getProperty(f9461g));
        if (f9466l.equals(property3)) {
            bVar4 = ks.b.TrueColor;
        } else if (f9465k.equals(property3)) {
            bVar4 = ks.b.Colors256;
        } else if (property3 != null) {
            bVar4 = ks.b.Colors16;
        } else {
            String str3 = System.getenv("COLORTERM");
            if (str3 == null || !(str3.contains(f9466l) || str3.contains("24bit"))) {
                String str4 = System.getenv("TERM");
                if (str4 == null || !str4.contains("-direct")) {
                    bVar4 = (str4 == null || !str4.contains("-256color")) ? ks.b.Colors16 : ks.b.Colors256;
                } else {
                    bVar4 = ks.b.TrueColor;
                }
            } else {
                bVar4 = ks.b.TrueColor;
            }
        }
        boolean z14 = (hVar == h.Unsupported || e(f9471q)) ? false : true;
        Charset charsetDefaultCharset = Charset.defaultCharset();
        if (property != null) {
            try {
                charsetDefaultCharset = Charset.forName(property);
            } catch (UnsupportedCharsetException unused3) {
            }
        }
        return i(new ms.a(eVar2, dVar, eVar3, bVar5, hVar, bVar4, charsetDefaultCharset, aVar, bVar, z14), charsetDefaultCharset.name());
    }

    public static f d() {
        g();
        return (f) f9476v;
    }

    public static boolean e(String str) {
        try {
            String property = System.getProperty(str);
            return property.isEmpty() || Boolean.parseBoolean(property);
        } catch (IllegalArgumentException | NullPointerException unused) {
            return false;
        }
    }

    public static int f() {
        int iH = j().h();
        return iH <= 0 ? d().h() : iH;
    }

    public static synchronized void g() {
        if (!D) {
            f9474t = c(true);
            f9476v = c(false);
            D = true;
        }
    }

    public static synchronized boolean h() {
        return E > 0;
    }

    public static f i(ms.a aVar, String str) {
        if (str != null) {
            try {
                return new f((OutputStream) aVar, true, str);
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return new f((OutputStream) aVar, true);
    }

    public static f j() {
        g();
        return (f) f9474t;
    }

    public static PrintStream k() {
        return f9475u;
    }

    public static PrintStream l() {
        return f9473s;
    }

    public static synchronized void m() {
        try {
            int i10 = E + 1;
            E = i10;
            if (i10 == 1) {
                g();
                try {
                    ((f) f9474t).n();
                    ((f) f9476v).n();
                    System.setOut(f9474t);
                    System.setErr(f9476v);
                } catch (IOException e10) {
                    throw new IOError(e10);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static synchronized void n() {
        try {
            int i10 = E - 1;
            E = i10;
            if (i10 == 0) {
                try {
                    ((f) f9474t).t();
                    ((f) f9476v).t();
                    D = false;
                    System.setOut(f9473s);
                    System.setErr(f9475u);
                } catch (IOException e10) {
                    throw new IOError(e10);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}

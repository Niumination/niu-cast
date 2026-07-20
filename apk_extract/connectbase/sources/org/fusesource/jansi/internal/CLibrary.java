package org.fusesource.jansi.internal;

import ls.a;

/* JADX INFO: loaded from: classes3.dex */
public class CLibrary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f12429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f12430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f12431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f12432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f12433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f12434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f12435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f12436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f12437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f12438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f12439k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f12440l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f12441m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static long f12442n;

    public static class Termios {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static int f12443h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f12444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f12445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f12446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f12447d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f12448e = new byte[32];

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f12449f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f12450g;

        static {
            a.l();
            init();
        }

        private static native void init();
    }

    public static class WinSize {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static int f12451e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public short f12452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public short f12453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public short f12454c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public short f12455d;

        static {
            a.l();
            init();
        }

        public WinSize() {
        }

        private static native void init();

        public WinSize(short s10, short s11) {
            this.f12452a = s10;
            this.f12453b = s11;
        }
    }

    static {
        boolean zL = a.l();
        f12429a = zL;
        if (zL) {
            init();
        }
        f12430b = 1;
        f12431c = 2;
    }

    private static native void init();

    public static native int ioctl(int i10, long j10, WinSize winSize);

    public static native int ioctl(int i10, long j10, int[] iArr);

    public static native int isatty(int i10);

    public static native int openpty(int[] iArr, int[] iArr2, byte[] bArr, Termios termios, WinSize winSize);

    public static native int tcgetattr(int i10, Termios termios);

    public static native int tcsetattr(int i10, int i11, Termios termios);

    public static native String ttyname(int i10);
}

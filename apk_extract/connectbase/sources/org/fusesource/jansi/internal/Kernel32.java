package org.fusesource.jansi.internal;

import java.io.IOException;
import ks.i;
import ls.a;
import rs.f;

/* JADX INFO: loaded from: classes3.dex */
public class Kernel32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static short f12456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static short f12457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static short f12458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static short f12459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static short f12460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static short f12461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static short f12462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static short f12463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static short f12464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static short f12465j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static short f12466k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static short f12467l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static short f12468m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static short f12469n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static short f12470o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f12471p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f12472q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f12473r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int f12474s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f12475t;

    public static class CHAR_INFO {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static int f12476c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public short f12477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public char f12478b;

        static {
            a.l();
            init();
        }

        private static native void init();
    }

    public static class CONSOLE_SCREEN_BUFFER_INFO {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static int f12479f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public short f12482c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public COORD f12480a = new COORD();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public COORD f12481b = new COORD();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public SMALL_RECT f12483d = new SMALL_RECT();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public COORD f12484e = new COORD();

        static {
            a.l();
            init();
        }

        private static native void init();

        public int a() {
            return this.f12483d.b() + 1;
        }

        public int b() {
            return this.f12483d.c() + 1;
        }
    }

    public static class COORD {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static int f12485c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public short f12486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public short f12487b;

        static {
            a.l();
            init();
        }

        private static native void init();

        public COORD a() {
            COORD coord = new COORD();
            coord.f12486a = this.f12486a;
            coord.f12487b = this.f12487b;
            return coord;
        }
    }

    public static class FOCUS_EVENT_RECORD {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static int f12488b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12489a;

        static {
            a.l();
            init();
        }

        private static native void init();
    }

    public static class INPUT_RECORD {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static int f12490g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static short f12491h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static short f12492i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static short f12493j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static short f12494k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static short f12495l;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public short f12496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public KEY_EVENT_RECORD f12497b = new KEY_EVENT_RECORD();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public MOUSE_EVENT_RECORD f12498c = new MOUSE_EVENT_RECORD();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public WINDOW_BUFFER_SIZE_RECORD f12499d = new WINDOW_BUFFER_SIZE_RECORD();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public MENU_EVENT_RECORD f12500e = new MENU_EVENT_RECORD();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public FOCUS_EVENT_RECORD f12501f = new FOCUS_EVENT_RECORD();

        static {
            a.l();
            init();
        }

        private static native void init();

        public static native void memmove(INPUT_RECORD input_record, long j10, long j11);
    }

    public static class KEY_EVENT_RECORD {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static int f12502g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static int f12503h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static int f12504i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static int f12505j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static int f12506k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static int f12507l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static int f12508m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static int f12509n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static int f12510o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static int f12511p;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public short f12513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public short f12514c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public short f12515d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public char f12516e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12517f;

        static {
            a.l();
            init();
        }

        private static native void init();

        public String toString() {
            StringBuilder sb2 = new StringBuilder("KEY_EVENT_RECORD{keyDown=");
            sb2.append(this.f12512a);
            sb2.append(", repeatCount=");
            sb2.append((int) this.f12513b);
            sb2.append(", keyCode=");
            sb2.append((int) this.f12514c);
            sb2.append(", scanCode=");
            sb2.append((int) this.f12515d);
            sb2.append(", uchar=");
            sb2.append(this.f12516e);
            sb2.append(", controlKeyState=");
            return u.a.a(sb2, this.f12517f, f.f14860b);
        }
    }

    public static class MENU_EVENT_RECORD {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static int f12518b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12519a;

        static {
            a.l();
            init();
        }

        private static native void init();
    }

    public static class MOUSE_EVENT_RECORD {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static int f12520e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static int f12521f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static int f12522g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static int f12523h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static int f12524i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static int f12525j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static int f12526k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static int f12527l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static int f12528m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static int f12529n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static int f12530o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static int f12531p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static int f12532q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static int f12533r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static int f12534s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static int f12535t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static int f12536u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static int f12537v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static int f12538w;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public COORD f12539a = new COORD();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12541c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12542d;

        static {
            a.l();
            init();
        }

        private static native void init();

        public String toString() {
            StringBuilder sb2 = new StringBuilder("MOUSE_EVENT_RECORD{mousePosition=");
            sb2.append(this.f12539a);
            sb2.append(", buttonState=");
            sb2.append(this.f12540b);
            sb2.append(", controlKeyState=");
            sb2.append(this.f12541c);
            sb2.append(", eventFlags=");
            return u.a.a(sb2, this.f12542d, f.f14860b);
        }
    }

    public static class SMALL_RECT {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static int f12543e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public short f12544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public short f12545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public short f12546c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public short f12547d;

        static {
            a.l();
            init();
        }

        private static native void init();

        public SMALL_RECT a() {
            SMALL_RECT small_rect = new SMALL_RECT();
            small_rect.f12544a = this.f12544a;
            small_rect.f12545b = this.f12545b;
            small_rect.f12546c = this.f12546c;
            small_rect.f12547d = this.f12547d;
            return small_rect;
        }

        public short b() {
            return (short) (this.f12547d - this.f12545b);
        }

        public short c() {
            return (short) (this.f12546c - this.f12544a);
        }
    }

    public static class WINDOW_BUFFER_SIZE_RECORD {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static int f12548b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public COORD f12549a = new COORD();

        static {
            a.l();
            init();
        }

        private static native void init();

        public String toString() {
            return "WINDOW_BUFFER_SIZE_RECORD{size=" + this.f12549a + f.f14860b;
        }
    }

    static {
        if (a.l()) {
            init();
        }
    }

    public static native int CloseHandle(long j10);

    public static native int FillConsoleOutputAttribute(long j10, short s10, int i10, COORD coord, int[] iArr);

    public static native int FillConsoleOutputCharacterW(long j10, char c10, int i10, COORD coord, int[] iArr);

    public static native int FlushConsoleInputBuffer(long j10);

    public static native int FormatMessageW(int i10, long j10, int i11, int i12, byte[] bArr, int i13, long[] jArr);

    public static native int GetConsoleMode(long j10, int[] iArr);

    public static native int GetConsoleOutputCP();

    public static native int GetConsoleScreenBufferInfo(long j10, CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info);

    public static native int GetLastError();

    public static native int GetNumberOfConsoleInputEvents(long j10, int[] iArr);

    public static native long GetStdHandle(int i10);

    private static native int PeekConsoleInputW(long j10, long j11, int i10, int[] iArr);

    private static native int ReadConsoleInputW(long j10, long j11, int i10, int[] iArr);

    public static native int ScrollConsoleScreenBuffer(long j10, SMALL_RECT small_rect, SMALL_RECT small_rect2, COORD coord, CHAR_INFO char_info);

    public static native int SetConsoleCursorPosition(long j10, COORD coord);

    public static native int SetConsoleMode(long j10, int i10);

    public static native int SetConsoleOutputCP(int i10);

    public static native int SetConsoleTextAttribute(long j10, short s10);

    public static native int SetConsoleTitle(String str);

    public static native int WaitForSingleObject(long j10, int i10);

    public static native int WriteConsoleW(long j10, char[] cArr, int i10, int[] iArr, long j11);

    public static native int _getch();

    public static INPUT_RECORD[] a(long j10, int i10, boolean z10) throws Throwable {
        long jMalloc;
        int[] iArr = new int[1];
        try {
            jMalloc = malloc(INPUT_RECORD.f12490g * i10);
            try {
                if (jMalloc == 0) {
                    throw new IOException("cannot allocate memory with JNI");
                }
                if ((z10 ? PeekConsoleInputW(j10, jMalloc, i10, iArr) : ReadConsoleInputW(j10, jMalloc, i10, iArr)) == 0) {
                    throw new IOException("ReadConsoleInputW failed: " + i.b());
                }
                int i11 = iArr[0];
                if (i11 <= 0) {
                    INPUT_RECORD[] input_recordArr = new INPUT_RECORD[0];
                    if (jMalloc != 0) {
                        free(jMalloc);
                    }
                    return input_recordArr;
                }
                INPUT_RECORD[] input_recordArr2 = new INPUT_RECORD[i11];
                for (int i12 = 0; i12 < i11; i12++) {
                    INPUT_RECORD input_record = new INPUT_RECORD();
                    input_recordArr2[i12] = input_record;
                    int i13 = INPUT_RECORD.f12490g;
                    INPUT_RECORD.memmove(input_record, ((long) (i12 * i13)) + jMalloc, i13);
                }
                if (jMalloc != 0) {
                    free(jMalloc);
                }
                return input_recordArr2;
            } catch (Throwable th2) {
                th = th2;
                if (jMalloc != 0) {
                    free(jMalloc);
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            jMalloc = 0;
        }
    }

    public static INPUT_RECORD[] b(long j10, int i10, boolean z10) throws Throwable {
        INPUT_RECORD[] input_recordArrA;
        int i11;
        int i12;
        do {
            input_recordArrA = a(j10, i10, z10);
            i12 = 0;
            for (INPUT_RECORD input_record : input_recordArrA) {
                if (input_record.f12496a == INPUT_RECORD.f12491h) {
                    i12++;
                }
            }
        } while (i12 <= 0);
        INPUT_RECORD[] input_recordArr = new INPUT_RECORD[i12];
        int i13 = 0;
        for (INPUT_RECORD input_record2 : input_recordArrA) {
            if (input_record2.f12496a == INPUT_RECORD.f12491h) {
                input_recordArr[i13] = input_record2;
                i13++;
            }
        }
        return input_recordArr;
    }

    public static native void free(long j10);

    private static native void init();

    public static native long malloc(long j10);
}

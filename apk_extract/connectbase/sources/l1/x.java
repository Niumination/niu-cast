package l1;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StringBuilder f9631a = new StringBuilder();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9632b;

    /* JADX WARN: Code duplicated, block: B:12:0x001a  */
    public void a(char[] cbuf, int off, int len) throws IOException {
        int i10;
        if (!this.f9632b || len <= 0) {
            i10 = off;
        } else {
            if (c(cbuf[off] == '\n')) {
                i10 = off + 1;
            } else {
                i10 = off;
            }
        }
        int i11 = off + len;
        int i12 = i10;
        while (i10 < i11) {
            char c10 = cbuf[i10];
            if (c10 != '\n') {
                if (c10 == '\r') {
                    this.f9631a.append(cbuf, i12, i10 - i12);
                    this.f9632b = true;
                    int i13 = i10 + 1;
                    if (i13 < i11) {
                        if (c(cbuf[i13] == '\n')) {
                            i10 = i13;
                        }
                    }
                }
                i10++;
            } else {
                this.f9631a.append(cbuf, i12, i10 - i12);
                c(true);
            }
            i12 = i10 + 1;
            i10++;
        }
        this.f9631a.append(cbuf, i12, i11 - i12);
    }

    public void b() throws IOException {
        if (this.f9632b || this.f9631a.length() > 0) {
            c(false);
        }
    }

    @t1.a
    public final boolean c(boolean sawNewline) throws IOException {
        String str;
        if (this.f9632b) {
            str = sawNewline ? "\r\n" : "\r";
        } else {
            str = sawNewline ? "\n" : "";
        }
        d(this.f9631a.toString(), str);
        this.f9631a = new StringBuilder();
        this.f9632b = false;
        return sawNewline;
    }

    public abstract void d(String line, String end) throws IOException;
}

package l1;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Readable f9633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.a
    public final Reader f9634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharBuffer f9635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final char[] f9636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Queue<String> f9637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x f9638f;

    public class a extends x {
        public a() {
        }

        @Override // l1.x
        public void d(String line, String end) {
            z.this.f9637e.add(line);
        }
    }

    public z(Readable readable) {
        CharBuffer charBufferAllocate = CharBuffer.allocate(2048);
        this.f9635c = charBufferAllocate;
        this.f9636d = charBufferAllocate.array();
        this.f9637e = new ArrayDeque();
        this.f9638f = new a();
        readable.getClass();
        this.f9633a = readable;
        this.f9634b = readable instanceof Reader ? (Reader) readable : null;
    }

    @gm.a
    @t1.a
    public String b() throws IOException {
        int i10;
        while (this.f9637e.peek() == null) {
            this.f9635c.clear();
            Reader reader = this.f9634b;
            if (reader != null) {
                char[] cArr = this.f9636d;
                i10 = reader.read(cArr, 0, cArr.length);
            } else {
                i10 = this.f9633a.read(this.f9635c);
            }
            if (i10 == -1) {
                this.f9638f.b();
                break;
            }
            this.f9638f.a(this.f9636d, 0, i10);
        }
        return this.f9637e.poll();
    }
}

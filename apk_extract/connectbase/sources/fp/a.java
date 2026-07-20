package fp;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements q {
    protected int memoizedHashCode = 0;

    public w newUninitializedMessageException() {
        return new w(this);
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        int iV = f.v(serializedSize) + serializedSize;
        if (iV > 4096) {
            iV = 4096;
        }
        f fVarJ = f.J(outputStream, iV);
        fVarJ.o0(serializedSize);
        writeTo(fVarJ);
        fVarJ.I();
    }

    /* JADX INFO: renamed from: fp.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0147a<BuilderType extends AbstractC0147a> implements q.a {
        public static w d(q qVar) {
            return new w(qVar);
        }

        @Override // 
        /* JADX INFO: renamed from: a */
        public abstract BuilderType l();

        @Override // fp.q.a
        /* JADX INFO: renamed from: b */
        public abstract BuilderType c(e eVar, g gVar) throws IOException;

        /* JADX INFO: renamed from: fp.a$a$a, reason: collision with other inner class name */
        public static final class C0148a extends FilterInputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6195a;

            public C0148a(InputStream inputStream, int i10) {
                super(inputStream);
                this.f6195a = i10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.f6195a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f6195a <= 0) {
                    return -1;
                }
                int i10 = super.read();
                if (i10 >= 0) {
                    this.f6195a--;
                }
                return i10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j10) throws IOException {
                long jSkip = super.skip(Math.min(j10, this.f6195a));
                if (jSkip >= 0) {
                    this.f6195a = (int) (((long) this.f6195a) - jSkip);
                }
                return jSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i10, int i11) throws IOException {
                int i12 = this.f6195a;
                if (i12 <= 0) {
                    return -1;
                }
                int i13 = super.read(bArr, i10, Math.min(i11, i12));
                if (i13 >= 0) {
                    this.f6195a -= i13;
                }
                return i13;
            }
        }
    }
}

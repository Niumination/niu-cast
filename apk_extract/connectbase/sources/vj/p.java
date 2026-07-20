package vj;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
@e0("https://github.com/grpc/grpc-java/issues/1704")
public interface p extends s, z {

    public static final class a implements p {
        @Override // vj.s, vj.z
        public String a() {
            return "gzip";
        }

        @Override // vj.z
        public InputStream b(InputStream inputStream) throws IOException {
            return new GZIPInputStream(inputStream);
        }

        @Override // vj.s
        public OutputStream c(OutputStream outputStream) throws IOException {
            return new GZIPOutputStream(outputStream);
        }
    }

    public static final class b implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f17223a = new b();

        @Override // vj.s, vj.z
        public String a() {
            return "identity";
        }

        @Override // vj.z
        public InputStream b(InputStream inputStream) {
            return inputStream;
        }

        @Override // vj.s
        public OutputStream c(OutputStream outputStream) {
            return outputStream;
        }
    }
}

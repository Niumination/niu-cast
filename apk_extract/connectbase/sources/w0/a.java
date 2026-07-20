package w0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
public class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final HttpURLConnection f17899a;

    public a(@NonNull HttpURLConnection httpURLConnection) {
        this.f17899a = httpURLConnection;
    }

    @Override // w0.d
    @Nullable
    public String U() {
        return this.f17899a.getContentType();
    }

    @Override // w0.d
    @NonNull
    public InputStream Z() throws IOException {
        return this.f17899a.getInputStream();
    }

    public final String b(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            try {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        sb2.append(line);
                        sb2.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused2) {
                    }
                    throw th2;
                }
            } catch (Exception e10) {
                throw e10;
            }
        }
        bufferedReader.close();
        return sb2.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f17899a.disconnect();
    }

    @Override // w0.d
    @Nullable
    public String k1() {
        try {
            if (o0()) {
                return null;
            }
            return "Unable to fetch " + this.f17899a.getURL() + ". Failed with " + this.f17899a.getResponseCode() + "\n" + b(this.f17899a);
        } catch (IOException e10) {
            z0.d.f("get error failed ", e10);
            return e10.getMessage();
        }
    }

    @Override // w0.d
    public boolean o0() {
        try {
            return this.f17899a.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }
}

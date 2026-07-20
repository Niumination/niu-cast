package w0;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import n0.p;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final g f17902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final f f17903b;

    public h(@NonNull g gVar, @NonNull f fVar) {
        this.f17902a = gVar;
        this.f17903b = fVar;
    }

    @Nullable
    @WorkerThread
    public final n0.g a(@NonNull String str, @Nullable String str2) {
        Pair<c, InputStream> pairB;
        if (str2 == null || (pairB = this.f17902a.b(str)) == null) {
            return null;
        }
        c cVar = (c) pairB.first;
        InputStream inputStream = (InputStream) pairB.second;
        n0.g gVar = (cVar == c.ZIP ? n0.h.B(new ZipInputStream(inputStream), str) : n0.h.k(inputStream, str)).f11070a;
        if (gVar != null) {
            return gVar;
        }
        return null;
    }

    @NonNull
    @WorkerThread
    public final p<n0.g> b(@NonNull String str, @Nullable String str2) {
        z0.d.a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                d dVarA = this.f17903b.a(str);
                if (!dVarA.o0()) {
                    p<n0.g> pVar = new p<>(new IllegalArgumentException(dVarA.k1()));
                    try {
                        dVarA.close();
                    } catch (IOException e10) {
                        z0.d.f("LottieFetchResult close failed ", e10);
                    }
                    return pVar;
                }
                p<n0.g> pVarD = d(str, dVarA.Z(), dVarA.U(), str2);
                StringBuilder sb2 = new StringBuilder("Completed fetch from network. Success: ");
                sb2.append(pVarD.f11070a != null);
                z0.d.a(sb2.toString());
                try {
                    dVarA.close();
                } catch (IOException e11) {
                    z0.d.f("LottieFetchResult close failed ", e11);
                }
                return pVarD;
            } catch (Exception e12) {
                p<n0.g> pVar2 = new p<>(e12);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e13) {
                        z0.d.f("LottieFetchResult close failed ", e13);
                    }
                }
                return pVar2;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e14) {
                    z0.d.f("LottieFetchResult close failed ", e14);
                }
            }
            throw th2;
        }
    }

    @NonNull
    @WorkerThread
    public p<n0.g> c(@NonNull String str, @Nullable String str2) {
        n0.g gVarA = a(str, str2);
        if (gVarA != null) {
            return new p<>(gVarA);
        }
        z0.d.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(str, str2);
    }

    @NonNull
    public final p<n0.g> d(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) throws IOException {
        c cVar;
        p<n0.g> pVarF;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str.split("\\?")[0].endsWith(".lottie")) {
            z0.d.a("Handling zip response.");
            cVar = c.ZIP;
            pVarF = f(str, inputStream, str3);
        } else {
            z0.d.a("Received json response.");
            cVar = c.JSON;
            pVarF = e(str, inputStream, str3);
        }
        if (str3 != null && pVarF.f11070a != null) {
            this.f17902a.f(str, cVar);
        }
        return pVarF;
    }

    @NonNull
    public final p<n0.g> e(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        return str2 == null ? n0.h.k(inputStream, null) : n0.h.k(new FileInputStream(new File(this.f17902a.g(str, inputStream, c.JSON).getAbsolutePath())), str);
    }

    @NonNull
    public final p<n0.g> f(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        return str2 == null ? n0.h.B(new ZipInputStream(inputStream), null) : n0.h.B(new ZipInputStream(new FileInputStream(this.f17902a.g(str, inputStream, c.ZIP))), str);
    }
}

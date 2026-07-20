package d5;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.connectx.mirror.source.SourceApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import k4.j;
import k4.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e<T, R> implements g<T, R> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f3533d = "BaseLocalConfigDataSource";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<T> f3534a = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h<T> f3536c;

    @Override // d5.g
    public void a() {
        if (this.f3534a.isEmpty()) {
            this.f3534a.addAll(e(this.f3535b));
        }
    }

    @Override // d5.g
    @NonNull
    public Collection<T> b() {
        return this.f3534a;
    }

    @Override // d5.g
    public void c() {
        this.f3534a.clear();
        this.f3534a.addAll(e(this.f3535b));
    }

    @Override // d5.g
    @Nullable
    public T d(R r10) {
        if (TextUtils.isEmpty((CharSequence) r10)) {
            return null;
        }
        ConcurrentLinkedQueue<T> concurrentLinkedQueue = this.f3534a;
        Objects.requireNonNull(r10);
        return (T) i6.b.c(concurrentLinkedQueue, new d(r10));
    }

    public List<T> e(String str) throws Throwable {
        String strA = k4.b.a(SourceApplication.b(), str);
        if (TextUtils.isEmpty(strA)) {
            return new ArrayList();
        }
        try {
            h<T> hVar = (h) j.a.f8962a.a(strA, this.f3536c.getClass());
            this.f3536c = hVar;
            return (hVar == null || hVar.b() == null || this.f3536c.b().isEmpty()) ? new ArrayList() : this.f3536c.b();
        } catch (Exception e10) {
            m.c(f3533d, "get data from local is error: " + e10.getMessage());
            return new ArrayList();
        }
    }
}

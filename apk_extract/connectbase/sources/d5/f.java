package d5;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
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
public abstract class f<T, R> implements g<T, R> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f3537e = "BaseRemoteConfigDataSource";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f3538f = "com_transsion_connectx_mirror_source_blacklist";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f3539g = "com_transsion_connectx_mirror_source_broadwidthlist";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f3540h = "com_transsion_connectx_mirror_source_securelist";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f3541i = "com_transsion_connectx_mirror_source_securewindowlist";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f3542j = "content://com.hoffnung.cloudControl.RemoteConfigProvider/config/";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h<T> f3545c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<T> f3543a = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<T> f3546d = new ArrayList();

    public class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContentResolver f3547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f3548b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Handler handler, ContentResolver contentResolver, Uri uri) {
            super(handler);
            this.f3547a = contentResolver;
            this.f3548b = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
            f fVar = f.this;
            fVar.f3546d = fVar.g(this.f3547a, this.f3548b);
        }
    }

    @Override // d5.g
    public void a() {
        if (this.f3543a.isEmpty()) {
            this.f3543a.addAll(h(SourceApplication.b()));
        }
    }

    @Override // d5.g
    @NonNull
    public Collection<T> b() {
        return this.f3543a;
    }

    @Override // d5.g
    public void c() {
        this.f3543a.clear();
        this.f3543a.addAll(h(SourceApplication.b()));
    }

    @Override // d5.g
    @Nullable
    public T d(R r10) {
        if (TextUtils.isEmpty((CharSequence) r10)) {
            return null;
        }
        ConcurrentLinkedQueue<T> concurrentLinkedQueue = this.f3543a;
        Objects.requireNonNull(r10);
        return (T) i6.b.c(concurrentLinkedQueue, new d(r10));
    }

    public final List<T> g(ContentResolver contentResolver, Uri uri) {
        try {
            Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToNext()) {
                this.f3545c = (h) j.a.f8962a.a(cursorQuery.getString(cursorQuery.getColumnIndex(this.f3544b)), this.f3545c.getClass());
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e10) {
            m.c(f3537e, "get data from remote is error: " + e10.getMessage());
        }
        h<T> hVar = this.f3545c;
        return (hVar == null || hVar.b() == null || this.f3545c.b().isEmpty()) ? new ArrayList() : this.f3545c.b();
    }

    public List<T> h(Context context) {
        try {
            Uri uri = Uri.parse(f3542j + this.f3544b);
            ContentResolver contentResolver = context.getContentResolver();
            contentResolver.registerContentObserver(uri, false, new a(new Handler(Looper.getMainLooper()), contentResolver, uri));
            this.f3546d = g(contentResolver, uri);
        } catch (Exception e10) {
            m.d(f3537e, e10);
        }
        return this.f3546d;
    }
}

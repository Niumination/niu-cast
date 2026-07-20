package n0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final w0.f f10976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final w0.e f10977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10978c;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public w0.f f10979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public w0.e f10980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10981c = false;

        public class a implements w0.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ File f10982a;

            public a(File file) {
                this.f10982a = file;
            }

            @Override // w0.e
            @NonNull
            public File a() {
                if (this.f10982a.isDirectory()) {
                    return this.f10982a;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        /* JADX INFO: renamed from: n0.i$b$b, reason: collision with other inner class name */
        public class C0288b implements w0.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ w0.e f10984a;

            public C0288b(w0.e eVar) {
                this.f10984a = eVar;
            }

            @Override // w0.e
            @NonNull
            public File a() {
                File fileA = this.f10984a.a();
                if (fileA.isDirectory()) {
                    return fileA;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        @NonNull
        public i a() {
            return new i(this.f10979a, this.f10980b, this.f10981c);
        }

        @NonNull
        public b b(boolean z10) {
            this.f10981c = z10;
            return this;
        }

        @NonNull
        public b c(@NonNull File file) {
            if (this.f10980b != null) {
                throw new IllegalStateException("There is already a cache provider!");
            }
            this.f10980b = new a(file);
            return this;
        }

        @NonNull
        public b d(@NonNull w0.e eVar) {
            if (this.f10980b != null) {
                throw new IllegalStateException("There is already a cache provider!");
            }
            this.f10980b = new C0288b(eVar);
            return this;
        }

        @NonNull
        public b e(@NonNull w0.f fVar) {
            this.f10979a = fVar;
            return this;
        }
    }

    public i(@Nullable w0.f fVar, @Nullable w0.e eVar, boolean z10) {
        this.f10976a = fVar;
        this.f10977b = eVar;
        this.f10978c = z10;
    }
}

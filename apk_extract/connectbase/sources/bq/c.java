package bq;

import kn.l0;
import kn.w;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1046a;

    public static final class a extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final a f1047b = new a(false);

        public a() {
            super(false);
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final String f1048b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@os.l String str) {
            super(false);
            l0.p(str, "error");
            this.f1048b = str;
        }
    }

    /* JADX INFO: renamed from: bq.c$c, reason: collision with other inner class name */
    public static final class C0045c extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final C0045c f1049b = new C0045c(true);

        public C0045c() {
            super(true);
        }
    }

    public /* synthetic */ c(boolean z10, w wVar) {
        this(z10);
    }

    public final boolean a() {
        return this.f1046a;
    }

    public c(boolean z10) {
        this.f1046a = z10;
    }
}

package yk;

import androidx.core.app.NotificationCompat;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends nl.e<l2, dk.b> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public static final a f21359v = new a();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public static final nl.j f21360w = new nl.j("before");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public static final nl.j f21361x = new nl.j(NotificationCompat.CATEGORY_CALL);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f21362i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public final uk.b f21363n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public final vk.d f21364p;

    public static final class a {
        public a() {
        }

        @os.l
        public final nl.j a() {
            return a0.f21360w;
        }

        @os.l
        public final nl.j b() {
            return a0.f21361x;
        }

        public a(kn.w wVar) {
        }
    }

    public a0() {
        this(false, 1, null);
    }

    @os.l
    public final uk.b S() {
        return this.f21363n;
    }

    @os.l
    public final vk.d T() {
        return this.f21364p;
    }

    @Override // nl.e
    public boolean m() {
        return this.f21362i;
    }

    public /* synthetic */ a0(boolean z10, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? false : z10);
    }

    public a0(boolean z10) {
        super(f21360w, f21361x);
        this.f21362i = z10;
        this.f21363n = new uk.b(z10);
        this.f21364p = new vk.d(z10);
    }
}

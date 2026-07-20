package yk;

import androidx.core.app.NotificationCompat;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k implements uk.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final dk.b f21418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final uk.b f21419b;

    public k(@os.l dk.b bVar) {
        l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        this.f21418a = bVar;
        uk.b bVar2 = new uk.b(bVar.a().I.h());
        bVar2.C(bVar.a().f3712n);
        this.f21419b = bVar2;
    }

    @Override // uk.d
    @os.l
    public uk.b c() {
        return this.f21419b;
    }

    @Override // uk.d
    @os.l
    public final dk.b f() {
        return this.f21418a;
    }
}

package o4;

import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements u4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f8376b = new f(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f8377c = new f(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8378a;

    public /* synthetic */ f(int i8) {
        this.f8378a = i8;
    }

    @Override // u4.a
    public final Object get() {
        switch (this.f8378a) {
            case 0:
                return Collections.emptySet();
            default:
                return null;
        }
    }
}

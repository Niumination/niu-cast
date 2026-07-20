package s4;

import q4.f;
import q4.g;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f9498b = new b(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f9499c = new b(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9500a;

    public /* synthetic */ b(int i8) {
        this.f9500a = i8;
    }

    @Override // q4.a
    public final void a(Object obj, Object obj2) {
        switch (this.f9500a) {
            case 0:
                c cVar = d.e;
                ((g) obj2).c((String) obj);
                break;
            default:
                c cVar2 = d.e;
                ((g) obj2).d(((Boolean) obj).booleanValue());
                break;
        }
    }
}

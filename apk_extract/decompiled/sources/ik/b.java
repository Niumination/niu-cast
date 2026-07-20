package ik;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ek.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5887b;

    public /* synthetic */ b(Object obj, int i8) {
        this.f5886a = i8;
        this.f5887b = obj;
    }

    @Override // ek.g
    public final Object call(Object obj) {
        switch (this.f5886a) {
            case 0:
                Object obj2 = this.f5887b;
                return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
            default:
                return Boolean.valueOf(((Class) this.f5887b).isInstance(obj));
        }
    }
}

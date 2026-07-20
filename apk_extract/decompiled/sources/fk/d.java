package fk;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f5057a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5058b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f5059c = new b();

    public static boolean a(ck.d dVar, Object obj) {
        if (obj == f5058b) {
            dVar.onCompleted();
            return true;
        }
        if (obj == f5059c) {
            dVar.onNext(null);
            return false;
        }
        if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
        if (obj.getClass() == c.class) {
            dVar.onError(((c) obj).e);
            return true;
        }
        dVar.onNext(obj);
        return false;
    }
}

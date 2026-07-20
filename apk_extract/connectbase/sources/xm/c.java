package xm;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements um.d<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final c f20292a = new c();

    @Override // um.d
    @os.l
    public um.g getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // um.d
    public void resumeWith(@os.l Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    @os.l
    public String toString() {
        return "This continuation is already complete";
    }
}

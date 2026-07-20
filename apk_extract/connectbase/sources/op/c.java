package op;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final a f12365a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f12366b;

        static {
            d.a aVar = d.f12368c;
            aVar.getClass();
            int i10 = d.f12376k;
            aVar.getClass();
            int i11 = d.f12374i;
            aVar.getClass();
            f12366b = (~(d.f12375j | i11)) & i10;
        }

        @Override // op.c
        public int a() {
            return f12366b;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final b f12367a = new b();

        @Override // op.c
        public int a() {
            return 0;
        }
    }

    public abstract int a();

    public String toString() {
        return getClass().getSimpleName();
    }
}

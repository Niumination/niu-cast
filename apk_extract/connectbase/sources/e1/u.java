package e1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
@b1.b
@i
public abstract class u {
    public static final u EXPLICIT = new a("EXPLICIT", 0);
    public static final u REPLACED = new u("REPLACED", 1) { // from class: e1.u.b
        @Override // e1.u
        public boolean wasEvicted() {
            return false;
        }
    };
    public static final u COLLECTED = new u("COLLECTED", 2) { // from class: e1.u.c
        @Override // e1.u
        public boolean wasEvicted() {
            return true;
        }
    };
    public static final u EXPIRED = new u("EXPIRED", 3) { // from class: e1.u.d
        @Override // e1.u
        public boolean wasEvicted() {
            return true;
        }
    };
    public static final u SIZE = new u("SIZE", 4) { // from class: e1.u.e
        @Override // e1.u
        public boolean wasEvicted() {
            return true;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ u[] f4034a = a();

    public final enum a extends u {
        public a(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, null);
        }

        @Override // e1.u
        public boolean wasEvicted() {
            return false;
        }
    }

    public u(String $enum$name, int $enum$ordinal) {
        super($enum$name, $enum$ordinal);
    }

    public static /* synthetic */ u[] a() {
        return new u[]{EXPLICIT, REPLACED, COLLECTED, EXPIRED, SIZE};
    }

    public static u valueOf(String name) {
        return (u) Enum.valueOf(u.class, name);
    }

    public static u[] values() {
        return (u[]) f4034a.clone();
    }

    public abstract boolean wasEvicted();

    public u(String str, int i10, a aVar) {
        super(str, i10);
    }
}

package un;

import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
public interface n extends un.b {

    public static final class a {
        @f1(version = "1.1")
        public static /* synthetic */ void a() {
        }
    }

    public enum b {
        INSTANCE,
        EXTENSION_RECEIVER,
        VALUE;


        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ ym.a f16345b = ym.c.c(a());

        @os.l
        public static ym.a<b> getEntries() {
            return f16345b;
        }
    }

    boolean b();

    int f();

    @os.l
    b getKind();

    @os.m
    String getName();

    @os.l
    s getType();

    boolean z();
}

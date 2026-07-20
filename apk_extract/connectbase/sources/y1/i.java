package y1;

import java.io.IOException;
import v1.a0;
import v1.u;
import v1.x;
import v1.y;
import v1.z;

/* JADX INFO: loaded from: classes.dex */
public final class i extends z<Number> {
    private static final a0 LAZILY_PARSED_NUMBER_FACTORY = newFactory(x.LAZILY_PARSED_NUMBER);
    private final y toNumberStrategy;

    public class a implements a0 {
        public a() {
        }

        @Override // v1.a0
        public <T> z<T> create(v1.e eVar, c2.a<T> aVar) {
            if (aVar.getRawType() == Number.class) {
                return i.this;
            }
            return null;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20626a;

        static {
            int[] iArr = new int[d2.c.values().length];
            f20626a = iArr;
            try {
                iArr[d2.c.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20626a[d2.c.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20626a[d2.c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private i(y yVar) {
        this.toNumberStrategy = yVar;
    }

    public static a0 getFactory(y yVar) {
        return yVar == x.LAZILY_PARSED_NUMBER ? LAZILY_PARSED_NUMBER_FACTORY : newFactory(yVar);
    }

    private static a0 newFactory(y yVar) {
        return new i(yVar).new a();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // v1.z
    public Number read(d2.a aVar) throws IOException {
        d2.c cVarPeek = aVar.peek();
        int i10 = b.f20626a[cVarPeek.ordinal()];
        if (i10 == 1) {
            aVar.nextNull();
            return null;
        }
        if (i10 == 2 || i10 == 3) {
            return this.toNumberStrategy.readNumber(aVar);
        }
        throw new u("Expecting number, got: " + cVarPeek + "; at path " + aVar.getPath());
    }

    @Override // v1.z
    public void write(d2.d dVar, Number number) throws IOException {
        dVar.value(number);
    }
}

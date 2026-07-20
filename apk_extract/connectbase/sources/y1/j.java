package y1;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import v1.a0;
import v1.x;
import v1.y;
import v1.z;

/* JADX INFO: loaded from: classes.dex */
public final class j extends z<Object> {
    private static final a0 DOUBLE_FACTORY = newFactory(x.DOUBLE);
    private final v1.e gson;
    private final y toNumberStrategy;

    public class a implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f20627a;

        public a(y yVar) {
            this.f20627a = yVar;
        }

        @Override // v1.a0
        public <T> z<T> create(v1.e eVar, c2.a<T> aVar) {
            a aVar2 = null;
            if (aVar.getRawType() == Object.class) {
                return new j(eVar, this.f20627a, aVar2);
            }
            return null;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20628a;

        static {
            int[] iArr = new int[d2.c.values().length];
            f20628a = iArr;
            try {
                iArr[d2.c.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20628a[d2.c.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20628a[d2.c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20628a[d2.c.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20628a[d2.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20628a[d2.c.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public /* synthetic */ j(v1.e eVar, y yVar, a aVar) {
        this(eVar, yVar);
    }

    public static a0 getFactory(y yVar) {
        return yVar == x.DOUBLE ? DOUBLE_FACTORY : newFactory(yVar);
    }

    private static a0 newFactory(y yVar) {
        return new a(yVar);
    }

    private Object readTerminal(d2.a aVar, d2.c cVar) throws IOException {
        int i10 = b.f20628a[cVar.ordinal()];
        if (i10 == 3) {
            return aVar.nextString();
        }
        if (i10 == 4) {
            return this.toNumberStrategy.readNumber(aVar);
        }
        if (i10 == 5) {
            return Boolean.valueOf(aVar.nextBoolean());
        }
        if (i10 == 6) {
            aVar.nextNull();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + cVar);
    }

    private Object tryBeginNesting(d2.a aVar, d2.c cVar) throws IOException {
        int i10 = b.f20628a[cVar.ordinal()];
        if (i10 == 1) {
            aVar.beginArray();
            return new ArrayList();
        }
        if (i10 != 2) {
            return null;
        }
        aVar.beginObject();
        return new x1.i();
    }

    @Override // v1.z
    public Object read(d2.a aVar) throws IOException {
        d2.c cVarPeek = aVar.peek();
        Object objTryBeginNesting = tryBeginNesting(aVar, cVarPeek);
        if (objTryBeginNesting == null) {
            return readTerminal(aVar, cVarPeek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.hasNext()) {
                String strNextName = objTryBeginNesting instanceof Map ? aVar.nextName() : null;
                d2.c cVarPeek2 = aVar.peek();
                Object objTryBeginNesting2 = tryBeginNesting(aVar, cVarPeek2);
                boolean z10 = objTryBeginNesting2 != null;
                if (objTryBeginNesting2 == null) {
                    objTryBeginNesting2 = readTerminal(aVar, cVarPeek2);
                }
                if (objTryBeginNesting instanceof List) {
                    ((List) objTryBeginNesting).add(objTryBeginNesting2);
                } else {
                    ((Map) objTryBeginNesting).put(strNextName, objTryBeginNesting2);
                }
                if (z10) {
                    arrayDeque.addLast(objTryBeginNesting);
                    objTryBeginNesting = objTryBeginNesting2;
                }
            } else {
                if (objTryBeginNesting instanceof List) {
                    aVar.endArray();
                } else {
                    aVar.endObject();
                }
                if (arrayDeque.isEmpty()) {
                    return objTryBeginNesting;
                }
                objTryBeginNesting = arrayDeque.removeLast();
            }
        }
    }

    @Override // v1.z
    public void write(d2.d dVar, Object obj) throws IOException {
        if (obj == null) {
            dVar.nullValue();
            return;
        }
        z adapter = this.gson.getAdapter(obj.getClass());
        if (!(adapter instanceof j)) {
            adapter.write(dVar, obj);
        } else {
            dVar.beginObject();
            dVar.endObject();
        }
    }

    private j(v1.e eVar, y yVar) {
        this.gson = eVar;
        this.toNumberStrategy = yVar;
    }
}

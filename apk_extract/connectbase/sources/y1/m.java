package y1;

import java.io.IOException;
import java.lang.reflect.Type;
import v1.a0;
import v1.r;
import v1.s;
import v1.z;

/* JADX INFO: loaded from: classes.dex */
public final class m<T> extends l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v1.e f20649a;
    private final m<T>.b context;
    private volatile z<T> delegate;
    private final v1.j<T> deserializer;
    private final boolean nullSafe;
    private final s<T> serializer;
    private final a0 skipPast;
    private final c2.a<T> typeToken;

    public final class b implements r, v1.i {
        public b() {
        }

        @Override // v1.i
        public <R> R deserialize(v1.k kVar, Type type) throws v1.o {
            return (R) m.this.f20649a.fromJson(kVar, type);
        }

        @Override // v1.r
        public v1.k serialize(Object obj) {
            return m.this.f20649a.toJsonTree(obj);
        }

        @Override // v1.r
        public v1.k serialize(Object obj, Type type) {
            return m.this.f20649a.toJsonTree(obj, type);
        }
    }

    public static final class c implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c2.a<?> f20651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f20652b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class<?> f20653c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final s<?> f20654d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final v1.j<?> f20655e;

        public c(Object obj, c2.a<?> aVar, boolean z10, Class<?> cls) {
            s<?> sVar = obj instanceof s ? (s) obj : null;
            this.f20654d = sVar;
            v1.j<?> jVar = obj instanceof v1.j ? (v1.j) obj : null;
            this.f20655e = jVar;
            x1.a.checkArgument((sVar == null && jVar == null) ? false : true);
            this.f20651a = aVar;
            this.f20652b = z10;
            this.f20653c = cls;
        }

        @Override // v1.a0
        public <T> z<T> create(v1.e eVar, c2.a<T> aVar) {
            boolean zIsAssignableFrom;
            c2.a<?> aVar2 = this.f20651a;
            if (aVar2 != null) {
                zIsAssignableFrom = aVar2.equals(aVar) || (this.f20652b && this.f20651a.getType() == aVar.getRawType());
            } else {
                zIsAssignableFrom = this.f20653c.isAssignableFrom(aVar.getRawType());
            }
            if (zIsAssignableFrom) {
                return new m(this.f20654d, this.f20655e, eVar, aVar, this);
            }
            return null;
        }
    }

    public m(s<T> sVar, v1.j<T> jVar, v1.e eVar, c2.a<T> aVar, a0 a0Var, boolean z10) {
        this.context = new b();
        this.serializer = sVar;
        this.deserializer = jVar;
        this.f20649a = eVar;
        this.typeToken = aVar;
        this.skipPast = a0Var;
        this.nullSafe = z10;
    }

    private z<T> delegate() {
        z<T> zVar = this.delegate;
        if (zVar != null) {
            return zVar;
        }
        z<T> delegateAdapter = this.f20649a.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static a0 newFactory(c2.a<?> aVar, Object obj) {
        return new c(obj, aVar, false, null);
    }

    public static a0 newFactoryWithMatchRawType(c2.a<?> aVar, Object obj) {
        return new c(obj, aVar, aVar.getType() == aVar.getRawType(), null);
    }

    public static a0 newTypeHierarchyFactory(Class<?> cls, Object obj) {
        return new c(obj, null, false, cls);
    }

    @Override // y1.l
    public z<T> getSerializationDelegate() {
        return this.serializer != null ? this : delegate();
    }

    @Override // v1.z
    public T read(d2.a aVar) throws IOException {
        if (this.deserializer == null) {
            return delegate().read(aVar);
        }
        v1.k kVar = x1.o.parse(aVar);
        if (this.nullSafe && kVar.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(kVar, this.typeToken.getType(), this.context);
    }

    @Override // v1.z
    public void write(d2.d dVar, T t10) throws IOException {
        s<T> sVar = this.serializer;
        if (sVar == null) {
            delegate().write(dVar, t10);
        } else if (this.nullSafe && t10 == null) {
            dVar.nullValue();
        } else {
            x1.o.write(sVar.serialize(t10, this.typeToken.getType(), this.context), dVar);
        }
    }

    public m(s<T> sVar, v1.j<T> jVar, v1.e eVar, c2.a<T> aVar, a0 a0Var) {
        this(sVar, jVar, eVar, aVar, a0Var, true);
    }
}

package y1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import v1.z;

/* JADX INFO: loaded from: classes.dex */
public final class n<T> extends z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v1.e f20656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z<T> f20657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type f20658c;

    public n(v1.e eVar, z<T> zVar, Type type) {
        this.f20656a = eVar;
        this.f20657b = zVar;
        this.f20658c = type;
    }

    public static Type a(Type type, Object obj) {
        if (obj != null) {
            return ((type instanceof Class) || (type instanceof TypeVariable)) ? obj.getClass() : type;
        }
        return type;
    }

    public static boolean b(z<?> zVar) {
        z<?> serializationDelegate;
        while ((zVar instanceof l) && (serializationDelegate = ((l) zVar).getSerializationDelegate()) != zVar) {
            zVar = serializationDelegate;
        }
        return zVar instanceof k.b;
    }

    @Override // v1.z
    public T read(d2.a aVar) throws IOException {
        return this.f20657b.read(aVar);
    }

    @Override // v1.z
    public void write(d2.d dVar, T t10) throws IOException {
        z<T> adapter = this.f20657b;
        Type typeA = a(this.f20658c, t10);
        if (typeA != this.f20658c) {
            adapter = this.f20656a.getAdapter(c2.a.get(typeA));
            if ((adapter instanceof k.b) && !b(this.f20657b)) {
                adapter = this.f20657b;
            }
        }
        adapter.write(dVar, t10);
    }
}

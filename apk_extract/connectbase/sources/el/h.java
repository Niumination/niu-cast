package el;

import ik.y0;
import java.util.Iterator;
import java.util.Map;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final f0 f4527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Map<String, l<?>> f4528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4529c;

    /* JADX WARN: Multi-variable type inference failed */
    public h(@os.l f0 f0Var, @os.l Map<String, ? extends l<?>> map) {
        l0.p(f0Var, "sessions");
        l0.p(map, "providerData");
        this.f4527a = f0Var;
        this.f4528b = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ h h(h hVar, f0 f0Var, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f0Var = hVar.f4527a;
        }
        if ((i10 & 2) != 0) {
            map = hVar.f4528b;
        }
        return hVar.g(f0Var, map);
    }

    @Override // el.d
    public void a(@os.l String str) {
        l0.p(str, "name");
        l<?> lVar = this.f4528b.get(str);
        if (lVar == null) {
            throw new IllegalStateException(n.a.a("Session data for `", str, "` was not registered"));
        }
        lVar.f4535a = null;
    }

    @Override // el.d
    public void b(@os.l String str, @os.m Object obj) {
        l0.p(str, "name");
        if (this.f4529c) {
            throw new i0();
        }
        l<?> lVar = this.f4528b.get(str);
        if (lVar == null) {
            throw new IllegalStateException(n.a.a("Session data for `", str, "` was not registered"));
        }
        k(lVar, obj);
    }

    @Override // el.d
    @os.l
    public String c(@os.l un.d<?> dVar) {
        Object next;
        l0.p(dVar, y0.a.f8215h);
        Iterator<T> it = this.f4528b.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!l0.g(((l) ((Map.Entry) next).getValue()).f4537c.f4532b, dVar));
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return ((l) entry.getValue()).f4537c.f4531a;
        }
        throw new IllegalArgumentException("Session data for type `" + dVar + "` was not registered");
    }

    public final void d() {
        this.f4529c = true;
    }

    @os.l
    public final f0 e() {
        return this.f4527a;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return l0.g(this.f4527a, hVar.f4527a) && l0.g(this.f4528b, hVar.f4528b);
    }

    @os.l
    public final Map<String, l<?>> f() {
        return this.f4528b;
    }

    @os.l
    public final h g(@os.l f0 f0Var, @os.l Map<String, ? extends l<?>> map) {
        l0.p(f0Var, "sessions");
        l0.p(map, "providerData");
        return new h(f0Var, map);
    }

    @Override // el.d
    @os.m
    public Object get(@os.l String str) {
        l0.p(str, "name");
        l<?> lVar = this.f4528b.get(str);
        if (lVar != null) {
            return lVar.f4535a;
        }
        throw new IllegalStateException(n.a.a("Session data for `", str, "` was not registered"));
    }

    public int hashCode() {
        return this.f4528b.hashCode() + (this.f4527a.hashCode() * 31);
    }

    @os.l
    public final Map<String, l<?>> i() {
        return this.f4528b;
    }

    @os.l
    public final f0 j() {
        return this.f4527a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <S> void k(l<S> lVar, Object obj) {
        if (obj != 0) {
            lVar.f4537c.f4534d.validate(obj);
        }
        if (obj == 0) {
            throw new NullPointerException("null cannot be cast to non-null type S of io.ktor.sessions.SessionData.setTyped");
        }
        lVar.f4535a = obj;
    }

    @os.l
    public String toString() {
        return "SessionData(sessions=" + this.f4527a + ", providerData=" + this.f4528b + ')';
    }
}

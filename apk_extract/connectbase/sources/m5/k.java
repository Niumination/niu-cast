package m5;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10473d = "FileRelationInfoContainer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, o1> f10474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, o1> f10475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, o1> f10476c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f10477a = new k();
    }

    public static /* synthetic */ boolean B(String str, o1 o1Var) {
        return o1Var.g().equals(str);
    }

    public static /* synthetic */ boolean C(String str, o1 o1Var) {
        return o1Var.g().equals(str);
    }

    public static /* synthetic */ boolean D(String str, o1 o1Var) {
        return o1Var.f().equals(str);
    }

    public static /* synthetic */ boolean E(String str, o1 o1Var) {
        return o1Var.g().equals(str);
    }

    public static /* synthetic */ boolean F(String str, o1 o1Var) {
        return o1Var.g().equals(str);
    }

    public static /* synthetic */ boolean G(o1 o1Var) {
        return o1Var.d() == 1;
    }

    public static /* synthetic */ boolean H(o1 o1Var) {
        return o1Var.d() == 0;
    }

    public static k m() {
        return a.f10477a;
    }

    public void A(String str, o1 o1Var) {
        this.f10476c.put(str, o1Var);
    }

    public void I(String str, String str2) {
        o1 o1Var = this.f10475b.get(str);
        if (o1Var == null) {
            d6.a.I(f10473d, m.a.a("send file container no id:", str));
        } else {
            o1Var.n(str2);
        }
    }

    public void J(String str, String str2) {
        o1 o1Var = this.f10475b.get(str);
        if (o1Var == null) {
            d6.a.I(f10473d, m.a.a("send file container no id:", str));
        } else {
            o1Var.o(str2);
        }
    }

    public void K(String str, String str2) {
        o1 o1Var = this.f10475b.get(str);
        if (o1Var == null) {
            d6.a.I(f10473d, m.a.a("send file container no id:", str));
        } else {
            o1Var.p(str2);
        }
    }

    public void L(String str, String str2) {
        o1 o1Var = this.f10476c.get(str);
        if (o1Var == null) {
            d6.a.I(f10473d, m.a.a("send file container no id:", str));
        } else {
            o1Var.o(str2);
        }
    }

    public void M(String str, String str2) {
        d6.a.I(f10473d, m.a.a("id:", str));
        o1 o1Var = this.f10476c.get(str);
        if (o1Var == null) {
            d6.a.I(f10473d, m.a.a("send file container no id:", str));
        } else {
            o1Var.p(str2);
        }
    }

    public Set<String> N() {
        return this.f10475b.keySet();
    }

    public Set<String> O() {
        return (Set) this.f10475b.values().stream().map(new c()).collect(Collectors.toSet());
    }

    public Collection<o1> P() {
        return this.f10475b.values();
    }

    public void Q() {
        j();
        k();
        i();
    }

    public void R(String str) {
        if (TextUtils.isEmpty(str)) {
            d6.a.I(f10473d, m.a.a("removeTccpSyncMap: sessionId no exist:", str));
        } else {
            this.f10474a.remove(str);
        }
    }

    public void S(String str) {
        if (TextUtils.isEmpty(str)) {
            d6.a.I(f10473d, m.a.a("removeReceiveFileById: id no exist:", str));
            return;
        }
        d6.a.G(f10473d, "removeSendFileById size:" + this.f10475b.size());
        this.f10475b.remove(str);
    }

    public void T(String str) {
        if (TextUtils.isEmpty(str)) {
            d6.a.I(f10473d, m.a.a("removeSendFileById: id no exist:", str));
            return;
        }
        this.f10476c.remove(str);
        d6.a.G(f10473d, "removeSendFileById size:" + this.f10476c.size());
    }

    public void U(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            this.f10476c.remove(it.next());
        }
    }

    public Set<String> V() {
        return this.f10476c.keySet();
    }

    public Set<String> W() {
        return (Set) this.f10476c.values().stream().map(new c()).collect(Collectors.toSet());
    }

    public Collection<o1> X() {
        return this.f10476c.values();
    }

    public void h(String str, o1 o1Var) {
        this.f10474a.put(str, o1Var);
    }

    public void i() {
        d6.a.G(f10473d, "clearOldMap");
        this.f10474a.clear();
    }

    public void j() {
        d6.a.G(f10473d, "clearReceiveContainer");
        this.f10475b.clear();
    }

    public void k() {
        d6.a.G(f10473d, "clearReceiveContainer");
        this.f10476c.clear();
    }

    public o1 l(final String str) {
        List list = (List) this.f10476c.values().stream().filter(new Predicate() { // from class: m5.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return k.B(str, (o1) obj);
            }
        }).collect(Collectors.toList());
        if (list.size() != 0) {
            return (o1) list.get(0);
        }
        List list2 = (List) this.f10475b.values().stream().filter(new Predicate() { // from class: m5.f
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return k.C(str, (o1) obj);
            }
        }).collect(Collectors.toList());
        if (list2.size() != 0) {
            return (o1) list2.get(0);
        }
        d6.a.I(f10473d, m.a.a("getFileInfoBySdkId no exist bing file, sdk id:", str));
        return null;
    }

    public Set<String> n() {
        return this.f10474a.keySet();
    }

    public o1 o(String str) {
        return this.f10474a.get(str);
    }

    public o1 p(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f10475b.get(str);
        }
        d6.a.I(f10473d, "getReceiveFileById id is empty");
        return null;
    }

    public o1 q(final String str) {
        List list = (List) this.f10475b.values().stream().filter(new Predicate() { // from class: m5.h
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return k.D(str, (o1) obj);
            }
        }).collect(Collectors.toList());
        if (list.size() != 0) {
            return (o1) list.get(0);
        }
        d6.a.I(f10473d, m.a.a("getReceiveFileBySavePath no exist bing file, path:", str));
        return null;
    }

    public o1 r(final String str) {
        List list = (List) this.f10475b.values().stream().filter(new Predicate() { // from class: m5.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return k.E(str, (o1) obj);
            }
        }).collect(Collectors.toList());
        if (list.size() != 0) {
            return (o1) list.get(0);
        }
        d6.a.I(f10473d, m.a.a("getReceiveFileBySdkId no exist bing file, sdk id:", str));
        return null;
    }

    public o1 s(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f10476c.get(str);
        }
        d6.a.I(f10473d, "getSendFileById id is empty");
        return null;
    }

    public o1 t(final String str) {
        List list = (List) this.f10476c.values().stream().filter(new Predicate() { // from class: m5.j
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return k.F(str, (o1) obj);
            }
        }).collect(Collectors.toList());
        if (list.size() != 0) {
            return (o1) list.get(0);
        }
        d6.a.I(f10473d, m.a.a("getSendFileBySdkId no exist bing file, sdk id:", str));
        return null;
    }

    public boolean u() {
        return this.f10474a.isEmpty();
    }

    public boolean v() {
        return this.f10474a.values().stream().noneMatch(new g());
    }

    public boolean w() {
        return this.f10474a.values().stream().noneMatch(new i());
    }

    public boolean x() {
        return this.f10475b.isEmpty();
    }

    public boolean y() {
        return this.f10476c.isEmpty();
    }

    public void z(String str, o1 o1Var) {
        this.f10475b.put(str, o1Var);
    }

    public k() {
        this.f10474a = new ConcurrentHashMap<>();
        this.f10475b = new ConcurrentHashMap<>();
        this.f10476c = new ConcurrentHashMap<>();
    }
}

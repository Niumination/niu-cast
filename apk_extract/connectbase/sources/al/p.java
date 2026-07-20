package al;

import fl.t0;
import ik.b0;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kn.l0;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class p implements b0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final HttpHeaders f376d;

    public static final class a implements Map.Entry<String, List<? extends String>>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f378b;

        public a(String str, p pVar) {
            this.f377a = str;
            this.f378b = pVar;
        }

        @Override // java.util.Map.Entry
        @os.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String getKey() {
            String str = this.f377a;
            l0.o(str, "it");
            return str;
        }

        @Override // java.util.Map.Entry
        @os.l
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public List<String> getValue() {
            List<String> all = this.f378b.f376d.getAll(this.f377a);
            l0.o(all, "headers.getAll(it)");
            return all;
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public List<String> setValue(List<String> list) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public p(@os.l HttpRequest httpRequest) {
        l0.p(httpRequest, "request");
        HttpHeaders httpHeadersHeaders = httpRequest.headers();
        l0.o(httpHeadersHeaders, "request.headers()");
        this.f376d = httpHeadersHeaders;
    }

    @Override // fl.o1
    public boolean a() {
        return true;
    }

    @Override // fl.o1
    @os.m
    public List<String> b(@os.l String str) {
        l0.p(str, "name");
        List<String> all = this.f376d.getAll(str);
        l0.o(all, "it");
        if (all.isEmpty()) {
            return null;
        }
        return all;
    }

    @Override // fl.o1
    public boolean contains(@os.l String str) {
        l0.p(str, "name");
        return this.f376d.contains(str);
    }

    @Override // fl.o1
    public boolean d(@os.l String str, @os.l String str2) {
        l0.p(str, "name");
        l0.p(str2, "value");
        return this.f376d.contains(str, str2, true);
    }

    @Override // fl.o1
    public void e(@os.l jn.p<? super String, ? super List<String>, l2> pVar) {
        l0.p(pVar, "body");
        Set<String> setNames = this.f376d.names();
        l0.o(setNames, "names");
        for (String str : setNames) {
            l0.o(str, "it");
            List<String> all = this.f376d.getAll(str);
            l0.o(all, "headers.getAll(it)");
            pVar.invoke(str, all);
        }
    }

    @Override // fl.o1
    @os.l
    public Set<Map.Entry<String, List<String>>> entries() {
        Set<String> setNames = this.f376d.names();
        l0.o(setNames, "names");
        LinkedHashSet linkedHashSet = new LinkedHashSet(setNames.size());
        Iterator<T> it = setNames.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(new a((String) it.next(), this));
        }
        return linkedHashSet;
    }

    @Override // fl.o1
    @os.m
    public String get(@os.l String str) {
        l0.p(str, "name");
        return this.f376d.get(str);
    }

    @Override // fl.o1
    public boolean isEmpty() {
        return this.f376d.isEmpty();
    }

    @Override // fl.o1
    @os.l
    public Set<String> names() {
        Set<String> setNames = this.f376d.names();
        l0.o(setNames, "headers.names()");
        return setNames;
    }
}

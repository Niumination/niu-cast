package ek;

import java.util.ArrayList;
import java.util.List;
import kn.l0;
import nm.z;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public class d implements ek.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final sj.a f4485a;

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final sj.a f4486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @l
        public final String f4487b;

        public a(@l sj.a aVar, @l String str) {
            l0.p(aVar, "config");
            l0.p(str, "path");
            this.f4486a = aVar;
            this.f4487b = str;
        }

        @l
        public final sj.a a() {
            return this.f4486a;
        }

        @Override // ek.b
        @l
        public List<String> b() {
            List<String> stringList = this.f4486a.getStringList(this.f4487b);
            l0.o(stringList, "config.getStringList(path)");
            return stringList;
        }

        @l
        public final String c() {
            return this.f4487b;
        }

        @Override // ek.b
        @l
        public String getString() {
            String string = this.f4486a.getString(this.f4487b);
            l0.o(string, "config.getString(path)");
            return string;
        }
    }

    public d(@l sj.a aVar) {
        l0.p(aVar, "config");
        this.f4485a = aVar;
    }

    @Override // ek.a
    @l
    public List<ek.a> a(@l String str) {
        l0.p(str, "path");
        List<? extends sj.a> configList = this.f4485a.getConfigList(str);
        l0.o(configList, "config.getConfigList(path)");
        List<? extends sj.a> list = configList;
        ArrayList arrayList = new ArrayList(z.b0(list, 10));
        for (sj.a aVar : list) {
            l0.o(aVar, "it");
            arrayList.add(new d(aVar));
        }
        return arrayList;
    }

    @Override // ek.a
    @l
    public ek.a b(@l String str) {
        l0.p(str, "path");
        sj.a config = this.f4485a.getConfig(str);
        l0.o(config, "config.getConfig(path)");
        return new d(config);
    }

    @Override // ek.a
    @m
    public b c(@l String str) {
        l0.p(str, "path");
        if (this.f4485a.hasPath(str)) {
            return new a(this.f4485a, str);
        }
        return null;
    }

    @Override // ek.a
    @l
    public b d(@l String str) throws c {
        l0.p(str, "path");
        if (this.f4485a.hasPath(str)) {
            return new a(this.f4485a, str);
        }
        throw new c(n.a.a("Property ", str, " not found."));
    }
}

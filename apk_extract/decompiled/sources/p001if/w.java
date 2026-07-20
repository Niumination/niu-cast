package p001if;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;
import ze.f0;
import ze.q;
import ze.q2;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends h {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final q2 f5852l = q2.e.h("no subchannels ready");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Random f5853j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public v f5854k;

    public w(f0 f0Var) {
        super(f0Var);
        this.f5854k = new t(f5852l);
        this.f5853j = new Random();
    }

    @Override // p001if.h
    public final void h() {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = this.f5811d;
        for (f fVar : linkedHashMap.values()) {
            if (!fVar.f && fVar.f5806d == q.READY) {
                arrayList.add(fVar);
            }
        }
        if (!arrayList.isEmpty()) {
            j(q.READY, i(arrayList));
            return;
        }
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            q qVar = ((f) it.next()).f5806d;
            q qVar2 = q.CONNECTING;
            if (qVar == qVar2 || qVar == q.IDLE) {
                j(qVar2, new t(q2.e));
                return;
            }
        }
        j(q.TRANSIENT_FAILURE, i(linkedHashMap.values()));
    }

    public final u i(Collection collection) {
        int iNextInt = this.f5853j.nextInt(collection.size());
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((f) it.next()).e);
        }
        return new u(iNextInt, arrayList);
    }

    public final void j(q qVar, v vVar) {
        if (qVar == this.f5813h && vVar.b(this.f5854k)) {
            return;
        }
        this.e.m(qVar, vVar);
        this.f5813h = qVar;
        this.f5854k = vVar;
    }
}

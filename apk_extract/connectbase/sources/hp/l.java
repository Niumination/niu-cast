package hp;

import java.util.Collection;
import java.util.LinkedList;
import kn.l0;
import kn.n0;
import lm.l2;
import nm.h0;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: Add missing generic type declarations: [H] */
    public static final class a<H> extends n0 implements jn.l<H, l2> {
        final /* synthetic */ eq.f<H> $conflictedHandles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(eq.f<H> fVar) {
            super(1);
            this.$conflictedHandles = fVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Object obj) {
            invoke2(obj);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(H h10) {
            eq.f<H> fVar = this.$conflictedHandles;
            l0.o(h10, "it");
            fVar.add(h10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <H> Collection<H> a(@os.l Collection<? extends H> collection, @os.l jn.l<? super H, ? extends eo.a> lVar) {
        l0.p(collection, "<this>");
        l0.p(lVar, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        eq.f fVarA = eq.f.f4674c.a();
        while (!linkedList.isEmpty()) {
            Object objB2 = h0.B2(linkedList);
            eq.f fVarA2 = eq.f.f4674c.a();
            Collection<a1.d> collectionR = j.r(objB2, linkedList, lVar, new a(fVarA2));
            l0.o(collectionR, "val conflictedHandles = …nflictedHandles.add(it) }");
            if (collectionR.size() == 1 && fVarA2.isEmpty()) {
                Object objF5 = h0.f5(collectionR);
                l0.o(objF5, "overridableGroup.single()");
                fVarA.add(objF5);
            } else {
                a1.d dVar = (Object) j.M(collectionR, lVar);
                l0.o(dVar, "selectMostSpecificMember…roup, descriptorByHandle)");
                eo.a aVarInvoke = lVar.invoke(dVar);
                for (a1.d dVar2 : collectionR) {
                    l0.o(dVar2, "it");
                    if (!j.C(aVarInvoke, lVar.invoke(dVar2))) {
                        fVarA2.add(dVar2);
                    }
                }
                if (!fVarA2.isEmpty()) {
                    fVarA.addAll(fVarA2);
                }
                fVarA.add(dVar);
            }
        }
        return fVarA;
    }
}

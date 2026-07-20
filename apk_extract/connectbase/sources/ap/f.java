package ap;

import ik.y0;
import java.util.ArrayList;
import java.util.List;
import kn.l0;
import nm.z;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    @m
    public static final yo.a.q a(@l yo.a.q qVar, @l g gVar) {
        l0.p(qVar, "<this>");
        l0.p(gVar, "typeTable");
        if (qVar.hasAbbreviatedType()) {
            return qVar.getAbbreviatedType();
        }
        if (qVar.hasAbbreviatedTypeId()) {
            return gVar.a(qVar.getAbbreviatedTypeId());
        }
        return null;
    }

    @l
    public static final yo.a.q b(@l yo.a.r rVar, @l g gVar) {
        l0.p(rVar, "<this>");
        l0.p(gVar, "typeTable");
        if (rVar.hasExpandedType()) {
            yo.a.q expandedType = rVar.getExpandedType();
            l0.o(expandedType, "expandedType");
            return expandedType;
        }
        if (rVar.hasExpandedTypeId()) {
            return gVar.a(rVar.getExpandedTypeId());
        }
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias");
    }

    @m
    public static final yo.a.q c(@l yo.a.q qVar, @l g gVar) {
        l0.p(qVar, "<this>");
        l0.p(gVar, "typeTable");
        if (qVar.hasFlexibleUpperBound()) {
            return qVar.getFlexibleUpperBound();
        }
        if (qVar.hasFlexibleUpperBoundId()) {
            return gVar.a(qVar.getFlexibleUpperBoundId());
        }
        return null;
    }

    public static final boolean d(@l yo.a.i iVar) {
        l0.p(iVar, "<this>");
        return iVar.hasReceiverType() || iVar.hasReceiverTypeId();
    }

    public static final boolean e(@l yo.a.n nVar) {
        l0.p(nVar, "<this>");
        return nVar.hasReceiverType() || nVar.hasReceiverTypeId();
    }

    @m
    public static final yo.a.q f(@l yo.a.c cVar, @l g gVar) {
        l0.p(cVar, "<this>");
        l0.p(gVar, "typeTable");
        if (cVar.hasInlineClassUnderlyingType()) {
            return cVar.getInlineClassUnderlyingType();
        }
        if (cVar.hasInlineClassUnderlyingTypeId()) {
            return gVar.a(cVar.getInlineClassUnderlyingTypeId());
        }
        return null;
    }

    @m
    public static final yo.a.q g(@l yo.a.q qVar, @l g gVar) {
        l0.p(qVar, "<this>");
        l0.p(gVar, "typeTable");
        if (qVar.hasOuterType()) {
            return qVar.getOuterType();
        }
        if (qVar.hasOuterTypeId()) {
            return gVar.a(qVar.getOuterTypeId());
        }
        return null;
    }

    @m
    public static final yo.a.q h(@l yo.a.i iVar, @l g gVar) {
        l0.p(iVar, "<this>");
        l0.p(gVar, "typeTable");
        if (iVar.hasReceiverType()) {
            return iVar.getReceiverType();
        }
        if (iVar.hasReceiverTypeId()) {
            return gVar.a(iVar.getReceiverTypeId());
        }
        return null;
    }

    @m
    public static final yo.a.q i(@l yo.a.n nVar, @l g gVar) {
        l0.p(nVar, "<this>");
        l0.p(gVar, "typeTable");
        if (nVar.hasReceiverType()) {
            return nVar.getReceiverType();
        }
        if (nVar.hasReceiverTypeId()) {
            return gVar.a(nVar.getReceiverTypeId());
        }
        return null;
    }

    @l
    public static final yo.a.q j(@l yo.a.i iVar, @l g gVar) {
        l0.p(iVar, "<this>");
        l0.p(gVar, "typeTable");
        if (iVar.hasReturnType()) {
            yo.a.q returnType = iVar.getReturnType();
            l0.o(returnType, "returnType");
            return returnType;
        }
        if (iVar.hasReturnTypeId()) {
            return gVar.a(iVar.getReturnTypeId());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function");
    }

    @l
    public static final yo.a.q k(@l yo.a.n nVar, @l g gVar) {
        l0.p(nVar, "<this>");
        l0.p(gVar, "typeTable");
        if (nVar.hasReturnType()) {
            yo.a.q returnType = nVar.getReturnType();
            l0.o(returnType, "returnType");
            return returnType;
        }
        if (nVar.hasReturnTypeId()) {
            return gVar.a(nVar.getReturnTypeId());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property");
    }

    @l
    public static final List<yo.a.q> l(@l yo.a.c cVar, @l g gVar) {
        l0.p(cVar, "<this>");
        l0.p(gVar, "typeTable");
        List<yo.a.q> supertypeList = cVar.getSupertypeList();
        if (supertypeList.isEmpty()) {
            supertypeList = null;
        }
        if (supertypeList == null) {
            List<Integer> supertypeIdList = cVar.getSupertypeIdList();
            l0.o(supertypeIdList, "supertypeIdList");
            List<Integer> list = supertypeIdList;
            supertypeList = new ArrayList<>(z.b0(list, 10));
            for (Integer num : list) {
                l0.o(num, "it");
                supertypeList.add(gVar.a(num.intValue()));
            }
        }
        return supertypeList;
    }

    @m
    public static final yo.a.q m(@l yo.a.q.b bVar, @l g gVar) {
        l0.p(bVar, "<this>");
        l0.p(gVar, "typeTable");
        if (bVar.hasType()) {
            return bVar.getType();
        }
        if (bVar.hasTypeId()) {
            return gVar.a(bVar.getTypeId());
        }
        return null;
    }

    @l
    public static final yo.a.q n(@l yo.a.u uVar, @l g gVar) {
        l0.p(uVar, "<this>");
        l0.p(gVar, "typeTable");
        if (uVar.hasType()) {
            yo.a.q type = uVar.getType();
            l0.o(type, y0.a.f8215h);
            return type;
        }
        if (uVar.hasTypeId()) {
            return gVar.a(uVar.getTypeId());
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter");
    }

    @l
    public static final yo.a.q o(@l yo.a.r rVar, @l g gVar) {
        l0.p(rVar, "<this>");
        l0.p(gVar, "typeTable");
        if (rVar.hasUnderlyingType()) {
            yo.a.q underlyingType = rVar.getUnderlyingType();
            l0.o(underlyingType, "underlyingType");
            return underlyingType;
        }
        if (rVar.hasUnderlyingTypeId()) {
            return gVar.a(rVar.getUnderlyingTypeId());
        }
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias");
    }

    @l
    public static final List<yo.a.q> p(@l yo.a.s sVar, @l g gVar) {
        l0.p(sVar, "<this>");
        l0.p(gVar, "typeTable");
        List<yo.a.q> upperBoundList = sVar.getUpperBoundList();
        if (upperBoundList.isEmpty()) {
            upperBoundList = null;
        }
        if (upperBoundList == null) {
            List<Integer> upperBoundIdList = sVar.getUpperBoundIdList();
            l0.o(upperBoundIdList, "upperBoundIdList");
            List<Integer> list = upperBoundIdList;
            upperBoundList = new ArrayList<>(z.b0(list, 10));
            for (Integer num : list) {
                l0.o(num, "it");
                upperBoundList.add(gVar.a(num.intValue()));
            }
        }
        return upperBoundList;
    }

    @m
    public static final yo.a.q q(@l yo.a.u uVar, @l g gVar) {
        l0.p(uVar, "<this>");
        l0.p(gVar, "typeTable");
        if (uVar.hasVarargElementType()) {
            return uVar.getVarargElementType();
        }
        if (uVar.hasVarargElementTypeId()) {
            return gVar.a(uVar.getVarargElementTypeId());
        }
        return null;
    }
}

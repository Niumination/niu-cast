package wo;

import ik.y0;
import jq.h0;
import kn.l0;
import lm.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements l<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final m f19813a = new m();

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19814a;

        static {
            int[] iArr = new int[ao.i.values().length];
            iArr[ao.i.BOOLEAN.ordinal()] = 1;
            iArr[ao.i.CHAR.ordinal()] = 2;
            iArr[ao.i.BYTE.ordinal()] = 3;
            iArr[ao.i.SHORT.ordinal()] = 4;
            iArr[ao.i.INT.ordinal()] = 5;
            iArr[ao.i.FLOAT.ordinal()] = 6;
            iArr[ao.i.LONG.ordinal()] = 7;
            iArr[ao.i.DOUBLE.ordinal()] = 8;
            f19814a = iArr;
        }
    }

    @Override // wo.l
    public k f() {
        return e("java/lang/Class");
    }

    @Override // wo.l
    @os.l
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public k b(@os.l k kVar) {
        mp.e eVar;
        l0.p(kVar, "possiblyPrimitiveType");
        if (!(kVar instanceof k.d) || (eVar = ((k.d) kVar).f19812j) == null) {
            return kVar;
        }
        String strF = mp.d.c(eVar.getWrapperFqName()).f();
        l0.o(strF, "byFqNameWithoutInnerClas…apperFqName).internalName");
        return e(strF);
    }

    @Override // wo.l
    @os.l
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public k a(@os.l String str) {
        mp.e eVar;
        l0.p(str, "representation");
        str.length();
        char cCharAt = str.charAt(0);
        mp.e[] eVarArrValues = mp.e.values();
        int length = eVarArrValues.length;
        int i10 = 0;
        do {
            if (i10 >= length) {
                eVar = null;
                break;
            }
            eVar = eVarArrValues[i10];
            i10++;
        } while (eVar.getDesc().charAt(0) != cCharAt);
        if (eVar != null) {
            return new k.d(eVar);
        }
        if (cCharAt == 'V') {
            return new k.d(null);
        }
        if (cCharAt == '[') {
            String strSubstring = str.substring(1);
            l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
            return new k.a(a(strSubstring));
        }
        if (cCharAt == 'L') {
            h0.Y2(str, ';', false, 2, null);
        }
        String strSubstring2 = str.substring(1, str.length() - 1);
        l0.o(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        return new k.c(strSubstring2);
    }

    @Override // wo.l
    @os.l
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public k.c e(@os.l String str) {
        l0.p(str, "internalName");
        return new k.c(str);
    }

    @Override // wo.l
    @os.l
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public k c(@os.l ao.i iVar) {
        l0.p(iVar, "primitiveType");
        switch (a.f19814a[iVar.ordinal()]) {
            case 1:
                k.f19801a.getClass();
                return k.f19802b;
            case 2:
                k.f19801a.getClass();
                return k.f19803c;
            case 3:
                k.f19801a.getClass();
                return k.f19804d;
            case 4:
                k.f19801a.getClass();
                return k.f19805e;
            case 5:
                k.f19801a.getClass();
                return k.f19806f;
            case 6:
                k.f19801a.getClass();
                return k.f19807g;
            case 7:
                k.f19801a.getClass();
                return k.f19808h;
            case 8:
                k.f19801a.getClass();
                return k.f19809i;
            default:
                throw new i0();
        }
    }

    @os.l
    public k k() {
        return e("java/lang/Class");
    }

    @Override // wo.l
    @os.l
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public String d(@os.l k kVar) {
        l0.p(kVar, y0.a.f8215h);
        if (kVar instanceof k.a) {
            return l0.C("[", d(((k.a) kVar).f19810j));
        }
        if (!(kVar instanceof k.d)) {
            if (kVar instanceof k.c) {
                return l.a.a(new StringBuilder("L"), ((k.c) kVar).f19811j, ';');
            }
            throw new i0();
        }
        mp.e eVar = ((k.d) kVar).f19812j;
        String desc = eVar == null ? "V" : eVar.getDesc();
        l0.o(desc, "type.jvmPrimitiveType?.desc ?: \"V\"");
        return desc;
    }
}

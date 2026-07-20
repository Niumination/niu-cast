package jp;

import eo.h0;
import ik.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.n0;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final h f8775a = new h();

    public static final class a extends n0 implements jn.l<h0, f0> {
        final /* synthetic */ f0 $type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f0 f0Var) {
            super(1);
            this.$type = f0Var;
        }

        @Override // jn.l
        @os.l
        public final f0 invoke(@os.l h0 h0Var) {
            l0.p(h0Var, "it");
            return this.$type;
        }
    }

    public static final class b extends n0 implements jn.l<h0, f0> {
        final /* synthetic */ ao.i $componentType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ao.i iVar) {
            super(1);
            this.$componentType = iVar;
        }

        @Override // jn.l
        @os.l
        public final f0 invoke(@os.l h0 h0Var) {
            l0.p(h0Var, "module");
            vp.n0 n0VarO = h0Var.n().O(this.$componentType);
            l0.o(n0VarO, "module.builtIns.getPrimi…KotlinType(componentType)");
            return n0VarO;
        }
    }

    public final jp.b a(List<?> list, ao.i iVar) {
        List listV5 = nm.h0.V5(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = listV5.iterator();
        while (it.hasNext()) {
            g<?> gVarC = c(it.next());
            if (gVarC != null) {
                arrayList.add(gVarC);
            }
        }
        return new jp.b(arrayList, new b(iVar));
    }

    @os.l
    public final jp.b b(@os.l List<? extends g<?>> list, @os.l f0 f0Var) {
        l0.p(list, "value");
        l0.p(f0Var, y0.a.f8215h);
        return new jp.b(list, new a(f0Var));
    }

    @os.m
    public final g<?> c(@os.m Object obj) {
        if (obj instanceof Byte) {
            return new d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new u(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new m(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new r(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            Character ch2 = (Character) obj;
            ch2.charValue();
            return new e(ch2);
        }
        if (obj instanceof Float) {
            return new l(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new i(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            Boolean bool = (Boolean) obj;
            bool.booleanValue();
            return new c(bool);
        }
        if (obj instanceof String) {
            return new v((String) obj);
        }
        if (obj instanceof byte[]) {
            return a(nm.r.Ey((byte[]) obj), ao.i.BYTE);
        }
        if (obj instanceof short[]) {
            return a(nm.r.Ly((short[]) obj), ao.i.SHORT);
        }
        if (obj instanceof int[]) {
            return a(nm.r.Iy((int[]) obj), ao.i.INT);
        }
        if (obj instanceof long[]) {
            return a(nm.r.Jy((long[]) obj), ao.i.LONG);
        }
        if (obj instanceof char[]) {
            return a(nm.r.Fy((char[]) obj), ao.i.CHAR);
        }
        if (obj instanceof float[]) {
            return a(nm.r.Hy((float[]) obj), ao.i.FLOAT);
        }
        if (obj instanceof double[]) {
            return a(nm.r.Gy((double[]) obj), ao.i.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            return a(nm.r.My((boolean[]) obj), ao.i.BOOLEAN);
        }
        if (obj == null) {
            return new s(null);
        }
        return null;
    }
}

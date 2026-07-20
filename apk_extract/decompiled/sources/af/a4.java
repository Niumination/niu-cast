package af;

import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MessageLite;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class a4 implements i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d6 f142a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public cf.j0 f144c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final mg.a0 f146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h6 f147h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f148i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f149j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f151l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f143b = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ze.o f145d = ze.o.f11387b;
    public final y3 e = new y3(this, 0);
    public final ByteBuffer f = ByteBuffer.allocate(5);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f150k = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public a4(z3 z3Var, mg.a0 a0Var, h6 h6Var) {
        this.f142a = (d6) z3Var;
        this.f146g = a0Var;
        this.f147h = h6Var;
    }

    public static int g(gf.a aVar, OutputStream outputStream) throws IOException {
        MessageLite messageLite = aVar.f5177a;
        if (messageLite != null) {
            int serializedSize = messageLite.getSerializedSize();
            aVar.f5177a.writeTo(outputStream);
            aVar.f5177a = null;
            return serializedSize;
        }
        ByteArrayInputStream byteArrayInputStream = aVar.f5179c;
        if (byteArrayInputStream == null) {
            return 0;
        }
        ExtensionRegistryLite extensionRegistryLite = gf.c.f5184a;
        v8.i(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        long j8 = 0;
        while (true) {
            int i8 = byteArrayInputStream.read(bArr);
            if (i8 == -1) {
                int i9 = (int) j8;
                aVar.f5179c = null;
                return i9;
            }
            outputStream.write(bArr, 0, i8);
            j8 += (long) i8;
        }
    }

    @Override // af.i1
    public final i1 a(ze.o oVar) {
        v8.i(oVar, "Can't pass an empty compressor");
        this.f145d = oVar;
        return this;
    }

    @Override // af.i1
    public final void b(int i8) {
        v8.n(this.f143b == -1, "max size already set");
        this.f143b = i8;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [af.d6, af.z3] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void c(x3 x3Var, boolean z2) {
        ArrayList arrayList = x3Var.f704a;
        Iterator it = arrayList.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            i8 += ((cf.j0) it.next()).f1571c;
        }
        ByteBuffer byteBuffer = this.f;
        byteBuffer.clear();
        byteBuffer.put(z2 ? (byte) 1 : (byte) 0).putInt(i8);
        this.f146g.getClass();
        cf.j0 j0VarB = mg.a0.b(5);
        j0VarB.a(byteBuffer.array(), 0, byteBuffer.position());
        if (i8 == 0) {
            this.f144c = j0VarB;
            return;
        }
        int i9 = this.f149j - 1;
        ?? r7 = this.f142a;
        r7.l(j0VarB, false, false, i9);
        this.f149j = 1;
        for (int i10 = 0; i10 < arrayList.size() - 1; i10++) {
            r7.l((cf.j0) arrayList.get(i10), false, false, 0);
        }
        this.f144c = (cf.j0) a1.a.i(1, arrayList);
        this.f151l = i8;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [af.d6, af.z3] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // af.i1
    public final void close() {
        if (this.f148i) {
            return;
        }
        this.f148i = true;
        cf.j0 j0Var = this.f144c;
        if (j0Var != null && j0Var.f1571c == 0) {
            this.f144c = null;
        }
        cf.j0 j0Var2 = this.f144c;
        this.f144c = null;
        this.f142a.l(j0Var2, true, true, this.f149j);
        this.f149j = 0;
    }

    @Override // af.i1
    public final void d(gf.a aVar) {
        if (this.f148i) {
            throw new IllegalStateException("Framer already closed");
        }
        this.f149j++;
        int i8 = this.f150k + 1;
        this.f150k = i8;
        this.f151l = 0L;
        h6 h6Var = this.f147h;
        for (ze.n nVar : h6Var.f312a) {
            nVar.i(i8);
        }
        boolean z2 = this.f145d != ze.o.f11387b;
        try {
            int iAvailable = aVar.available();
            int iH = (iAvailable == 0 || !z2) ? h(aVar, iAvailable) : e(aVar);
            if (iAvailable != -1 && iH != iAvailable) {
                throw new ze.s2(ze.q2.f11410m.h(o.d.f(iH, iAvailable, "Message length inaccurate ", " != ")));
            }
            long j8 = iH;
            ze.n[] nVarArr = h6Var.f312a;
            for (ze.n nVar2 : nVarArr) {
                nVar2.k(j8);
            }
            long j10 = this.f151l;
            for (ze.n nVar3 : nVarArr) {
                nVar3.l(j10);
            }
            int i9 = this.f150k;
            long j11 = this.f151l;
            for (ze.n nVar4 : h6Var.f312a) {
                nVar4.j(i9, j11, j8);
            }
        } catch (IOException e) {
            throw new ze.s2(ze.q2.f11410m.h("Failed to frame message").g(e));
        } catch (RuntimeException e4) {
            throw new ze.s2(ze.q2.f11410m.h("Failed to frame message").g(e4));
        }
    }

    public final int e(gf.a aVar) throws IOException {
        OutputStream gZIPOutputStream;
        x3 x3Var = new x3(this);
        switch (this.f145d.f11388a) {
            case 0:
                gZIPOutputStream = x3Var;
                break;
            default:
                gZIPOutputStream = new GZIPOutputStream(x3Var);
                break;
        }
        try {
            int iG = g(aVar, gZIPOutputStream);
            gZIPOutputStream.close();
            int i8 = this.f143b;
            if (i8 < 0 || iG <= i8) {
                c(x3Var, true);
                return iG;
            }
            ze.q2 q2Var = ze.q2.f11408k;
            Locale locale = Locale.US;
            throw new ze.s2(q2Var.h("message too large " + iG + " > " + i8));
        } catch (Throwable th2) {
            gZIPOutputStream.close();
            throw th2;
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [af.d6, af.z3] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void f(byte[] bArr, int i8, int i9) {
        while (i9 > 0) {
            cf.j0 j0Var = this.f144c;
            if (j0Var != null && j0Var.f1570b == 0) {
                this.f144c = null;
                this.f142a.l(j0Var, false, false, this.f149j);
                this.f149j = 0;
            }
            if (this.f144c == null) {
                this.f146g.getClass();
                this.f144c = mg.a0.b(i9);
            }
            int iMin = Math.min(i9, this.f144c.f1570b);
            this.f144c.a(bArr, i8, iMin);
            i8 += iMin;
            i9 -= iMin;
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [af.d6, af.z3] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // af.i1
    public final void flush() {
        cf.j0 j0Var = this.f144c;
        if (j0Var == null || j0Var.f1571c <= 0) {
            return;
        }
        this.f144c = null;
        this.f142a.l(j0Var, false, true, this.f149j);
        this.f149j = 0;
    }

    public final int h(gf.a aVar, int i8) throws IOException {
        if (i8 == -1) {
            x3 x3Var = new x3(this);
            int iG = g(aVar, x3Var);
            int i9 = this.f143b;
            if (i9 < 0 || iG <= i9) {
                c(x3Var, false);
                return iG;
            }
            ze.q2 q2Var = ze.q2.f11408k;
            Locale locale = Locale.US;
            throw new ze.s2(q2Var.h("message too large " + iG + " > " + i9));
        }
        this.f151l = i8;
        int i10 = this.f143b;
        if (i10 >= 0 && i8 > i10) {
            ze.q2 q2Var2 = ze.q2.f11408k;
            Locale locale2 = Locale.US;
            throw new ze.s2(q2Var2.h("message too large " + i8 + " > " + i10));
        }
        ByteBuffer byteBuffer = this.f;
        byteBuffer.clear();
        byteBuffer.put((byte) 0).putInt(i8);
        if (this.f144c == null) {
            int iPosition = byteBuffer.position() + i8;
            this.f146g.getClass();
            this.f144c = mg.a0.b(iPosition);
        }
        f(byteBuffer.array(), 0, byteBuffer.position());
        return g(aVar, this.e);
    }

    @Override // af.i1
    public final boolean isClosed() {
        return this.f148i;
    }
}

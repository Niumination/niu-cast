package gj;

import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.FieldPacker;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.Script;
import android.renderscript.ScriptC;

/* JADX INFO: loaded from: classes2.dex */
public class b extends ScriptC {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f6480k = "boxblur";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f6481l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f6482m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f6483n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f6484o = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f6485p = 4;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f6486q = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f6487r = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Element f6488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Element f6489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Element f6490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FieldPacker f6491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FieldPacker f6492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Allocation f6493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Allocation f6494g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6495h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6496i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6497j;

    public b(RenderScript renderScript) {
        super(renderScript, f6480k, a.a(), a.d());
        this.f6488a = Element.ALLOCATION(renderScript);
        this.f6489b = Element.I32(renderScript);
        this.f6490c = Element.U8_4(renderScript);
    }

    public void a(Allocation allocation) {
        b(allocation, null);
    }

    public void b(Allocation allocation, Script.LaunchOptions launchOptions) {
        if (!allocation.getType().getElement().isCompatible(this.f6490c)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        forEach(1, allocation, (Allocation) null, (FieldPacker) null, launchOptions);
    }

    public void c(Allocation allocation) {
        d(allocation, null);
    }

    public void d(Allocation allocation, Script.LaunchOptions launchOptions) {
        if (!allocation.getType().getElement().isCompatible(this.f6490c)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        forEach(2, allocation, (Allocation) null, (FieldPacker) null, launchOptions);
    }

    public Script.FieldID e() {
        return createFieldID(3, null);
    }

    public Script.FieldID f() {
        return createFieldID(0, null);
    }

    public Script.FieldID g() {
        return createFieldID(1, null);
    }

    public Script.FieldID h() {
        return createFieldID(4, null);
    }

    public Script.FieldID i() {
        return createFieldID(2, null);
    }

    public Script.KernelID j() {
        return createKernelID(1, 57, null, null);
    }

    public Script.KernelID k() {
        return createKernelID(2, 57, null, null);
    }

    public int l() {
        return this.f6496i;
    }

    public Allocation m() {
        return this.f6493f;
    }

    public Allocation n() {
        return this.f6494g;
    }

    public int o() {
        return this.f6497j;
    }

    public int p() {
        return this.f6495h;
    }

    public synchronized void q(int i10) {
        setVar(3, i10);
        this.f6496i = i10;
    }

    public synchronized void r(Allocation allocation) {
        setVar(0, allocation);
        this.f6493f = allocation;
    }

    public synchronized void s(Allocation allocation) {
        setVar(1, allocation);
        this.f6494g = allocation;
    }

    public synchronized void t(int i10) {
        setVar(4, i10);
        this.f6497j = i10;
    }

    public synchronized void u(int i10) {
        setVar(2, i10);
        this.f6495h = i10;
    }
}

package gj;

import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.FieldPacker;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.Script;
import android.renderscript.ScriptC;

/* JADX INFO: loaded from: classes2.dex */
public class c extends ScriptC {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f6498k = "stackblur";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f6499l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f6500m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f6501n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f6502o = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f6503p = 4;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f6504q = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f6505r = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Element f6506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Element f6507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Element f6508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FieldPacker f6509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FieldPacker f6510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Allocation f6511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Allocation f6512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6514i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6515j;

    public c(RenderScript renderScript) {
        super(renderScript, f6498k, d.a(), d.d());
        this.f6506a = Element.ALLOCATION(renderScript);
        this.f6507b = Element.I32(renderScript);
        this.f6508c = Element.U8_4(renderScript);
    }

    public void a(Allocation allocation) {
        b(allocation, null);
    }

    public void b(Allocation allocation, Script.LaunchOptions launchOptions) {
        if (!allocation.getType().getElement().isCompatible(this.f6508c)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        forEach(1, allocation, (Allocation) null, (FieldPacker) null, launchOptions);
    }

    public void c(Allocation allocation) {
        d(allocation, null);
    }

    public void d(Allocation allocation, Script.LaunchOptions launchOptions) {
        if (!allocation.getType().getElement().isCompatible(this.f6508c)) {
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
        return this.f6514i;
    }

    public Allocation m() {
        return this.f6511f;
    }

    public Allocation n() {
        return this.f6512g;
    }

    public int o() {
        return this.f6515j;
    }

    public int p() {
        return this.f6513h;
    }

    public synchronized void q(int i10) {
        setVar(3, i10);
        this.f6514i = i10;
    }

    public synchronized void r(Allocation allocation) {
        setVar(0, allocation);
        this.f6511f = allocation;
    }

    public synchronized void s(Allocation allocation) {
        setVar(1, allocation);
        this.f6512g = allocation;
    }

    public synchronized void t(int i10) {
        setVar(4, i10);
        this.f6515j = i10;
    }

    public synchronized void u(int i10) {
        setVar(2, i10);
        this.f6513h = i10;
    }
}

package dk;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    @Deprecated
    public c(String str, Collection<? extends Throwable> collection) {
        this.cause = null;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            for (Throwable th2 : collection) {
                if (th2 instanceof c) {
                    linkedHashSet.addAll(((c) th2).getExceptions());
                } else if (th2 != null) {
                    linkedHashSet.add(th2);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        this.exceptions = listUnmodifiableList;
        this.message = listUnmodifiableList.size() + " exceptions occurred. ";
    }

    public static void a(StringBuilder sb2, Throwable th2, String str) {
        sb2.append(str);
        sb2.append(th2);
        sb2.append("\n");
        for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
            sb2.append("\t\tat ");
            sb2.append(stackTraceElement);
            sb2.append("\n");
        }
        if (th2.getCause() != null) {
            sb2.append("\tCaused by: ");
            a(sb2, th2.getCause(), "");
        }
    }

    public final void b(b bVar) {
        Appendable appendable;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this);
        sb2.append("\n");
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb2.append("\tat ");
            sb2.append(stackTraceElement);
            sb2.append("\n");
        }
        int i8 = 1;
        for (Throwable th2 : this.exceptions) {
            sb2.append("  ComposedException ");
            sb2.append(i8);
            sb2.append(" :");
            sb2.append("\n");
            a(sb2, th2, "\t");
            i8++;
        }
        switch (bVar.f4654a) {
            case 0:
                appendable = (PrintStream) bVar.f4655b;
                break;
            default:
                appendable = (PrintWriter) bVar.f4655b;
                break;
        }
        synchronized (appendable) {
            String string = sb2.toString();
            switch (bVar.f4654a) {
                case 0:
                    ((PrintStream) bVar.f4655b).println((Object) string);
                    break;
                default:
                    ((PrintWriter) bVar.f4655b).println((Object) string);
                    break;
            }
        }
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        try {
            if (this.cause == null) {
                a aVar = new a();
                HashSet hashSet = new HashSet();
                Iterator<Throwable> it = this.exceptions.iterator();
                Throwable cause = aVar;
                while (it.hasNext()) {
                    Throwable next = it.next();
                    if (!hashSet.contains(next)) {
                        hashSet.add(next);
                        ArrayList<Throwable> arrayList = new ArrayList();
                        Throwable cause2 = next.getCause();
                        if (cause2 != null) {
                            while (true) {
                                arrayList.add(cause2);
                                if (cause2.getCause() == null) {
                                    break;
                                }
                                cause2 = cause2.getCause();
                            }
                        }
                        for (Throwable th2 : arrayList) {
                            if (hashSet.contains(th2)) {
                                next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                            } else {
                                hashSet.add(th2);
                            }
                        }
                        try {
                            cause.initCause(next);
                            cause = cause.getCause();
                        } catch (Throwable unused) {
                            cause = next;
                        }
                    }
                }
                this.cause = aVar;
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return this.cause;
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        b(new b(printStream, 0));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        b(new b(printWriter, 1));
    }

    public c(Collection<? extends Throwable> collection) {
        this(null, collection);
    }

    public c(Throwable... thArr) {
        this.cause = null;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (thArr != null) {
            for (Throwable th2 : thArr) {
                if (th2 instanceof c) {
                    linkedHashSet.addAll(((c) th2).getExceptions());
                } else if (th2 != null) {
                    linkedHashSet.add(th2);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        this.exceptions = listUnmodifiableList;
        this.message = listUnmodifiableList.size() + " exceptions occurred. ";
    }
}

package com.huawei.android.hardware.fmradio;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: C:\Users\MOUNIERR\AppData\Local\Temp\jadx-8406931342016594350.dex */
public interface IFmEventCallback extends IInterface {
    void onEventCallback(int i, int i2, int i3) throws RemoteException;

    /* loaded from: C:\Users\MOUNIERR\AppData\Local\Temp\jadx-8406931342016594350.dex */
    public static abstract class Stub extends Binder implements IFmEventCallback {
        private static final String DESCRIPTOR = "com.huawei.android.hardware.fmradio.IFmEventCallback";
        static final int TRANSACTION_onEventCallback = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFmEventCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IFmEventCallback)) {
                return (IFmEventCallback) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    int _arg2 = data.readInt();
                    onEventCallback(_arg0, _arg1, _arg2);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: C:\Users\MOUNIERR\AppData\Local\Temp\jadx-8406931342016594350.dex */
        private static class Proxy implements IFmEventCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.huawei.android.hardware.fmradio.IFmEventCallback
            public void onEventCallback(int event, int param1, int param2) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(event);
                    _data.writeInt(param1);
                    _data.writeInt(param2);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }
    }
}

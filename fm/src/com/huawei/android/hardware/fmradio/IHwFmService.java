package com.huawei.android.hardware.fmradio;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.android.hardware.fmradio.IFmEventCallback;

/* IHwFmService plutot manager */
public interface IHwFmService extends IInterface {
    int acquireFd(String str) throws RemoteException;

    int audioControl(int i, int i2, int i3) throws RemoteException;

    int cancelSearch(int i) throws RemoteException;

    int closeFd(int i) throws RemoteException;

    int getAudioQuilty(int i, int i2) throws RemoteException;

    int getBuffer(int i, byte[] bArr, int i2) throws RemoteException;

    int getControl(int i, int i2) throws RemoteException;

    int getFreq(int i) throws RemoteException;

    int getLowerBand(int i) throws RemoteException;

    int getRSSI(int i) throws RemoteException;

    int getRawRds(int i, byte[] bArr, int i2) throws RemoteException;

    int getUpperBand(int i) throws RemoteException;

    int setBand(int i, int i2, int i3) throws RemoteException;

    int setControl(int i, int i2, int i3) throws RemoteException;

    void setFmDeviceConnectionState(int i) throws RemoteException;

    int setFmRssiThresh(int i, int i2) throws RemoteException;

    int setFmSnrThresh(int i, int i2) throws RemoteException;

    int setFreq(int i, int i2) throws RemoteException;

    int setMonoStereo(int i, int i2) throws RemoteException;

    void setNotchFilter(boolean z) throws RemoteException;

    void startListner(int i, IFmEventCallback iFmEventCallback) throws RemoteException;

    int startSearch(int i, int i2) throws RemoteException;

    void stopListner() throws RemoteException;

    public static abstract class Stub extends Binder implements IHwFmService {
        private static final String DESCRIPTOR = "com.huawei.android.hardware.fmradio.IHwFmService";
        static final int TRANSACTION_acquireFd = 1;
        static final int TRANSACTION_audioControl = 2;
        static final int TRANSACTION_cancelSearch = 3;
        static final int TRANSACTION_closeFd = 4;
        static final int TRANSACTION_getAudioQuilty = 18;
        static final int TRANSACTION_getBuffer = 10;
        static final int TRANSACTION_getControl = 7;
        static final int TRANSACTION_getFreq = 5;
        static final int TRANSACTION_getLowerBand = 13;
        static final int TRANSACTION_getRSSI = 11;
        static final int TRANSACTION_getRawRds = 16;
        static final int TRANSACTION_getUpperBand = 14;
        static final int TRANSACTION_setBand = 12;
        static final int TRANSACTION_setControl = 8;
        static final int TRANSACTION_setFmDeviceConnectionState = 21;
        static final int TRANSACTION_setFmRssiThresh = 20;
        static final int TRANSACTION_setFmSnrThresh = 19;
        static final int TRANSACTION_setFreq = 6;
        static final int TRANSACTION_setMonoStereo = 15;
        static final int TRANSACTION_setNotchFilter = 17;
        static final int TRANSACTION_startListner = 22;
        static final int TRANSACTION_startSearch = 9;
        static final int TRANSACTION_stopListner = 23;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IHwFmService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IHwFmService)) {
                return (IHwFmService) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            byte[] bArr;
            byte[] bArr2;
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    int _result = acquireFd(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg02 = data.readInt();
                    int _arg1 = data.readInt();
                    int _arg2 = data.readInt();
                    int _result2 = audioControl(_arg02, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg03 = data.readInt();
                    int _result3 = cancelSearch(_arg03);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg04 = data.readInt();
                    int _result4 = closeFd(_arg04);
                    reply.writeNoException();
                    reply.writeInt(_result4);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg05 = data.readInt();
                    int _result5 = getFreq(_arg05);
                    reply.writeNoException();
                    reply.writeInt(_result5);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg06 = data.readInt();
                    int _arg12 = data.readInt();
                    int _result6 = setFreq(_arg06, _arg12);
                    reply.writeNoException();
                    reply.writeInt(_result6);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg07 = data.readInt();
                    int _arg13 = data.readInt();
                    int _result7 = getControl(_arg07, _arg13);
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg08 = data.readInt();
                    int _arg14 = data.readInt();
                    int _arg22 = data.readInt();
                    int _result8 = setControl(_arg08, _arg14, _arg22);
                    reply.writeNoException();
                    reply.writeInt(_result8);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg09 = data.readInt();
                    int _arg15 = data.readInt();
                    int _result9 = startSearch(_arg09, _arg15);
                    reply.writeNoException();
                    reply.writeInt(_result9);
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg010 = data.readInt();
                    int _arg1_length = data.readInt();
                    if (_arg1_length < 0) {
                        bArr2 = null;
                    } else {
                        bArr2 = new byte[_arg1_length];
                    }
                    int _arg23 = data.readInt();
                    int _result10 = getBuffer(_arg010, bArr2, _arg23);
                    reply.writeNoException();
                    reply.writeInt(_result10);
                    reply.writeByteArray(bArr2);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg011 = data.readInt();
                    int _result11 = getRSSI(_arg011);
                    reply.writeNoException();
                    reply.writeInt(_result11);
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg012 = data.readInt();
                    int _arg16 = data.readInt();
                    int _arg24 = data.readInt();
                    int _result12 = setBand(_arg012, _arg16, _arg24);
                    reply.writeNoException();
                    reply.writeInt(_result12);
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg013 = data.readInt();
                    int _result13 = getLowerBand(_arg013);
                    reply.writeNoException();
                    reply.writeInt(_result13);
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg014 = data.readInt();
                    int _result14 = getUpperBand(_arg014);
                    reply.writeNoException();
                    reply.writeInt(_result14);
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg015 = data.readInt();
                    int _arg17 = data.readInt();
                    int _result15 = setMonoStereo(_arg015, _arg17);
                    reply.writeNoException();
                    reply.writeInt(_result15);
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg016 = data.readInt();
                    int _arg1_length2 = data.readInt();
                    if (_arg1_length2 < 0) {
                        bArr = null;
                    } else {
                        bArr = new byte[_arg1_length2];
                    }
                    int _arg25 = data.readInt();
                    int _result16 = getRawRds(_arg016, bArr, _arg25);
                    reply.writeNoException();
                    reply.writeInt(_result16);
                    reply.writeByteArray(bArr);
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg017 = data.readInt() != 0;
                    setNotchFilter(_arg017);
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg018 = data.readInt();
                    int _arg18 = data.readInt();
                    int _result17 = getAudioQuilty(_arg018, _arg18);
                    reply.writeNoException();
                    reply.writeInt(_result17);
                    return true;
                case 19:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg019 = data.readInt();
                    int _arg19 = data.readInt();
                    int _result18 = setFmSnrThresh(_arg019, _arg19);
                    reply.writeNoException();
                    reply.writeInt(_result18);
                    return true;
                case 20:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg020 = data.readInt();
                    int _arg110 = data.readInt();
                    int _result19 = setFmRssiThresh(_arg020, _arg110);
                    reply.writeNoException();
                    reply.writeInt(_result19);
                    return true;
                case 21:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg021 = data.readInt();
                    setFmDeviceConnectionState(_arg021);
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg022 = data.readInt();
                    IFmEventCallback _arg111 = IFmEventCallback.Stub.asInterface(data.readStrongBinder());
                    startListner(_arg022, _arg111);
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface(DESCRIPTOR);
                    stopListner();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: C:\Users\MOUNIERR\AppData\Local\Temp\jadx-15910938879466725409.dex */
        private static class Proxy implements IHwFmService {
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

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int acquireFd(String path) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(path);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int audioControl(int fd, int control, int field) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    _data.writeInt(control);
                    _data.writeInt(field);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int cancelSearch(int fd) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int closeFd(int fd) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int getFreq(int fd) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int setFreq(int fd, int freq) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    _data.writeInt(freq);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int getControl(int fd, int id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    _data.writeInt(id);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int setControl(int fd, int id, int value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    _data.writeInt(id);
                    _data.writeInt(value);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int startSearch(int fd, int dir) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    _data.writeInt(dir);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int getBuffer(int fd, byte[] buff, int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    if (buff == null) {
                        _data.writeInt(-1);
                    } else {
                        _data.writeInt(buff.length);
                    }
                    _data.writeInt(index);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    _reply.readByteArray(buff);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int getRSSI(int fd) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int setBand(int fd, int low, int high) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    _data.writeInt(low);
                    _data.writeInt(high);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int getLowerBand(int fd) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int getUpperBand(int fd) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int setMonoStereo(int fd, int val) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    _data.writeInt(val);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int getRawRds(int fd, byte[] buff, int count) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    if (buff == null) {
                        _data.writeInt(-1);
                    } else {
                        _data.writeInt(buff.length);
                    }
                    _data.writeInt(count);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    _reply.readByteArray(buff);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public void setNotchFilter(boolean value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(value ? 1 : 0);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int getAudioQuilty(int fd, int value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    _data.writeInt(value);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int setFmSnrThresh(int fd, int value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    _data.writeInt(value);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public int setFmRssiThresh(int fd, int value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    _data.writeInt(value);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public void setFmDeviceConnectionState(int state) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(state);
                    this.mRemote.transact(21, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public void startListner(int fd, IFmEventCallback cb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(fd);
                    _data.writeStrongBinder(cb != null ? cb.asBinder() : null);
                    this.mRemote.transact(22, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.huawei.android.hardware.fmradio.IHwFmService
            public void stopListner() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(23, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}

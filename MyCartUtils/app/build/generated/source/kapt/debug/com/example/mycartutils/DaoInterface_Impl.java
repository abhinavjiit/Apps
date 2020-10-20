package com.example.mycartutils;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DaoInterface_Impl implements DaoInterface {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LoanedDataModel> __insertionAdapterOfLoanedDataModel;

  private final EntityInsertionAdapter<AvailableDataModel> __insertionAdapterOfAvailableDataModel;

  public DaoInterface_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLoanedDataModel = new EntityInsertionAdapter<LoanedDataModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `loanedData` (`id`,`itemImageView`,`itemName`,`itemCost`,`itemSize`,`userImage`,`userName`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LoanedDataModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getItemImageView() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItemImageView());
        }
        if (value.getItemName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getItemName());
        }
        if (value.getItemCost() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getItemCost());
        }
        if (value.getItemSize() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getItemSize());
        }
        if (value.getUserImage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUserImage());
        }
        if (value.getUserName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUserName());
        }
      }
    };
    this.__insertionAdapterOfAvailableDataModel = new EntityInsertionAdapter<AvailableDataModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `AvailableData` (`id`,`itemImageView`,`itemName`,`itemCost`,`itemSize`,`userImage`,`userName`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AvailableDataModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getItemImageView() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItemImageView());
        }
        if (value.getItemName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getItemName());
        }
        if (value.getItemCost() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getItemCost());
        }
        if (value.getItemSize() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getItemSize());
        }
        if (value.getUserImage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUserImage());
        }
        if (value.getUserName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUserName());
        }
      }
    };
  }

  @Override
  public Object loaned(final List<LoanedDataModel> loanedAndAvailableDataModel,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLoanedDataModel.insert(loanedAndAvailableDataModel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object available(final List<AvailableDataModel> loanedAndAvailableDataModel,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAvailableDataModel.insert(loanedAndAvailableDataModel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object getLoanedData(final Continuation<? super List<LoanedDataModel>> p0) {
    final String _sql = "select * from loanedData where id = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<LoanedDataModel>>() {
      @Override
      public List<LoanedDataModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfItemImageView = CursorUtil.getColumnIndexOrThrow(_cursor, "itemImageView");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfItemCost = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCost");
          final int _cursorIndexOfItemSize = CursorUtil.getColumnIndexOrThrow(_cursor, "itemSize");
          final int _cursorIndexOfUserImage = CursorUtil.getColumnIndexOrThrow(_cursor, "userImage");
          final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "userName");
          final List<LoanedDataModel> _result = new ArrayList<LoanedDataModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final LoanedDataModel _item;
            final String _tmpItemImageView;
            _tmpItemImageView = _cursor.getString(_cursorIndexOfItemImageView);
            final String _tmpItemName;
            _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            final String _tmpItemCost;
            _tmpItemCost = _cursor.getString(_cursorIndexOfItemCost);
            final String _tmpItemSize;
            _tmpItemSize = _cursor.getString(_cursorIndexOfItemSize);
            final String _tmpUserImage;
            _tmpUserImage = _cursor.getString(_cursorIndexOfUserImage);
            final String _tmpUserName;
            _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
            _item = new LoanedDataModel(_tmpItemImageView,_tmpItemName,_tmpItemCost,_tmpItemSize,_tmpUserImage,_tmpUserName);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }

  @Override
  public Object getAvailableData(final Continuation<? super List<AvailableDataModel>> p0) {
    final String _sql = "select * from AvailableData where id = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<AvailableDataModel>>() {
      @Override
      public List<AvailableDataModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfItemImageView = CursorUtil.getColumnIndexOrThrow(_cursor, "itemImageView");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfItemCost = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCost");
          final int _cursorIndexOfItemSize = CursorUtil.getColumnIndexOrThrow(_cursor, "itemSize");
          final int _cursorIndexOfUserImage = CursorUtil.getColumnIndexOrThrow(_cursor, "userImage");
          final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "userName");
          final List<AvailableDataModel> _result = new ArrayList<AvailableDataModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AvailableDataModel _item;
            final String _tmpItemImageView;
            _tmpItemImageView = _cursor.getString(_cursorIndexOfItemImageView);
            final String _tmpItemName;
            _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            final String _tmpItemCost;
            _tmpItemCost = _cursor.getString(_cursorIndexOfItemCost);
            final String _tmpItemSize;
            _tmpItemSize = _cursor.getString(_cursorIndexOfItemSize);
            final String _tmpUserImage;
            _tmpUserImage = _cursor.getString(_cursorIndexOfUserImage);
            final String _tmpUserName;
            _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
            _item = new AvailableDataModel(_tmpItemImageView,_tmpItemName,_tmpItemCost,_tmpItemSize,_tmpUserImage,_tmpUserName);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }
}

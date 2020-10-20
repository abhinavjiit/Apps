package com.example.mycartutils;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DataBase_Impl extends DataBase {
  private volatile DaoInterface _daoInterface;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `loanedData` (`id` INTEGER NOT NULL, `itemImageView` TEXT NOT NULL, `itemName` TEXT NOT NULL, `itemCost` TEXT NOT NULL, `itemSize` TEXT NOT NULL, `userImage` TEXT NOT NULL, `userName` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `AvailableData` (`id` INTEGER NOT NULL, `itemImageView` TEXT, `itemName` TEXT, `itemCost` TEXT, `itemSize` TEXT, `userImage` TEXT, `userName` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '3b83f8ef40c1761e68fde9c477cd25be')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `loanedData`");
        _db.execSQL("DROP TABLE IF EXISTS `AvailableData`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsLoanedData = new HashMap<String, TableInfo.Column>(7);
        _columnsLoanedData.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoanedData.put("itemImageView", new TableInfo.Column("itemImageView", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoanedData.put("itemName", new TableInfo.Column("itemName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoanedData.put("itemCost", new TableInfo.Column("itemCost", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoanedData.put("itemSize", new TableInfo.Column("itemSize", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoanedData.put("userImage", new TableInfo.Column("userImage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoanedData.put("userName", new TableInfo.Column("userName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLoanedData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLoanedData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLoanedData = new TableInfo("loanedData", _columnsLoanedData, _foreignKeysLoanedData, _indicesLoanedData);
        final TableInfo _existingLoanedData = TableInfo.read(_db, "loanedData");
        if (! _infoLoanedData.equals(_existingLoanedData)) {
          return new RoomOpenHelper.ValidationResult(false, "loanedData(com.example.mycartutils.LoanedDataModel).\n"
                  + " Expected:\n" + _infoLoanedData + "\n"
                  + " Found:\n" + _existingLoanedData);
        }
        final HashMap<String, TableInfo.Column> _columnsAvailableData = new HashMap<String, TableInfo.Column>(7);
        _columnsAvailableData.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAvailableData.put("itemImageView", new TableInfo.Column("itemImageView", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAvailableData.put("itemName", new TableInfo.Column("itemName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAvailableData.put("itemCost", new TableInfo.Column("itemCost", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAvailableData.put("itemSize", new TableInfo.Column("itemSize", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAvailableData.put("userImage", new TableInfo.Column("userImage", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAvailableData.put("userName", new TableInfo.Column("userName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAvailableData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAvailableData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAvailableData = new TableInfo("AvailableData", _columnsAvailableData, _foreignKeysAvailableData, _indicesAvailableData);
        final TableInfo _existingAvailableData = TableInfo.read(_db, "AvailableData");
        if (! _infoAvailableData.equals(_existingAvailableData)) {
          return new RoomOpenHelper.ValidationResult(false, "AvailableData(com.example.mycartutils.AvailableDataModel).\n"
                  + " Expected:\n" + _infoAvailableData + "\n"
                  + " Found:\n" + _existingAvailableData);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "3b83f8ef40c1761e68fde9c477cd25be", "94d1bad0a30a0b053f61d6835d45bc5b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "loanedData","AvailableData");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `loanedData`");
      _db.execSQL("DELETE FROM `AvailableData`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public DaoInterface loanedAndAvailable() {
    if (_daoInterface != null) {
      return _daoInterface;
    } else {
      synchronized(this) {
        if(_daoInterface == null) {
          _daoInterface = new DaoInterface_Impl(this);
        }
        return _daoInterface;
      }
    }
  }
}

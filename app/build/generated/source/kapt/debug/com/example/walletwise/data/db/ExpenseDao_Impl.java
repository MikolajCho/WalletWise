package com.example.walletwise.data.db;

import androidx.annotation.NonNull;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.example.walletwise.data.model.Expense;
import java.lang.Class;
import java.lang.Double;
import java.lang.Long;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class ExpenseDao_Impl implements ExpenseDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<Expense> __insertAdapterOfExpense;

  private final EntityDeleteOrUpdateAdapter<Expense> __deleteAdapterOfExpense;

  private final EntityDeleteOrUpdateAdapter<Expense> __updateAdapterOfExpense;

  public ExpenseDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfExpense = new EntityInsertAdapter<Expense>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `expenses` (`id`,`amount`,`category`,`description`,`date`,`receiptImagePath`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, @NonNull final Expense entity) {
        statement.bindLong(1, entity.getId());
        statement.bindDouble(2, entity.getAmount());
        if (entity.getCategory() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getCategory());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getDescription());
        }
        statement.bindLong(5, entity.getDate());
        if (entity.getReceiptImagePath() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getReceiptImagePath());
        }
      }
    };
    this.__deleteAdapterOfExpense = new EntityDeleteOrUpdateAdapter<Expense>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `expenses` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, @NonNull final Expense entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfExpense = new EntityDeleteOrUpdateAdapter<Expense>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `expenses` SET `id` = ?,`amount` = ?,`category` = ?,`description` = ?,`date` = ?,`receiptImagePath` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, @NonNull final Expense entity) {
        statement.bindLong(1, entity.getId());
        statement.bindDouble(2, entity.getAmount());
        if (entity.getCategory() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getCategory());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getDescription());
        }
        statement.bindLong(5, entity.getDate());
        if (entity.getReceiptImagePath() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getReceiptImagePath());
        }
        statement.bindLong(7, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Expense expense, final Continuation<? super Long> $completion) {
    if (expense == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      return __insertAdapterOfExpense.insertAndReturnId(_connection, expense);
    }, $completion);
  }

  @Override
  public Object delete(final Expense expense, final Continuation<? super Unit> $completion) {
    if (expense == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __deleteAdapterOfExpense.handle(_connection, expense);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object update(final Expense expense, final Continuation<? super Unit> $completion) {
    if (expense == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __updateAdapterOfExpense.handle(_connection, expense);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Flow<List<Expense>> getAllExpenses() {
    final String _sql = "SELECT * FROM expenses ORDER BY date DESC";
    return FlowUtil.createFlow(__db, false, new String[] {"expenses"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfAmount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "amount");
        final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "date");
        final int _columnIndexOfReceiptImagePath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "receiptImagePath");
        final List<Expense> _result = new ArrayList<Expense>();
        while (_stmt.step()) {
          final Expense _item;
          final long _tmpId;
          _tmpId = _stmt.getLong(_columnIndexOfId);
          final double _tmpAmount;
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount);
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final long _tmpDate;
          _tmpDate = _stmt.getLong(_columnIndexOfDate);
          final String _tmpReceiptImagePath;
          if (_stmt.isNull(_columnIndexOfReceiptImagePath)) {
            _tmpReceiptImagePath = null;
          } else {
            _tmpReceiptImagePath = _stmt.getText(_columnIndexOfReceiptImagePath);
          }
          _item = new Expense(_tmpId,_tmpAmount,_tmpCategory,_tmpDescription,_tmpDate,_tmpReceiptImagePath);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Flow<List<Expense>> getExpensesByMonth(final long start, final long end) {
    final String _sql = "SELECT * FROM expenses WHERE date BETWEEN ? AND ? ORDER BY date DESC";
    return FlowUtil.createFlow(__db, false, new String[] {"expenses"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, start);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, end);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfAmount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "amount");
        final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "date");
        final int _columnIndexOfReceiptImagePath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "receiptImagePath");
        final List<Expense> _result = new ArrayList<Expense>();
        while (_stmt.step()) {
          final Expense _item;
          final long _tmpId;
          _tmpId = _stmt.getLong(_columnIndexOfId);
          final double _tmpAmount;
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount);
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final long _tmpDate;
          _tmpDate = _stmt.getLong(_columnIndexOfDate);
          final String _tmpReceiptImagePath;
          if (_stmt.isNull(_columnIndexOfReceiptImagePath)) {
            _tmpReceiptImagePath = null;
          } else {
            _tmpReceiptImagePath = _stmt.getText(_columnIndexOfReceiptImagePath);
          }
          _item = new Expense(_tmpId,_tmpAmount,_tmpCategory,_tmpDescription,_tmpDate,_tmpReceiptImagePath);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Flow<List<Expense>> getExpensesByCategory(final String category) {
    final String _sql = "SELECT * FROM expenses WHERE category = ? ORDER BY date DESC";
    return FlowUtil.createFlow(__db, false, new String[] {"expenses"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (category == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, category);
        }
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfAmount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "amount");
        final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "date");
        final int _columnIndexOfReceiptImagePath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "receiptImagePath");
        final List<Expense> _result = new ArrayList<Expense>();
        while (_stmt.step()) {
          final Expense _item;
          final long _tmpId;
          _tmpId = _stmt.getLong(_columnIndexOfId);
          final double _tmpAmount;
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount);
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final long _tmpDate;
          _tmpDate = _stmt.getLong(_columnIndexOfDate);
          final String _tmpReceiptImagePath;
          if (_stmt.isNull(_columnIndexOfReceiptImagePath)) {
            _tmpReceiptImagePath = null;
          } else {
            _tmpReceiptImagePath = _stmt.getText(_columnIndexOfReceiptImagePath);
          }
          _item = new Expense(_tmpId,_tmpAmount,_tmpCategory,_tmpDescription,_tmpDate,_tmpReceiptImagePath);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Object getExpenseById(final long id, final Continuation<? super Expense> $completion) {
    final String _sql = "SELECT * FROM expenses WHERE id = ?";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfAmount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "amount");
        final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "date");
        final int _columnIndexOfReceiptImagePath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "receiptImagePath");
        final Expense _result;
        if (_stmt.step()) {
          final long _tmpId;
          _tmpId = _stmt.getLong(_columnIndexOfId);
          final double _tmpAmount;
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount);
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final long _tmpDate;
          _tmpDate = _stmt.getLong(_columnIndexOfDate);
          final String _tmpReceiptImagePath;
          if (_stmt.isNull(_columnIndexOfReceiptImagePath)) {
            _tmpReceiptImagePath = null;
          } else {
            _tmpReceiptImagePath = _stmt.getText(_columnIndexOfReceiptImagePath);
          }
          _result = new Expense(_tmpId,_tmpAmount,_tmpCategory,_tmpDescription,_tmpDate,_tmpReceiptImagePath);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object getTotalForMonth(final long start, final long end,
      final Continuation<? super Double> $completion) {
    final String _sql = "SELECT SUM(amount) FROM expenses WHERE date BETWEEN ? AND ?";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, start);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, end);
        final Double _result;
        if (_stmt.step()) {
          final Double _tmp;
          if (_stmt.isNull(0)) {
            _tmp = null;
          } else {
            _tmp = _stmt.getDouble(0);
          }
          _result = _tmp;
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object getCategoryTotalsForMonth(final long start, final long end,
      final Continuation<? super List<CategoryTotal>> $completion) {
    final String _sql = "\n"
            + "        SELECT category, SUM(amount) as total\n"
            + "        FROM expenses\n"
            + "        WHERE date BETWEEN ? AND ?\n"
            + "        GROUP BY category\n"
            + "    ";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, start);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, end);
        final int _columnIndexOfCategory = 0;
        final int _columnIndexOfTotal = 1;
        final List<CategoryTotal> _result = new ArrayList<CategoryTotal>();
        while (_stmt.step()) {
          final CategoryTotal _item;
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final double _tmpTotal;
          _tmpTotal = _stmt.getDouble(_columnIndexOfTotal);
          _item = new CategoryTotal(_tmpCategory,_tmpTotal);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

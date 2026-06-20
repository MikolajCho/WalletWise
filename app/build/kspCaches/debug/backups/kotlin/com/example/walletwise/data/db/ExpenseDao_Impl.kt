package com.example.walletwise.`data`.db

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.walletwise.`data`.model.Expense
import javax.`annotation`.processing.Generated
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class ExpenseDao_Impl(
  __db: RoomDatabase,
) : ExpenseDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfExpense: EntityInsertAdapter<Expense>

  private val __deleteAdapterOfExpense: EntityDeleteOrUpdateAdapter<Expense>

  private val __updateAdapterOfExpense: EntityDeleteOrUpdateAdapter<Expense>
  init {
    this.__db = __db
    this.__insertAdapterOfExpense = object : EntityInsertAdapter<Expense>() {
      protected override fun createQuery(): String = "INSERT OR REPLACE INTO `expenses` (`id`,`amount`,`category`,`description`,`date`,`receiptImagePath`) VALUES (nullif(?, 0),?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: Expense) {
        statement.bindLong(1, entity.id)
        statement.bindDouble(2, entity.amount)
        statement.bindText(3, entity.category)
        statement.bindText(4, entity.description)
        statement.bindLong(5, entity.date)
        val _tmpReceiptImagePath: String? = entity.receiptImagePath
        if (_tmpReceiptImagePath == null) {
          statement.bindNull(6)
        } else {
          statement.bindText(6, _tmpReceiptImagePath)
        }
      }
    }
    this.__deleteAdapterOfExpense = object : EntityDeleteOrUpdateAdapter<Expense>() {
      protected override fun createQuery(): String = "DELETE FROM `expenses` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Expense) {
        statement.bindLong(1, entity.id)
      }
    }
    this.__updateAdapterOfExpense = object : EntityDeleteOrUpdateAdapter<Expense>() {
      protected override fun createQuery(): String = "UPDATE OR ABORT `expenses` SET `id` = ?,`amount` = ?,`category` = ?,`description` = ?,`date` = ?,`receiptImagePath` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Expense) {
        statement.bindLong(1, entity.id)
        statement.bindDouble(2, entity.amount)
        statement.bindText(3, entity.category)
        statement.bindText(4, entity.description)
        statement.bindLong(5, entity.date)
        val _tmpReceiptImagePath: String? = entity.receiptImagePath
        if (_tmpReceiptImagePath == null) {
          statement.bindNull(6)
        } else {
          statement.bindText(6, _tmpReceiptImagePath)
        }
        statement.bindLong(7, entity.id)
      }
    }
  }

  public override suspend fun insert(expense: Expense): Long = performSuspending(__db, false, true) { _connection ->
    val _result: Long = __insertAdapterOfExpense.insertAndReturnId(_connection, expense)
    _result
  }

  public override suspend fun delete(expense: Expense): Unit = performSuspending(__db, false, true) { _connection ->
    __deleteAdapterOfExpense.handle(_connection, expense)
  }

  public override suspend fun update(expense: Expense): Unit = performSuspending(__db, false, true) { _connection ->
    __updateAdapterOfExpense.handle(_connection, expense)
  }

  public override suspend fun getAllExpenses(): List<Expense> {
    val _sql: String = "SELECT * FROM expenses ORDER BY date DESC"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfAmount: Int = getColumnIndexOrThrow(_stmt, "amount")
        val _columnIndexOfCategory: Int = getColumnIndexOrThrow(_stmt, "category")
        val _columnIndexOfDescription: Int = getColumnIndexOrThrow(_stmt, "description")
        val _columnIndexOfDate: Int = getColumnIndexOrThrow(_stmt, "date")
        val _columnIndexOfReceiptImagePath: Int = getColumnIndexOrThrow(_stmt, "receiptImagePath")
        val _result: MutableList<Expense> = mutableListOf()
        while (_stmt.step()) {
          val _item: Expense
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpAmount: Double
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount)
          val _tmpCategory: String
          _tmpCategory = _stmt.getText(_columnIndexOfCategory)
          val _tmpDescription: String
          _tmpDescription = _stmt.getText(_columnIndexOfDescription)
          val _tmpDate: Long
          _tmpDate = _stmt.getLong(_columnIndexOfDate)
          val _tmpReceiptImagePath: String?
          if (_stmt.isNull(_columnIndexOfReceiptImagePath)) {
            _tmpReceiptImagePath = null
          } else {
            _tmpReceiptImagePath = _stmt.getText(_columnIndexOfReceiptImagePath)
          }
          _item = Expense(_tmpId,_tmpAmount,_tmpCategory,_tmpDescription,_tmpDate,_tmpReceiptImagePath)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getExpensesByMonth(start: Long, end: Long): List<Expense> {
    val _sql: String = "SELECT * FROM expenses WHERE date BETWEEN ? AND ? ORDER BY date DESC"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, start)
        _argIndex = 2
        _stmt.bindLong(_argIndex, end)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfAmount: Int = getColumnIndexOrThrow(_stmt, "amount")
        val _columnIndexOfCategory: Int = getColumnIndexOrThrow(_stmt, "category")
        val _columnIndexOfDescription: Int = getColumnIndexOrThrow(_stmt, "description")
        val _columnIndexOfDate: Int = getColumnIndexOrThrow(_stmt, "date")
        val _columnIndexOfReceiptImagePath: Int = getColumnIndexOrThrow(_stmt, "receiptImagePath")
        val _result: MutableList<Expense> = mutableListOf()
        while (_stmt.step()) {
          val _item: Expense
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpAmount: Double
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount)
          val _tmpCategory: String
          _tmpCategory = _stmt.getText(_columnIndexOfCategory)
          val _tmpDescription: String
          _tmpDescription = _stmt.getText(_columnIndexOfDescription)
          val _tmpDate: Long
          _tmpDate = _stmt.getLong(_columnIndexOfDate)
          val _tmpReceiptImagePath: String?
          if (_stmt.isNull(_columnIndexOfReceiptImagePath)) {
            _tmpReceiptImagePath = null
          } else {
            _tmpReceiptImagePath = _stmt.getText(_columnIndexOfReceiptImagePath)
          }
          _item = Expense(_tmpId,_tmpAmount,_tmpCategory,_tmpDescription,_tmpDate,_tmpReceiptImagePath)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getExpensesByCategory(category: String): List<Expense> {
    val _sql: String = "SELECT * FROM expenses WHERE category = ? ORDER BY date DESC"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, category)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfAmount: Int = getColumnIndexOrThrow(_stmt, "amount")
        val _columnIndexOfCategory: Int = getColumnIndexOrThrow(_stmt, "category")
        val _columnIndexOfDescription: Int = getColumnIndexOrThrow(_stmt, "description")
        val _columnIndexOfDate: Int = getColumnIndexOrThrow(_stmt, "date")
        val _columnIndexOfReceiptImagePath: Int = getColumnIndexOrThrow(_stmt, "receiptImagePath")
        val _result: MutableList<Expense> = mutableListOf()
        while (_stmt.step()) {
          val _item: Expense
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpAmount: Double
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount)
          val _tmpCategory: String
          _tmpCategory = _stmt.getText(_columnIndexOfCategory)
          val _tmpDescription: String
          _tmpDescription = _stmt.getText(_columnIndexOfDescription)
          val _tmpDate: Long
          _tmpDate = _stmt.getLong(_columnIndexOfDate)
          val _tmpReceiptImagePath: String?
          if (_stmt.isNull(_columnIndexOfReceiptImagePath)) {
            _tmpReceiptImagePath = null
          } else {
            _tmpReceiptImagePath = _stmt.getText(_columnIndexOfReceiptImagePath)
          }
          _item = Expense(_tmpId,_tmpAmount,_tmpCategory,_tmpDescription,_tmpDate,_tmpReceiptImagePath)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getExpenseById(id: Long): Expense? {
    val _sql: String = "SELECT * FROM expenses WHERE id = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, id)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfAmount: Int = getColumnIndexOrThrow(_stmt, "amount")
        val _columnIndexOfCategory: Int = getColumnIndexOrThrow(_stmt, "category")
        val _columnIndexOfDescription: Int = getColumnIndexOrThrow(_stmt, "description")
        val _columnIndexOfDate: Int = getColumnIndexOrThrow(_stmt, "date")
        val _columnIndexOfReceiptImagePath: Int = getColumnIndexOrThrow(_stmt, "receiptImagePath")
        val _result: Expense?
        if (_stmt.step()) {
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpAmount: Double
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount)
          val _tmpCategory: String
          _tmpCategory = _stmt.getText(_columnIndexOfCategory)
          val _tmpDescription: String
          _tmpDescription = _stmt.getText(_columnIndexOfDescription)
          val _tmpDate: Long
          _tmpDate = _stmt.getLong(_columnIndexOfDate)
          val _tmpReceiptImagePath: String?
          if (_stmt.isNull(_columnIndexOfReceiptImagePath)) {
            _tmpReceiptImagePath = null
          } else {
            _tmpReceiptImagePath = _stmt.getText(_columnIndexOfReceiptImagePath)
          }
          _result = Expense(_tmpId,_tmpAmount,_tmpCategory,_tmpDescription,_tmpDate,_tmpReceiptImagePath)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getTotalForMonth(start: Long, end: Long): Double? {
    val _sql: String = "SELECT SUM(amount) FROM expenses WHERE date BETWEEN ? AND ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, start)
        _argIndex = 2
        _stmt.bindLong(_argIndex, end)
        val _result: Double?
        if (_stmt.step()) {
          val _tmp: Double?
          if (_stmt.isNull(0)) {
            _tmp = null
          } else {
            _tmp = _stmt.getDouble(0)
          }
          _result = _tmp
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getCategoryTotalsForMonth(start: Long, end: Long): List<CategoryTotal> {
    val _sql: String = """
        |
        |        SELECT category, SUM(amount) as total
        |        FROM expenses
        |        WHERE date BETWEEN ? AND ?
        |        GROUP BY category
        |    
        """.trimMargin()
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, start)
        _argIndex = 2
        _stmt.bindLong(_argIndex, end)
        val _columnIndexOfCategory: Int = 0
        val _columnIndexOfTotal: Int = 1
        val _result: MutableList<CategoryTotal> = mutableListOf()
        while (_stmt.step()) {
          val _item: CategoryTotal
          val _tmpCategory: String
          _tmpCategory = _stmt.getText(_columnIndexOfCategory)
          val _tmpTotal: Double
          _tmpTotal = _stmt.getDouble(_columnIndexOfTotal)
          _item = CategoryTotal(_tmpCategory,_tmpTotal)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}

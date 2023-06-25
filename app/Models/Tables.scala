package Models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends Tables {
  val profile = slick.jdbc.MySQLProfile
}

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Items.schema ++ Users.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Items
   *  @param itemId Database column item_id SqlType(BIGINT UNSIGNED), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(INT), Default(None)
   *  @param text Database column text SqlType(VARCHAR), Length(2000,true), Default(None) */
  case class ItemsRow(itemId: Long, userId: Option[Int] = None, text: Option[String] = None)
  /** GetResult implicit for fetching ItemsRow objects using plain SQL queries */
  implicit def GetResultItemsRow(implicit e0: GR[Long], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[ItemsRow] = GR{
    prs => import prs._
    ItemsRow.tupled((<<[Long], <<?[Int], <<?[String]))
  }
  /** Table description of table items. Objects of this class serve as prototypes for rows in queries. */
  class Items(_tableTag: Tag) extends profile.api.Table[ItemsRow](_tableTag, Some("tasklist"), "items") {
    def * = (itemId, userId, text) <> (ItemsRow.tupled, ItemsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(itemId), userId, text)).shaped.<>({r=>import r._; _1.map(_=> ItemsRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column item_id SqlType(BIGINT UNSIGNED), AutoInc, PrimaryKey */
    val itemId: Rep[Long] = column[Long]("item_id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(INT), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column text SqlType(VARCHAR), Length(2000,true), Default(None) */
    val text: Rep[Option[String]] = column[Option[String]]("text", O.Length(2000,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Items */
  lazy val Items = new TableQuery(tag => new Items(tag))

  /** Entity class storing rows of table Users
   *  @param id Database column id SqlType(BIGINT UNSIGNED), AutoInc, PrimaryKey
   *  @param username Database column username SqlType(VARCHAR), Length(20,true)
   *  @param password Database column password SqlType(VARCHAR), Length(200,true) */
  case class UsersRow(id: Long, username: String, password: String)
  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[Long], e1: GR[String]): GR[UsersRow] = GR{
    prs => import prs._
    UsersRow.tupled((<<[Long], <<[String], <<[String]))
  }
  /** Table description of table users. Objects of this class serve as prototypes for rows in queries. */
  class Users(_tableTag: Tag) extends profile.api.Table[UsersRow](_tableTag, Some("tasklist"), "users") {
    def * = (id, username, password) <> (UsersRow.tupled, UsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(username), Rep.Some(password))).shaped.<>({r=>import r._; _1.map(_=> UsersRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column username SqlType(VARCHAR), Length(20,true) */
    val username: Rep[String] = column[String]("username", O.Length(20,varying=true))
    /** Database column password SqlType(VARCHAR), Length(200,true) */
    val password: Rep[String] = column[String]("password", O.Length(200,varying=true))
  }
  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag => new Users(tag))
}

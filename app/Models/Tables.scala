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
  lazy val schema: profile.SchemaDescription = Followers.schema ++ Messages.schema ++ Users.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Followers
   *  @param followerId Database column follower_id SqlType(INT)
   *  @param followedId Database column followed_id SqlType(INT) */
  case class FollowersRow(followerId: Int, followedId: Int)
  /** GetResult implicit for fetching FollowersRow objects using plain SQL queries */
  implicit def GetResultFollowersRow(implicit e0: GR[Int]): GR[FollowersRow] = GR{
    prs => import prs._
    FollowersRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table followers. Objects of this class serve as prototypes for rows in queries. */
  class Followers(_tableTag: Tag) extends profile.api.Table[FollowersRow](_tableTag, Some("luna"), "followers") {
    def * = (followerId, followedId) <> (FollowersRow.tupled, FollowersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(followerId), Rep.Some(followedId))).shaped.<>({r=>import r._; _1.map(_=> FollowersRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column follower_id SqlType(INT) */
    val followerId: Rep[Int] = column[Int]("follower_id")
    /** Database column followed_id SqlType(INT) */
    val followedId: Rep[Int] = column[Int]("followed_id")

    /** Primary key of Followers (database name followers_PK) */
    val pk = primaryKey("followers_PK", (followerId, followedId))
  }
  /** Collection-like TableQuery object for table Followers */
  lazy val Followers = new TableQuery(tag => new Followers(tag))

  /** Entity class storing rows of table Messages
   *  @param messageId Database column message_id SqlType(BIGINT UNSIGNED), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(INT)
   *  @param text Database column text SqlType(VARCHAR), Length(2000,true)
   *  @param likes Database column likes SqlType(INT), Default(0)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP) */
  case class MessagesRow(messageId: Long, userId: Int, text: String, likes: Int = 0, createdAt: Option[java.sql.Timestamp])
  /** GetResult implicit for fetching MessagesRow objects using plain SQL queries */
  implicit def GetResultMessagesRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[String], e3: GR[Option[java.sql.Timestamp]]): GR[MessagesRow] = GR{
    prs => import prs._
    MessagesRow.tupled((<<[Long], <<[Int], <<[String], <<[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table messages. Objects of this class serve as prototypes for rows in queries. */
  class Messages(_tableTag: Tag) extends profile.api.Table[MessagesRow](_tableTag, Some("luna"), "messages") {
    def * = (messageId, userId, text, likes, createdAt) <> (MessagesRow.tupled, MessagesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(messageId), Rep.Some(userId), Rep.Some(text), Rep.Some(likes), createdAt)).shaped.<>({r=>import r._; _1.map(_=> MessagesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column message_id SqlType(BIGINT UNSIGNED), AutoInc, PrimaryKey */
    val messageId: Rep[Long] = column[Long]("message_id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(INT) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column text SqlType(VARCHAR), Length(2000,true) */
    val text: Rep[String] = column[String]("text", O.Length(2000,varying=true))
    /** Database column likes SqlType(INT), Default(0) */
    val likes: Rep[Int] = column[Int]("likes", O.Default(0))
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at")
  }
  /** Collection-like TableQuery object for table Messages */
  lazy val Messages = new TableQuery(tag => new Messages(tag))

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
  class Users(_tableTag: Tag) extends profile.api.Table[UsersRow](_tableTag, Some("luna"), "users") {
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

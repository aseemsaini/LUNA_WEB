package Models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends Tables {
  val profile = slick.jdbc.PostgresProfile
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
   *  @param followerId Database column follower_id SqlType(int4)
   *  @param followedId Database column followed_id SqlType(int4) */
  case class FollowersRow(followerId: Int, followedId: Int)
  /** GetResult implicit for fetching FollowersRow objects using plain SQL queries */
  implicit def GetResultFollowersRow(implicit e0: GR[Int]): GR[FollowersRow] = GR{
    prs => import prs._
    FollowersRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table followers. Objects of this class serve as prototypes for rows in queries. */
  class Followers(_tableTag: Tag) extends profile.api.Table[FollowersRow](_tableTag, "followers") {
    def * = (followerId, followedId) <> (FollowersRow.tupled, FollowersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(followerId), Rep.Some(followedId))).shaped.<>({r=>import r._; _1.map(_=> FollowersRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column follower_id SqlType(int4) */
    val followerId: Rep[Int] = column[Int]("follower_id")
    /** Database column followed_id SqlType(int4) */
    val followedId: Rep[Int] = column[Int]("followed_id")

    /** Primary key of Followers (database name followers_pkey) */
    val pk = primaryKey("followers_pkey", (followerId, followedId))

    /** Foreign key referencing Users (database name followers_followed_id_fkey) */
    lazy val usersFk1 = foreignKey("followers_followed_id_fkey", followedId, Users)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing Users (database name followers_follower_id_fkey) */
    lazy val usersFk2 = foreignKey("followers_follower_id_fkey", followerId, Users)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table Followers */
  lazy val Followers = new TableQuery(tag => new Followers(tag))

  /** Entity class storing rows of table Messages
   *  @param messageId Database column message_id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4)
   *  @param text Database column text SqlType(varchar), Length(2000,true)
   *  @param likes Database column likes SqlType(int4), Default(0)
   *  @param createdAt Database column created_at SqlType(timestamp) */
  case class MessagesRow(messageId: Int, userId: Int, text: String, likes: Int = 0, createdAt: Option[java.sql.Timestamp])
  /** GetResult implicit for fetching MessagesRow objects using plain SQL queries */
  implicit def GetResultMessagesRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[java.sql.Timestamp]]): GR[MessagesRow] = GR{
    prs => import prs._
    MessagesRow.tupled((<<[Int], <<[Int], <<[String], <<[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table messages. Objects of this class serve as prototypes for rows in queries. */
  class Messages(_tableTag: Tag) extends profile.api.Table[MessagesRow](_tableTag, "messages") {
    def * = (messageId, userId, text, likes, createdAt) <> (MessagesRow.tupled, MessagesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(messageId), Rep.Some(userId), Rep.Some(text), Rep.Some(likes), createdAt)).shaped.<>({r=>import r._; _1.map(_=> MessagesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column message_id SqlType(serial), AutoInc, PrimaryKey */
    val messageId: Rep[Int] = column[Int]("message_id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column text SqlType(varchar), Length(2000,true) */
    val text: Rep[String] = column[String]("text", O.Length(2000,varying=true))
    /** Database column likes SqlType(int4), Default(0) */
    val likes: Rep[Int] = column[Int]("likes", O.Default(0))
    /** Database column created_at SqlType(timestamp) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at")

    /** Foreign key referencing Users (database name messages_user_id_fkey) */
    lazy val usersFk = foreignKey("messages_user_id_fkey", userId, Users)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table Messages */
  lazy val Messages = new TableQuery(tag => new Messages(tag))

  /** Entity class storing rows of table Users
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param username Database column username SqlType(varchar), Length(20,true)
   *  @param password Database column password SqlType(varchar), Length(200,true) */
  case class UsersRow(id: Int, username: String, password: String)
  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[Int], e1: GR[String]): GR[UsersRow] = GR{
    prs => import prs._
    UsersRow.tupled((<<[Int], <<[String], <<[String]))
  }
  /** Table description of table users. Objects of this class serve as prototypes for rows in queries. */
  class Users(_tableTag: Tag) extends profile.api.Table[UsersRow](_tableTag, "users") {
    def * = (id, username, password) <> (UsersRow.tupled, UsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(username), Rep.Some(password))).shaped.<>({r=>import r._; _1.map(_=> UsersRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column username SqlType(varchar), Length(20,true) */
    val username: Rep[String] = column[String]("username", O.Length(20,varying=true))
    /** Database column password SqlType(varchar), Length(200,true) */
    val password: Rep[String] = column[String]("password", O.Length(200,varying=true))
  }
  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag => new Users(tag))
}

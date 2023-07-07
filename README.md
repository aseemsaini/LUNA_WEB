# LUNA Application

LUNA is a web application developed using the Scala Play framework, MySQL database, HTML, CSS, and JavaScript. It provides users with a platform to share and interact with messages, similar to popular social media platforms.

## Features

- User Registration and Login: Users can create new accounts or log in to existing ones to access the application.
- Profile Management: Users have their own profiles where they can view and edit their personal information.
- Home Page: Displays a feed of messages posted by users, including functionalities such as likes, retweets, and deletion.
- Search Functionality: Allows users to search for specific users, messages, or hashtags.
- Followers/Following: Users can follow and be followed by other users, building a network of connections.
- Message Interactions: Users can like, retweet, and delete their own messages.
- Visual Enhancements: Implemented CSS to enhance the overall look and feel of the application.

## Installation

1. Clone the repository: `git clone https://github.com/aseemsaini/luna-web.git`
2. Install dependencies: `npm install`
3. Set up the database LUNA: Create a MySQL database and configure the connection details in the application.
4. Run the following commands to create tables under the Database:
```sql
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(20) NOT NULL,
  password VARCHAR(200) NOT NULL
);

CREATE TABLE messages (
  message_id SERIAL PRIMARY KEY,
  user_id INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  text VARCHAR(2000) NOT NULL,
  likes INT NOT NULL DEFAULT 0,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE followers (
  follower_id INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  followed_id INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  PRIMARY KEY (follower_id, followed_id)
);
```

5. Remember to change `db.url = jdbc:mysql://localhost/luna?user=aseem&password=aseem123` in application.conf to your username and password.
6. Run the application: `sbt run`

## Usage

1. Access the application through a web browser: `http://localhost:8080`
2. Create a new account or log in with existing credentials.
3. Explore the different features of the application, such as posting messages, searching for users, and interacting with other users' messages.

## Contributing

Contributions are welcome! If you encounter any issues or have suggestions for improvements, please feel free to submit a pull request or open an issue on the GitHub repository.

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

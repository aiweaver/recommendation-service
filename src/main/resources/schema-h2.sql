-- promotions
DROP TABLE IF EXISTS promotions;
CREATE TABLE promotions (
  id int(11) NOT NULL,
  category varchar(255) NOT NULL,
  content int(11) NOT NULL,
  promotion_month int(11) NOT NULL,
);

-- notifications
DROP TABLE IF EXISTS notifications;
CREATE TABLE notifications (
  id int(11) NOT NULL,
  content int(11) NOT NULL,
  noti_date varchar(255) NOT NULL,
  profile varchar(255) NOT NULL,
);
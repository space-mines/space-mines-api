CREATE TABLE IF NOT EXISTS "mine_field"
(
  "id"   SERIAL PRIMARY KEY,
  "size" INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS "mine"
(
  "id"            SERIAL PRIMARY KEY,
  "mine_field_id" BIGINT  NOT NULL,
  "x"             INTEGER NOT NULL,
  "y"             INTEGER NOT NULL,
  "z"             INTEGER NOT NULL,

  FOREIGN KEY ("mine_field_id") REFERENCES "mine_field" ("id")
);

INSERT INTO mine_field(id, size)
VALUES (1, 3);

INSERT INTO mine(id, mine_field_id, x, y, z)
VALUES (DEFAULT, 1, 1, 1, 1);
DROP TABLE IF EXISTS "sector";
DROP TABLE IF EXISTS "level";

CREATE TABLE IF NOT EXISTS "level"
(
  "id"   BIGINT PRIMARY KEY,
  "size" INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS "sector"
(
  "id"            BIGINT PRIMARY KEY,
  "level_id"      BIGINT  NOT NULL,
  "x"             INTEGER NOT NULL,
  "y"             INTEGER NOT NULL,
  "z"             INTEGER NOT NULL,
  "radiation"     INTEGER DEFAULT 0,
  "has_mine"      BOOLEAN DEFAULT FALSE,

  FOREIGN KEY ("level_id") REFERENCES "level" ("id")
);

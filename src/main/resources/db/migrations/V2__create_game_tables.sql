CREATE TABLE IF NOT EXISTS "game"
(
  "id" SERIAL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS "mine_pod"
(
  "id"        SERIAL PRIMARY KEY,
  "game_id"   INTEGER NOT NULL,
  "x"         INTEGER NOT NULL,
  "y"         INTEGER NOT NULL,
  "z"         INTEGER NOT NULL,
  "radiation" INTEGER NOT NULL,
  "flagged"   BOOLEAN DEFAULT FALSE,

  FOREIGN KEY ("game_id") REFERENCES "game" ("id")
);

INSERT INTO game(id) VALUES (1);

INSERT INTO mine_pod(id, game_id, x, y, z, radiation)
VALUES (DEFAULT, 1, 1, 1, 1, -1);
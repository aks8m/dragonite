-- 1. GAMES (Top Level)
CREATE TABLE games
(
    id   SMALLINT PRIMARY KEY,
    code VARCHAR(10) UNIQUE, -- 'PKM'
    name VARCHAR(255)        -- 'Pokemon'
);

-- 2. SERIES (The New Middle Layer)
CREATE TABLE series
(
    id           SERIAL PRIMARY KEY,
    game_id      SMALLINT     NOT NULL REFERENCES games (id),
    name         VARCHAR(255) NOT NULL, -- 'Scarlet & Violet', 'Sun & Moon'

    -- Optional: Helps sort eras chronologically (e.g. 2023, 2020)
    release_date DATE
);

-- 3. EXPANSIONS (Updated)
CREATE TABLE expansions
(
    id        SERIAL PRIMARY KEY,

    -- Now points to Series instead of directly to Game (usually)
    series_id INTEGER      NOT NULL REFERENCES series (id),

    code      VARCHAR(20)  NOT NULL, -- 'sv1', 'swsh12'
    name      VARCHAR(255) NOT NULL, -- 'Scarlet & Violet Base Set'

    -- Constraint: Codes must be unique within a series (or game)
    UNIQUE (series_id, code)
);

-- 1. SERIES TABLE
-- Speeds up: "Show me all Series in Pokemon"
CREATE INDEX idx_series_game_id ON series (game_id);

-- 2. EXPANSIONS TABLE
-- Speeds up: "Show me all Expansions in the Scarlet & Violet Series"
CREATE INDEX idx_expansions_series_id ON expansions (series_id);

-- -- 3. CARDS TABLE (The Big One)
-- -- Speeds up: "Show me all cards in the 'Lost Origin' expansion"
-- CREATE INDEX idx_cards_expansion_id ON cards (expansion_id);
--
-- -- Speeds up: "Show me all versions of 'Pikachu'"
-- CREATE INDEX idx_cards_name_id ON cards (name_id);~
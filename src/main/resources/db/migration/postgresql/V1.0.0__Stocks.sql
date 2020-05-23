DROP TABLE IF EXISTS stocksconfiguration;

CREATE TABLE stocksconfiguration (
    uuid            uuid NOT NULL,
    code            varchar(200) NOT NULL,
    createdAt       bigint,
    modifiedAt      bigint,
    active          boolean,
    test            varchar(1),
    PRIMARY KEY (uuid)
);

CREATE INDEX idx_stocksconfiguration ON stocksconfiguration (code, active);

COMMIT;

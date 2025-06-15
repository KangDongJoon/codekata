WITH Ranked AS (
    SELECT
        ID,
        SIZE_OF_COLONY,
        NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS percentile_group
    FROM
        ECOLI_DATA
),
Labeled AS (
    SELECT
        ID,
        CASE percentile_group
            WHEN 1 THEN 'CRITICAL'
            WHEN 2 THEN 'HIGH'
            WHEN 3 THEN 'MEDIUM'
            WHEN 4 THEN 'LOW'
        END AS COLONY_NAME
    FROM
        Ranked
)
SELECT
    ID,
    COLONY_NAME
FROM
    Labeled
ORDER BY
    ID;

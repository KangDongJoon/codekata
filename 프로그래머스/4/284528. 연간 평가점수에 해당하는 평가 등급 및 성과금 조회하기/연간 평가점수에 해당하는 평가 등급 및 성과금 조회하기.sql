WITH EMP_GRADE AS (
    SELECT
        g.EMP_NO,
        FLOOR(AVG(g.SCORE)) AS AVG_SCORE,
        CASE
            WHEN AVG(g.SCORE) >= 96 THEN 'S'
            WHEN AVG(g.SCORE) >= 90 THEN 'A'
            WHEN AVG(g.SCORE) >= 80 THEN 'B'
            ELSE 'C'
        END AS GRADE
    FROM HR_GRADE g
    GROUP BY g.EMP_NO
)
SELECT
    e.EMP_NO,
    e.EMP_NAME,
    eg.GRADE,
    CASE
        WHEN eg.GRADE = 'S' THEN e.SAL * 0.2
        WHEN eg.GRADE = 'A' THEN e.SAL * 0.15
        WHEN eg.GRADE = 'B' THEN e.SAL * 0.1
        ELSE 0
    END AS BONUS
FROM EMP_GRADE eg
JOIN HR_EMPLOYEES e ON e.EMP_NO = eg.EMP_NO
ORDER BY e.EMP_NO ASC;

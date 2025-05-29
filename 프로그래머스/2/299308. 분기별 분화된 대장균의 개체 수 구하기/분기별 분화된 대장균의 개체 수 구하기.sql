SELECT
  CONCAT(quarter_number, 'Q') AS QUARTER,
  COUNT(*) AS ECOLI_COUNT
FROM (
  SELECT
    QUARTER(DIFFERENTIATION_DATE) AS quarter_number
  FROM
    ECOLI_DATA
) AS sub
GROUP BY
  quarter_number
ORDER BY
  quarter_number;

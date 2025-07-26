WITH skill_bit AS (
  SELECT d.id, d.email, s.name, s.category
  FROM developers d
  JOIN skillcodes s
    ON d.skill_code & s.code != 0
),
graded AS (
  SELECT
    id,
    email,
    MAX(CASE WHEN category = 'Front End' THEN 1 ELSE 0 END) AS has_front,
    MAX(CASE WHEN name = 'Python' THEN 1 ELSE 0 END) AS has_python,
    MAX(CASE WHEN name = 'C#' THEN 1 ELSE 0 END) AS has_csharp
  FROM skill_bit
  GROUP BY id, email
),
final_grade AS (
  SELECT
    id,
    email,
    CASE
      WHEN has_front = 1 AND has_python = 1 THEN 'A'
      WHEN has_csharp = 1 THEN 'B'
      WHEN has_front = 1 THEN 'C'
      ELSE NULL
    END AS grade
  FROM graded
)
SELECT grade, id, email
FROM final_grade
WHERE grade IS NOT NULL
ORDER BY grade, id;

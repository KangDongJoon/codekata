SELECT COUNT(*) AS FISH_COUNT,
       i.FISH_NAME AS FISH_NAME
FROM FISH_INFO f
INNER JOIN FISH_NAME_INFO i ON f.FISH_TYPE = i.FISH_TYPE
GROUP BY FISH_NAME
ORDER BY FISH_COUNT DESC;
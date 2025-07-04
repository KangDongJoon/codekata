SELECT 
    P.ID,
    COUNT(C.ID) AS CHILD_COUNT
FROM 
    ECOLI_DATA P
LEFT JOIN 
    ECOLI_DATA C ON C.PARENT_ID = P.ID
GROUP BY 
    P.ID
ORDER BY 
    P.ID ASC;

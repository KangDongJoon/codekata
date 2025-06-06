SELECT c.ITEM_ID,
       c.ITEM_NAME,
       c.RARITY
FROM ITEM_TREE t
INNER JOIN ITEM_INFO p ON t.PARENT_ITEM_ID = p.ITEM_ID
INNER JOIN ITEM_INFO c ON t.ITEM_ID = c.ITEM_ID
WHERE p.RARITY = 'RARE'
ORDER BY c.ITEM_ID DESC;



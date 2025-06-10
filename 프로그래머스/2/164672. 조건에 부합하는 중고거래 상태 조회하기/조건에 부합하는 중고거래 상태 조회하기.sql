SELECT g.BOARD_ID,
       g.WRITER_ID,
       g.TITLE,
       g.PRICE,
       CASE g.STATUS
          WHEN 'SALE' THEN '판매중'
          WHEN 'RESERVED' THEN '예약중'
          ELSE '거래완료'
       END AS STATUS
FROM USED_GOODS_BOARD g
WHERE g.CREATED_DATE = '2022-10-05'
ORDER BY BOARD_ID DESC;
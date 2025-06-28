-- Exercise 1: Control Structures
-- Created by Hariny Bhaskar

-- Scenario 1: Apply 1% discount for customers over 60
BEGIN
  FOR c IN (SELECT * FROM CUSTOMER) LOOP
    IF c.age > 60 THEN
      UPDATE CUSTOMER
      SET interestrate = interestrate - 1
      WHERE customerid = c.customerid;
    END IF;
  END LOOP;
  COMMIT;
END;
/

-- Scenario 2: Promote to VIP if balance > 10000
BEGIN
  FOR c IN (SELECT * FROM CUSTOMER) LOOP
    IF c.balance > 10000 THEN
      UPDATE CUSTOMER
      SET isvip = 'Y'
      WHERE customerid = c.customerid;
    END IF;
  END LOOP;
  COMMIT;
END;
/

-- Scenario 3: Remind loans due in next 30 days
BEGIN
  FOR l IN (
    SELECT l.loanid, c.name, l.duedate
    FROM loan l
    JOIN customer c ON c.customerid = l.customerid
    WHERE l.duedate <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || l.loanid || ' for ' || l.name || ' is due on ' || TO_CHAR(l.duedate, 'DD-MON-YYYY'));
  END LOOP;
END;
/
